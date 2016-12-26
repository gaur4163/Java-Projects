/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.FundApprover;
import Business.Role.MayorRole;
import Business.Role.Role;
import Business.Role.SurveyorRole;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class HigherAuthorityOrganization extends Organization{

    public HigherAuthorityOrganization() {
        super(Organization.Type.HigherAuthority.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MayorRole());
       
        roles.add(new SurveyorRole());
        roles.add(new FundApprover());
        return roles;
    }
    
}
