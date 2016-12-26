/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Gaurav
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
        if (type == Enterprise.EnterpriseType.MunicipalCorporation){
            enterprise = new MunicipalCorporationEnterprise(name);
            enterpriseList.add(enterprise);
        }else if (type == Enterprise.EnterpriseType.HouseholdCommunity){
            enterprise = new HouseholdCommunityEnterprise(name);
            enterpriseList.add(enterprise);
        }else if (type == Enterprise.EnterpriseType.ResearchOrganization){
            enterprise = new ResearchOrganizationEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
