package kh.edu.istad.restfulapim1.dto;

public record AddUserRequest(
        String name,
        String email,
        String password
) {

}
