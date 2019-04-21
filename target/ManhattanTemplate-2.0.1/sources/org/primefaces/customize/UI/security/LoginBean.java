/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.UI.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.customize.UI.exceptions.ManhattanException;
import org.primefaces.customize.UI.utils.UIMessageManagement;
import org.primefaces.customize.controllers.LoginUsers;

/**
 *
 * @author OvalleGA
 */
@RequestScoped
@ManagedBean(name = "LoginBean")
public class LoginBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String login(){
        //System.out.println("Login user: "+username+" with pass: "+password);
//        try {
//            if(LoginUsers.ValidateCredentials(username, password)){
//                return "autowired";
//            }else{
//                return "denied";
//            }
//        } catch (ManhattanException ex) {
//            UIMessageManagement.putErrorMessage(ex.getMsg());
//            return "denied";
//        }
return "denied";
    }
}
