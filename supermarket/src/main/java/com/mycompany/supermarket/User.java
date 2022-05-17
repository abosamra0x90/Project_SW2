/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import com.mycompany.supermarket.database.SQLQueries;
import com.mycompany.supermarket.database.DatabasePraparedQuery;
import com.mycompany.supermarket.database.DatabaseOperations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author moham
 */
public class User implements DatabaseOperations {
    private String Name ,password,NewName,Newpassword;
    public  User (String Name,String password){
    this.Name = Name ;
    this.password = password;
    }
    public  User (Arguments NewData){
        NewName=NewData.newusername.getText();
        Newpassword=NewData.newpassword.getText();
        this.Name = NewData.username.getText() ;
        this.password = NewData.password.getText();  
    }
    @Override
    public void Insert() {
        try {
            PreparedStatement Prepared_Statement = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.InsertUsers());
            Prepared_Statement.setString(1, Name);
            Prepared_Statement.setString(2, password);
            ResultSet Result = Prepared_Statement.executeQuery();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update() {
         try 
         {
            PreparedStatement Prepared_Statement = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.Updateusers());
            Prepared_Statement.setString(1, NewName);
            Prepared_Statement.setString(2, Newpassword);
            Prepared_Statement.setString(3, Name);
            Prepared_Statement.setString(4, password);
            ResultSet Result = Prepared_Statement.executeQuery();
            JOptionPane.showMessageDialog(null , "Update Sucessfully");
           
        } 
         catch (SQLException ex) 
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete() {
        
    }
    public ResultSet search(){
        try {
            PreparedStatement Prepared_Statement = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.SearchForUser());
            Prepared_Statement.setString (1,Name);
            Prepared_Statement.setString(2,password);
            System.out.println(Prepared_Statement);
            ResultSet result = Prepared_Statement.executeQuery();
            return result;
              
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
             
        }
   return null; }
    public String getusername(){
    return this.Name;
    }
    
   public String getpassword(){
    return this.password;
    }
   public void PreparedForUpdate(Arguments NewData){
     try
        {
            User InsertData = new User(Name,password);
            ResultSet Result = InsertData.search();   
            if (Result.next()) {
                GoodResultForUser.checkUserForUpdate(NewData);
            }
            else
            {
                DataInViwe.ShowTextMessage("username and password are not correct");
            } 
        }
     catch( Exception  e )
        {
            DataInViwe.ShowTextMessage(e.toString());   
        }
   }
       public static void checkUser(javax.swing.JTextField username,JFrame Currentframe){
           if (username.getText().equals("Admin")){
              InterFaces.SwitchTOAdminInterFace(Currentframe);
            }
           else {
               InterFaces.SwitchTOUserInterface(Currentframe, username);
            }
    }
       public static void checkUserForUpdate(Arguments NewData){
           if (NewData.username.getText().equals("Admin")){
              DataInViwe.ShowTextMessage("you cannot edite name to Admin");
            }
           else {
               if (NewData.renewpassword.getText().equals(NewData.newpassword.getText())){
                 
               }
               else {
               DataInViwe.ShowTextMessage("password andrepassword are not same");
               }
            }
    }
           
}
