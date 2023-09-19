/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement;

import java.util.ArrayList;
import storeManagement.dto.IMenu;
import utils.Utils;

/**
 *
 * @author DELL
 */
public class Menu extends ArrayList<String> implements IMenu{

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        return Utils.getInt("",0 , this.size());
    }

    @Override
    public void showMenu() {
        for(String e : this){
            System.out.println(e);
        }
    }

    @Override
    public boolean confirmYesNo(String welcome) {
        return Utils.confirmYesNo(welcome);
    }
    
}
