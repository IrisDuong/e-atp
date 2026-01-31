package com.eatp.settingmgt.localeinput.service;

import java.util.List;

import com.eatp.common.service.CustomDataConverter;
import com.eatp.settingmgt.localeinput.dto.LocaleInputCodeDTO;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCode;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCodePK;

public interface LocaleInputCodeService extends CustomDataConverter<LocaleInputCode, LocaleInputCodeDTO>{
	List<LocaleInputCode> findByListLocaleCode(List<Integer> localeCodeParams);
	boolean saveListLocaleInputCode(List<LocaleInputCode> entities);
	boolean deleteByIds(List<LocaleInputCodePK> ids);
	Integer findMaxLocaleCode();
	
}
