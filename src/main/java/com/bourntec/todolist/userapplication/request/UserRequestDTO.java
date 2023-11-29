package com.bourntec.todolist.userapplication.request;

import org.springframework.beans.BeanUtils;

import com.bourntec.todolist.userapplication.entity.UserItems;
import com.bourntec.todolist.userapplication.status.UserStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRequestDTO {
	private Integer taskId;
	
	@NotBlank
	@Size(min=3,max=10,message="Enter the new task titile")
	private String title;
	
	@Size(min=2,max=50,message="Enter the description of your new chase")
	private String description;
	
	@NotBlank(message="Enter how much time you needed to achieve the task")
	private String estimatedTime;
	
	@Enumerated(EnumType.STRING)
	private UserStatus toDoStatus;
	
	public UserItems convertToModel() {

		UserItems userItems = new UserItems();
		BeanUtils.copyProperties(this, userItems);
		return userItems;
	}
}