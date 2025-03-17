package com.pontta.hardware_shopping.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.pontta.hardware_shopping.HardwareShoppingApplication;
import com.pontta.hardware_shopping.dto.CreateUserDto;
import com.pontta.hardware_shopping.dto.UserDto;
import com.pontta.hardware_shopping.exceptions.EmailAlreadyExistsException;

@SpringBootTest(classes = HardwareShoppingApplication.class)
@ActiveProfiles("test")
public class UserServiceTest {
    
    @Autowired
    UserService userService;

    @Test
    public void testaCriacao(){

        CreateUserDto createUserDto = new CreateUserDto("joao", "joao@email.com");

        UserDto user = userService.createUser(createUserDto);

        assertNotNull(user.id());
    }

    @Test
    public void testaMesmoEmail(){
        
        CreateUserDto createUserDto1 = new CreateUserDto("joao1", "joao1@email.com");
        CreateUserDto createUserDto2 = new CreateUserDto("joao2", "joao1@email.com");

        UserDto user1 = userService.createUser(createUserDto1);

        assertNotNull(user1.id());

        assertThrows(EmailAlreadyExistsException.class, ()-> userService.createUser(createUserDto2));

    }

}
