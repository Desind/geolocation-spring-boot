package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.model.User;

public interface UserService {

    User getUserByUsername(String username);
}
