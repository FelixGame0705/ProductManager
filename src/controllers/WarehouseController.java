/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.List;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class WarehouseController {
    
    private WarehouseController(){}
    private static WarehouseController instance;
    public static WarehouseController Instance(){
        if(instance!= null) return instance;
        else instance = new WarehouseController();
        return  instance;
    }
    
    Warehouse warehouse = new Warehouse();
    CollectorProductList collectorProductList = new CollectorProductList();
    
    public CollectorProductList geCollectorProductList(){
        return  collectorProductList;
    }
    
    public void setCollectorProductList(CollectorProductList collectorProductList){
        this.collectorProductList = collectorProductList;
    }
    
    public void addReceipt(Receipt receipt){
        System.out.println("Receipt code:");
        receipt.setCode(Utils.getString());
        System.out.println("Time update:");
        receipt.setTimeUpdate(Utils.validateDate());
    }
    
    public void addImportReceipt(){
        Receipt receipt = new Receipt();
        addReceipt(receipt);
        receipt.setTypeReceipt(TYPE_RECEIPT.IMPORT);
        addCollectorProduct(receipt);
        warehouse.addReceipt(receipt);
        warehouse.setUpdateDate(receipt.getTimeUpdate());
    }
    
    public void addExportReceipt(){
        Receipt receipt = new Receipt();
        addReceipt(receipt);
        receipt.setTypeReceipt(TYPE_RECEIPT.EXPORT);
        collectorProductList.minus(Utils.getString(), 0);
        warehouse.addReceipt(receipt);
        warehouse.setUpdateDate(receipt.getTimeUpdate());
    }
    
    public void addCollectorProduct(Receipt receipt){
        collectorProductList.add();
        receipt.setCollectorProductList(collectorProductList);
        
    }
}
