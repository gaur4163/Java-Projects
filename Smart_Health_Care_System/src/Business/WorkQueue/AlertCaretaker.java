/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.HealthCare.VitalSign;

/**
 *
 * @author Apoorva
 */
public class AlertCaretaker extends WorkRequest {
    private String alert;
    private VitalSign sign;

    public AlertCaretaker(){
    super.setRequestType("Alert Request");
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public VitalSign getSign() {
        return sign;
    }

    public void setSign(VitalSign sign) {
        this.sign = sign;
    }
    
    
}
