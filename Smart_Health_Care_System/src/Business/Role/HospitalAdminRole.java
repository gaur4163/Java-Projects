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
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;

import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class HospitalAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business);
        //return null;
    }

      @Override
    public String toString() {
        return "Hospital Admin";
    }
    
    
}
