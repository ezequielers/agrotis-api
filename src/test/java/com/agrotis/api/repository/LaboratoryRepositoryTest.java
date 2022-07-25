package com.agrotis.api.repository;

import com.agrotis.api.model.LaboratoryModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class LaboratoryRepositoryTest {
    @Autowired
    LaboratoryRepository laboratoryRepository;

    @DisplayName("Step 1 - Create Laboratory")
    @Test
    void shouldCreateLaboratory(){
        LaboratoryModel laboratoryModel = new LaboratoryModel();
        laboratoryModel.setName("Lab Pharms Corporation");
        laboratoryRepository.save(laboratoryModel);
    }

    @DisplayName("Step 2 - List Laboratories")
    @Test
    void shouldListLaboratories(){
        List<LaboratoryModel> list = laboratoryRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("Step 3 - List Laboratory By Id")
    @Test
    void shouldListLaboratoryById(){
        LaboratoryModel laboratoryModel = laboratoryRepository.findById(1L).get();
        assertEquals("Lab Pharms Corporation", laboratoryModel.getName());
    }

    @DisplayName("Step 4 - Change Laboratory Name")
    @Test
    void shouldChangeLaboratory(){
        LaboratoryModel laboratoryModel = laboratoryRepository.findById(1L).get();
        laboratoryModel.setName("Lab Pharms Co.");
        laboratoryRepository.save(laboratoryModel);
        assertEquals("Lab Pharms Co.", laboratoryModel.getName());
    }

    @DisplayName("Step 5 - Delete Laboratory")
    @Test
    void shouldDeleteLaboratory(){
        laboratoryRepository.deleteById(1L);
        assertThat(laboratoryRepository.existsById(1L));
    }
}
