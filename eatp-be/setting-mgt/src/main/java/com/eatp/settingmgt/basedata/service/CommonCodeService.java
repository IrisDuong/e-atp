package com.eatp.settingmgt.basedata.service;

import java.util.List;

import com.eatp.settingmgt.basedata.dto.CommonCodeRequestDTO;
import com.eatp.settingmgt.basedata.dto.CommonCodeResponseDTO;
import com.eatp.settingmgt.basedata.entity.CommonCode;

public interface CommonCodeService {

	boolean createCommonCode(CommonCodeRequestDTO param) throws Exception;
	List<CommonCodeResponseDTO> searchCommonCodes(CommonCodeRequestDTO param);
}
