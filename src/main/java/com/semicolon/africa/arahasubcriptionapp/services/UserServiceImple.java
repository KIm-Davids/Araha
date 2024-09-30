package com.semicolon.africa.arahasubcriptionapp.services;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.semicolon.africa.arahasubcriptionapp.Utils.JwtUtilsImpl;
import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import com.semicolon.africa.arahasubcriptionapp.data.repositories.UserRepository;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UpdateUserRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserLoginRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.requests.UserRegisterRequest;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UpdatedUserResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserLoginResponse;
import com.semicolon.africa.arahasubcriptionapp.dtos.responses.UserRegisterResponse;
import com.semicolon.africa.arahasubcriptionapp.exception.EmailAlreadyExist;
import com.semicolon.africa.arahasubcriptionapp.exceptions.InvalidEmailException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor

public class UserServiceImple implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private JwtUtilsImpl utils;
    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        validateExistingUserByEmail(userRegisterRequest.getEmail().trim().strip());
        validateExistingUserByPhonenumber(userRegisterRequest.getPhoneNumber());
        validateExistingUserByUsername(userRegisterRequest.getUsername().trim().strip());
        validateEmail(userRegisterRequest.getEmail());
        String password = passwordEncoder.encode(userRegisterRequest.getPassword());
        userRegisterRequest.setPassword(password);
        User user = modelMapper.map(userRegisterRequest, User.class);
        user = userRepository.save(user);
        String token = utils.generateToken(userRegisterRequest.getUsername(), userRegisterRequest.getPhoneNumber(), userRegisterRequest.getEmail(),  userRegisterRequest.getPassword());
        UserRegisterResponse response = modelMapper.map(user, UserRegisterResponse.class);
        response.setToken(token);
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
    public UserLoginResponse login(UserLoginRequest userLoginRequest, String jwtToken) throws ParseException {
        try {
            String email = extractEmail(jwtToken);
            String password = utils.extractPassword(jwtToken);

            User user = existsByEmail(email);
            validateUserPassword(user, password);
            user.setLoggedIn(true);
            userRepository.save(user);
            UserLoginResponse response = modelMapper.map(user, UserLoginResponse.class);
            response.setId(response.getId());
            response.setMessage("Logged in Successfully");
            return response;
     //       userLoginRequest.getEmail().trim().strip()
            // userLoginRequest.getPassword()
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public UpdatedUserResponse update(UpdateUserRequest userUpdateRequest) {
        Optional<User> user = findById(userUpdateRequest.getId());
        user.get().setUsername(userUpdateRequest.getNewUsername());
        user.get().setPhoneNumber(userUpdateRequest.getNewPhoneNumber());
        user.get().setEmail(userUpdateRequest.getNewEmail());
        user.get().setPassword(passwordEncoder.encode(userUpdateRequest.getNewPassword()));
        User updatedUser = userRepository.save(user.get());
        UpdatedUserResponse response = modelMapper.map(updatedUser, UpdatedUserResponse.class);
        response.setId(response.getId());
        response.setMessage("User updated successfully");
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
    private Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!id.equals(user.get().getId())){
            throw new EmailAlreadyExist("User does not exist");
        }
        return  user;
    }

    private JWTClaimsSet extractClaims(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet();
    }

    private String extractEmail(String token) throws ParseException {
        JWTClaimsSet claimsSet = extractClaims(token);
        return claimsSet.getStringClaim("email");
    }

    private void validateEmail(String email){
        String emailToVerify = "^[a-zA-z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2}$";
        Pattern pattern = Pattern.compile(emailToVerify);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            throw new InvalidEmailException("Invalid Email");
        }
    }



}
