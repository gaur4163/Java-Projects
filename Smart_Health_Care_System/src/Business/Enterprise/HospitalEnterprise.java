/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.SeniorPerson.CriticalPatients;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class HospitalEnterprise extends Enterprise{
    
    private CriticalPatients criticalPerson;

    public CriticalPatients getCriticalPerson() {
        return criticalPerson;
    }
    
    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
          OrganizationDirectory orgList = super.getOrganizationDirectory();
          orgList.createOrganization(Type.Admin);
        orgList.createOrganization(Type.Assistant);
        orgList.createOrganization(Type.Doctor);
        this.criticalPerson = new CriticalPatients();
        
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
