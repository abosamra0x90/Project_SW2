/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;
import Gui.LoginGui;
import Gui.Register;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author moham
 */
public class InterFaces {
    public static void SwitchTORegisterInterface (JFrame CurrentFrame){  
    Register pointer_to_RegisterInterface = new Register();
    SwichProcess Switch = new SwichProcess(pointer_to_RegisterInterface,CurrentFrame);
    }
    public static void SwitchTOLoginInterface (JFrame CurrentFrame){  
    LoginGui pointer_to_LoginInterface = new LoginGui();
    SwichProcess Switch = new SwichProcess(pointer_to_LoginInterface,CurrentFrame);
    }

}
