package com.example.CRUDjavaBoot.service;

import com.example.CRUDjavaBoot.dao.UserDAO;
import com.example.CRUDjavaBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


private final UserDAO userDao;

@Autowired
public UserServiceImpl(UserDAO userDao) {
    this.userDao = userDao;
}

@Override
public List<User> getUsers() {
    return userDao.findAll();
}

@Override
@Transactional
public void addUser(User user) {
    userDao.save(user);
}

@Override
public User getUserById(Long id) {
    return userDao.findById(id).orElseThrow(
            () -> new RuntimeException()
    );
}

@Override
@Transactional
public void update(User user){
    userDao.save(user);
}

@Override
@Transactional
public void delete(Long id) {
    userDao.deleteById(id);
}


}
