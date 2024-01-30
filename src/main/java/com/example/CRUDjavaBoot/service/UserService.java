package com.example.CRUDjavaBoot.service;

import com.example.CRUDjavaBoot.model.User;
import java.util.List;

public interface UserService {

List<User> getUsers();

void addUser(User user);

User getUserById(Long id);

void update(User user);

void delete(Long id);

}
