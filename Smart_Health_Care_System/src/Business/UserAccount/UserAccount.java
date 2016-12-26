/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Person person;
    private SeniorPerson seniorPerson;
    private Role role;
    private WorkQueue workQueue;
   

    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public SeniorPerson getSeniorPerson() {
        return seniorPerson;
    }

    public void setSeniorPerson(SeniorPerson seniorPerson) {
       this.setPerson(seniorPerson);
       this.seniorPerson = seniorPerson;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
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
            for(UserAccount p :((PatientOrganization)org).getUserAccountDirectory().getUserAccountList()){
           
             if(p.getSeniorPerson().getName().equalsIgnoreCase(name))
           {
           exist = true;
           break;
           }
            }}
                
            else{     // System.out.println("org name "+org);
            for(UserAccount p :org.getUserAccountDirectory().getUserAccountList()){
           if(p.getPerson().getName().equalsIgnoreCase(name))
           {
           exist = true;
           break;
           } }
            
            }
            }
            }
            
            
            }
        }
    return exist;
    }
    
    
}