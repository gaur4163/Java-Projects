/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization searchorg(Type type){
     Organization organization = null;
     for(Organization org :organizationList ){
     if (org.toString().equalsIgnoreCase(type.getValue())){
     organization = org;
     }
     }
     return    organization;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Assistant.getValue())){
            organization = new AssistantOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
         
        
        else if (type.getValue().equals(Type.HigherAuthority.getValue())){
            organization = new HigherAuthorityOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CareTaker.getValue())){
            organization = new CareTakerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Manager.getValue())){
            organization = new ManagerOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}