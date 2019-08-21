package com.service;
import com.entity.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository _userRepository){
        this.userRepository = _userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        return userRepository.findById(id).get();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(String id, User userRequest){
        User user = userRepository.findById(id).get();
        user.setName(userRequest.getName());
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        User user = this.getUser(id);
        userRepository.delete(user);
    }

}