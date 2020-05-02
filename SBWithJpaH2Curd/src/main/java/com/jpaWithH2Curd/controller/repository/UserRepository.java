package com.jpaWithH2Curd.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaWithH2Curd.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
