/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Gaurav
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPerson(String name){
        Person person = new Person();
        person.setName(name);
        personList.add(person);
        return person;
    }
     public Person createAdminPerson(String name,String email){
        Person person = new Person();
        person.setName(name);
        person.setEmailAddress(email);
        personList.add(person);
        return person;
    }
}