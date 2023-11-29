package com.bourntec.todolist.userapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.todolist.userapplication.request.UserRequestDTO;
import com.bourntec.todolist.userapplication.response.UserResponseDTO;
import com.bourntec.todolist.userapplication.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
@PreAuthorize("hasRole('ADMIN','USER')")

public class ToDoListUserController {

	@Autowired

	UserService toDoListService;

	@GetMapping("/{taskId}")
	@PreAuthorize("hasAuthority('admin:read') or hasAuthority('user:read')")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Integer taskId) throws Exception {

		return ResponseEntity.ok(toDoListService.findById(taskId));

	}

	@GetMapping("/all-todo")
	@PreAuthorize("hasAuthority('admin:read') or hasAuthority('user:read')")
	public ResponseEntity<List<UserResponseDTO>> getAll() throws Exception {

		return ResponseEntity.ok(toDoListService.getAll());

	}

	@PostMapping()
	@PreAuthorize("hasAuthority('user:create')")
	public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO userRequestDTO) throws Exception {

		return ResponseEntity.ok(toDoListService.save(userRequestDTO));
	}

	@PutMapping("/{taskId}")
	@PreAuthorize("hasAuthority('user:update')")
	public ResponseEntity<UserResponseDTO> updateById(@Valid @PathVariable Integer taskId,
			@RequestBody UserRequestDTO userRequestDTO) throws Exception {
		return ResponseEntity.ok(toDoListService.updateById(taskId, userRequestDTO));
	}

	@DeleteMapping("/{taskId}")
	@PreAuthorize("hasAuthority('user:delete')")
	public ResponseEntity<String> deleteById(@PathVariable Integer taskId) throws Exception {
		toDoListService.deleteById(taskId);
		return ResponseEntity.ok("Deleted successfully!");

	}

}
