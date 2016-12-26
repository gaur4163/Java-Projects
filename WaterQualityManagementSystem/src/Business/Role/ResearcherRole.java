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
import userinterface.AdminRole.AdminWorkAreaJPanel;
import userinterface.AnalystRole.ResearchWorkAreaJPanel1;

/**
 *
 * @author Gaurav
 */
public class ResearcherRole extends Role {
     @Override
        public String toString() {
            return RoleType.Researcher.getValue();
        }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WaterQualityMonitoring business,Network ntwk) {
        return new ResearchWorkAreaJPanel1(userProcessContainer, enterprise,ntwk,business);
    }
    
}
