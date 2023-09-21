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
public class WarehouseManager {
    static Warehouse warehouse = new Warehouse();
    static CollectorProductList warehouseProductList = new CollectorProductList();
    private void SetWarehouse()
    {
    }
    
    public static CollectorProductList getWarehouseProductList(){
        return  warehouseProductList;
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
        addCollectorProduct(receipt);
        warehouse.addReceipt(receipt);
        warehouse.setUpdateDate(receipt.getTimeUpdate());
    }
    
    public void addCollectorProduct(Receipt receipt){
        warehouseProductList.add();
        receipt.setCollectorProductList(warehouseProductList);
    }
    
    public Warehouse getWarehouse(){
        return warehouse;
    }
}