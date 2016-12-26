/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SurveyorRole;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class SurveyorOrganization extends Organization{

    public SurveyorOrganization() {
        super(Organization.Type.SurveyorOrganization.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SurveyorRole());
        return roles;
    }
     
}