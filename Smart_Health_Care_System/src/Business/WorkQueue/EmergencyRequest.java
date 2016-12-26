/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Apoorva
 */
public class EmergencyRequest extends WorkRequest {
    private String emergency;
    private String location;

    public EmergencyRequest(){
    super.setRequestType("Emergency Help");
    }
    
    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}
