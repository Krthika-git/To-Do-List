package com.bourntec.todolist.userapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bourntec.todolist.userapplication.entity.UserItems;



public interface ToDoListUserRepository extends JpaRepository<UserItems, Integer>, JpaSpecificationExecutor<UserItems>{

}
