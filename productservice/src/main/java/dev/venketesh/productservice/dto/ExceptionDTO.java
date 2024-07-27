package dev.venketesh.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDTO {

    public ExceptionDTO(HttpStatus errorCode,String message){
        this.errorCode = errorCode;
        this.message =message;
    }
    private HttpStatus errorCode;
    private String message;
}
