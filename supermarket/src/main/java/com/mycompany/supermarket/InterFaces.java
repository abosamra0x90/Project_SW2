/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import Gui.AdminGui;
import Gui.LoginGui;
import Gui.Register;
import Gui.ReportOfPurchase;
import Gui.ShowSupplierGui;
import Gui.SupplierGui;
import Gui.UserInterface;
import Gui.product;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author moham
 */
public class InterFaces {
   
    public static void SwitchTOUserInterface (JFrame CurrentFrame,javax.swing.JTextField username){  
    UserInterface pointer_to_Userinterface = new UserInterface(username.getText());
    SwichProcess Switch = new SwichProcess(pointer_to_Userinterface,CurrentFrame);
    }
    
    public static void SwitchTOproductInterface (JFrame CurrentFrame){  
    product pointer_to_productInterface = new product();
    SwichProcess Switch = new SwichProcess(pointer_to_productInterface,CurrentFrame);
    }
   
}
