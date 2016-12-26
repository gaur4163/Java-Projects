/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Measurements.WaterQualityMeasurement;

/**
 *
 * @author Gaurav
 */
public class LineDefectMaintenanceWorkRequest extends WorkRequest{
    private String qualityMaintenanceAlert;
    private WaterQualityMeasurement measure;
    private String result;
    private String priority;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return super.getMessage();
    }
    
    public LineDefectMaintenanceWorkRequest(){
    super.setRequestType("Line Defect Maintenance Request");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
    
    public String getQualityMaintenanceAlert() {
        return qualityMaintenanceAlert;
    }

    public void setQualityMaintenanceAlert(String qualityMaintenanceAlert) {
        this.qualityMaintenanceAlert = qualityMaintenanceAlert;
    }

    public WaterQualityMeasurement getMeasure() {
        return measure;
    }

    public void setMeasure(WaterQualityMeasurement measure) {
        this.measure = measure;
    }
       
}
