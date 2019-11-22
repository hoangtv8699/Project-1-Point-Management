/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.controller;

import com.qlsv.dao.UserDAO;
import com.qlsv.models.User;

/**
 *
 * @author Hiddenpants-H
 */
public abstract class Controller {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Controller(User user) {
        this.user = new UserDAO().findById(user);
    }
    public Controller() {
    }
    
}
