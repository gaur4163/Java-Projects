/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.HouseholdCommunityAdminRole;
import Business.Role.MaintenanceOrganizationAdminRole;
import Business.Role.MunicipalCorpAdminRole;
import Business.Role.ResearchOrgAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.AdminOrganization.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MunicipalCorpAdminRole());
        roles.add(new ResearchOrgAdminRole());
        roles.add(new HouseholdCommunityAdminRole());
        roles.add(new MaintenanceOrganizationAdminRole());
        
        return roles;
    }
     
}
