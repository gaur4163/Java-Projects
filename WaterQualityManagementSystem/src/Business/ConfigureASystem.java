package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Gaurav
 */
public class ConfigureASystem {
    
    public static WaterQualityMonitoring configure(){
        
        
        WaterQualityMonitoring system = WaterQualityMonitoring.getInstance();
          Person.setSys(system);
        Person person = system.getPersonDirectory().createPerson("SystemAdmin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        return system;
    }
    
}
