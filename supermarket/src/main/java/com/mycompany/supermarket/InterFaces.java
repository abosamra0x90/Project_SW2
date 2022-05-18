/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import Gui.AdminGui;
import Gui.LoginGui;
import Gui.PurchaseGui;
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
    public static void SwitchTOAdminInterFace (JFrame CurrentFrame){  
    AdminGui pointer_to_AdminInterface = new AdminGui();
    SwichProcess Switch = new SwichProcess(pointer_to_AdminInterface,CurrentFrame);
    }
    public static void SwitchTOUserInterface (JFrame CurrentFrame,javax.swing.JTextField username){  
    UserInterface pointer_to_Userinterface = new UserInterface(username.getText());
    SwichProcess Switch = new SwichProcess(pointer_to_Userinterface,CurrentFrame);
    }
    public static void SwitchTORegisterInterface (JFrame CurrentFrame){  
    Register pointer_to_RegisterInterface = new Register();
    SwichProcess Switch = new SwichProcess(pointer_to_RegisterInterface,CurrentFrame);
    }
    public static void SwitchTOLoginInterface (JFrame CurrentFrame){  
    LoginGui pointer_to_LoginInterface = new LoginGui();
    SwichProcess Switch = new SwichProcess(pointer_to_LoginInterface,CurrentFrame);
    }
    public static void SwitchTOproductInterface (JFrame CurrentFrame){  
    product pointer_to_productInterface = new product();
    SwichProcess Switch = new SwichProcess(pointer_to_productInterface,CurrentFrame);
    }
    public static void SwitchTOSupplierInterface (JFrame CurrentFrame){  
    SupplierGui pointer_to_productInterface = new SupplierGui();
    SwichProcess Switch = new SwichProcess(pointer_to_productInterface,CurrentFrame);
    }
    public static void SwitchTOReportOfPurchaseInterface (JFrame CurrentFrame,JTable jtable,String UserName ){  
    ReportOfPurchase pointer_to_ReportOfPurchaseInterface = new ReportOfPurchase(jtable,UserName);
    SwichProcess Switch = new SwichProcess(pointer_to_ReportOfPurchaseInterface,CurrentFrame);
    }
    public static void SwitchTOShowSupplierGuiInterface (JFrame CurrentFrame){  
    ShowSupplierGui SwitchTOShowSupplierGuiInterface = new ShowSupplierGui();
    SwichProcess Switch = new SwichProcess(SwitchTOShowSupplierGuiInterface,CurrentFrame);
    }
    public static void SwitchTOPurchaseGuiInterface (JFrame CurrentFrame, String UserName){  
    PurchaseGui SwitchTOPurchaseGuiInterface = new PurchaseGui(UserName);
    SwichProcess Switch = new SwichProcess(SwitchTOPurchaseGuiInterface,CurrentFrame);
    }
}
