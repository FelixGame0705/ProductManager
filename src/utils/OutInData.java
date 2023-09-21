/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.WarehouseController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author DELL
 */
public class OutInData<T> {

    private OutInData() {
    }
    private static OutInData instance;

    public static OutInData Instance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new OutInData();
        }
        return instance;
    }

    public void SaveData(T list, String path) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //Khai báo mảng
            //Bước 2: Ghi mảng đối tượng vào file
            oos.writeObject(list);
            //Bước 3: Đóng luồng
            fos.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

    public T LoadData(T list, String path) {
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Bước 2: Đọc dữ liệu
            list = (T) ois.readObject();
            //Bước 3: Đóng luồng
            fis.close();
            ois.close();
            return list;
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
        return null;
    }
}
