package com.quotes.service;

import com.quotes.dto.UserMinResponse;
import com.quotes.dto.UserRegisterRequest;
import com.quotes.enums.Role;
import com.quotes.model.User;
import com.quotes.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserMinResponse createUser(UserRegisterRequest userRegisterRequest){
        isUserAlreadyExists(userRegisterRequest.email());

        return mapUserToUserMinResponse(userRepository.save(mapUserRegisterRequestToUser(userRegisterRequest)));
    }

    private UserMinResponse mapUserToUserMinResponse(User user) {
        return new UserMinResponse(user.getId(),user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername());
    }

    private void isUserAlreadyExists(String email){
        User user = userRepository.findByUsername(email).orElse(null);
        if(user != null) throw new RuntimeException("Email already in use");
    }

    private User mapUserRegisterRequestToUser(UserRegisterRequest userRegisterRequest){
        return User.builder()
                .firstName(userRegisterRequest.firstName())
                .lastName(userRegisterRequest.lastName())
                .email(userRegisterRequest.email())
                .username(userRegisterRequest.email())
                .password(userRegisterRequest.password())
                .role(Role.USER)
                .build();
    }
}
