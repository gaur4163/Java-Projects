/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization searchOrganization(Type type){
          Organization organization = null;
          for(Organization orgs : organizationList){
              if (orgs.toString().equalsIgnoreCase(type.getValue())){
                  organization=orgs;
              }
          }
             return organization;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.AdminOrganization.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ResidentOrganization.getValue())){
            organization = new ResidentOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HigherMgmtOrganization.getValue())){
            organization = new HigherMgmtOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ResearchOrganization.getValue())){
            organization = new ResearchOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.SurveyorOrganization.getValue())){
            organization = new SurveyorOrganization();
            organizationList.add(organization);
        }else if (type.getValue().equals(Type.MaintenanceOrganization.getValue())){
            organization = new MaintenanceOrganization();
            organizationList.add(organization);
        }
       
        return organization;
    }
}