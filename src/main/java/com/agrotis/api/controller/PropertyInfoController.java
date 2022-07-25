package com.agrotis.api.controller;

import com.agrotis.api.model.PropertyInfoModel;
import com.agrotis.api.service.PropertyInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/propertyinfo")
public class PropertyInfoController {
    @Autowired
    private PropertyInfoService propertyInfoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PropertyInfoModel save(@RequestBody PropertyInfoModel propertyInfoModel){
        return propertyInfoService.save(propertyInfoModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PropertyInfoModel> listAllPropertiesInfo(){
        return propertyInfoService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PropertyInfoModel findPropertyInfoById(@PathVariable Long id){
        return propertyInfoService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePropertyInfoById(@PathVariable Long id, @RequestBody PropertyInfoModel propertyInfoModel){
        propertyInfoService.findById(id)
                .map(propertyInfoBase -> {
                    modelMapper.map(propertyInfoModel, propertyInfoBase);
                    propertyInfoService.save(propertyInfoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePropertyInfo(@PathVariable Long id){
        propertyInfoService.findById(id)
                .map(propertyInfo -> {
                    propertyInfoService.delete(propertyInfo.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
