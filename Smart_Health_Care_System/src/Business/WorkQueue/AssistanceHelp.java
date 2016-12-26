/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class AssistanceHelp extends WorkRequest{
    
    private String assistance;

    public AssistanceHelp(){
    super.setRequestType("Assistance Help");
    }
    
    public String getAssistance() {
        return assistance;
    }

    public void setAssistance(String assistance) {
        this.assistance = assistance;
    }

   
    
}
