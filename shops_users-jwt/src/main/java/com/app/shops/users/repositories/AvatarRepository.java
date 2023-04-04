package com.app.shops.users.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.shops.users.models.entity.Avatar;

import java.util.Optional;

public interface AvatarRepository extends CrudRepository<Avatar, Long > {

    Optional<Avatar> findByEmail(String email);
    boolean existsByEmail(String email);
    Avatar findByname(String name);
    @Query("select u from Avatar u where u.name=?1")
    Avatar
    getByname(String name);



}
