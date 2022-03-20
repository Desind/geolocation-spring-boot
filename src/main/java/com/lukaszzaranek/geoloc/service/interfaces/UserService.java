package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.model.User;

import java.util.Map;

public interface UserService {
    User getUserByUsername(String username);
    Map<String, String> saveUser(NewUserDto newUserDto);
}
