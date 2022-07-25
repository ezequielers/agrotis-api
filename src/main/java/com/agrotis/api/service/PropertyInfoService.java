package com.agrotis.api.service;

import com.agrotis.api.model.PropertyInfoModel;
import com.agrotis.api.repository.PropertyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyInfoService {
    @Autowired
    private PropertyInfoRepository propertyRepository;

    public PropertyInfoModel save(PropertyInfoModel propertyInfoModel){
        return propertyRepository.save(propertyInfoModel);
    }

    public List<PropertyInfoModel> listAll(){
        return propertyRepository.findAll();
    }

    public Optional<PropertyInfoModel> findById(Long id){
        return propertyRepository.findById(id);
    }

    public void delete(Long id){
        propertyRepository.deleteById(id);
    }
}
