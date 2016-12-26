/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HealthCare;

import Business.Person.Person;
import Business.Store.MedicineProduct;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Apoorva
 */
public class Medicine {
    private int availQuantity;
    private MedicineProduct product;
    private String directions;
    private Person doctor;
    private WorkRequest request;
    
    public Medicine(MedicineProduct product,String prescription, Person doctor ){
    
    this.availQuantity = 0;
    this.product = product;
    this.directions = prescription;
    this.doctor= doctor;
    }

    public WorkRequest getRequest() {
        return request;
    }

    public void setRequest(WorkRequest request) {
        this.request = request;
    }

    public Person getDoctor() {
        return doctor;
    }

    public void setDoctor(Person doctor) {
        this.doctor = doctor;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }
    
    public int addQuantity(int quantity){
    this.availQuantity =this.availQuantity+ quantity;
    return this.availQuantity;
    }
    
     public int decQuantity(int quantity){
    this.availQuantity =this.availQuantity- quantity;
    return this.availQuantity;
    }

    public int getAvailQuantity() {
        return availQuantity;
    }

    public void setAvailQuantity(int availQuantity) {
        this.availQuantity = availQuantity;
    }

    public MedicineProduct getProduct() {
        return product;
    }

    public void setProduct(MedicineProduct product) {
        this.product = product;
    }
    
    
}
