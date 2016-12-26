package Business;


import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;


/**
 *
 * @author Apoorva
 */
public class ConfigureASystem {
    

   
    
    public static USA_Smart_HealthCare configure(){
        
        USA_Smart_HealthCare system = USA_Smart_HealthCare.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        Person.setSys(system);
        Person employee = system.getPersonDirectory().createPerson("System Admin");
               
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
    }
    
}
