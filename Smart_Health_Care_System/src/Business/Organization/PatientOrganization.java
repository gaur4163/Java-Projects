/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.PatientRole;
import Business.Role.Role;
import Business.SeniorPerson.SeniorPerson;
import Business.SeniorPerson.SeniorPersonDirectory;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class PatientOrganization  extends Organization{
    
    private SeniorPersonDirectory personDir;
    public PatientOrganization() {
        super(Type.Patient.getValue());
        personDir = new SeniorPersonDirectory();
      
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }
    
    public SeniorPersonDirectory getPersonDir(){
       // System.out.print("in pat org"+ personDir);
    return this.personDir;
    }
    
    
    
}
