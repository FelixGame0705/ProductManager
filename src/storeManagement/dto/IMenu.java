/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeManagement.dto;

/**
 *
 * @author DELL
 */
public interface IMenu {
    // add a menu item--> add text to menu
   void addItem(String s);
   // get user choice( user input their choice)
   int getChoice();
   // show menu for user choice
   void showMenu();
   // confirm yes/ no (Y/N)
   boolean confirmYesNo(String welcome);
}
