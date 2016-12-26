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
public class SurveyorVisitWorkRequest extends WorkRequest{
    private String surveyorVisitAlert;
    private WaterQualityMeasurement measure;
    
    
   @Override
    public String toString() {
        return super.getMessage();
    }
    
    public SurveyorVisitWorkRequest(){
    super.setRequestType("Surveyor visit Request");
    }

    
    
    public String getSurveyorVisitAlert() {
        return surveyorVisitAlert;
    }

    public void setSurveyorVisitAlert(String surveyorVisitAlert) {
        this.surveyorVisitAlert = surveyorVisitAlert;
    }

    public WaterQualityMeasurement getMeasure() {
        return measure;
    }

    public void setMeasure(WaterQualityMeasurement measure) {
        this.measure = measure;
    }
       
}
