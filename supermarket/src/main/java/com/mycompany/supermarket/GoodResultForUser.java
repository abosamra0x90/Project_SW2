/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import javax.swing.JFrame;

/**
 *
 * @author moham
 */
public class GoodResultForUser {
    public static void checkUser(javax.swing.JTextField username,JFrame Currentframe){
           User.checkUser(username, Currentframe);
    }    
    public static void checkUserForUpdate(Arguments NewData){
        User.checkUserForUpdate(NewData);
    }
}
