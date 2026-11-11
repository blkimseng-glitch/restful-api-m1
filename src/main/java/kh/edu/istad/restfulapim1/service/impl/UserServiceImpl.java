package kh.edu.istad.restfulapim1.service.impl;

import kh.edu.istad.restfulapim1.dto.AddUserRequest;
import kh.edu.istad.restfulapim1.dto.UserRespone;
import kh.edu.istad.restfulapim1.model.User;
import kh.edu.istad.restfulapim1.repository.UserRepository;
import kh.edu.istad.restfulapim1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Override
    public void deleteById(UUID id) {
        if(!userRepository.checkById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userRepository.delete(id);
    }



    @Override
    public UserRespone create(AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.name());
        user.setPassword(addUserRequest.password());
        user.setEmail(addUserRequest.email());

        //2.Manage system data
        user.setId(UUID.randomUUID());

        //3. saved data
        userRepository.insertOne(user);

        return new UserRespone(
                user.getId(),
                user.getName()
        );

    }

    @Autowired
    public List<UserRespone> getUsers() {
        return userRepository.selectAllUsers()
                .stream()
                .map(user -> new UserRespone(user.getId(),
                        user.getName()
                     ))
                .toList();
    }
}
