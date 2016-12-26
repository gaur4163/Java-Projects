/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Store;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apoorva
 */
public class ProductCatalog {
    private List<MedicineProduct> productCatalog;

    public ProductCatalog() {
    productCatalog = new ArrayList<MedicineProduct>();
    }
    
    public List<MedicineProduct> getProductcatalog(){
        return productCatalog;
    }
    
    
    public MedicineProduct addProduct(){
        MedicineProduct p = new MedicineProduct();
        productCatalog.add(p);
        return p;
    }
    
    public void removeProduct(MedicineProduct p){
        productCatalog.remove(p);
    }
    
    public MedicineProduct searchProduct(int id){
        for (MedicineProduct product : productCatalog) {
            if(product.getModelNumber()==id){
                return product;
            }
        }
        return null;
    }
}
