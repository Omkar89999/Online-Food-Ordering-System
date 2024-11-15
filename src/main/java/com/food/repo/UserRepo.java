package com.food.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.food.entity.User;
import com.food.entity.UserCart;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);
	Optional<User> findById(User id);
}
