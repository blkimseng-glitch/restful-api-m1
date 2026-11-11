package kh.edu.istad.restfulapim1.controller;


import kh.edu.istad.restfulapim1.dto.AddUserRequest;
import kh.edu.istad.restfulapim1.dto.UserRespone;

import kh.edu.istad.restfulapim1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }

    @PostMapping
    public UserRespone addUser(@RequestBody AddUserRequest addUserRequest){
        return userService.create(addUserRequest);
    }

    @GetMapping
    public List<UserRespone> getUsers(){
        return userService.getUsers();
    }
}
