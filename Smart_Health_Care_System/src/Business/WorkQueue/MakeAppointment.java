/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Person.Age;
import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class MakeAppointment extends WorkRequest {
    private Age appointmentDate;
    private String reason;
    private String result;
    private String prescription;

    public MakeAppointment(){
    super.setRequestType("Appointment creation");
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
 
    public Age getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Age appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
