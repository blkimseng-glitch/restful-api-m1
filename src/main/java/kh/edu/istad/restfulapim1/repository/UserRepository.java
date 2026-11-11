package kh.edu.istad.restfulapim1.repository;

import kh.edu.istad.restfulapim1.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private final List<User> users;

    public boolean checkById(UUID id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }

    public UserRepository(){
        User user1 = new User(UUID.randomUUID(),"koko", "koko@gmail.com", "12345");
        User user2 = new User(UUID.randomUUID(),"kaka", "kaka@gmail.com", "23456");

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    public List<User> selectAllUsers(){
        return users;
    }

    public void insertOne(User user){
        users.add(user);
    }

    public void delete(UUID id){
        users.removeIf(u->u.getId().equals(id));
    }
}
