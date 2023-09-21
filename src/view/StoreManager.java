/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.CollectorProductList;
import java.util.Dictionary;
import java.util.List;
import controllers.Menu;
import controllers.ProductList;
import controllers.ProductsController;
import controllers.ReportController;
import controllers.WarehouseController;
import storeManagement.dto.IList;
import storeManagement.dto.IMenu;
import utils.OutInData;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class StoreManager {

    static IList plist = new ProductList();
    static CollectorProductList collectorProductList = new CollectorProductList();

    public static void main(String[] args) {
        plist = (ProductList) OutInData.Instance().LoadData(plist, "D:\\product.dat");
        collectorProductList = (CollectorProductList) OutInData.Instance().LoadData(collectorProductList, "D:\\warehouse.dat");
        if(plist!=null)
        ProductsController.Instance().setProductList((ProductList) plist);
        if(collectorProductList!=null)
        WarehouseController.Instance().setCollectorProductList((CollectorProductList) OutInData.Instance().LoadData(WarehouseController.Instance().geCollectorProductList(), "D:\\warehouse.dat"));

        mainMenu();
    }

    private static void mainMenu() {
        IMenu menu = new Menu();
        menu.addItem("0. Product manager");
        menu.addItem("1. Warehouse manager");
        menu.addItem("2. Report manager");
        menu.showMenu();
        int choice = menu.getChoice();
        switch (choice) {
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
                mainMenu();
                break;
        }
    }

    private static void productMenu() {
        IMenu menu = new Menu();
        //IList list = new ProductList();
        menu.addItem("0. Add product");
        menu.addItem("1. Update product");
        menu.addItem("2. Delete product");
        menu.addItem("3. Show all products");
        menu.showMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 0:
                ProductsController.Instance().getProductList().add();
                break;
            case 1:
                ProductsController.Instance().getProductList().update();
                break;
            case 2:
                ProductsController.Instance().getProductList().delete();
                break;
            case 3:
                ProductsController.Instance().getProductList().showAll();
                break;
        }
    }

    private static void warehouseMenu() {
        IMenu menu = new Menu();
        menu.addItem("0. Create an import receipt");
        menu.addItem("1. Create an export receipt");
        menu.showMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 0:
                WarehouseController.Instance().addImportReceipt();
                break;
            case 1:
                WarehouseController.Instance().addExportReceipt();
                break;
        }
    }

    private static void reportMenu() {
        IMenu menu = new Menu();
        menu.addItem("0. Products that have expired");
        menu.addItem("1. The products that the store is selling");
        menu.addItem("2. Products that are running out of stock (sorted in ascending order)");
        menu.addItem("3. Import/Export receipt of a product");
        menu.addItem("4. Store data to files");
        menu.showMenu();
        int choice = menu.getChoice();
        switch (choice) {
            case 0:
                ReportController.Instance().reportProductsExpired(WarehouseController.Instance().geCollectorProductList());
                break;
            case 1:
                ReportController.Instance().reportProductSelling(WarehouseController.Instance().geCollectorProductList());
                break;
            case 2:
                ReportController.Instance().reportProductRunningOutOfStock(WarehouseController.Instance().geCollectorProductList());
                break;
            case 3:
                WarehouseController.Instance().geCollectorProductList().showAll();
                break;
            case 4:
                OutInData.Instance().SaveData(ProductsController.Instance().getProductList(), "D:\\product.dat");
                OutInData.Instance().SaveData(WarehouseController.Instance().geCollectorProductList(), "D:\\warehouse.dat");
                break;
        }
    }
}
