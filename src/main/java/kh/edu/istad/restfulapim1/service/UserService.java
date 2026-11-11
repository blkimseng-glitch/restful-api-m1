package kh.edu.istad.restfulapim1.service;

import kh.edu.istad.restfulapim1.dto.AddUserRequest;
import kh.edu.istad.restfulapim1.dto.UserRespone;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void deleteById(UUID id);
    UserRespone create(AddUserRequest addUserRequest);

    List<UserRespone> getUsers();


}
