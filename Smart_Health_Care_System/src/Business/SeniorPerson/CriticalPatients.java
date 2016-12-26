/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SeniorPerson;

import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class CriticalPatients {
    private ArrayList<SeniorPerson> patientList;
    
    public CriticalPatients(){
    patientList = new ArrayList<SeniorPerson>();
    }
    
    public ArrayList<SeniorPerson> getPatientList() {
        return patientList;
    }
    
    public void addPatient( SeniorPerson person){
       // System.out.println("in ");
        if(patientList.isEmpty()) { patientList.add(person);
        //System.out.println("in if to add the alert");
        }
        else{ for(SeniorPerson per : patientList)
       { //System.out.println("in else to add the alert");
           if(!(per.getName().equals(person.getName())))
           {
              //System.out.println("in if");
        patientList.add(person);
        }}
    }
    }

    
}
