package disney.challenge.auth.dto;

import disney.challenge.dto.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AuthRequestDTO {

    private String username;
    private String password;
}
