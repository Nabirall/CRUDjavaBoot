package com.example.CRUDjavaBoot.dao;

import com.example.CRUDjavaBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {


}