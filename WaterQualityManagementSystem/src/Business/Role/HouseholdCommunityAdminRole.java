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
import javax.swing.JPanel;
import userinterface.ResidentAdminRole.ResidentAdminWorkAreaJPanel;

/**
 *
 * @author Gaurav
 */
public class HouseholdCommunityAdminRole extends Role{
    
     @Override
        public String toString() {
            return RoleType.HouseholdCommunityAdmin.getValue();
        }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WaterQualityMonitoring business,Network ntwk) {
        System.out.println("network val"+ntwk);
        return new ResidentAdminWorkAreaJPanel(userProcessContainer, enterprise,ntwk,business);
        
    }

    
}
