/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.UI.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.customize.UI.exceptions.ManhattanException;
import org.primefaces.customize.UI.utils.UIMessageManagement;
import org.primefaces.customize.controllers.session.LoginUsers;

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
        try {
            if(LoginUsers.getInstance().ValidateCredentials(username, password, (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true))){
                UIMessageManagement.putInfoMessage("Bienvenido "+username);
                return "autowired";
            }else{
                return "denied";
            }
        } catch (ManhattanException ex) {
            UIMessageManagement.putErrorMessage(ex.getMsg());
            return "denied";
        }
    }
    
    public String logout(){
        System.out.println("Cerrar la sesion...");
        //System.out.println("Login user: "+username+" with pass: "+password);
        if (LoginUsers.logout((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true))) {
            UIMessageManagement.putInfoMessage("La sesion del usuario "+username+" finalizó correctamente.");
            return "logout";
        } else {
            return "failed";
        }
    }
}
