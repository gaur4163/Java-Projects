/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.USA_Smart_HealthCare;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.AssistantrRole.AssistantHelpStaffWorkAreaJPanel1;

/**
 *
 * @author raunak
 */
public class AssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        return new AssistantHelpStaffWorkAreaJPanel1(userProcessContainer, account, organization, business);
        //return null;
    }

    @Override
    public String toString() {
        return "Assistant";
    }
    
    
}
