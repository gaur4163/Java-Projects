/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author Apoorva
 */
public class AskFunds extends WorkRequest {
    private String reason;
    private String result;
    private int amount;
    private boolean surveyDone;
    private int age;
    private String condition;
    private String relation;
    private String comments;
    private double availableAmount;
    private Date surveyDate;
    private boolean legitimate;
    private boolean approved;

    public AskFunds(){
    super.setRequestType("Request for Funds");
    this.surveyDone = false;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    

    public boolean isLegitimate() {
        return legitimate;
    }

    public void setLegitimate(boolean legitimate) {
        this.legitimate = legitimate;
    }

    public String getSurveyDate() {
         String s = surveyDate.toString();
        String mon = s.substring(4, 7);
       String date = s.substring(8, 10);
       String year = s.substring(24, 28);
       String time = s.substring(11, 16);
     
       
       return date+"-"+mon+"-"+year+" at "+time;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    
    public String getResult() {
        return result;
    }

    public boolean isSurveyDone() {
        return surveyDone;
    }

    public void setSurveyDone(boolean surveyDone) {
        this.surveyDone = surveyDone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

   

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
