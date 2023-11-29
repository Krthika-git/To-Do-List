package com.bourntec.todolist.userapplication.jwtsecurity.request;

import com.bourntec.todolist.userapplication.constants.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	@NotBlank(message = "First name should not be null")
	@Size(min = 2, max = 20, message = "First name should be from 5 to 20 characters")
	private String firstname;

	@Size(min = 1, max = 20, message = "Lst name should be from 1 to 20 characters")
	private String lastname;

	@NotNull(message = "Enter a valid email id")
	@Email
	private String email;

	@NotNull(message = "Must enter a password")
	@Size(min = 5, max = 20,message ="Password size should be between 5 to 20")
	@Pattern(regexp = "^[A-Za-z0-9$@_]+$", message = "Password cannot contain special characters other than $ _ @")

	private String password;

	private Role role;
}
