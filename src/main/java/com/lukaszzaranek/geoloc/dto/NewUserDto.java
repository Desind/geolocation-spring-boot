package com.lukaszzaranek.geoloc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewUserDto {
    String username;
    String password;
}
