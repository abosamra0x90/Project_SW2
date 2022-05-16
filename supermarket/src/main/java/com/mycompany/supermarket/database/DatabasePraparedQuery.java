package com.mycompany.supermarket.database;


import com.mycompany.supermarket.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author muham
 */
public class DatabasePraparedQuery {
    public static Connection connectorHande;
    public DatabasePraparedQuery() {
       DatabaseConnection databaseConnector = new DatabaseConnection();
       connectorHande = databaseConnector.Connector_database_handel();
       
    }
    public static PreparedStatement Database_PreparedStatement (String sqlQuery) throws SQLException
    {
        //PreparedStatement pst=connectorHande.prepareStatement(sqlQuery);
         DatabaseConnection databaseConnector = new DatabaseConnection();
       connectorHande = databaseConnector.Connector_database_handel();
        PreparedStatement preparedStatementt = connectorHande.prepareStatement(sqlQuery);
        return preparedStatementt;
    }
    
    
}
