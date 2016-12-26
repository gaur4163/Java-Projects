/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HigherManagementRole;
import Business.Role.MayorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class HigherMgmtOrganization extends Organization{
     public HigherMgmtOrganization() {
        super(Organization.Type.HigherMgmtOrganization.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HigherManagementRole());
        roles.add(new MayorRole());
        return roles;
    }
}
