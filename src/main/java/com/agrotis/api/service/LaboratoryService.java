package com.agrotis.api.service;

import com.agrotis.api.model.LaboratoryModel;
import com.agrotis.api.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryService {
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public LaboratoryModel save(LaboratoryModel laboratory){
        return laboratoryRepository.save(laboratory);
    }

    public List<LaboratoryModel> listAll(){
        return laboratoryRepository.findAll();
    }

    public Optional<LaboratoryModel> findById(Long id){
        return laboratoryRepository.findById(id);
    }

    public void delete(Long id){
        laboratoryRepository.deleteById(id);
    }
}
