/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;
import com.mycompany.supermarket.database.SQLQueries;
import com.mycompany.supermarket.database.DatabasePraparedQuery;
import com.mycompany.supermarket.database.DatabaseOperations;
import com.mycompany.supermarket.TotalPrice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moham
 */
public class Product implements DatabaseOperations {
    private int Product_Quantity;
    public float Product_Price,No_Gain_Price;
    private String Product_Name,Product_ID,Product_Expiration,Product_Production,Product_Catcegories;
    public Product (){
    
    }
    @Override
    public void Insert() {
       try {
           PreparedStatement preparedStatementForProduct = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getInsertQuery());
           preparedStatementForProduct.setString(1,Product_Name);
           preparedStatementForProduct.setString(2,Product_ID);
           preparedStatementForProduct.setString(3,Product_Expiration);
           preparedStatementForProduct.setString(4,Product_Production);
           preparedStatementForProduct.setInt(5,Product_Quantity);
           preparedStatementForProduct.setFloat(6,Product_Price);
           preparedStatementForProduct.setString(7,Product_Catcegories);
           preparedStatementForProduct.setFloat(8,No_Gain_Price);
           preparedStatementForProduct.executeUpdate();
           ShowDataInGui.ShowTextMessage("Add Sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(Gui.product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsertProduct(Arguments PruductArguments){
    this.Product_Name = PruductArguments.Product_Name; 
    this.Product_ID = PruductArguments.Product_ID; 
    this.Product_Expiration = PruductArguments.Product_Expiration; 
    this.Product_Production = PruductArguments.Product_Production; 
    this.Product_Quantity = PruductArguments.Product_Quantity; 
    this.Product_Price = PruductArguments.Product_Price; 
    this.Product_Catcegories = PruductArguments.Product_Catcegories;
    this.No_Gain_Price = PruductArguments.No_Gain_Price;
    Insert();
    
    }

    @Override
    public void Update() {
           try {
           PreparedStatement preparedStatement = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getUpdateQuery());
           preparedStatement.setString(1,Product_Name);
           preparedStatement.setString(2,Product_Expiration);
           preparedStatement.setString(3,Product_Production);
           preparedStatement.setInt(4,Product_Quantity);
           preparedStatement.setFloat(5,Product_Price);
           preparedStatement.setString(7,Product_ID);
           
           preparedStatement.setFloat(6,No_Gain_Price);
           preparedStatement.executeUpdate();
           ShowDataInGui.ShowTextMessage("Update Sucessfully");
           
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateProduct(Arguments PruductArguments){
    this.Product_Name = PruductArguments.Product_Name; 
    this.Product_ID = PruductArguments.Product_ID; 
    this.Product_Expiration = PruductArguments.Product_Expiration; 
    this.Product_Production = PruductArguments.Product_Production; 
    this.Product_Quantity = PruductArguments.Product_Quantity; 
    this.Product_Price = PruductArguments.Product_Price; 
    this.Product_Catcegories = PruductArguments.Product_Catcegories;
    this.No_Gain_Price = PruductArguments.No_Gain_Price;

    Update();
    
    }

    @Override
    public void Delete() {
        try {   
            PreparedStatement preparedStatement= DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getDeleteQuery());
            preparedStatement.setString(1,Product_ID);
            preparedStatement.executeUpdate();
            ShowDataInGui.ShowTextMessage("Delete Sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteProduct(String Product_ID){
    this.Product_ID = Product_ID;
    Delete();
    
    }
       public void SerachProduct(Arguments PruductArguments)
    {
        try{
            PreparedStatement preparedStatement= DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getSearchQuery());
            preparedStatement.setString(1, PruductArguments.Product_Name);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                PruductArguments.Product_ID = resultSet.getString("Product_ID");
                PruductArguments.Product_Name = resultSet.getString("Product_Name");
                PruductArguments.Product_Expiration = resultSet.getString("Product_Expiration");
                PruductArguments.Product_Production = resultSet.getString("Product_Production");
                PruductArguments.Product_Quantity = resultSet.getInt("Product_Quantity");
                PruductArguments.Product_Price = resultSet.getFloat("Product_Price");
                PruductArguments.No_Gain_Price = resultSet.getFloat("No_Gain_Price");
            }
            else {
                ShowDataInGui.ShowTextMessage("Not Found");
            }
        }
        catch(Exception e){
            ShowDataInGui.ShowTextMessage(e.getMessage());
        }
    }
    
  
  

    public void showProducts(JTable ListOfProduct) throws SQLException {
        ShowDataInGui ShowData =new ShowDataInGui ();
        ResultSet Result = GetDataFromDataBase.GetTableProduct();
        ShowData.ShowProducts(Result, ListOfProduct);

    }
}
