/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HealthCare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class VitalSign {
    
    private int respiratoryRate;
    private int heartRate;
    private int bloodPressure;
    private int weight;
    private final Date timestamp;
    private int stepCount;
    private int sugarLevel;
    private int sleepinghours;
    private String status;
    
    
    public VitalSign(){
     timestamp = new Date();
    }
    
     
    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
        return ft.format(timestamp);
    }
    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public int getSleepinghours() {
        return sleepinghours;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public void setSleepinghours(int sleepinghours) {
        this.sleepinghours = sleepinghours;
    }

    
  
}
