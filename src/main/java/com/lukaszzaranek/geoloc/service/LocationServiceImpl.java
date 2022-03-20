package com.lukaszzaranek.geoloc.service;

import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.model.Location;
import com.lukaszzaranek.geoloc.model.User;
import com.lukaszzaranek.geoloc.repository.LocationRepository;
import com.lukaszzaranek.geoloc.repository.UserRepository;
import com.lukaszzaranek.geoloc.service.interfaces.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    //90.0000000
    Integer MAX_LATITUDE = 900000000;
    //180.0000000
    Integer MAX_LONGITUDE = 1800000000;

    @Override
    public Map<String, String> saveLocation(NewLocationDto newLocationDto, String username) {
        Location location = new Location();
        String message = "";
        Map<String,String> saveMessage = new HashMap<>();
        if(Math.abs(newLocationDto.getLatitude())>MAX_LATITUDE){
            message += "Latitude out of range (-" + MAX_LATITUDE + "," + MAX_LATITUDE + ") ";
        }
        if(Math.abs(newLocationDto.getLongitude())>MAX_LONGITUDE){
            message += "Longitude out of range (-" + MAX_LONGITUDE + "," + MAX_LONGITUDE + ")";
        }
        if(message.length() != 0){
            saveMessage.put("message",message);
            return saveMessage;
        }
        User user = userRepository.findByUsername(username);
        location.setDeviceName(newLocationDto.getDeviceName());
        location.setLatitude(newLocationDto.getLatitude());
        location.setLongitude(newLocationDto.getLongitude());
        location.setUser(user);

        try{
            location = locationRepository.save(location);
            saveMessage.put("id", String.valueOf(location.getId()));
            saveMessage.put("username", location.getUser().getUsername());
            saveMessage.put("deviceName", location.getDeviceName());
            saveMessage.put("latitude", String.valueOf(location.getLatitude()));
            saveMessage.put("longitude", String.valueOf(location.getLongitude()));
            return saveMessage;
        }catch (Exception e){
            saveMessage.put("error", e.getMessage());
            return saveMessage;
        }
    }
}
