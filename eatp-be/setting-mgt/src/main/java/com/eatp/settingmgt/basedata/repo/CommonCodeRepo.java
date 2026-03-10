package com.eatp.settingmgt.basedata.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.eatp.settingmgt.basedata.entity.CommonCode;

public interface CommonCodeRepo extends JpaRepository<CommonCode, Integer>, JpaSpecificationExecutor<CommonCode>{
}
