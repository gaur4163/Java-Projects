/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CaretakerRole.CareTakerWorkAreaJPanel;

/**
 *
 * @author Apoorva
 */
public class CareTakerRole extends Role{
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        return new CareTakerWorkAreaJPanel(userProcessContainer,account,organization,enterprise,business,network);
       // return null;
    }
      @Override
    public String toString() {
        return "Care Taker";
    }
    
}
