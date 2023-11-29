package com.bourntec.todolist.userapplication.service;

import java.util.List;

import com.bourntec.todolist.userapplication.request.UserRequestDTO;
import com.bourntec.todolist.userapplication.response.UserResponseDTO;

public interface UserService {

	public UserResponseDTO findById(Integer taskId)throws Exception;

	public List<UserResponseDTO> getAll()throws Exception;

	UserResponseDTO save(UserRequestDTO userRequestDTO)throws Exception;

	UserResponseDTO updateById(Integer taskId, UserRequestDTO userRequestDTO)  throws Exception;

	public UserResponseDTO deleteById(Integer taskId) throws Exception;
}
