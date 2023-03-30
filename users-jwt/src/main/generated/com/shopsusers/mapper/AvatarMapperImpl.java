package com.shopsusers.mapper;

import com.shopsusers.dto.AvatarDto;
import com.shopsusers.models.entity.Avatar;
import com.shopsusers.models.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-28T17:08:54-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class AvatarMapperImpl implements AvatarMapper {

    @Override
    public Avatar avatarDtoToavatar(AvatarDto avatarDto) {
        if ( avatarDto == null ) {
            return null;
        }

        Avatar avatar = new Avatar();

        avatar.setId( avatarDto.getId() );
        avatar.setName( avatarDto.getName() );
        avatar.setLastName( avatarDto.getLastName() );
        avatar.setEmail( avatarDto.getEmail() );
        avatar.setPassword( avatarDto.getPassword() );
        List<Role> list = avatarDto.getRoles();
        if ( list != null ) {
            avatar.setRoles( new ArrayList<Role>( list ) );
        }

        return avatar;
    }

    @Override
    public AvatarDto avatarToavatarDto(Avatar avatar) {
        if ( avatar == null ) {
            return null;
        }

        AvatarDto avatarDto = new AvatarDto();

        avatarDto.setId( avatar.getId() );
        avatarDto.setName( avatar.getName() );
        avatarDto.setLastName( avatar.getLastName() );
        avatarDto.setEmail( avatar.getEmail() );
        avatarDto.setPassword( avatar.getPassword() );
        List<Role> list = avatar.getRoles();
        if ( list != null ) {
            avatarDto.setRoles( new ArrayList<Role>( list ) );
        }

        return avatarDto;
    }
}
