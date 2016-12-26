/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class ResidentsEnterprise extends Enterprise{
   public ResidentsEnterprise(String name) {
        super(name, EnterpriseType.Residents);
          OrganizationDirectory orgList = super.getOrganizationDirectory();
          orgList.createOrganization(Type.Admin);
         orgList.createOrganization(Type.CareTaker);
        orgList.createOrganization(Type.Patient);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    public OrganizationDirectory getSupportedOrgs(){
        OrganizationDirectory orgList = super.getOrganizationDirectory();
        return orgList;
    } 
}
