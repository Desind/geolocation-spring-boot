package com.lukaszzaranek.geoloc.service;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.model.User;
import com.lukaszzaranek.geoloc.repository.UserRepository;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public Map<String, String> saveUser(NewUserDto newUserDto) {
        Map<String, String> message = new HashMap<>();
        if(newUserDto.getUsername() == null
                || newUserDto.getPassword() == null
                || newUserDto.getUsername().length() < 5
                || newUserDto.getPassword().length() < 5
        ){
            message.put("message", "Username or password too short");
            return message;
        }
        User newUser = new User();
        newUser.setUsername(newUserDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(newUserDto.getPassword()));
        try{
            User user = userRepository.save(newUser);
            message.put("username", user.getUsername());
            log.info(user.toString());
        }catch (Exception e){
            message.put("message", "Username is already taken");
        }
        return message;
    }
}
