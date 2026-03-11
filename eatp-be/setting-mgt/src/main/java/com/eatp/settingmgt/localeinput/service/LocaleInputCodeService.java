package com.eatp.settingmgt.localeinput.service;

import java.util.List;

import com.eatp.common.service.CustomDataConverter;
import com.eatp.settingmgt.localeinput.dto.LocaleInputCodeDTO;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCode;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCodePK;

public interface LocaleInputCodeService extends CustomDataConverter<LocaleInputCode, LocaleInputCodeDTO>{
	List<LocaleInputCodeDTO> findByListLocaleCode(List<Integer> localeCodeParams);
	boolean saveListLocaleInputCode(List<LocaleInputCode> entities);
	boolean deleteByIds(List<LocaleInputCodePK> ids);
	Integer findMaxLocaleCode();
	List<LocaleInputCodeDTO> findByLocaleCodeNo(Integer localeCodeNo);
	
	@Override
	default LocaleInputCodeDTO convertToDto(LocaleInputCode e) {
		return LocaleInputCodeDTO.builder()
				.langCode(e.getId().getLangCode())
				.localeCodeNo(e.getId().getLocaleCodeNo())
				.codeName(e.getCodeName())
				.build();
	}
	@Override
	default LocaleInputCode convertToEntity(LocaleInputCodeDTO d) {
		LocaleInputCodePK id = LocaleInputCodePK.builder()
				.langCode(d.getLangCode())
				.localeCodeNo(d.getLocaleCodeNo())
				.build();
		return LocaleInputCode.builder()
				.id(id)
				.codeName(d.getCodeName())
				.build();
	}
	
}
