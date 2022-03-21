package com.lukaszzaranek.geoloc;

import com.lukaszzaranek.geoloc.dto.NewUserDto;
import com.lukaszzaranek.geoloc.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	void userIsCreatedSuccessfully() {
		NewUserDto userDto = new NewUserDto("Desind","testpass");
		Map<String,String> response = userService.saveUser(userDto);
		assert(response.get("username").equals("Desind"));
	}

	@ParameterizedTest
	@CsvSource({
			",,false",
			"Desind2,testpass,true",
			"asdfg,asdfg,true",
			"Desind3,a,false",
			"a,testpass,false",
			"诶必西弟衣,诶必西弟衣,true",
	})
	void correctlyChecksLengthOfPasswordAndUsername(String username, String password, boolean expectedResult) {
		NewUserDto userDto = new NewUserDto(username,password);
		Map<String,String> response = userService.saveUser(userDto);
		if(expectedResult){
			Assert.assertEquals(username, response.get("username"));
		}else{
			Assert.assertEquals("Username or password too short", response.get("message"));
		}
	}

	@Test
	void unableToCreateUsernameDuplicate() {
		NewUserDto userDto = new NewUserDto("Desind","testpass");
		userService.saveUser(userDto);
		Map<String,String> response = userService.saveUser(userDto);
		assert(response.get("message").equals("Username is already taken"));
	}

}
