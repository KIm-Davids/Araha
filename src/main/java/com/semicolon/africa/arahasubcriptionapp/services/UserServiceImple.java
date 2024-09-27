package com.semicolon.africa.arahasubcriptionapp.services;

import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.UserRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLoginRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLoginResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.arahasubcriptionapp.exception.EmailAlreadyExist;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImple implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        validateExistingUserByEmail(userRegisterRequest.getEmail().trim().strip());
        validateExistingUserByPhonenumber(userRegisterRequest.getPhoneNumber());
        validateExistingUserByUsername(userRegisterRequest.getUsername().trim().strip());
        String password = passwordEncoder.encode(userRegisterRequest.getPassword());
        userRegisterRequest.setPassword(password);
        System.out.println(password);
        User user = modelMapper.map(userRegisterRequest, User.class);
        user = userRepository.save(user);
        UserRegisterResponse response = modelMapper.map(user, UserRegisterResponse.class);
        response.setEmail(response.getEmail());
        response.setMessage("successfully registered");
        response.setId(response.getId());
        return response;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        User user = existsByEmail(userLoginRequest.getEmail().trim().strip());
        validateUserPassword(user, userLoginRequest.getPassword());
        user.setLoggedIn(true);
        userRepository.save(user);
        UserLoginResponse response = modelMapper.map(user, UserLoginResponse.class);
        response.setId(response.getId());
        response.setMessage("Logged in Successfully");
        return response;
    }
    private User existsByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailAlreadyExist("User not found"));
    }
    private void validateUserPassword(User user, String password) {
        if (!passwordEncoder.matches(password, user.getPassword()))
            throw new EmailAlreadyExist("Invalid Login Details");
    }

    private void validateExistingUserByEmail(String email){
        boolean existsByEmail = userRepository.existsByEmail(email);
        if (existsByEmail) throw new EmailAlreadyExist("Email already exists");
    }
    private void validateExistingUserByUsername(String username){
        boolean existsByUsername = userRepository.existsByUsername(username);
        if (existsByUsername) throw new EmailAlreadyExist("Username already exists");
    }
    private void validateExistingUserByPhonenumber(String phonenumber){
        boolean existsByPhonenumber = userRepository.existsByPhoneNumber(phonenumber);
        if(phonenumber.length() != 11) throw new EmailAlreadyExist("Invalid phone number");
        if (existsByPhonenumber) throw new EmailAlreadyExist("Phone number already exists");
    }
}
