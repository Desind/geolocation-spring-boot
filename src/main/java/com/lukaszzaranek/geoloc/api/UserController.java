package com.lukaszzaranek.geoloc.api;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    public final UserService userService;

    @PostMapping()
    public ResponseEntity<?> saveNewCookUser(@RequestBody NewUserDto newUserDto){
        Map<String, String> message = userService.saveUser(newUserDto);
        if (message.get("username") != null){
            return ResponseEntity.status(201).body(message);
        }
        return ResponseEntity.status(403).body(message);
    }

}

