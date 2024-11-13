package com.exam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByusername(String username);

}
