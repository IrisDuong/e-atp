package com.eatp.settingmgt.localeinput.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.eatp.settingmgt.localeinput.dto.LocaleInputCodeDTO;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCode;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCodePK;
import com.eatp.settingmgt.localeinput.repo.LocaleInputCodeRepo;
import com.eatp.settingmgt.localeinput.service.LocaleInputCodeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocaleInputCodeServiceImpl implements LocaleInputCodeService{
	private final LocaleInputCodeRepo localeInputCodeRepo;

	@Override
	public List<LocaleInputCodeDTO> findByListLocaleCode(List<Integer> localeCodeNoParams) {
		return localeInputCodeRepo.findById_LocaleCodeNoIn(localeCodeNoParams)
				.stream().map(this::convertToDto).toList();
	}

	@Override
	public boolean saveListLocaleInputCode(List<LocaleInputCode> entities) {
		try {
			localeInputCodeRepo.saveAllAndFlush(entities);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public Integer findMaxLocaleCode() {
		return localeInputCodeRepo.findMaxLocaleCode();
	}


	@Override
	public boolean deleteByIds(List<LocaleInputCodePK> ids) {
		try {
			localeInputCodeRepo.deleteAllByIdInBatch(ids);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public List<LocaleInputCodeDTO> findByLocaleCodeNo(Integer localeCodeNo) {
		return localeInputCodeRepo.findById_LocaleCodeNo(localeCodeNo)
				.stream().map(this::convertToDto).toList();
	}

}
