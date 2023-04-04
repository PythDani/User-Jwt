package com.app.shops.users.services;

import com.app.shops.users.dto.AvatarDto;
import com.app.shops.users.models.entity.Avatar;

import java.util.List;
import java.util.Optional;

public interface IAvatarService {

    List<Avatar> listAll();

    Optional<Avatar> byId(Long id) ;

    Avatar saveAvatar(Avatar avatar);


    Avatar editAvatar(AvatarDto avatarDto, Long id);

    void deleteAvatar(Long id);

    Optional<Avatar> byEmail(String email);

    boolean existsByEmail(String email);
}
