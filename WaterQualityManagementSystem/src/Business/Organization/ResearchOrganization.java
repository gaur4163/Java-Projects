/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ResearchOrgAdminRole;
import Business.Role.ResearcherRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class ResearchOrganization extends Organization{

    public ResearchOrganization() {
        super(Organization.Type.ResearchOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ResearcherRole());
        return roles;
    }
     
   
    
    
}
