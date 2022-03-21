package com.lukaszzaranek.geoloc;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class LoginTest {

    @Autowired
    private UserService userService;

    private static final String URL = "http://localhost:8080";

    @Test
    void canLogInSuccessfully(){
        NewUserDto userDto = new NewUserDto("Desind","testpass");
        userService.saveUser(userDto);

        Response response = RestAssured
                .given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                    .formParam("login", "Desind")
                    .formParam("password", "testpass")
                .when()
                    .post(URL + "/login");
        assert(response.statusCode() == 200);
    }
}
