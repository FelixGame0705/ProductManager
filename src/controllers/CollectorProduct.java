/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author DELL
 */
public class CollectorProduct {
    private Product product;
    private String manuFacturingDate;
    private String expirationDate;
    private int quantity;

    public String getManuFacturingDate() {
        return manuFacturingDate;
    }

    public void setManuFacturingDate(String manuFacturingDate) {
        this.manuFacturingDate = manuFacturingDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public CollectorProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public CollectorProduct(){}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
