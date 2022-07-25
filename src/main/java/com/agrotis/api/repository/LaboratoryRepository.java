package com.agrotis.api.repository;

import com.agrotis.api.model.LaboratoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryRepository extends JpaRepository<LaboratoryModel, Long> {
}
