/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
      public void BuyProducts(JTable TableOfProducts,String UserName){
        DefaultTableModel ModelOfProducts=(DefaultTableModel)TableOfProducts.getModel();
        Arguments ProductArguments = new Arguments();
        ModelOfProducts.getRowCount();
        int CounterForRows = 1 ;
        int CounterForCoulmns = ModelOfProducts.getRowCount() ;
        while ( CounterForCoulmns>0){
            DataInJTable.SetDataInArguments(ProductArguments, ModelOfProducts, CounterForRows);
            Product Product_found = new Product(); 
            Product_found.SerachProduct(ProductArguments);
            Purchases.StorePurchases(ProductArguments, UserName);
            ProductArguments.Product_Quantity  = ProductArguments.Product_Quantity - ProductArguments.Quantity;
            Product_found.UpdateProduct(ProductArguments);
            CounterForRows ++ ;
            CounterForCoulmns --;
        }
            
    }
}
