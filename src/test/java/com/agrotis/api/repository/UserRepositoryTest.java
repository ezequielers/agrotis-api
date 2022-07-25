package com.agrotis.api.repository;

import com.agrotis.api.model.UserModel;
import com.agrotis.api.model.PropertyInfoModel;
import com.agrotis.api.model.LaboratoryModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PropertyInfoRepository propertyInfoRepository;

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @DisplayName("Step 1 - Create Property Info")
    @Test
    void shouldCreatePropertyInfo(){
        PropertyInfoModel propertyInfoModel = new PropertyInfoModel();
        propertyInfoModel.setName("Duda's Ranch");
        propertyInfoModel.setCnpj("12.345.678/0001-79");
        propertyInfoRepository.save(propertyInfoModel);
    }

    @DisplayName("Step 2 - Create Laboratory")
    @Test
    void shouldCreateLaboratory(){
        LaboratoryModel laboratoryModel = new LaboratoryModel();
        laboratoryModel.setName("Lab Pharms Corporation");
        laboratoryRepository.save(laboratoryModel);
    }

    @DisplayName("Step 3 - Create User")
    @Test
    void shouldCreateUser() {
        Date data = new Date();
        UserModel userModel = new UserModel();
        userModel.setName("Kevin Page");
        userModel.setInitialDate(data);
        userModel.setFinalDate(data);
        userModel.setNotes("Observacao exemplo de teste");
        userRepository.save(userModel);
    }

    @DisplayName("Step 4 - List Users")
    @Test
    void shouldListAllUsers() {
        List<UserModel> list = userRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    @DisplayName("Step 5 - List User By Id")
    @Test
    void shouldListUserById() {
        UserModel userModel = userRepository.findById(3L).get();
        assertEquals("Kevin Page", userModel.getName());
    }

    @DisplayName("Step 6 - Change User Name")
    @Test
    void shouldChangeUserName() {
        UserModel userModel = userRepository.findById(3L).get();
        userModel.setName("John Morel");
        userRepository.save(userModel);
        assertEquals("John Morel", userModel.getName());
    }

    @DisplayName("Step 7 - Delete User")
    @Test
    void shouldDeleteUser() {
        userRepository.deleteById(3L);
        assertThat(userRepository.existsById(3L));
    }
}
