package com.shopsusers.mapper;

import com.shopsusers.dto.AvatarDto;
import com.shopsusers.models.entity.AvatarEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-31T18:40:25-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class AvatarMapperImpl implements AvatarMapper {

    @Override
    public AvatarEntity avatarDtoToavatar(AvatarDto avatarDto) {
        if ( avatarDto == null ) {
            return null;
        }

        AvatarEntity avatarEntity = new AvatarEntity();

        avatarEntity.setId( avatarDto.getId() );
        avatarEntity.setName( avatarDto.getName() );
        avatarEntity.setLastName( avatarDto.getLastName() );
        avatarEntity.setEmail( avatarDto.getEmail() );

        return avatarEntity;
    }

    @Override
    public AvatarDto avatarToavatarDto(AvatarEntity avatarEntity) {
        if ( avatarEntity == null ) {
            return null;
        }

        AvatarDto avatarDto = new AvatarDto();

        avatarDto.setId( avatarEntity.getId() );
        avatarDto.setName( avatarEntity.getName() );
        avatarDto.setLastName( avatarEntity.getLastName() );
        avatarDto.setEmail( avatarEntity.getEmail() );

        return avatarDto;
    }
}
