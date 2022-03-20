package com.lukaszzaranek.geoloc.repository;

import com.lukaszzaranek.geoloc.model.Location;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationRepository extends Repository<Location, Integer> {
    Location save(Location location);
    Location findById(Integer id);
    List<Location> findByUser(Integer id);
    void deleteById(Integer id);
    List<Location> findAll();
}
