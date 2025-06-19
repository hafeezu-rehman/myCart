package com.mycart.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycart.store.model.User;
import com.mycart.store.repository.UserRepository;
@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    public void createUser(User user){
        if(user.getUsername()!=null && user.getPassword() !=null && user.getEmail()!=null && user.getPhone_number()!=null)
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        else
            throw new IllegalArgumentException("Unable to create user due to incomplete information");
    }
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }
    public User findUser(Long userId){
        return userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
    public void updateUser(User updatedUser){
        if(updatedUser.getUsername()!=null && updatedUser.getPassword() !=null && updatedUser.getEmail()!=null && updatedUser.getPhone_number()!=null){
            userRepository.findById(updatedUser.getUser_id())
            .map(user->{
                user.setUsername(updatedUser.getUsername());
                user.setRole(updatedUser.getRole());
                user.setPhone_number(updatedUser.getPhone_number());
                user.setPassword(updatedUser.getPassword());
                user.setEmail(updatedUser.getEmail());
                user.setAddress(updatedUser.getAddress());
                return userRepository.save(user);
            })
            .orElseThrow(()->new IllegalArgumentException("Unable to update user due to incomplete information"));
        }
        else
            throw new IllegalArgumentException("Unable to update user due to incomplete information");
    }
    public void deleteUser(Long id){
        if(findUser(id)!=null)
                userRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Unable to delete the user due to incomplete information");
    }
    
}
