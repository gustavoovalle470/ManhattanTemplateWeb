/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.controllers.session;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

/**
 *
 * @author OvalleGA
 */
public class UserSessionManager {
    private static UserSessionManager instance;
    private final HashMap<String, HttpSession> users_online;
    
    public UserSessionManager(){
        users_online = new HashMap<String, HttpSession>();
    }
    
    public static UserSessionManager getInstance(){
        if(instance == null){
            instance = new UserSessionManager();
        }
        return instance;
    }
    
    public boolean isUserConnected(String username){
        return users_online.containsKey(username);
    }
    
    public void connectUser(String user, HttpSession session){
        users_online.put(user, session);
    }
    
    public void disconectUser(String user){
        users_online.get(user).invalidate();
        users_online.remove(user);
    }
    
    public void putAttribute(String user, String attribute, Object value){
        users_online.get(user).setAttribute(attribute, value);
    }
    
    public Object getAttribute(String user, String attribute){
        return users_online.get(user).getAttribute(attribute);
    }
    
    public String getUser(HttpSession session){
        for(String user: users_online.keySet()){
            if(users_online.get(user).equals(session)){
                return user;
            }
        }
        return "";
    }

    public boolean logout(HttpSession session) {
        users_online.remove(getUser(session));
        return true;
    }
}
