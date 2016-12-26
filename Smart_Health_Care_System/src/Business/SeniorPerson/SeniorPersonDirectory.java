/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorPerson;

import Business.Enterprise.HospitalEnterprise;
import Business.Person.Age;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class SeniorPersonDirectory {
    private ArrayList<SeniorPerson> personList;

    public SeniorPersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<SeniorPerson> getSerPersonList() {
        
      //  System.out.print("in sen org dir");
        return personList;
    }
    
    public SeniorPerson createPerson(String name,Age dateOfBirth,String emailAddress,String contactNumber,HospitalEnterprise primaryHospital,boolean stayAlone, String address){
        SeniorPerson person = new SeniorPerson();
        person.setName(name);
        person.setDateOfBirth(dateOfBirth);
        person.setEmailAddress(emailAddress);
        person.setHospital(primaryHospital);
        person.setAddress(address);
        person.setContactNumber(contactNumber);
        person.setStayAlone(stayAlone);
        personList.add(person);
        return person;
    }
    
    public void addSeniorPer(SeniorPerson p){
    personList.add(p);
    
    }
    
}
