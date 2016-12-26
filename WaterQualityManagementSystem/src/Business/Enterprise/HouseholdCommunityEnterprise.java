/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class HouseholdCommunityEnterprise  extends Enterprise{

    public HouseholdCommunityEnterprise(String name) {
        super(name, EnterpriseType.HouseholdCommunity);
         OrganizationDirectory listOfOrg = super.getOrganizationDirectory();
        listOfOrg.createOrganization(Organization.Type.AdminOrganization);
        listOfOrg.createOrganization(Organization.Type.ResidentOrganization);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    public OrganizationDirectory getSupportedOrganization(){
       OrganizationDirectory listOfOrg = super.getOrganizationDirectory();
        return listOfOrg;
    }
    
    
    
}
