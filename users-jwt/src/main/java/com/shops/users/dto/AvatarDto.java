package com.shops.users.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.shops.commons.users.models.entity.Role;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvatarDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;



}
