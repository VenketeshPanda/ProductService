package dev.venketesh.productservice.commons;

import dev.venketesh.productservice.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommons {
    private RestTemplate restTemplate;

    public AuthCommons(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO validateToken(String token) {
        //Call the user service now to validate token
        ResponseEntity<UserDTO> responseEntity =
                restTemplate.getForEntity("http://UserService-prod-env.ap-south-1.elasticbeanstalk.com/users/validate/"+token, UserDTO.class);

        if(responseEntity.getBody()==null){
            //token is invalid
            return null;
        }
        return responseEntity.getBody();
    }
}
