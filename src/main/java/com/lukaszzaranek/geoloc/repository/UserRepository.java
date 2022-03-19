package com.lukaszzaranek.geoloc.repository;

import com.lukaszzaranek.geoloc.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer>{
    User save(User user);
    User findByUsername(String username);
    User findByUserId(Integer id);
    void deleteByUserId(Integer id);
    List<User> findAll();
}
