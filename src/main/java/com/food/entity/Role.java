package com.food.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {
	@Id
	private long id;
	private String roleName;

}
