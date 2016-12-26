/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Measurements;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gaurav 
 */
public class WaterQualityMeasurement {
    private int readingId;
    private float pHvalue;
    private float salinity;
    private float ionNitrates;
    private float ionLead;
    private float ionBromide;
    private float ionFluoride;
    private float dissolvedOxygen;
    private float ionMercury;
    private Date timestampOfMeasure;
    private String Status;
    private static int count = 100;

    public WaterQualityMeasurement() {
        readingId=count;
        count++;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }
    
    
    

    public Date getTimestampOfMeasure() {
        return timestampOfMeasure;
    }

    public void setTimestampOfMeasure(Date timestampOfMeasure) {
        this.timestampOfMeasure = timestampOfMeasure;
    }

    
    public float getpHvalue() {
        return pHvalue;
    }

    public void setpHvalue(float pHvalue) {
        this.pHvalue = pHvalue;
    }

    public float getSalinity() {
        return salinity;
    }

    public void setSalinity(float salinity) {
        this.salinity = salinity;
    }

    public float getIonNitrates() {
        return ionNitrates;
    }

    public void setIonNitrates(float ionNitrates) {
        this.ionNitrates = ionNitrates;
    }

    public float getIonLead() {
        return ionLead;
    }

    public void setIonLead(float ionLead) {
        this.ionLead = ionLead;
    }

    public float getIonBromide() {
        return ionBromide;
    }

    public void setIonBromide(float ionBromide) {
        this.ionBromide = ionBromide;
    }

    public float getIonFluoride() {
        return ionFluoride;
    }

    public void setIonFluoride(float ionFluoride) {
        this.ionFluoride = ionFluoride;
    }

    public float getDissolvedOxygen() {
        return dissolvedOxygen;
    }

    public void setDissolvedOxygen(float dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public float getIonMercury() {
        return ionMercury;
    }

    public void setIonMercury(float ionMercury) {
        this.ionMercury = ionMercury;
    }

    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mm:ss a");
        return ft.format(timestampOfMeasure);
    }
    
    
    
}
