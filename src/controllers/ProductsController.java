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
public class ProductsController {
    private static ProductsController instance;

    public static ProductsController Instance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new ProductsController();
        }
        return instance;
    }
    
    private ProductList productList = new ProductList();
    public ProductList getProductList(){
        return productList;
    }
    
    public void setProductList(ProductList productList){
        this.productList = productList;
    }
}
