/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Store;

import java.util.ArrayList;

/**
 *
 * @author Apoorva// not using this class
 */
public class StoreDirectory {
     private ArrayList<Store> storeList;

    public StoreDirectory() {
        storeList = new ArrayList<>();
    }

    public ArrayList<Store> getPersonList() {
        return storeList;
    }
    
    public Store addStore(String name){
        Store store = new Store(name);
        return store;
    }
}
