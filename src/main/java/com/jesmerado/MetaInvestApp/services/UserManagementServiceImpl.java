package com.jesmerado.MetaInvestApp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesmerado.MetaInvestApp.persistence.User;
import com.jesmerado.MetaInvestApp.persistence.UserRepositoryI;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
@Service
public class UserManagementServiceImpl implements UserManagementServiceI {

    @Autowired
    private UserRepositoryI userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void insertUser(User user) {
        userRepo.saveAndFlush(user);

    }

    @Override
    public void removeUser(User user) {
        userRepo.delete(user);

    }

    @Override
    public void updateUser(User user, String name, String mail, String password) {
        // Check the values.
        if (!(name.length() == 0)) {
            user.setName(name);
        }
        if (!(mail.length() == 0)) {
            user.setMail(mail);
        }
        if (!(password.length() == 0)) {
            user.setPassword(password);
        }
        userRepo.save(user);

    }

    @Override
    public User findByMailAndPassword(String mail, String password) {
        return userRepo.findByMailAndPassword(mail, password);
    }

    @Override
    public User findById(User user) {
        return userRepo.findByEntityId(user.getEntityId());
    }


}
