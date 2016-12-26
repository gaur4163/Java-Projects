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
public class ResearchOrganizationEnterprise extends Enterprise{

    public ResearchOrganizationEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.ResearchOrganization);
        OrganizationDirectory listOfOrg = super.getOrganizationDirectory();
        listOfOrg.createOrganization(Organization.Type.AdminOrganization);
        listOfOrg.createOrganization(Organization.Type.ResearchOrganization);
       
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    @Override
      public OrganizationDirectory getSupportedOrganization(){
        OrganizationDirectory listOfOrg = super.getOrganizationDirectory(); 
        return listOfOrg;
    }
    
}
