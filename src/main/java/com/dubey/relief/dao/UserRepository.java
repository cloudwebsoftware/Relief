package com.dubey.relief.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dubey.relief.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
