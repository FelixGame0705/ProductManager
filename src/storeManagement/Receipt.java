/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Receipt {
    private CollectorProductList collectorProductList;
    private String code;
    private String timeUpdate;
    private TYPE_RECEIPT typeReceipt;

    public Receipt(String code, String timeUpdate, TYPE_RECEIPT typeReceipt) {
        this.code = code;
        this.timeUpdate = timeUpdate;
        this.typeReceipt = typeReceipt;
    }
    
    public Receipt(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    
    public TYPE_RECEIPT getTypeReceipt() {
        return typeReceipt;
    }

    public void setTypeReceipt(TYPE_RECEIPT typeReceipt) {
        this.typeReceipt = typeReceipt;
    }
    
    public CollectorProductList getCollectorProductList() {
        return collectorProductList;
    }

    public void setCollectorProductList(CollectorProductList warehouseProductList) {
        this.collectorProductList = warehouseProductList;
    }
}

enum TYPE_RECEIPT{
    IMPORT,
    EXPORT
}
