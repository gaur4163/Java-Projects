/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.USA_Smart_HealthCare;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class DoctorRole extends Role{
    
    private String doctorType;
      @Override
    public String toString() {
        return "Doctor";
    }
    
    
   public enum DoctorType{ 
        Dentist("Dentist Doctor"),
        Dermatologist("Dermatologist"),
        Dietician("Dietician"),
        Oncologist("Oncologist"),
        Neurologist("Neurologist"),
        Psychiatrist("Psychiatrist"),
        Physician("Physician"),
        Surgeon("Surgeon"),
        Physiotherapist("Physiotherapist"),
        opthamologist("opthamologist");
        
        private String value;
        private DoctorType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    
    };

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }
    
   
   
   
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
       return new DoctorWorkAreaJPanel(userProcessContainer, account, organization, business, network,enterprise);
        
    }
    
    
}
