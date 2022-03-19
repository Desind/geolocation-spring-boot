package com.lukaszzaranek.geoloc.api;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.model.User;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserController {
    public final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> saveNewCookUser(@RequestBody NewUserDto newUserDto){
        User newUser = userService.saveUser(newUserDto);
        if (newUser != null){
            Map<String, String> username = new HashMap<>();
            username.put("username",newUser.getUsername());
            return ResponseEntity.status(201).body(newUser);
        }
        return ResponseEntity.status(403).build();
    }
}

