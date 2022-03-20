package com.lukaszzaranek.geoloc.service.interfaces;

import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.model.Location;

public interface LocationService {
    Location saveLocation(NewLocationDto newLocationDto);
}
