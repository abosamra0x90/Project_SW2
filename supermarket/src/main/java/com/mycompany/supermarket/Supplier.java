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
import com.mycompany.supermarket.database.DatabaseOperations;
import javax.swing.JTable;
/**
 *
 * @author moham
 */
public class Supplier implements DatabaseOperations {
    private String Name , Telphone;
    public Supplier(String Name,String Telphone){
        this.Name = Name;
        this.Telphone = Telphone;
    }
    @Override
    public void Insert() {
        try {
            PreparedStatement preparedStatement = com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.AddSupplier());
            preparedStatement.setString(1,this.Telphone);
            preparedStatement.setString(2,this.Name);
            
            ResultSet Resulte = preparedStatement.executeQuery();
            if(Resulte.next()){
                GoodResult.InsertDone();
            } 
        } 
        catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update() {
        try {
            PreparedStatement preparedStatement = com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.UpdateSupplier());
            preparedStatement.setString(1,this.Telphone);
            preparedStatement.setString(2,this.Name);
            ResultSet Resulte = preparedStatement.executeQuery();
            if(Resulte.next()){
                GoodResult.IUpdateDone();
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Delete() {
        try {
            PreparedStatement preparedStatement = com.mycompany.supermarket.database.DatabasePraparedQuery.Database_PreparedStatement(com.mycompany.supermarket.database.SQLQueries.DeleteSupplier());
            preparedStatement.setString(1,this.Name);
            ResultSet Resulte = preparedStatement.executeQuery();
            if(Resulte.next()){
                GoodResult.DeleteDone();
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void Show_All_Supplier(JTable jtable){
        ResultSet Resulte = GetDataFromDataBase.GetTableSupplier();
        ShowDataInGui ShowSuppliers = new ShowDataInGui();
        try {
            ShowSuppliers.ShowSuppliers(Resulte, jtable);
        } catch (SQLException ex) {
            Logger.getLogger(Supplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
