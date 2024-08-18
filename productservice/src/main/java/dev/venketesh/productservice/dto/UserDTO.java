package dev.venketesh.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String email;
    private String name;
    private List<Role> roles;
}
