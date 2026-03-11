package com.eatp.settingmgt.basedata.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eatp.common.enums.BaseCodeTypeEnums;
import com.eatp.common.enums.BaseUseStatusEnums;
import com.eatp.common.exception.BadRequestException;
import com.eatp.common.exception.NotFoundException;
import com.eatp.common.utils.JpaUtils;
import com.eatp.settingmgt.basedata.dto.CommonCodeRequestDTO;
import com.eatp.settingmgt.basedata.dto.CommonCodeResponseDTO;
import com.eatp.settingmgt.basedata.entity.CommonCode;
import com.eatp.settingmgt.basedata.repo.CommonCodeRepo;
import com.eatp.settingmgt.basedata.service.CommonCodeService;
import com.eatp.settingmgt.localeinput.dto.LocaleInputCodeDTO;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCode;
import com.eatp.settingmgt.localeinput.service.LocaleInputCodeService;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonCodeServiceImpl implements CommonCodeService{
	private final CommonCodeRepo commonCodeRepo;
	private final LocaleInputCodeService localeInputCodeService;

	@Override
	@Transactional
	public boolean createCommonCode(CommonCodeRequestDTO param) throws Exception {
		try {
			
			if(commonCodeRepo.existsById(param.getCommonCodeNo())) {
				log.info("DUPLICATE COMMON CODE NO  = {}", param.getCommonCodeNo());
				throw new BadRequestException("Duplicate common code");
			}
			
			Integer maxLocalCodeNo = localeInputCodeService.findMaxLocaleCode() + 1;
			List<LocaleInputCode> localeInputCodes = param.getLocaleInputCodes().stream()
					.map(e-> {
						e.setLocaleCodeNo(maxLocalCodeNo);
						return e;
					})
					.map(localeInputCodeService::convertToEntity)
					.toList();
			localeInputCodeService.saveListLocaleInputCode(new ArrayList<>(localeInputCodes));
			
			CommonCode commonCodeToSave = new  CommonCode();
			commonCodeToSave.setCodeTypeNo(param.getCodeTypeNo());
			commonCodeToSave.setUseStatusNo(param.getUseStatusNo());
			commonCodeToSave.setFeatureCodeNo(param.getFeatureCodeNo());
			commonCodeToSave.setLocaleCodeNo(localeInputCodes.get(0).getId().getLocaleCodeNo());
			commonCodeRepo.save(commonCodeToSave);
			return true;
		} catch (Exception e) {
			throw new Exception("Create common code failed");
		}
	}

	@Override
	public List<CommonCodeResponseDTO> searchCommonCodes(CommonCodeRequestDTO param) {
		Specification<CommonCode> sepeSpecification = (root,query,cb)->{
			// localeInputCode
			Subquery<Integer> licSubquery = query.subquery(Integer.class);
			Root<LocaleInputCode> licRoot  = licSubquery.from(LocaleInputCode.class);
			licSubquery.select(licRoot.get("id").get("localeCodeNo"))
						.where(cb.like(licRoot.get("codeName"), JpaUtils.likeParamsFormater(param.getCommonCodeName(), true)));
			
			// commonCode
			List<Predicate> predicates = List.of(
					cb.or(
							cb.isNotNull(root.get("commonCodeNo")),
							cb.equal(root.get("commonCodeNo"), param.getCommonCodeNo())
					),
					cb.equal(root.get("featureCodeNo"), param.getFeatureCodeNo()),
					cb.equal(root.get("useStatusNo"), param.getUseStatusNo()),
					cb.equal(root.get("codeTypeNo"), param.getCodeTypeNo()),
					root.get("localeCodeNo").in(licSubquery)
					
			);
			return cb.and(predicates.toArray(new Predicate[0]));
		};
		var queryResult = commonCodeRepo.findAll(sepeSpecification);
		var  listLocaleInputCodesDto = localeInputCodeService.findByListLocaleCode(queryResult.stream().map(CommonCode::getLocaleCodeNo).toList());
		return queryResult.stream().map(code->{
			return CommonCodeResponseDTO.builder()
					.commonCodeNo(code.getCommonCodeNo())
					.featureCodeNo(code.getFeatureCodeNo())
					.codeType(BaseCodeTypeEnums.buildFromCodeTypeNo(code.getCodeTypeNo()))
					.useStatus(BaseUseStatusEnums.buildFromStatusNo(code.getUseStatusNo()))
					.localeInputCodes(
							listLocaleInputCodesDto.stream()
							.filter(lic-> lic.getLocaleCodeNo().equals(code.getLocaleCodeNo())).toList()
					)
					.build();
		}).toList();
	}

	@Transactional
	@Override
	public CommonCodeResponseDTO getCommonCodeDetail(Integer commonCodeNo) {
		CommonCode result = commonCodeRepo.findById(commonCodeNo)
				.orElseThrow(()-> new NotFoundException("No common code with this param"));
		
		List<LocaleInputCodeDTO> listLocaleInputCodesDto = localeInputCodeService.findByLocaleCodeNo(result.getLocaleCodeNo());
				
		return CommonCodeResponseDTO.builder()
				.commonCodeNo(result.getCommonCodeNo())
				.featureCodeNo(result.getFeatureCodeNo())
				.codeType(BaseCodeTypeEnums.buildFromCodeTypeNo(result.getCodeTypeNo()))
				.useStatus(BaseUseStatusEnums.buildFromStatusNo(result.getUseStatusNo()))
				.localeInputCodes(listLocaleInputCodesDto)
				.build();
	}

}
