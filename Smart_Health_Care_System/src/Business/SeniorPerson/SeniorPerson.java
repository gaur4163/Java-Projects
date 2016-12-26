/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorPerson;

import Business.Enterprise.HospitalEnterprise;


import Business.HealthCare.Medicine;
import Business.Store.Order;


import Business.HealthCare.VitalSignHistory;
import Business.Network.Network;
import Business.Person.Person;
import Business.Store.MedicineProduct;
import Business.Store.OrderItem;
import Business.WorkQueue.MakeAppointment;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class SeniorPerson extends Person{
    
    private HospitalEnterprise hospital;
    private ArrayList<Person> careTakers;
    private ArrayList<MakeAppointment> appointmentList;
    private boolean stayAlone;
    private VitalSignHistory vitalSignList;
    private ArrayList<Order> medOrder;
    private String address;
    private ArrayList<Medicine> medicineList;
    private Person assignedJdoc;
    private Network network;
    
    public SeniorPerson(){
        super();
    careTakers = new ArrayList<>();//
    appointmentList = new ArrayList<>();//
    vitalSignList =new VitalSignHistory();
    medOrder = new ArrayList<>();//
    medicineList =new ArrayList<>();//
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    
     //for ordering a medicine
    public void addOrder(Order o) {
        medOrder.add(o);
        //System.out.println("in adding order");
        for(OrderItem oi: o.getOrderItemList())
        {
         MedicineProduct p=oi.getProduct();
         //System.out.println("in for oop produscts "+p);
        Medicine med = this.searchMedicine(p.getProdName());
        if(med!=null){
            int i = med.getAvailQuantity()+oi.getQuantity();
        med.setAvailQuantity(i);
       // System.out.println("in adding quntity "+i);
        
        }
        }
       
    }
    
      
    //for caretakers details
     public Person addCareTakerPerson(String name, String emailAddress, String contactNumber){
        Person per = new Person();
       per.setContactNumber(contactNumber);
       per.setEmailAddress(emailAddress);
       per.setName(name);
        careTakers.add(per);
        return per;
    }
    
    public void removeCareTakerPerson(Person a){
        careTakers.remove(a);
    }
    
    public Person searchCareTakerPerson(String name){
        for (Person per : careTakers) {
            if(per.getName().equals(name)){
                return per;
            }
        }
        return null;
    }

    
    
    //for appointment handeling
     public MakeAppointment makeAppointment(MakeAppointment request){
            appointmentList.add(request);
        return request;
    }
    
    public void removeAppointment(MakeAppointment a){
        appointmentList.remove(a);
    }
    
    public MakeAppointment searchAppointment(Date date){
        for (MakeAppointment appointment : appointmentList) {
            if(appointment.getAppointmentDate().equals(date)){
                return appointment;
            }
        }
        return null;
    }

    
    //for tracking a medicine
    public Medicine addMedicine(MedicineProduct product,String pres, Person doc){
        Medicine p = new Medicine(product, pres, doc);
        medicineList.add(p);
        return p;
    }
    
    public void removeMedicine(Medicine p){
        medicineList.remove(p);
    }
    
    public void removePres(Person dc)
    {
     for (Medicine medicine : medicineList)
     {
     if (medicine.getDoctor().equals(dc)){
     
     medicineList.remove(medicine);
     }}}  
    
    public ArrayList<Medicine> getPresMedForApp(WorkRequest req){
    ArrayList<Medicine> list = new ArrayList<Medicine>();
     for (Medicine medicine : medicineList)
     {
     if (medicine.getRequest().equals(req)){
         list.add(medicine);
     }}
    
    return list;
    }
    
    public boolean ifDocPres(Person dc){
    boolean present = false;
     for (Medicine medicine : medicineList)
     {
     if (medicine.getDoctor().equals(dc)){
     present = true;
     break;
     }
     
     }
    
     return present;
    }
    
    public Medicine searchMedicine(String name){
        for (Medicine medicine : medicineList) {
            if(medicine.getProduct().getProdName().equalsIgnoreCase(name)){
                return medicine;
            }
        }
        return null;
    }

    //getters and setters

    public HospitalEnterprise getHospital() {
        return hospital;
    }

    public void setHospital(HospitalEnterprise hospital) {
        this.hospital = hospital;
    }
    

    public ArrayList<Person> getCareTakers() {
        return careTakers;
    }

    public ArrayList<MakeAppointment> getAppointmentList() {
        return appointmentList;
    }

    public boolean isStayAlone() {
        return stayAlone;
    }

    public VitalSignHistory getVitalSignList() {
        return vitalSignList;
    }

    public ArrayList<Order> getMedOrder() {
        return medOrder;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Medicine> getMedicineList() {
        return medicineList;
    }

    public Person getAssignedJdoc() {
        return assignedJdoc;
    }

    public void setAssignedJdoc(Person assignedJdoc) {
        this.assignedJdoc = assignedJdoc;
    }

    

    public void setStayAlone(boolean stayAlone) {
        this.stayAlone = stayAlone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
