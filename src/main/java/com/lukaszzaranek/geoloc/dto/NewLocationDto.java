package com.lukaszzaranek.geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewLocationDto {
    private String deviceName;
    private Integer latitude;
    private Integer longitude;
}
