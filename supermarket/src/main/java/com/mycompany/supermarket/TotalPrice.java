/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermarket;

/**
 *
 * @author moham
 */
public class TotalPrice {
    public static float CalculateTotalPrice(Arguments productArguments){
        return productArguments.Quantity * productArguments.Product_Price;
    }
}
