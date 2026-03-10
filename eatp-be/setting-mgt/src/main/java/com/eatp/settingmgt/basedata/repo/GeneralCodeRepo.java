package com.eatp.settingmgt.basedata.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eatp.settingmgt.basedata.dto.GeneralCodeResponseDTO;
import com.eatp.settingmgt.basedata.entity.GeneralCode;
import com.eatp.settingmgt.basedata.entity.GeneralCodeID;

public interface GeneralCodeRepo extends JpaRepository<GeneralCode, GeneralCodeID>{

	@Query("SELECT new com.eatp.settingmgt.basedata.dto.GeneralCodeResponseDTO"
			+ "(G.id.commonCodeNo,G.id.generalCodeNo,G.featureCodeNo,G.codeTypeNo,G.useStatusNo,G.localeCodeNo,G.isTree)"
			+ " FROM GeneralCode G"
			+ " WHERE G.id.commonCodeNo = :commonCodeNo AND G.featureCodeNo = :featureCodeNo AND G.useStatusNo = :useStatusNo"
			+ " ORDER BY G.id.generalCodeNo ASC")
	List<GeneralCodeResponseDTO> getListGeneralByCommonCode(Integer commonCodeNo,String featureCodeNo,String useStatusNo);
	
	@Query("SELECT COALESCE(MAX(G.id.generalCodeNo),0) FROM GeneralCode G"
			+ " WHERE G.id.commonCodeNo = :commonCodeNo"
			+ " AND G.featureCodeNo = :featureCodeNo"
			+ " AND G.useStatusNo = :useStatusNo")
	Integer findMaxGeneralcode(Integer commonCodeNo,String featureCodeNo,String useStatusNo);
	
//	@Query("SELECT new com.eatp.settingmgt.basedata.dto.GeneralCodeRequestDTO(G.id.commonCodeNo,G.id.generalCodeNo,G.featureCodeNo,G.isTree) FROM GeneralCode G"
//			+ " WHERE G.id.commonCodeNo = :commonCodeNo"
//			+ " AND G.featureCodeNo = :featureCodeNo"
//			+ " AND G.useStatusNo = :useStatusNo"
//			+ " AND G.id.generalCodeNo IN :generalCodes")
//	List<GeneralCodeRequestDTO> getListExistedGeneralCodeNo(@Param("generalCodes") List<Integer> generalCodes, Integer commonCodeNo,String featureCodeNo,String useStatusNo);
}
