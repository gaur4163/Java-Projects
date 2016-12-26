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
import userinterface.AdminRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Gaurav
 */
public class MunicipalCorpAdminRole extends Role{
    
     
      @Override
        public String toString() {
            return RoleType.MunicipalCorporationAdmin.getValue();
        }
        
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, WaterQualityMonitoring business,Network ntwk) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business);
    }

    
    
}
