/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AssistantRole;
import Business.Role.EmergencyStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AssistantOrganization extends Organization{

    public AssistantOrganization() {
        super(Organization.Type.Assistant.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AssistantRole());
        roles.add(new EmergencyStaffRole());
        return roles;
    }
     
   
    
    
}
