/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.UI.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.customize.UI.utils.UIMessageManagement;
import org.primefaces.customize.controllers.session.UserSessionManager;

/**
 *
 * @author OvalleGA
 */
@SessionScoped
@ManagedBean(name = "UserSessionBean")
public class UserSessionBean {
    private String username;
    private HttpSession session;

    public UserSessionBean(){
        session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        username = UserSessionManager.getInstance().getUser(session);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String logout(){
        System.out.println("Cerrar la sesion para el usuario: "+username);
        if (UserSessionManager.getInstance().disconectUser(session)) {
            UIMessageManagement.putInfoMessage("La sesion del usuario "+username+" finalizó correctamente.");
            return "logout";
        } else {
            return "failed";
        }
    }
}
