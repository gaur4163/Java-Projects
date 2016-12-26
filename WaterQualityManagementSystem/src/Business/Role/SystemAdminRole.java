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
import UserInterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Gaurav
 */
public class SystemAdminRole extends Role{
    
     @Override
        public String toString() {
            return RoleType.SystemAdmin.getValue();
        }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WaterQualityMonitoring system,Network ntwk) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }
    
}
