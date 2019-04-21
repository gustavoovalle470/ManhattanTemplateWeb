/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.primefaces.customize.controllers;

import org.primefaces.customize.UI.exceptions.ManhattanException;

/**
 *
 * @author OvalleGA
 */
public class LoginUsers {
    public static boolean ValidateCredentials(String user, String password) throws ManhattanException{
        String msg ="No se pudo iniciar sesión porque: ";
        if(user == null || password == null || 
           user.equals("") || password.equals("")
           || isInvalidCrendetial(user, password)){
            msg = msg+(user == null?"\n - El usuario no puede ser nulo":"")
                     +(password == null?"\n - La contraseña no puede ser nula":"")
                     +(user.equals("")?"\n - El usuario no puede estar vacio":"")
                     +(password.equals("")?"\n - La contraseña no puede estar vacia":"")
                     +(password.equals("")?"\n - El usuario y/o contraseña no son validos.":"");
            throw new ManhattanException(msg);
        }
        return true;
    }

    private static boolean isInvalidCrendetial(String user, String password) {
        if(!user.equals("govalle") && !password.equals("ovalle")){
            return false;
        }
        return true;
    }
}
