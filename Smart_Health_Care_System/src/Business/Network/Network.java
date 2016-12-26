/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Apoorva
 */
public class Network {
    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        enterpriseDirectory.createAndAddEnterprise("Residents", Enterprise.EnterpriseType.Residents);
        enterpriseDirectory.createAndAddEnterprise("Health Care Department", Enterprise.EnterpriseType.CityHealthCareDepartment);
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
