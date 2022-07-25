package com.agrotis.api.repository;

import com.agrotis.api.model.PropertyInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyInfoRepository extends JpaRepository<PropertyInfoModel, Long> {
}
