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
public class CityHealthCareDepartmentEnterprise  extends Enterprise{

    public CityHealthCareDepartmentEnterprise(String name) {
        super(name, EnterpriseType.CityHealthCareDepartment);
        OrganizationDirectory orgList = super.getOrganizationDirectory();
        orgList.createOrganization(Type.Admin);
        orgList.createOrganization(Type.HigherAuthority);
       
    }

    public OrganizationDirectory getSupportedOrgs(){
          OrganizationDirectory orgList = super.getOrganizationDirectory();
        return orgList;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
