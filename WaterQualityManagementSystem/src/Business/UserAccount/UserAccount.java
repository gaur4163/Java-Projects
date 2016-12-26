/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Person.Person;
import Business.Person.Residents;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Gaurav
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Person person;
    private Residents residents;
    private Role role;
    private WorkQueue workQueue;
    private String email;

    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public Residents getResidents() {
        return residents;
    }

    public void setResidents(Residents residents) {
        this.residents = residents;
    }

    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}