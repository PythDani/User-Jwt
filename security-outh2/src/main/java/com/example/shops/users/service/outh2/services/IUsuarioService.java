package com.example.shops.users.service.outh2.services;

import com.shops.commons.users.models.entity.Avatar;

public interface IUsuarioService {
	
	public Avatar findByEmail(String email);

}
