package com.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.food.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
