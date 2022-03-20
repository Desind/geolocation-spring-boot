package com.lukaszzaranek.geoloc.dto;

import lombok.Data;

@Data
public class NewLocationDto {
    private String deviceName;
    private Integer latitude;
    private Integer longitude;
}
