/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.Store.Store;
import java.util.ArrayList;
import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.store;

/**
 *
 * @author Apoorva
 */
public class SmartMedicineDeliveryEnterprise  extends Enterprise{

    private Store store;
    public SmartMedicineDeliveryEnterprise(String name) {
        super(name, EnterpriseType.SmartMedicineDelivery);
         OrganizationDirectory orgList = super.getOrganizationDirectory();
         orgList.createOrganization(Type.Admin);
        orgList.createOrganization(Type.Manager);
        this.store = new Store(name);
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public Store getStore() {
        return store;
    }
    
    public OrganizationDirectory getSupportedOrgs(){
        OrganizationDirectory orgList = super.getOrganizationDirectory();
        return orgList;
    }
}
