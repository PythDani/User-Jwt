package com.example.shops.users.service.outh2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.shops.users.service.outh2.client.AvatarFeignClient;
import com.shops.commons.users.models.entity.Avatar;

@Service
public class AvatarService implements UserDetailsService,IUsuarioService {

	private Logger log = LoggerFactory.getLogger(AvatarService.class);

	@Autowired
	private AvatarFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Avatar avatar = client.findByEmail(email);

		if (avatar == null) {

			log.error("Avatar " + email + "  does not exist");
			throw new UsernameNotFoundException("Avatar " + email + "  does not exist");
		}

		List<GrantedAuthority> authorities = avatar.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());
		log.info("Avatar authenticated: " + email);

		return new User(avatar.getEmail(), avatar.getPassword(), true, true, true, true, authorities);
	}

	@Override
	public Avatar findByEmail(String email) {

		return client.findByEmail(email);
	}

}
