package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.model.User;

public interface UserService {
    User getUserByUsername(String username);
    User saveUser(NewUserDto newUserDto);
}
