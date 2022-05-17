/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class Purchases {
    public static void StorePurchases(Arguments PurchasesArguments ,String UserNameِ){
        try {
           PreparedStatement preparedStatement = com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.Insertpurchase());
           preparedStatement.setString(1,UserNameِ);
           preparedStatement.setString(2,PurchasesArguments.Product_Name);
           preparedStatement.setInt(3,PurchasesArguments.Quantity);
           preparedStatement.setFloat(4,PurchasesArguments.No_Gain_Price);
           preparedStatement.setFloat(5,PurchasesArguments.Product_Price);
           preparedStatement.setFloat(6,TotalPrice.CalculateTotalPrice(PurchasesArguments));
           preparedStatement.executeUpdate();
           
           
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
