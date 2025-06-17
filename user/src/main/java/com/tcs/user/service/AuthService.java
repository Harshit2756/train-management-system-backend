package com.tcs.user.service;

import com.tcs.user.dto.AdminRegistrationDTO;
import com.tcs.user.dto.LoginDTO;
import com.tcs.user.dto.UserRegistrationDTO;
import com.tcs.user.exception.UserAlreadyExistsException;
import com.tcs.user.model.*;
import com.tcs.user.repository.CustomerRepository;
import com.tcs.user.repository.LoginRepository;
import com.tcs.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private EmailValidationService emailValidationService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(UserRegistrationDTO dto) {
        emailValidationService.validateEmail(dto.getEmail());
        if (customerRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists with email: " + dto.getEmail());
        }
        Customer customer = new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber(),
                dto.getAddress(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        customerRepository.save(customer);
        Login login = new Login(
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                UserType.CUSTOMER,
                Status.ACTIVE,
                LocalDateTime.now()
        );
        loginRepository.save(login);
    }

    public void registerAdmin(AdminRegistrationDTO dto) {
        emailValidationService.validateEmail(dto.getEmail());
        if (customerRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Admin already exists with email: " + dto.getEmail());
        }
        Customer customer = new Customer(
                dto.getName(),
                dto.getEmail(),
                dto.getContactNumber(),
                dto.getAddress(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        customerRepository.save(customer);
        Login login = new Login(
                dto.getEmail(),
                passwordEncoder.encode(dto.getPassword()),
                UserType.ADMIN,
                Status.ACTIVE,
                LocalDateTime.now()
        );
        loginRepository.save(login);
    }

    public String login(LoginDTO dto) {
        Optional<Login> loginOpt = loginRepository.findByEmail(dto.getEmail());
        if (loginOpt.isPresent()) {
            Login login = loginOpt.get();
            if (passwordEncoder.matches(dto.getPassword(), login.getPassword()) && login.getStatus() == Status.ACTIVE) {
                return JwtUtil.generateToken(login.getEmail());
            }
        }
        throw new RuntimeException("Invalid credentials or inactive user");
    }
} 