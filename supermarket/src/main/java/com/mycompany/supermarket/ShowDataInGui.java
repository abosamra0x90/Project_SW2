/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mycompany.supermarket.database.DatabaseConnection;
import com.mycompany.supermarket.database.SQLQueries;
import java.awt.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.commons.dbutils.DbUtils;


/**
 *
 * @author moham
 */
public class ShowDataInGui {
   
    public static void ShowTextMessage(String Message){
    JOptionPane.showMessageDialog(null , Message);
    }
    
    public void ShowProducts(ResultSet resultSet,JTable jframe) throws SQLException{ 
        
        System.out.println(resultSet.next());
        Arguments ArgumentForAll = new Arguments();
        while(resultSet.next())
    {
           ArgumentForAll.Product_ID = resultSet.getString("Product_ID");
           ArgumentForAll.Product_Name = resultSet.getString("Product_Name");
           ArgumentForAll.Product_Expiration = resultSet.getString("Product_Expiration");
           ArgumentForAll.Product_Production = resultSet.getString("Product_Production");
           ArgumentForAll.Product_Quantity = resultSet.getInt("Product_Quantity");
           ArgumentForAll.Product_Price = resultSet.getFloat("Product_Price");
           String tbData[]={ArgumentForAll.Product_Name,ArgumentForAll.Product_ID,Integer.toString(ArgumentForAll.Product_Quantity),Float.toString(ArgumentForAll.Product_Price)};
           DataInJTable.PutFrom_DataTo_Jtable(jframe, tbData);
         }}
    public void ShowSuppliers(ResultSet resultSet,JTable jframe) throws SQLException{ 
        
        System.out.println(resultSet.next());
        Arguments ArgumentForAll= new Arguments ();
        while(resultSet.next())
    {
           ArgumentForAll.Name_Supplier = resultSet.getString("Sup_Name");
           ArgumentForAll.Telphone_Supplier = resultSet.getString("Sup_Tel");
           String tbData[]={ArgumentForAll.Name_Supplier,ArgumentForAll.Telphone_Supplier};
           DataInJTable.PutFrom_DataTo_Jtable(jframe, tbData);
         }
}
    public void ShoworderProduct(Arguments PruductArguments ,JTable jtable) throws SQLException{    
        Product Product_Found = new Product();
        Product_Found.SerachProduct(PruductArguments);
        PruductArguments.TotalPrice = TotalPrice.CalculateTotalPrice(PruductArguments);
        ShowDataInGui Test = new ShowDataInGui();
        String[] tbData = Test.TransformArgument_ToList(PruductArguments);
        DataInJTable.PutFrom_DataTo_Jtable(jtable, tbData);

    }
   public String[] TransformArgument_ToList(Arguments ArgumentProduct) throws SQLException{ 
         
           String tbData[]={
               ArgumentProduct.Product_ID,
               ArgumentProduct.Product_Name,
               Integer.toString(ArgumentProduct.Quantity),
               Float.toString(ArgumentProduct.Product_Price),
               Float.toString(ArgumentProduct.TotalPrice)};
        return tbData; }
   
}

    

