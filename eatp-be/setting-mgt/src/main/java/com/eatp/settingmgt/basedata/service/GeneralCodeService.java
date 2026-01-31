package com.eatp.settingmgt.basedata.service;

import java.util.List;

import com.eatp.settingmgt.basedata.dto.GeneralCodeRequestDTO;
import com.eatp.settingmgt.basedata.dto.GeneralCodeResponseDTO;

public interface GeneralCodeService {

	boolean createGeneralCode(GeneralCodeRequestDTO param) throws Exception;
//	boolean createGeneralCode(List<GeneralCodeRequestDTO> params);
	List<GeneralCodeResponseDTO> getListGeneralByCommonCode(GeneralCodeRequestDTO param);
}
