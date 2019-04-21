/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.controllers.session;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.primefaces.customize.UI.exceptions.ManhattanException;

/**
 *
 * @author OvalleGA
 */
public class LoginUsers {
    private static LoginUsers instance;
    
    public static LoginUsers getInstance(){
        if(instance == null){
            instance = new LoginUsers();
        }
        return instance;
    }
    
    public boolean ValidateCredentials(String user, String password, HttpSession session) throws ManhattanException{
        String msg ="No se pudo iniciar sesión porque: ";
        /**if(user == null || password == null || 
           user.equals("") || password.equals("")
           || UserSessionManager.getInstance().isUserConnected(user)
           || !isInvalidCrendetial(user, password)){
            msg = msg+(user == null?"\n - El usuario no puede ser nulo":"")
                     +(password == null?"\n - La contraseña no puede ser nula":"")
                     +(user.equals("")?"\n - El usuario no puede estar vacio":"")
                     +(password.equals("")?"\n - La contraseña no puede estar vacia":"")
                     +(UserSessionManager.getInstance().isUserConnected(user)?"\n - El usuario "+user+" ya tiene una sesión abierta.":"")
                     +(password.equals("")?"\n - El usuario y/o contraseña no son validos.":"");
            throw new ManhattanException(msg);
        }
        UserSessionManager.getInstance().connectUser(user, session); HABILITAR PARA UNA SOLA SESION.*/ 
        return true;
    }

    private static boolean isInvalidCrendetial(String user, String password) {
        if(!user.equals("govalle") && !password.equals("ovalle")){
            return false;
        }
        return true;
    }
    
    public static boolean logout(HttpSession session){
        System.out.println("Cerrando sesion para el usuario: "+UserSessionManager.getInstance().getUser(session));
        return UserSessionManager.getInstance().logout(session);
    }
}
