package com.shopsusers.web;

import com.shops.commons.users.models.entity.Avatar;
import com.shopsusers.dto.AvatarDto;

import com.shopsusers.services.IAvatarService;
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

	private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
		Map<String, String> errors = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errors.put(err.getField(), "Field " + err.getField() + " " + err.getDefaultMessage());

		});
		return ResponseEntity.badRequest().body(errors);
	}

}
