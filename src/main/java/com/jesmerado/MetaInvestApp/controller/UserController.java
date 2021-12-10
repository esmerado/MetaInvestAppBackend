package com.jesmerado.MetaInvestApp.controller;

import com.jesmerado.MetaInvestApp.persistence.User;
import com.jesmerado.MetaInvestApp.services.UserManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * MetaInvest App - Javier Esmerado Vela
 *
 * @author esmer
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserManagementServiceI userManagementServiceI;

    /**
     *
     * @return a list of users.
     */
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userManagementServiceI.findAll();
    }

    /**
     *
     * To find a client by the mail and password.
     *
     * @param user
     * @return
     */
    @PostMapping("/getUserByMailAndPass")
    public User getUserByMailAndPass(@RequestBody User user) {
        return userManagementServiceI.findByMailAndPassword(user.getMail(), user.getPassword());
    }

    /**
     *
     * To add a new user.
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {

        if (userManagementServiceI.findByMailAndPassword(user.getMail(), user.getPassword()) != null ) {
            return "User exists";
        } else {
            userManagementServiceI.insertUser(user);
            return "New user is added";
        }
    }

    /**
     *
     * To remove a user.
     *
     * @param user
     * @return
     */
    @PostMapping("/remove")
    public String removeUser(@RequestBody User user) {
        userManagementServiceI.removeUser(user);
        return "User delete";
    }

    /**
     *
     * To update the user.
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        userManagementServiceI.updateUser(user, user.getName(), user.getMail(), user.getPassword());
        return "User updated.";
    }

    /**
     *
     * To find a client by the mail and password.
     *
     * @param user
     * @return
     */
    @PostMapping("/getById")
    public User getById(@RequestBody User user) {
        return userManagementServiceI.findById(user);
    }






}
