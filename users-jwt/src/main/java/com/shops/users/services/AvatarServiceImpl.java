package com.shops.users.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shops.commons.users.models.entity.Avatar;
import com.shops.users.dto.AvatarDto;
import com.shops.users.exceptionHandler.ResourceBadRequestException;
import com.shops.users.exceptionHandler.ResourceNotFoundException;
import com.shops.users.repositories.AvatarRepository;


@Service
public class AvatarServiceImpl implements IAvatarService {

    @Autowired
    private AvatarRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Avatar> listAll() {
        return (List<Avatar>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Avatar> byId(Long id) {

        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("avatar does not exists")));
    }

    @Override
    @Transactional
    public Avatar saveAvatar(Avatar avatar) {

        if (Objects.nonNull(avatar.getEmail()) && repository.existsByEmail(avatar.getEmail())) {

            throw new ResourceBadRequestException("mail, already exists");
        }

        if (!Objects.nonNull(avatar.getEmail())) {

            throw new ResourceBadRequestException("mail, cannot be null");

        }
        if (Objects.nonNull(avatar.getEmail()) && avatar.getEmail().isEmpty()) {

            throw new ResourceBadRequestException("mail, cannot be blank");
        }

        return repository.save(avatar);
    }

    @Override
    @Transactional
    public Avatar editAvatar(AvatarDto avatarDto, Long id) {

        Optional<Avatar> o = repository.findById(id);
        if (o.isPresent()) {

            Avatar avatarDb = o.get();


            if (!avatarDto.getEmail().isEmpty() && !avatarDto.getEmail().equalsIgnoreCase(avatarDb.getEmail()) && repository.findByEmail(avatarDto.getEmail()).isPresent()) {
                throw new ResourceBadRequestException("mail, already exists");
            }

            if (!Objects.nonNull(avatarDto.getEmail())) {

                throw new ResourceBadRequestException("mail, cannot be null");

            }

            if (Objects.nonNull(avatarDto.getEmail()) && avatarDto.getEmail().isEmpty()) {

                throw new ResourceBadRequestException("mail, cannot be blank");
            }

            avatarDb.setId(avatarDto.getId());
            avatarDb.setName(avatarDto.getName());
            avatarDb.setLastName(avatarDto.getLastName());
            avatarDb.setPassword(avatarDto.getPassword());
            avatarDb.setRoles(avatarDto.getRoles());
           
            repository.save(avatarDb);

            return avatarDb;
        }

        throw new ResourceNotFoundException("avatar does not exists");


    }

    @Override
    @Transactional
    public void deleteAvatar(Long id) {

        Optional<Avatar> o = repository.findById(id);
        if (o.isPresent()) {

            repository.deleteById(id);
        }else {throw new ResourceNotFoundException("avatar does not exists");}
    }

	@Override
	public Optional<Avatar> byEmail(String email) {

		Optional<Avatar> o = repository.findByEmail(email);
		if (o.isPresent()) {

			return o;
			
		} else {
			throw new ResourceNotFoundException("avatar does not exists");
		}

	}

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
