package com.lukaszzaranek.geoloc;

import com.lukaszzaranek.geoloc.dto.LocationDto;
import com.lukaszzaranek.geoloc.dto.NewLocationDto;
import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.service.interfaces.LocationService;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class LocationServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;

    String TEST_USER = "testuser";

    @Test
    void newUserHasNoLocations() {
        NewUserDto userDto = new NewUserDto(TEST_USER,TEST_USER);
        userService.saveUser(userDto);
        List<LocationDto> locations = locationService.getLocation(TEST_USER);
        assert(locations.size() == 0);
    }

    @Test
    void newLocationIsAdded(){
        int numberOfLocations = locationService.getLocation(TEST_USER).size();
        NewLocationDto newLocationDto = new NewLocationDto("phone",0,0);
        locationService.saveLocation(newLocationDto,TEST_USER);
        assert(numberOfLocations+1 == locationService.getLocation(TEST_USER).size());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0,true",
            "900000000,1800000000,true",
            "-900000000,1800000000,true",
            "-900000000,-1800000000,true",
            "900000000,-1800000000,true",
            "900000001,0,badLat",
            "-900000001,0,badLat",
            "0,1800000001,badLong",
            "0,-1800000001,badLong",
            "900000001,1800000001,badLat-badLong",
            "-900000001,-1800000001,badLat-badLong",
            "900000001,-1800000001,badLat-badLong",
            "-900000001,1800000001,badLat-badLong",
    })
    void parametersOutOfRangeAreRejected(Integer latitude, Integer longitude, String expectedResult){
        NewLocationDto newLocationDto = new NewLocationDto("phone", latitude, longitude);
        Map<String,String> result = locationService.saveLocation(newLocationDto,TEST_USER);
        if(expectedResult.equals("true")){
            assert(result.containsKey("id"));
        }else if(expectedResult.equals("badLat-badLong")){
            assert(result.get("message").contains("Latitude out of range")
                    && result.get("message").contains("Longitude out of range"));
        }else if(expectedResult.contains("badLat")){
            assert(result.get("message").contains("Latitude out of range"));
        }else if(expectedResult.contains("badLong")){
            assert(result.get("message").contains("Longitude out of range"));
        }
    }
}
