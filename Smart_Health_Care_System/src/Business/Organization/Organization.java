/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"), 
//        HCDeptAdmin("Heath Care Department Admin Organization"),
//        DeliveryAdmin("Delivery Admin Organization"),
//        SocietyAdmin("Society Admin Organization"),
//        SensorPAdmin("Sensor Provider Admin Organization"),
        Doctor("Doctor Organization"), Assistant("Assistant Organization"),
        CareTaker("Care Taker Organization"), Manager("Manager Organization"),
        Charity("Charity Organization"),Patient("Patient Organization"),
        HigherAuthority("Higher Authority's Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
       
        userAccountDirectory = new UserAccountDirectory();
        personDirectory = new PersonDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

   
    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
