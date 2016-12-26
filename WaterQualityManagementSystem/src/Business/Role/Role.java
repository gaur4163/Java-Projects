/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.WaterQualityMonitoring;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Gaurav
 */
public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("System Admin"),
        MunicipalCorporationAdmin("MunicipalCorporation Admin"),
        HouseholdCommunityAdmin("HouseholdCommunity Admin"),
        ResearchOrganizationAdmin("ResearchOrganization Admin"),
        MaintenanceOrganizationAdmin("MaintenanceOrganization Admin"),
        Researcher("Researcher"),
        MayorRole("Mayor"),
        HouseholdResident("HouseholdResident"),
        HigherManagement("HigherManagement"),
        Surveyor("Surveyor"),
        MaintenanceStaff("MaintenanceStaff");
        
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            WaterQualityMonitoring business,
            Network network);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}