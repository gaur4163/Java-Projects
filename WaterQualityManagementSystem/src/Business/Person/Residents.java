/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Network.Network;



/**
 *
 * @author Gaurav
 */
public class Residents extends Person{
   
    private String primaryDoctorName;
    private String sufferedDisease;
    private VitalSignHistory vitalSignHistory;
    private Family family;

    private Network ntw;

    public Network getNtw() {
        return ntw;
    }

    public void setNtw(Network ntw) {
        this.ntw = ntw;
       //  System.out.println("seteed "+ntw);
    }
    
    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
    
    
   
    
    public Residents(){
         this.vitalSignHistory = new VitalSignHistory();
         this.family = new Family();
    
    }

    public String getSufferedDisease() {
        return sufferedDisease;
    }

    public void setSufferedDisease(String sufferedDisease) {
        this.sufferedDisease = sufferedDisease;
    }
    
    
    
    @Override
    public String toString()
    {
        return super.getName();
    }

   

    public String getPrimaryDoctorName() {
        return primaryDoctorName;
    }

    public void setPrimaryDoctorName(String primaryDoctorName) {
        this.primaryDoctorName = primaryDoctorName;
    }

    public VitalSignHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }
    
    
}
