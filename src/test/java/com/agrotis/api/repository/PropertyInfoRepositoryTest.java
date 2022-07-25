package com.agrotis.api.repository;

import com.agrotis.api.model.PropertyInfoModel;
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
public class PropertyInfoRepositoryTest {
    @Autowired
    PropertyInfoRepository propertyInfoRepository;

    @DisplayName("Step 1 - Create Property Info")
    @Test
    void shouldCreatePropertyInfo(){
        PropertyInfoModel propertyInfoModel = new PropertyInfoModel();
        propertyInfoModel.setName("Duda's Ranch");
        propertyInfoModel.setCnpj("12.345.678/0001-79");
        propertyInfoRepository.save(propertyInfoModel);
    }

    @DisplayName("Step 2 - List Properties")
    @Test
    void shouldListPropertiesInfo(){
        List<PropertyInfoModel> list = propertyInfoRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("Step 3 - List Property Info By Id")
    @Test
    void shouldListPropertiesInfoById(){
        PropertyInfoModel propertyInfoModel = propertyInfoRepository.findById(1L).get();
        assertEquals("Duda's Ranch", propertyInfoModel.getName());
    }

    @DisplayName("Step 4 - Change Property Info Name")
    @Test
    void shouldChangePropertiesInfoName(){
        PropertyInfoModel propertyInfoModel = propertyInfoRepository.findById(1L).get();
        propertyInfoModel.setName("Duda's Ranch Camp");
        propertyInfoRepository.save(propertyInfoModel);
        assertEquals("Duda's Ranch Camp", propertyInfoModel.getName());
    }

    @DisplayName("Step 5 - Delete Property Info")
    @Test
    void shouldDeletePropertiesInfo(){
        propertyInfoRepository.deleteById(1L);
        assertThat(propertyInfoRepository.existsById(1L));
    }
}
