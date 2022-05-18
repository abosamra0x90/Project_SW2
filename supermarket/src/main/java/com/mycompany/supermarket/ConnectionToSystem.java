/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;
import Gui.AdminGui;
import Gui.UserInterface;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.mycompany.supermarket.InterFaces;

/**
 *
 * @author moham
 */
public class ConnectionToSystem {
    public static void  login(javax.swing.JPasswordField password,javax.swing.JTextField username,JFrame Currentframe)
    {
        try
        {
            User searchData = new User(username.getText(),password.getText());
            ResultSet Result = searchData.search();
            if (Result.next()) 
            {
                GoodResultForUser.checkUser(username, Currentframe);
            }
            else
            {
                ShowDataInGui.ShowTextMessage("username and password are not correct");
            }
        }
        catch( Exception  e )
        {
            JOptionPane.showMessageDialog(null , e);
        }
    }
}
