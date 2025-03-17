package com.pontta.hardware_shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontta.hardware_shopping.dto.CreateUserDto;
import com.pontta.hardware_shopping.dto.UserDto;
import com.pontta.hardware_shopping.entities.User;
import com.pontta.hardware_shopping.exceptions.EmailAlreadyExistsException;
import com.pontta.hardware_shopping.exceptions.ResourceNotFoundException;
import com.pontta.hardware_shopping.mappers.UserMapper;
import com.pontta.hardware_shopping.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public UserDto createUser(CreateUserDto createUserDto){

        if(this.userRepository.existsByEmail(createUserDto.email())){
            throw new EmailAlreadyExistsException();
        }

        User user = new User();
        user.setName(createUserDto.name());
        user.setEmail(createUserDto.email());

        User userSaved = userRepository.save(user);

        return userMapper.userToUserDto(userSaved);

    }

    public UserDto findUserById(Long id){

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException());

        return userMapper.userToUserDto(user);

    }

    public List<UserDto> findUsersByName(String name){
        return userRepository.findByNameContainingIgnoreCase(name)
                             .stream()
                             .map(userMapper::userToUserDto)
                             .toList();
    }

    public UserDto updateUser(Long id, CreateUserDto createUserDto){

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException());

        if(userRepository.existsByEmail(createUserDto.email()) && !user.getEmail().equals(createUserDto.email())){
            throw new EmailAlreadyExistsException();
        }

        user.setName(createUserDto.name());
        user.setEmail(createUserDto.email());

        return userMapper.userToUserDto(userRepository.save(user));

    }

    public void deleteUser(Long id){

        User user = userRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException());

        userRepository.delete(user);

    }

}
