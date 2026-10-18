package com.crudop.crudoperation.service;

import com.crudop.crudoperation.dto.UserRequest;
import com.crudop.crudoperation.dto.UserResponse;
import com.crudop.crudoperation.entity.User;
import com.crudop.crudoperation.exception.ResourceNotFoundException;
import com.crudop.crudoperation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }

    public UserResponse getUserById(Long id) {
        return UserResponse.from(findUser(id));
    }

    public UserResponse createUser(UserRequest request) {
        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        return UserResponse.from(userRepository.save(user));
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        User existing = findUser(id);
        existing.setName(request.name());
        existing.setEmail(request.email());
        return UserResponse.from(userRepository.save(existing));
    }

    public void deleteUser(Long id) {
        userRepository.delete(findUser(id));
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }
}