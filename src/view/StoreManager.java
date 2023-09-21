/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Dictionary;
import java.util.List;
import controllers.Menu;
import controllers.ProductList;
import controllers.ReportController;
import controllers.WarehouseManager;
import storeManagement.dto.IList;
import storeManagement.dto.IMenu;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class StoreManager {
    static IList plist = new ProductList();
    public static void main(String[] args) {
        mainMenu();
    }
    
    private static void mainMenu(){
        IMenu menu = new Menu();
        menu.addItem("0. Product manager");
        menu.addItem("1. Warehouse manager");
        menu.addItem("2. Report manager");
        menu.showMenu();
        int choice = menu.getChoice();
        switch(choice){
            case 0:
                productMenu();
                mainMenu();
                break;
            case 1:
                warehouseMenu();
                mainMenu();
                break;
            case 2:
                reportMenu();
                break;
        }
    }
    
    private static void productMenu(){
        IMenu menu = new Menu();
        //IList list = new ProductList();
        menu.addItem("0. Add product");
        menu.addItem("1. Update product");
        menu.addItem("2. Delete product");
        menu.addItem("3. Show all products");
        menu.showMenu();
        int choice = menu.getChoice();
        switch(choice){
            case 0:
                plist.add();
                break;
            case 1:
                plist.update();
                break;
            case 2:
                plist.delete();
                break;
            case 3:
                plist.showAll();
                break;
        }
    }
    
    private static void warehouseMenu(){
        IMenu menu = new Menu();
        WarehouseManager warehouseManager = new WarehouseManager();
        menu.addItem("0. Create an import receipt");
        menu.addItem("1. Create an export receipt");
        menu.showMenu();
        int choice = menu.getChoice();
        switch(choice){
            case 0:
                warehouseManager.addImportReceipt();
                break;
            case 1:
                warehouseManager.addExportReceipt();
                break;
        }
    }
    
    private static void reportMenu(){
        IMenu menu = new Menu();
        ReportController reportController = new ReportController();
        menu.addItem("0. Products that have expired");
        menu.addItem("1. The products that the store is selling");
        menu.addItem("2. Products that are running out of stock (sorted in ascending order)");
        menu.addItem("3. Import receipt of a product");
        menu.addItem("4. Export receipt of a product");
        menu.addItem("5. Store data to files");
        menu.showMenu();
        int choice = menu.getChoice();
        switch(choice){
            case 0:
                reportController.reportProductsExpired(WarehouseManager.getWarehouseProductList());
                break;
            case 1:
                //list.update();
                break;
            case 2:
                //list.delete();
                break;
            case 3:
                
                break;
        }
    }
}
