package com.tcs.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.user.dto.AdminRegistrationDTO;
import com.tcs.user.dto.LoginDTO;
import com.tcs.user.dto.UserRegistrationDTO;
import com.tcs.user.exception.InvalidCredentialsException;
import com.tcs.user.exception.UserAlreadyExistsException;
import com.tcs.user.model.Login;
import com.tcs.user.model.Status;
import com.tcs.user.model.User;
import com.tcs.user.model.UserType;
import com.tcs.user.repository.LoginRepository;
import com.tcs.user.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private EmailValidationService emailValidationService;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void registerUser(UserRegistrationDTO dto) {
        try {
            emailValidationService.validateEmail(dto.getEmail());
            if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("User already exists with email: " + dto.getEmail());
            }
            User user = new User(
                    dto.getName(),
                    dto.getEmail(),
                    passwordEncoder.encode(dto.getPassword()),
                    dto.getContactNumber(),
                    dto.getAddress(),
                     UserType.CUSTOMER,
                    Status.ACTIVE, LocalDateTime.now(),
                    LocalDateTime.now()
            );
            userRepository.save(user);
            Login login = new Login(
                    dto.getEmail(),
                    passwordEncoder.encode(dto.getPassword()),
                    UserType.CUSTOMER,
                    Status.ACTIVE,
                    LocalDateTime.now()
            );
            loginRepository.save(login);
        } catch (DataAccessException e) {
            throw new DataAccessException("Database error during user registration: " + e.getMessage()) {
            };
        }
    }

    @Transactional
    public void registerAdmin(AdminRegistrationDTO dto) {
        try {
            emailValidationService.validateEmail(dto.getEmail());
            if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new UserAlreadyExistsException("Admin already exists with email: " + dto.getEmail());
            }
            User user = new User(
                    dto.getName(),
                    dto.getEmail(),
                    passwordEncoder.encode(dto.getPassword()),
                    dto.getContactNumber(),
                    dto.getAddress(),
                    UserType.ADMIN,
                    Status.ACTIVE,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            userRepository.save(user);
            Login login = new Login(
                    dto.getEmail(),
                    passwordEncoder.encode(dto.getPassword()),
                    UserType.ADMIN,
                    Status.ACTIVE,
                    LocalDateTime.now()
            );
            loginRepository.save(login);
        } catch (DataAccessException e) {
            throw new DataAccessException("Database error during admin registration: " + e.getMessage()) {
            };
        }
    }

    public User login(LoginDTO dto) {
        try {
            Optional<Login> loginOpt = loginRepository.findByEmail(dto.getEmail());
            if (loginOpt.isPresent()) {
                Login login = loginOpt.get();
                if (passwordEncoder.matches(dto.getPassword(), login.getPassword()) && login.getStatus() == Status.ACTIVE) {
                    Optional<User> userOpt = userRepository.findByEmail(dto.getEmail());
                    if (userOpt.isPresent()) {
                        return userOpt.get();
                    }
                }
            }
            throw new InvalidCredentialsException("Invalid credentials or inactive user");
        } catch (DataAccessException e) {
            throw new DataAccessException("Database error during login: " + e.getMessage()) {
            };
        }
    }

    @Transactional
    public void activateAccount(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            throw new InvalidCredentialsException("User not found with ID: " + userId);
        }

        User user = userOpt.get();
        Optional<Login> loginOpt = loginRepository.findByEmail(user.getEmail());
        if (!loginOpt.isPresent()) {
            throw new InvalidCredentialsException("Login details not found for user ID: " + userId);
        }

        Login login = loginOpt.get();
        if (login.getStatus() == Status.ACTIVE) {
            throw new IllegalStateException("Account is already active");
        }

        login.setStatus(Status.ACTIVE);
        loginRepository.save(login);
    }
}
