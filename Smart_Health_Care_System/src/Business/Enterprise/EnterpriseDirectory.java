/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Hospital){
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.CityHealthCareDepartment){
            enterprise = new CityHealthCareDepartmentEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.SmartMedicineDelivery){
            enterprise = new SmartMedicineDeliveryEnterprise(name);
            enterpriseList.add(enterprise);
        }else if (type == Enterprise.EnterpriseType.Residents){
            enterprise = new ResidentsEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
