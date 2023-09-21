/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Product {
    private String productCode;
    private String productName;
    //private String manuFacturingDate;
    //private String expirationDate;
    private float price;
    
//    public Product(String productCode, String productName, String manuFacturingDate, String expirationDate, float price) {
//        this.productCode = productCode;
//        this.productName = productName;
//        this.manuFacturingDate = manuFacturingDate;
//        this.expirationDate = expirationDate;
//        this.price = price;
//    }

    public Product() {
    }
    
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public String getManuFacturingDate() {
//        return manuFacturingDate;
//    }
//
//    public void setManuFacturingDate(String manuFacturingDate) {
//        this.manuFacturingDate = manuFacturingDate;
//    }
//
//    public String getExpirationDate() {
//        return expirationDate;
//    }
//
//    public void setExpirationDate(String expirationDate) {
//        this.expirationDate = expirationDate;
//    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
