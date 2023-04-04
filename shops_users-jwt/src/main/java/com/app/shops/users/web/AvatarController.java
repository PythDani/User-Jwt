package com.app.shops.users.web;

import com.app.shops.users.dto.AvatarDto;
import com.app.shops.users.models.entity.Avatar;
import com.app.shops.users.services.IAvatarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

	@Autowired
	private IAvatarService service;

	@GetMapping("/")
	public Map<String, List<Avatar>> listar() {
		return Collections.singletonMap("Avatars", service.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		return ResponseEntity.ok(service.byId(id).get());
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveAvatar(@RequestBody Avatar avatar) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAvatar(avatar));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editAvatar(@RequestBody AvatarDto avatarDto, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.editAvatar(avatarDto, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		service.deleteAvatar(id);
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/search"
			+ "")
	public Avatar findByEmail(@RequestParam String email) {
		
			
		return service.byEmail(email).get();
	}
	
	@GetMapping("/authorized")
	public Map<String, Object> authorized(@RequestParam(name = "code") String code){
		
		return Collections.singletonMap("code", code);
	}
	

	private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
		Map<String, String> errors = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errors.put(err.getField(), "Field " + err.getField() + " " + err.getDefaultMessage());

		});
		return ResponseEntity.badRequest().body(errors);
	}


}
