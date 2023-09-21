/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import storeManagement.dto.IList;

/**
 *
 * @author DELL
 */
public class ReportController {

    private ReportController() {
    }
    private static ReportController instance;

    public static ReportController Instance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new ReportController();
        }
        return instance;
    }

    public void reportProductsExpired(CollectorProductList collectorList) {
        for (CollectorProduct e : collectorList) {
            if (utils.Utils.calculateAge(LocalDate.parse(e.getExpirationDate()), LocalDate.now()) < 0) {
                show(e);
            }
        }
    }

    public void reportProductSelling(CollectorProductList collectorList) {
        for (CollectorProduct e : collectorList) {
            if (utils.Utils.calculateAge(LocalDate.parse(e.getExpirationDate()), LocalDate.now()) > 0) {
                show(e);
            }
        }
    }

    public void reportProductRunningOutOfStock(CollectorProductList collectorList) {
        sortCollectorProductList(collectorList);
        for (CollectorProduct e : collectorList) {
            if (utils.Utils.calculateAge(LocalDate.parse(e.getExpirationDate()), LocalDate.now()) > 0) {
                show(e);
            }
        }
    }

    private void sortCollectorProductList(CollectorProductList collectorProductList) {
        Collections.sort(collectorProductList, new Comparator<CollectorProduct>() {
            @Override
            public int compare(CollectorProduct o1, CollectorProduct o2) {
                return o1.getQuantity() < o2.getQuantity() ? -1 : 1;
            }
        });
    }

    public void show(CollectorProduct collectorProduct) {
        System.out.println("Product code: " + collectorProduct.getProduct().getProductCode());
        System.out.println("Product name: " + collectorProduct.getProduct().getProductName());
        System.out.println("Product manufacturing date: " + collectorProduct.getManuFacturingDate());
        System.out.println("Product experation date: " + collectorProduct.getExpirationDate());
        System.out.println("Quantity: " + collectorProduct.getQuantity());
    }

    
}
