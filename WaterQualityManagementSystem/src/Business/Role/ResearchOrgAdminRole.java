/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WaterQualityMonitoring;
import userinterface.AdminRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Gaurav 
 */
public class ResearchOrgAdminRole extends Role{
    
    
      @Override
        public String toString() {
            return RoleType.ResearchOrganizationAdmin.getValue();
        }
        

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WaterQualityMonitoring business,Network ntwk) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business);
    }
}
