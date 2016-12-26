/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;


import Business.Person.Person;
import Business.Role.Role;
import Business.SeniorPerson.SeniorPerson;
import java.util.ArrayList;

/**
 *
 * @author Apoorva
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public void addAccounDirectory(ArrayList<UserAccount> list){
     for (UserAccount ua : list){
     userAccountList.add(ua);
     }
    }
    
    public UserAccount createUserAccount(String username, String password, Person person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    //overloading
     public UserAccount createUserAccount(String username, String password, SeniorPerson person, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setSeniorPerson(person);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    
}
