package com.shops.commons.users.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "avatars")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Avatar implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 15)
    private String name;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @Column(unique = true, length = 100)
    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @Column(length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "avatars_roles", joinColumns = @JoinColumn(name="avatar_id"), inverseJoinColumns = @JoinColumn(name="role_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"avatar_id", "role_id"})})
    private List<Role> roles;












}
