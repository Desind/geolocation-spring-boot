package com.lukaszzaranek.geoloc.repository;

import com.lukaszzaranek.geoloc.dto.LocationDto;
import com.lukaszzaranek.geoloc.model.Location;
import com.lukaszzaranek.geoloc.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationRepository extends Repository<Location, Integer> {
    Location save(Location location);
    Location findById(Integer id);
    List<Location> findByUser(User user);
    void deleteById(Integer id);
    List<Location> findAll();
}
