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
    private String Product_Name,IProduct_ID,Product_Expiration,Product_Production,Product_Catcegories;
    public Product (){
    
    }
    @Override
    public void Insert() {
       try {
           PreparedStatement preparedStatement = DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getInsertQuery());
           preparedStatement.setString(1,Product_Name);
           preparedStatement.setString(2,IProduct_ID);
           preparedStatement.setString(3,Product_Expiration);
           preparedStatement.setString(4,Product_Production);
           preparedStatement.setInt(5,Product_Quantity);
           preparedStatement.setFloat(6,Product_Price);
           preparedStatement.setString(7,Product_Catcegories);
           preparedStatement.setFloat(8,No_Gain_Price);
           preparedStatement.executeUpdate();
           DataInViwe.ShowTextMessage("Add Sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(Gui.product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void InsertProduct(Arguments PruductArguments){
    this.Product_Name = PruductArguments.Product_Name; 
    this.IProduct_ID = PruductArguments.IProduct_ID; 
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
           preparedStatement.setString(7,IProduct_ID);
           
           preparedStatement.setFloat(6,No_Gain_Price);
           preparedStatement.executeUpdate();
           DataInViwe.ShowTextMessage("Update Sucessfully");
           
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UpdateProduct(Arguments PruductArguments){
    this.Product_Name = PruductArguments.Product_Name; 
    this.IProduct_ID = PruductArguments.IProduct_ID; 
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
            preparedStatement.setString(1,IProduct_ID);
            preparedStatement.executeUpdate();
            DataInViwe.ShowTextMessage("Delete Sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteProduct(String IProduct_ID){
    this.IProduct_ID = IProduct_ID;
    Delete();
    
    }
       public void SerachProduct(Arguments PruductArguments)
    {
        try{
            PreparedStatement preparedStatement= DatabasePraparedQuery.Database_PreparedStatement(SQLQueries.getSearchQuery());
            preparedStatement.setString(1, PruductArguments.Product_Name);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                PruductArguments.IProduct_ID = resultSet.getString("IProduct_ID");
                PruductArguments.Product_Name = resultSet.getString("Product_Name");
                PruductArguments.Product_Expiration = resultSet.getString("Product_Expiration");
                PruductArguments.Product_Production = resultSet.getString("Product_Production");
                PruductArguments.Product_Quantity = resultSet.getInt("Product_Quantity");
                PruductArguments.Product_Price = resultSet.getFloat("Product_Price");
                PruductArguments.No_Gain_Price = resultSet.getFloat("No_Gain_Price");
            }
            else {
                DataInViwe.ShowTextMessage("Not Found");
            }
        }
        catch(Exception e){
            DataInViwe.ShowTextMessage(e.getMessage());
        }
    }
    public void AddOrder_Product(Arguments PruductArguments ,JTable jtable) throws SQLException{    
        SerachProduct(PruductArguments);
        PruductArguments.TotalPrice = TotalPrice.CalculateTotalPrice(PruductArguments);
        DataInViwe Test = new DataInViwe();
        Test.TransformArgument_ToList(PruductArguments, jtable);
    }
    public ResultSet showProducts(JTable jframe){
        ResultSet resultSet = GetDataFromDataBase.GetTableProduct();
        try {
            DataInViwe showTable =new DataInViwe();
            showTable.ShowTableProducts(resultSet,jframe);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    public void BuyProducts(JTable TableOfProducts,String UserName){
        DefaultTableModel ModelOfProducts=(DefaultTableModel)TableOfProducts.getModel();
        Arguments ProductArguments = new Arguments();
        ModelOfProducts.getRowCount();
        int CounterForRows = 1 ;
        int CounterForCoulmns = ModelOfProducts.getRowCount() ;
        while ( CounterForCoulmns>0){
            DataInJTable.SetDataInArguments(ProductArguments, ModelOfProducts, CounterForRows);
            SerachProduct(ProductArguments);
            Purchases.StorePurchases(ProductArguments, UserName);
            ProductArguments.Product_Quantity  = ProductArguments.Product_Quantity - ProductArguments.Quantity;
            UpdateProduct(ProductArguments);
            CounterForRows ++ ;
            CounterForCoulmns --;
        }
            
    }
     public ResultSet showProducts(JTable jframe){
        ResultSet resultSet = GetDataFromDataBase.GetTableProduct();
        try {
            DataInViwe showTable =new DataInViwe();
            showTable.ShowTableProducts(resultSet,jframe);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
}
