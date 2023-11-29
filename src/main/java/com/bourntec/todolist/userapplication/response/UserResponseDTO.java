package com.bourntec.todolist.userapplication.response;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.bourntec.todolist.userapplication.entity.UserItems;
import com.bourntec.todolist.userapplication.status.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	private Integer taskId;
	private String title;
	private String description;
	private LocalDateTime creationDate;
	private String createdByUser;
	private LocalDateTime modificationDate;
	private String modifiedByUser;
	private String estimatedTime;
	
	private UserStatus toDoStatus;

	public UserResponseDTO(UserItems userItems)  {
		BeanUtils.copyProperties(userItems,this);
	}

	
}
