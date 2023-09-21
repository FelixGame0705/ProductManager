/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import storeManagement.dto.IList;
import utils.Utils;
/**
 *
 * @author DELL
 */
public class ProductList extends ArrayList<Product> implements IList{

    @Override
    public void add() {
        Product product = new Product();
        System.out.println("Product code: ");
        product.setProductCode(Utils.getString());
        System.out.println("Product name: ");
        product.setProductName(Utils.getString());
        System.out.println("Manufacturing date: ");
//        product.setManuFacturingDate(Utils.validateDate());
        System.out.println("Expiration date: ");
//        product.setExpirationDate(Utils.validateDate());
        System.out.println("Price: ");
        product.setPrice(Utils.getInt("", 0, 499999999));
        this.add(product);
    }

    @Override
    public void update() {
        System.out.println("Input product code");
        Product product = find(Utils.getString());
        System.out.println("Product code: ");
        product.setProductCode(Utils.getString());
        System.out.println("Product name: ");
        product.setProductName(Utils.getString());
//        System.out.println("Manufacturing date: ");
//        product.setManuFacturingDate(Utils.validateDate());
//        System.out.println("Expiration date: ");
//        product.setExpirationDate(Utils.validateDate());
        System.out.println("Price: ");
        product.setPrice(Utils.getInt("", 0, 499999999));
    }

    @Override
    public void delete() {
        this.remove(find(Utils.getString()));
    }

    @Override
    public void show(String code) {
        Product product = find(code);
        System.out.println("Product code: " + product.getProductCode());
        System.out.println("Product name: " + product.getProductName());
//        System.out.println("Product facturing date: " + product.getManuFacturingDate());
//        System.out.println("Product expiration date: " + product.getExpirationDate());
        System.out.println("Product price: " + product.getPrice());
        System.out.println("------------------------------------");
    }

    @Override
    public Product find(String code) {
        for(Product e : this){
            if(e.getProductCode().equals(code)){
                return e;
            }
        }
        return null;
    }
    
    @Override
    public void showAll(){
        for(Product product : this){
        System.out.println("Product code: " + product.getProductCode());
        System.out.println("Product name: " + product.getProductName());
//        System.out.println("Product facturing date: " + product.getManuFacturingDate());
//        System.out.println("Product expiration date: " + product.getExpirationDate());
        System.out.println("Product price: " + product.getPrice());
        System.out.println("------------------------------------");
        }
    }
    
}
