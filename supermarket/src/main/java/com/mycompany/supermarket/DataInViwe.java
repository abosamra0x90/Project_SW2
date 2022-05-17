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
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.commons.dbutils.DbUtils;


/**
 *
 * @author moham
 */
public class DataInViwe {
 
    public static void ShowTextMessage(String Message){
    JOptionPane.showMessageDialog(null , Message);
    }

}

    

