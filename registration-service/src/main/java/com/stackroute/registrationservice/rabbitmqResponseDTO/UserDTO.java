package com.stackroute.registrationservice.rabbitmqResponseDTO;

import com.stackroute.registrationservice.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String emailId;
    private String userName;

    private String password;

    private Role role;
}
