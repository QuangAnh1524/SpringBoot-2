package com.quanh1524.identity_service.service;

import com.quanh1524.identity_service.dto.request.UserCreationRequest;
import com.quanh1524.identity_service.dto.request.UserUpdateRequest;
import com.quanh1524.identity_service.entity.User;
import com.quanh1524.identity_service.exception.AppException;
import com.quanh1524.identity_service.exception.ErrorCode;
import com.quanh1524.identity_service.mapper.UserMapper;
import com.quanh1524.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername()))
                throw new AppException(ErrorCode.USER_EXISTED);

        //UserCreationRequest request1 = UserCreationRequest.builder()
          //      .username("chi pheo")
            //    .build();

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(String  userID, UserUpdateRequest request) {
        User user = getUser(userID);
        userMapper.updateUser(user, request);

        return userRepository.save(user);
    }

    public void deleteUser(String userID) {
        userRepository.deleteById(userID);
    }
}
