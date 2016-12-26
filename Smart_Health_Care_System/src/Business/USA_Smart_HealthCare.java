package Business;


import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class USA_Smart_HealthCare extends Organization {

    private static USA_Smart_HealthCare business;
    private ArrayList<Network> networkList;
    private ArrayList<Integer> IdObj;

    
    public static USA_Smart_HealthCare getInstance() {
        if (business == null) {
            business = new USA_Smart_HealthCare();
     
        }
        
        return business;
    }
   
  
    private USA_Smart_HealthCare() {
        super(null);
        networkList = new ArrayList<>();
      
         
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network state = new Network();
        networkList.add(state);
        return state;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

//    public boolean checkIfUsernameIsUnique(String username) {
//
//        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
//            return false;
//        }
//
//        for (Network city : networkList) {
//        }
//
//        return true;
//    }
}