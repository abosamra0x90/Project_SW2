package com.mycompany.supermarket.database;




import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muham
 */
public class DatabaseConnection {

    private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url="jdbc:sqlserver://DESKTOP-TPLTUD0\\MSSQLSERVER:1433;databaseName=tesg;encrypt=true; trustServerCertificate=true;";
    private String user="test";
    private String pass="test";
    
    
    public DatabaseConnection() {
  
    }
    public Connection Connector_database_handel()
    {
     try
     {
        Class.forName(driver);
        Connection connectorHandel=DriverManager.getConnection(url, user, pass);  
        return connectorHandel;
     }
     catch(Exception e){
            System.out.print("connection error");
            Connection connector_Handel_faild = null;
            return connector_Handel_faild;
        }
     
     
    }
    
}
