package com.app.shops.users.dto;



import java.util.List;

import com.app.shops.users.models.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvatarDto
{

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;

}
