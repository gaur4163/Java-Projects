/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Store;

/**
 *
 * @author Apoorva
 */
public class MedicineProduct {
     private static int count = 0;
    private String prodName;
    private int modelNumber;
    private int availability;
    private int price;
   
    public MedicineProduct() {
        count++;
        modelNumber = count;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        MedicineProduct.count = count;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    
   
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

  
    @Override
    public String toString() {
        return prodName; //To change body of generated methods, choose Tools | Templates.
    }

}
