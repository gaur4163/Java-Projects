/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Store;

import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class Order {
    
    private static int count = 0;
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private Person customer;
    private Double orderTotal;
    private Date orderDate;
    private char orderRecieved;
    public Order() {
        count++;
        orderNumber = count;
        orderItemList = new ArrayList<>();
        orderDate= new Date();
        orderRecieved = 'N';
    }
    
    public void removeOrderItem(OrderItem o) {
        orderItemList.remove(o);
    }
    
    public OrderItem addOrderItem(MedicineProduct p, int q, double price) {
        OrderItem o = new OrderItem();
        o.setProduct(p);
        o.setQuantity(q);
        o.setPrice(price);
        orderItemList.add(o);
        return o;
    }
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public Person getCustomer() {
        return customer;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public char getOrderRecieved() {
        return orderRecieved;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderCompleted() {
        this.orderRecieved = 'Y';
    }
    
   
}
