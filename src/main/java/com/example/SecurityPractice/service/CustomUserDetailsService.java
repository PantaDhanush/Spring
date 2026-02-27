package com.example.SecurityPractice.service;
import com.example.SecurityPractice.repo.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.SecurityPractice.config.CustomUserDetails;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    UsersRepository usersRepository;
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email)
                .map(CustomUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}

