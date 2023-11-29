package com.bourntec.todolist.userapplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.todolist.userapplication.entity.UserItems;
import com.bourntec.todolist.userapplication.exception.RecordNotFoundException;
import com.bourntec.todolist.userapplication.jwtsecurity.config.JwtAuthenticationFilter;
import com.bourntec.todolist.userapplication.jwtsecurity.service.AuthenticationService;
import com.bourntec.todolist.userapplication.jwtsecurity.service.JwtService;
import com.bourntec.todolist.userapplication.repository.ToDoListUserRepository;
import com.bourntec.todolist.userapplication.request.UserRequestDTO;
import com.bourntec.todolist.userapplication.response.UserResponseDTO;
import com.bourntec.todolist.userapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired

	ToDoListUserRepository userRepository;

	@Autowired
	JwtService jwtService;

	Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	JwtAuthenticationFilter jwtAuthenticationFilter;

	@Autowired
	AuthenticationService authenticationService;

	@Override
	public List<UserResponseDTO> getAll() {
		return userRepository.findAll().stream().map(UserResponseDTO::new).toList();
	}

	@Override
	public UserResponseDTO save(UserRequestDTO userRequestDTO) throws Exception {
		UserItems userItems = userRequestDTO.convertToModel();
		userItems = userRepository.save(userItems);
		return new UserResponseDTO(userItems);
	}

	@Override
	public UserResponseDTO findById(Integer taskId) throws Exception {
		if (userRepository.existsById(taskId)) {
			Optional<UserItems> userItems = userRepository.findById(taskId);

			return new UserResponseDTO(userItems.get());
		} else {
			throw new RecordNotFoundException(" id " + taskId + " not found");
		}

	}

	@Override
	public UserResponseDTO deleteById(Integer taskId) throws Exception {

		UserResponseDTO userResponseDTO = null;
		if (userRepository.existsById(taskId)) {
			Optional<UserItems> userItems = userRepository.findById(taskId);
			if (userItems.isPresent()) {
				userResponseDTO = new UserResponseDTO(userItems.get());
			}
			userRepository.deleteById(taskId);
			logger.info("The id " + taskId + " deleted successfully");

		} else
			throw new RecordNotFoundException(taskId + " id not found");

		return userResponseDTO;
	}

	@Override
	public UserResponseDTO updateById(Integer taskId, UserRequestDTO userRequestDTO) throws Exception {

		Optional<UserItems> userItems = userRepository.findById(taskId);
		UserItems toDoItem;
		if (userItems.isPresent()) {
			userRequestDTO.setTaskId(taskId);
			toDoItem = userItems.get();

			if (userRequestDTO.getTitle() != null) {
				toDoItem.setTitle(userRequestDTO.getTitle());
			}
			if (userRequestDTO.getDescription() != null) {
				toDoItem.setDescription(userRequestDTO.getDescription());

			}

			if (userRequestDTO.getEstimatedTime() != null) {
				toDoItem.setEstimatedTime(userRequestDTO.getEstimatedTime());
			}
			if (userRequestDTO.getToDoStatus() != null) {
				toDoItem.setToDoStatus(userRequestDTO.getToDoStatus());
			}

			toDoItem = userRepository.save(toDoItem);
		} else {

			throw new RecordNotFoundException("Data not found");
		}

		return new UserResponseDTO(toDoItem);

	}

}
