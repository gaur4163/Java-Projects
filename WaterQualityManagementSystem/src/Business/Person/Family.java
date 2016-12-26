/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Measurements.MeasurementsDirectory;

/**
 *
 * @author Gaurav
 */
public class Family {
    private MeasurementsDirectory measurementList;
    private ResidentDirectory familyMembers;

    public Family() {
        measurementList = new MeasurementsDirectory();
        familyMembers = new ResidentDirectory();
    }

    public MeasurementsDirectory getMeasurementList() {
        return measurementList;
    }

    public void setMeasurementList(MeasurementsDirectory measurementList) {
        this.measurementList = measurementList;
    }

    public ResidentDirectory getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(ResidentDirectory familyMembers) {
        this.familyMembers = familyMembers;
    }
    
    
}
