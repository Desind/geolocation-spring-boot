package com.lukaszzaranek.geoloc.service;

import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.model.Location;
import com.lukaszzaranek.geoloc.repository.LocationRepository;
import com.lukaszzaranek.geoloc.service.interfaces.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Location saveLocation(NewLocationDto newLocationDto) {
        return null;
    }
}
