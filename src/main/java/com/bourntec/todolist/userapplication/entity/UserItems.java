package com.bourntec.todolist.userapplication.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bourntec.todolist.userapplication.status.UserStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "toDoItemsList")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	private String title;
	private String description;

	@CreationTimestamp
	private LocalDateTime creationDate;
	
	@CreatedBy
	private String createdByUser;
	
	@UpdateTimestamp
	private LocalDateTime modificationDate;
	
	@LastModifiedBy
	private String modifiedByUser;
	
	private String estimatedTime;
	
	@Enumerated(EnumType.STRING)
	private UserStatus toDoStatus;

}
