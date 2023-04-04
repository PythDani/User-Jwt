package com.example.shops.users.service.outh2.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.example.shops.users.service.outh2.services.IUsuarioService;
import com.shops.commons.users.models.entity.Avatar;

@Component
public class InfoAddToken implements TokenEnhancer{
	
	
	@Autowired
	private IUsuarioService usuairioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		Avatar avatar = usuairioService.findByEmail(authentication.getName());
		info.put("name", avatar.getName());
		info.put("lastName", avatar.getLastName());
		info.put("email", avatar.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		
		return accessToken;
	}

}
