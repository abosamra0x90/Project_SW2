package com.mycompany.supermarket.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muham
 */
public class SQLQueries {
    private static String SearchQuery = "Select * from Product where Product_Name=?";
    private static String InsertQuery = "insert into Product"+"(Product_Name,IProduct_ID,Product_Expiration,Product_Production,Product_Quantity,Product_Price,Product_Catcegories,No_Gain_Price)"+ "values(?,?,?,?,?,?,?,?)";
    private static String InsertUsers = "INSERT INTO [dbo].[test]([username],[password])VALUES(?,?)";
    private static String UpdateQuery = "update Product set Product_Name=?,Product_Expiration=?,Product_Production=?,Product_Quantity=?,Product_Price=?,No_Gain_Price=? where IProduct_ID=?";
    private static String UpdateusersQuery = "update test set username=?,password=? where username=? AND password=?";
    private static String DeleteQuery = "Delete from Product where IProduct_ID=?";
    private static String CategoryQuery = "select * from Category";
    private static String SearchForUserQuery = "Select * from test where username =? and password =?" ;
    private static String AddSupplierQuery = "insert into Supplier (Sup_Tel , Sup_Name ) "  +  " values ( ? , ?)" ;
    private static String DeleteSupplierQuery = "Delete from Supplier where Sup_Name=?" ;
    private static String UpdateSupplierQuery = "update Supplier set Sup_Tel=? where Sup_Name =?" ;
    private static String ShowtableProductQuery = "Select * from Product";
    private static String InsertpurchaseQuery = "insert into BuIng(NameOfUser,Name ,Quantity,Margin,Price, Profit)VALUES(?,?,?,?,?,?)";
    public static String getCategoryQuery() {
        return CategoryQuery;
    }

    public static String getDeleteQuery() {
        return DeleteQuery;
    }
    public static String getSearchQuery() {
        return SearchQuery;
    }

    public static String getInsertQuery() {
        return InsertQuery;
    }

    public static String getUpdateQuery() {
        return UpdateQuery;
    }
    public static String SearchForUser() {
        return SearchForUserQuery;
    }
    public static String InsertUsers() {
        return InsertUsers;
    }
    public static String Updateusers() {
        return UpdateusersQuery;
    }
    public static String AddSupplier() {
        return AddSupplierQuery;
    }
    public static String DeleteSupplier() {
        return DeleteSupplierQuery;
    }
    public static String UpdateSupplier() {
        return UpdateSupplierQuery;
    }
    public static String ShowtableProduct() {
        return ShowtableProductQuery;
    }
    public static String Insertpurchase() {
        return InsertpurchaseQuery;
    }
    
    
}
