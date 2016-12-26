/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DeliveryAdminRole;
import Business.Role.HCDeptAdminRole;
import Business.Role.HospitalAdminRole;
import Business.Role.ResidentAdminRole;
import Business.Role.Role;


import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HospitalAdminRole());
        roles.add(new DeliveryAdminRole());
        roles.add(new HCDeptAdminRole());
        roles.add(new ResidentAdminRole());
        return roles;
    }
     
}
