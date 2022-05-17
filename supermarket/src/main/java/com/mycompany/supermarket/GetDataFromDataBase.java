/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moham
 */
public class GetDataFromDataBase {
    public static ResultSet GetTableProduct(){
        ResultSet resultSet = null ;
            try {
                PreparedStatement preparedStatement= com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.ShowtableProduct());
                resultSet = preparedStatement.executeQuery();
                
                return resultSet;
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

         return resultSet;
    }
    public static ResultSet GetTableSupplier(){
        ResultSet resultSet = null ;
            try {
                PreparedStatement preparedStatement= com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.ShowtableSupplierQuery());
                resultSet = preparedStatement.executeQuery();
                
                return resultSet;
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

         return resultSet;
    }
    
}
