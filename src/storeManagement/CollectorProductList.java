/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement;

import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class CollectorProductList extends ArrayList<CollectorProduct> {
    public void add(){
        CollectorProduct collectorProduct = new CollectorProduct();
        Product product = new Product();
        System.out.println("Product code: ");
        product.setProductCode(Utils.getString());
        System.out.println("Product name: ");
        product.setProductName(Utils.getString());
        System.out.println("Manufacturing date: ");
        product.setManuFacturingDate(Utils.validateDate());
        System.out.println("Expiration date: ");
        product.setExpirationDate(Utils.validateDate());
        System.out.println("Price: ");
        product.setPrice(Utils.getInt("", 0, 499999999));
        collectorProduct.setProduct(product);
        System.out.println("Quantity: ");
        collectorProduct.setQuantity(Utils.getInt("", 1, 499999999));
    }
}
