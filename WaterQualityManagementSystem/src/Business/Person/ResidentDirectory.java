/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gaurav 
 */
public class ResidentDirectory {
    
    private ArrayList<Residents> residentList;

    public ResidentDirectory() {
        residentList = new ArrayList<>();
    }

    public ArrayList<Residents> getResidentList() {
        return residentList;
    }
    
    public Residents createResident(String name,String doctor,int year, String disease,String contactNum, String emailAdd){
        Residents resident = new Residents();
        resident.setName(name);
        resident.setPrimaryDoctorName(doctor);
        resident.setYear(year);
        resident.setSufferedDisease(disease);
        resident.setContactNum(contactNum);
        resident.setEmailAddress(emailAdd);
        residentList.add(resident);
        return resident;
    }
    
    public void addResidents(Residents p){
    residentList.add(p);
    
    }
}
