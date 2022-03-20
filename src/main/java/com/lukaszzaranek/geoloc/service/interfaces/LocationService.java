package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.dto.NewLocationDto;

import java.util.HashMap;
import java.util.Map;

public interface LocationService {
    Map<String, String> saveLocation(NewLocationDto newLocationDto, String username);
}
