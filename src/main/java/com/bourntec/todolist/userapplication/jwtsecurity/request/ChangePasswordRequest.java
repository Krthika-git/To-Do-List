package com.bourntec.todolist.userapplication.jwtsecurity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ChangePasswordRequest {

	@NotBlank
	@Size(min = 5, max = 20,message ="Password size should be between 5 to 20")
	@Pattern(regexp = "^[^A-Za-z0-9$@_]+$", message = "Password cannot contain special characters other than $ _ @")
	private String currentPassword;

	@NotBlank
	@Size(min = 5, max = 20,message ="Password size should be between 5 to 20")
	@Pattern(regexp = "^[A-Za-z0-9$@_]+$", message = "Password cannot contain special characters other than $ _ @")
	private String newPassword;

	@NotBlank
	@Size(min = 5, max = 20,message ="Password size should be between 5 to 20")
	@Pattern(regexp = "^[^A-Za-z0-9$@_]+$", message = "Password cannot contain special characters other than $ _ @")

	private String confirmationPassword;
}
