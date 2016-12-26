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

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        
        SystemAdminRole("SystemAdminRole"),
        CareTaker("CareTaker"),
        Patient("Patient"),

        HospitalAdminRole("Hospital Admin"),
        Doctor("Doctor"),
        Assistant("Assistant"),
        EmergencyStaff("EmergencyStaff"),
       
        
        DeliveryAdminRole("Delivery Admin"),
        DeliveryManager("DeliveryManager"),
        
        HCDeptAdminRole("Heath Care Department Admin"),
        Mayor("Mayor"),
        Surveyor("Surveyor"),
        FundApprover("FundApprover"),
        
       
        ResidentAdminRole("Resident Admin");
        
        
        
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
            USA_Smart_HealthCare business,
            Network network);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}