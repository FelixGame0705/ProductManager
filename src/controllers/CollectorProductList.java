/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class CollectorProductList extends ArrayList<CollectorProduct> implements Serializable {

    public void add() {
        CollectorProduct collectorProduct = new CollectorProduct();
        Product product = new Product();
        System.out.println("Product code: ");
        product.setProductCode(Utils.getString());
        System.out.println("Product name: ");
        product.setProductName(Utils.getString());
        System.out.println("Production date: ");
        collectorProduct.setManuFacturingDate(Utils.validateDate());
        System.out.println("Expiration date: ");
        collectorProduct.setExpirationDate(Utils.validateDate());
        System.out.println("Price: ");
        product.setPrice(Utils.getInt("", 0, 499999999));
        collectorProduct.setProduct(product);
        System.out.println("Quantity: ");
        collectorProduct.setQuantity(Utils.getInt("", 1, 499999999));
        checkExistProduct(product, collectorProduct);
    }
    
    public void minus(String code, int quantity){
        CollectorProduct collectorProduct = findCollectorProduct(code);
        if(quantity <= collectorProduct.getQuantity())
        collectorProduct.setQuantity(collectorProduct.getQuantity() - quantity);
        else{
            System.out.println("Error!!!!");
        }
    }

    public CollectorProductList getCollectorProductList() {
        return this;
    }

    public void showAll() {
        for (CollectorProduct e : this) {
            System.out.println("Product code: " + e.getProduct().getProductCode());
            System.out.println("Product name: " + e.getProduct().getProductName());
            System.out.println("Production date: " + e.getManuFacturingDate());
            System.out.println("Expiration date: " + e.getExpirationDate());
            System.out.println("Quantity: " + e.getQuantity());
        }
    }

    public void checkExistProduct(Product product, CollectorProduct collectorProduct) {
        for (Product e : ProductsController.Instance().getProductList()) {
            if (product.getProductCode().equals(e.getProductCode()) == true) {
                this.add(collectorProduct);
                return;
            }
        }
        System.out.println("Fail! Product does not exist");

    }
    
    public CollectorProduct findCollectorProduct(String id){
        for(int i = 0; i < this.size(); i++){
            if(this.get(i).getProduct().getProductCode().equals(id)){
                return this.get(i);
            }
        }
        return null;
    }
}
