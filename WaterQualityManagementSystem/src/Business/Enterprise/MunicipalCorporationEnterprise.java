/*
 * To change this template, choose Tools | Templates
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
public class MunicipalCorporationEnterprise extends Enterprise{

    public MunicipalCorporationEnterprise(String name) {
        super(name, EnterpriseType.MunicipalCorporation);
        OrganizationDirectory listOfOrg = super.getOrganizationDirectory();
        listOfOrg.createOrganization(Organization.Type.AdminOrganization);
        listOfOrg.createOrganization(Organization.Type.SurveyorOrganization);
        listOfOrg.createOrganization(Organization.Type.HigherMgmtOrganization);
        listOfOrg.createOrganization(Organization.Type.MaintenanceOrganization);
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
