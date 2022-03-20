package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.dto.LocationDto;
import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.model.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LocationService {
    Map<String, String> saveLocation(NewLocationDto newLocationDto, String username);
    List<LocationDto> getLocation(String username);
}
