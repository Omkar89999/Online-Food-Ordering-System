package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
