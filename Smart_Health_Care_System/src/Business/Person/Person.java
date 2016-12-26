/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class Person {
    private String name;
    private Age dateOfBirth;
    private String emailAddress;
    private String contactNumber;
    private SeniorPerson dependent;
    private static int count =0;
    private int id;
    private static USA_Smart_HealthCare sys;
    
    
    

    public Person() {
        if (count ==0){
            count =1;
            //System.out.println(" count "+count);
            if(sys.getNetworkList().size()!=0){ 
            for(Network n: sys.getNetworkList()){
               // System.out.println("netw name "+n);
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList())
            {//System.out.println("etr name "+e);
            for (Organization org : e.getOrganizationDirectory().getOrganizationList())
            {
               // System.out.println("org name "+org);
            for(Person p :org.getPersonDirectory().getPersonList()){
            count=count+1;
             //System.out.println(" count "+count +" size of list "+org.getPersonDirectory().getPersonList().size());
                }
            if(org instanceof PatientOrganization){
            for(Person p :((PatientOrganization)org).getPersonDir().getSerPersonList()){
            count=count+1;
             //System.out.println(" count "+count +" size of list "+((PatientOrganization)org).getPersonDir().getSerPersonList().size());
                }
            }
            }
            }
            
            
            }
        }}
        else 
        {count++;    
        }  id = count;
            
            System.out.println("Id of person "+id);
    }

    public static void setSys(USA_Smart_HealthCare sys){
    Person.sys = sys;
    }
    
    public SeniorPerson getDependent() {
        return dependent;
    }

    public void setDependent(SeniorPerson dependent) {
        this.dependent = dependent;
    }
    
  

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getid() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Age getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Age dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
    public UserAccount searchAccount(Person p, UserAccountDirectory dir){
    UserAccount us = null;
    for(UserAccount a : dir.getUserAccountList())    
    {
        
    if(a.getPerson().getName().equals(p.getName()))
    {us = a;
    
    }
    }
    return us;
    }
   
    public boolean checkIfExists(String name,USA_Smart_HealthCare sys ){
     boolean exist=false;
            //System.out.println(" count "+count);
            if(sys.getNetworkList().size()!=0){ 
            for(Network n: sys.getNetworkList()){
               // System.out.println("netw name "+n);
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList())
            {//System.out.println("etr name "+e);
            for (Organization org : e.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof PatientOrganization){
            for(Person p :((PatientOrganization)org).getPersonDir().getSerPersonList()){
           
             if(p.getName().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           }
            }}
                
            else{     // System.out.println("org name "+org);
            for(Person p :org.getPersonDirectory().getPersonList()){
           if(p.getName().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           } }
            
            }
            }
            }
            
            
            }
        }
    return exist;
    }
    
    
}
