package com.quickjwt.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quickjwt.entities.Authority;
import com.quickjwt.entities.User;
import com.quickjwt.exceptions.UserNotFoundException;
import com.quickjwt.models.RegistrationModel;
import com.quickjwt.repositories.AuthorityRepository;
import com.quickjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findOneByUsername(username);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }

        return user;
    }

    public void register(RegistrationModel registrationModel){
        User user = new User();
        user.setUsername(registrationModel.getUsername());
        user.setPassword(passwordEncoder.encode(registrationModel.getPassword()));
        Authority authority = this.authorityRepository.findOneByAuthority("ROLE_USER");


        user.setAuthorities(new HashSet<>());
        user.getAuthorities().add(authority);
        this.userRepository.save(user);
    }
}

