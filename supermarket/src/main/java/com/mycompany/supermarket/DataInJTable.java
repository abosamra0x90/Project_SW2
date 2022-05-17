/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moham
 */
public class DataInJTable {
    public static void PutFrom_DataTo_Jtable (JTable jframe , String tbData[]){
           DefaultTableModel tblModel=(DefaultTableModel)jframe.getModel();
           jframe.setModel(tblModel);
           tblModel.addRow(tbData);
           jframe.setModel(tblModel);
           tblModel.fireTableDataChanged();
           jframe.setModel(tblModel);
    }
    public static void PutFrom_JTableTo_Jtable (JTable Injtable,JTable Outjtable){
        DefaultTableModel InModel=(DefaultTableModel)Injtable.getModel();
        Outjtable.setModel(InModel);
    }
    
}
