package com.lukaszzaranek.geoloc.api;

import com.lukaszzaranek.geoloc.dto.LocationDto;
import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.model.Location;
import com.lukaszzaranek.geoloc.service.interfaces.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/location")
@AllArgsConstructor
@Slf4j
public class LocationController {

    public final LocationService locationService;

    @PostMapping
    public ResponseEntity<?> saveNewLocation(HttpServletRequest request, @RequestBody NewLocationDto newLocationDto){
        Map<String,String> message = locationService.saveLocation(newLocationDto, request.getRemoteUser());
        if(message.containsKey("id")){
            return ResponseEntity.status(201).body(message);
        }else{
            return ResponseEntity.status(400).body(message);
        }
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getUserLocation(HttpServletRequest request){
        return ResponseEntity.status(200).body(locationService.getLocation(request.getRemoteUser()));
    }
}
