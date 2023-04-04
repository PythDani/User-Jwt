package com.example.shops.users.service.outh2.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shops.commons.users.models.entity.Avatar;

@FeignClient(name="shop-users")
public interface AvatarFeignClient {
	
	@GetMapping("/avatar/search")
	public Avatar findByEmail(@RequestParam String email);
}