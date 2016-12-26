/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person.ResidentDirectory;
import Business.Role.HouseholdCommunityAdminRole;
import Business.Role.HouseholdResidentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class ResidentOrganization extends Organization{
    private ResidentDirectory residentDirectory;
     public ResidentOrganization() {
        super(Organization.Type.ResidentOrganization.getValue());
        residentDirectory = new ResidentDirectory();
    }

    public ResidentDirectory getResidentDirectory() {
        return residentDirectory;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HouseholdResidentRole());
        
        return roles;
    }
}
