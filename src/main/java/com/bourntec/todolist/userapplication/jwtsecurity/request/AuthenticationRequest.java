package com.bourntec.todolist.userapplication.jwtsecurity.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class AuthenticationRequest {

	@NotBlank(message = "Enter a valid email id")
	@Email
	private String email;

	@NotBlank
	@Size(min = 5, max = 20,message ="Password size should be between 5 to 20")
	@Pattern(regexp = "^[A-Za-z0-9$@_]+$", message = "Password cannot contain special characters other than $ _ @")
	String password;
}
