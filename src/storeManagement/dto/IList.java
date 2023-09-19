/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement.dto;

import java.util.List;
import storeManagement.Product;

/**
 *
 * @author DELL
 */
public interface IList {
    public void add();
    public void update();
    public Object find(String code);
    public void delete();
    public void show(String code);
}
