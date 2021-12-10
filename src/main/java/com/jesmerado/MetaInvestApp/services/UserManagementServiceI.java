package com.jesmerado.MetaInvestApp.services;


import java.util.List;

import com.jesmerado.MetaInvestApp.persistence.User;

/**
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 */
public interface UserManagementServiceI {

    /**
     * @return all the users.
     */
    List<User> findAll();

    /**
     * Add user.
     */
    void insertUser(User user);

    /**
     * Remove user.
     */
    void removeUser(User user);

    /**
     * @param user to update.
     */
    void updateUser(User user, String name, String mail, String password);

    /**
     * @return the user.
     */
    User findByMailAndPassword(final String mail, final String password);

    /**
     * Find user by id.
     *
     * @param user
     * @return
     */
    User findById(final User user);


}
