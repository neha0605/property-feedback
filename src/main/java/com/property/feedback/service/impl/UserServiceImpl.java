package com.property.feedback.service.impl;

import com.property.feedback.repository.models.User;
import com.property.feedback.service.UserService;
import com.property.feedback.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hojha on 23/10/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findUser(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return userRepo.findByUserId(userId);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

//    @Override
//    public Set<Book> findBookByUser(String name) {
//        List<User> byName = userRepo.findByName(name);
//        Set<Book> books = new HashSet<>();
//        byName.forEach(u -> {
//            books.addAll(u.getBooks());
//        });
//        return books;
//    }
}
