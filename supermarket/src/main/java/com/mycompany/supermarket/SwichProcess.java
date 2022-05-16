/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

import javax.swing.JFrame;

/**
 *
 * @author moham
 */
public class SwichProcess {
    public SwichProcess(JFrame OpenFrame,JFrame CloseFrame){
        CloseFrame.dispose();
        OpenFrame.setVisible(true);
    }
}
