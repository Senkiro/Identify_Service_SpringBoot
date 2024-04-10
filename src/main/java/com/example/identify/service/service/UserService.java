package com.example.identify.service.service;

import com.example.identify.service.dto.request.UserCreationRequest;
import com.example.identify.service.dto.request.UserUpdateRequest;
import com.example.identify.service.dto.response.UserResponse;
import com.example.identify.service.entity.User;
import com.example.identify.service.exception.AppException;
import com.example.identify.service.exception.ErrorCode;
import com.example.identify.service.mapper.UserMapper;
import com.example.identify.service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User createRequest(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return  userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("user not found")));
    }

    public UserResponse updateUser(String userId,UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("user not found"));
        userMapper.updateUser(user,request);

       return userMapper.toUserResponse(userRepository.save(user));

    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
