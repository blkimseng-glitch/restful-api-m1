package kh.edu.istad.restfulapim1.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record ApiErrorRespone<T>(
        String message,
        String code,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
}
