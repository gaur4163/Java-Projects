/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class PersonDirectory {
      private ArrayList<Person> personList;
      
      

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person createPerson(String name){
        Person person = new Person();
        person.setName(name);
        personList.add(person);
        return person;
    }

}
