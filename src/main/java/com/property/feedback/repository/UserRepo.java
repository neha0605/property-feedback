package com.property.feedback.repository;

import com.property.feedback.repository.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hojha on 23/10/16.
 */
public interface UserRepo extends JpaRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

    List<User> findAll();

    User findByEmail(String email);

    List<User> findByName(String name);

    User findByUserId(Integer userId);


}
