/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Warehouse {

    private List<Receipt> receipts = new ArrayList<Receipt>();
    private String updateDate;

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDatePara) {
        updateDate = updateDatePara;
    }

}
