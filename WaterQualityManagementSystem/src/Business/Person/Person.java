/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ResidentOrganization;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WaterQualityMonitoring;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Gaurav
 */
public class Person {
    
    private String name;
    
    private String month;
    private int date;
    private int year;
    private int age;
    private String emailAddress;
    private String contactNum;
       private static int count =0;
    private int id;
    private static WaterQualityMonitoring sys;
    
    
    

    public Person() {
        if (count ==0){
            count =1;
            System.out.println(" count "+count);
            if(sys.getNetworkList().size()!=0){ 
            for(Network n: sys.getNetworkList()){
               // System.out.println("netw name "+n);
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList())
            {System.out.println("etr name "+e);
            for (Organization org : e.getOrganizationDirectory().getOrganizationList())
            {
                System.out.println("org name "+org);
            for(Person p :org.getPersonDirectory().getPersonList()){
            count=count+1;
             System.out.println(" count "+count +" size of list "+org.getPersonDirectory().getPersonList().size());
                }
            if(org instanceof ResidentOrganization){
            for(Person p :((ResidentOrganization)org).getResidentDirectory().getResidentList()){
            count=count+1;
             System.out.println(" count "+count +" size of list "+((ResidentOrganization)org).getResidentDirectory().getResidentList().size());
                }
            }
            }
            }
            
            
            }
        }}
        else 
        {count++;    
        }  id = count;
            
            System.out.println("Id of person "+id);
    }

    public static void setSys(WaterQualityMonitoring sys){
    Person.sys = sys;
    }
    

    public int getAge() {
        return age;
    }
    
    

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setYear(int year) {
        this.year = year;
        Calendar c = Calendar.getInstance();
        int yr = c.get(Calendar.YEAR);
        int age = yr -year;
        this.setAge(age);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
        
    
    public UserAccount searchAccount(Person p, UserAccountDirectory dir){
    UserAccount us = null;
    for(UserAccount a : dir.getUserAccountList())    
    {
        
    if(a.getPerson().getName().equals(p.getName()))
    {us = a;
    
    }
    }
    return us;
    }
    
  

    
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
