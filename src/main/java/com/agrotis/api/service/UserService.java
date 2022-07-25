package com.agrotis.api.service;

import com.agrotis.api.model.UserModel;
import com.agrotis.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> listAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
