package com.example.demo.controlllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.WebUser;
import com.example.demo.exceptions.DuplicateValueException;
import com.example.demo.ifaces.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegisterRequest request) throws DuplicateValueException {

    	if (userRepository.existsByUsername(request.username())) {
            throw new DuplicateValueException("Username is already taken!");
        }
        if (userRepository.existsByEmail(request.email())) {
            throw new DuplicateValueException("Email is already in use!");
        }

        WebUser user = new WebUser();
        user.setUsername(request.username());
        user.setEmail(request.email());
        
        user.setPassword(passwordEncoder.encode(request.password())); 
        user.setRole(request.role());
        
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WebUser portalUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));

        return User.builder()
                .username(portalUser.getUsername())
                .password(portalUser.getPassword())
                .roles(portalUser.getRole()) 
                .build();
    }

}
