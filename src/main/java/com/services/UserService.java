package com.services;

import com.models.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.delete(id);
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> getUserBySurname(String surname){
        return userRepository.findBySurname(surname);
    }

    public Optional<User> getUserByNameAndSurname(String name, String surname){
        return userRepository.findByNameAndSurname(name,surname);
    }

    public User getUserById(String id){ return userRepository.findOne(id);}



}
