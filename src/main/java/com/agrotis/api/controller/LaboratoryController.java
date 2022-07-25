package com.agrotis.api.controller;

import com.agrotis.api.model.LaboratoryModel;
import com.agrotis.api.service.LaboratoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {
    @Autowired
    private LaboratoryService laboratoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LaboratoryModel save(@RequestBody LaboratoryModel laboratory){
        return laboratoryService.save(laboratory);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LaboratoryModel> listAllLaboratories(){
        return laboratoryService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LaboratoryModel findLaboratoryById(@PathVariable Long id){
        return laboratoryService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLaboratory(@PathVariable Long id, @RequestBody LaboratoryModel laboratory){
        laboratoryService.findById(id)
                .map(laboratoryBase -> {
                    modelMapper.map(laboratory, laboratoryBase);
                    laboratoryService.save(laboratoryBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLaboratory(@PathVariable Long id){
        laboratoryService.findById(id)
                .map(laboratory -> {
                    laboratoryService.delete(laboratory.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
