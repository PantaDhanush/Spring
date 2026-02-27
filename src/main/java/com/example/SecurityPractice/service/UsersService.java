package com.example.SecurityPractice.service;

import com.example.SecurityPractice.dao.UserRequestDao;
import com.example.SecurityPractice.entity.Users;
import com.example.SecurityPractice.repo.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Users save(UserRequestDao userRequestDao) {
        Users user = new Users();
        user.setName(userRequestDao.getName());
        user.setEmail(userRequestDao.getEmail());
        user.setRole(userRequestDao.getRole());
        user.setPassword(passwordEncoder.encode(userRequestDao.getPassword()));
        return usersRepository.save(user);
    }
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    }
}
