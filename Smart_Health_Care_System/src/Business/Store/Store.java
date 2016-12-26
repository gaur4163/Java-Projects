/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Store;

import Business.Person.PersonDirectory;

/**
 *
 * @author Apoorva
 */
public class Store {
    private String name;
    private MasterOrderCatalog masterOrderCatalog;
    private PersonDirectory customerDirectory;
    private ProductCatalog productList;

    @Override
    public String toString() {
        return name ;
    }
   
    
    public Store(String name) {
       this.name = name;
        masterOrderCatalog = new MasterOrderCatalog();
        customerDirectory= new PersonDirectory();
        productList = new ProductCatalog();
        //initFile();
    }

    public ProductCatalog getProductList() {
        return productList;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public String getName() {
        return name;
    }

    

    public PersonDirectory getCustomerDirectory() {
        return customerDirectory;
    }


}
