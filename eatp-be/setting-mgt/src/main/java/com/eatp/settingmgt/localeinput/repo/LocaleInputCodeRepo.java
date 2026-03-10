package com.eatp.settingmgt.localeinput.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.eatp.settingmgt.localeinput.entity.LocaleInputCode;
import com.eatp.settingmgt.localeinput.entity.LocaleInputCodePK;

import jakarta.persistence.LockModeType;

public interface LocaleInputCodeRepo extends JpaRepository<LocaleInputCode, LocaleInputCodePK>{

//	@Query("SELECT COALESCE(MAX(lic.id.localeCodeNo),0)+1 FROM LocaleInputCode lic")
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("""
			SELECT COALESCE(MAX(lic.id.localeCodeNo),0)
			FROM LocaleInputCode lic
			""")
	Integer findMaxLocaleCode();
	List<LocaleInputCode> findById_LocaleCodeNo(Integer localeCodeNo);
	List<LocaleInputCode> findById_LocaleCodeNoIn(List<Integer> localeCodeNos);
}
