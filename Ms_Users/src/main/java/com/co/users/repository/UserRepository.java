package com.co.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.users.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
