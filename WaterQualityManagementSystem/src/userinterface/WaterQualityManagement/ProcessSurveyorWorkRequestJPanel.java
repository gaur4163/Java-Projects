/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WaterQualityManagement;

import Business.Enterprise.Enterprise;
import Business.Network.Network;

import Business.Organization.MaintenanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Validations.MyPhoneNumberVerifier;
import Business.Validations.MyStringVerifier;
import Business.WorkQueue.LineDefectMaintenanceWorkRequest;
import Business.WorkQueue.QualityMaintenanceWorkRequest;
import Business.WorkQueue.SurveyorVisitWorkRequest;

import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apoorva
 */
public class ProcessSurveyorWorkRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcessAppointmentJPanel
     */
   JPanel userProcessContainer;
   SurveyorVisitWorkRequest request;
   UserAccount userAccount;
   Network ntwk; 
   private BufferedImage image;
   
   
    public ProcessSurveyorWorkRequestJPanel(JPanel userProcessContainer,SurveyorVisitWorkRequest request,UserAccount userAccount,Network ntwk) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request=request;
        this.userAccount=userAccount;
        this.ntwk=ntwk;
        popCombo();
        populateTable();
        submitjButton1.setEnabled(true);
        setImg();
        
    }
   
    
    public void setImg(){
    setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        try
        {
            image = ImageIO.read(new File(getClass().getResource("/userinterface/water-background.jpg").toURI()));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    
     @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(300, 300));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender() ==  null ?"Sensor Generated"  :request.getSender().getResidents().getName();
            row[2] = request.getSender() ==  null ?"Sensor Generated"  :request.getSender().getResidents().getContactNum();
            //row[2] = request.getSender().getResidents().getContactNum();
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
            row[4] = request.getStatus();
            row[5]=((SurveyorVisitWorkRequest)request).getRequestDate();
            model.addRow(row);
        }
    
    
    
    public void popCombo(){
        medjComboBox1.removeAllItems();
        medjComboBox1.addItem("High Priority");
        medjComboBox1.addItem("Medium Priority");
        medjComboBox1.addItem("Low Priority");
        
       
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultjTextArea1 = new javax.swing.JTextArea();
        submitjButton1 = new javax.swing.JButton();
        medjComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        qualityIssue = new javax.swing.JRadioButton();
        lineDamageIssue = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<< Back");
        backJButton.setMinimumSize(null);
        backJButton.setPreferredSize(null);
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Survey Results for Maintenance Department");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 300, 30));

        resultjTextArea1.setColumns(20);
        resultjTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resultjTextArea1.setForeground(new java.awt.Color(51, 51, 255));
        resultjTextArea1.setRows(5);
        jScrollPane2.setViewportView(resultjTextArea1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 394, 280, 80));

        submitjButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitjButton1.setForeground(new java.awt.Color(0, 0, 153));
        submitjButton1.setText("Submit");
        submitjButton1.setMinimumSize(null);
        submitjButton1.setPreferredSize(null);
        submitjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitjButton1ActionPerformed(evt);
            }
        });
        add(submitjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 80, -1));

        medjComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        medjComboBox1.setForeground(new java.awt.Color(51, 51, 255));
        medjComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(medjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Criticality/Priority:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 170, 20));

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(51, 51, 255));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Contact No.", "Receiver", "Status", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 720, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Process Work Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        buttonGroup1.add(qualityIssue);
        qualityIssue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qualityIssue.setForeground(new java.awt.Color(102, 0, 102));
        qualityIssue.setText("Water Quality Issue");
        qualityIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualityIssueActionPerformed(evt);
            }
        });
        add(qualityIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        buttonGroup1.add(lineDamageIssue);
        lineDamageIssue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lineDamageIssue.setForeground(new java.awt.Color(102, 0, 102));
        lineDamageIssue.setText("Line Damage Issue");
        add(lineDamageIssue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

          userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewSurveyorWorkRequestJPanel vwrjp = (ViewSurveyorWorkRequestJPanel) component;
        vwrjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitjButton1ActionPerformed
try{
        String result = resultjTextArea1.getText();
    String priority = (String)medjComboBox1.getSelectedItem();
    
  if(result.length()==0|| priority.equals(""))
           { 
               JOptionPane.showMessageDialog(this, "Please fill or select all Inputs");
               return;
           
           }
        
    
    if (qualityIssue.isSelected()){
        QualityMaintenanceWorkRequest qmsRequest = new QualityMaintenanceWorkRequest();
        qmsRequest.setMessage(result);
        qmsRequest.setSender(userAccount);
        qmsRequest.setStatus("Processing");
        request.setStatus("Completed");
        qmsRequest.setPriority(priority);
        
       
        
        Organization org = null;
      //  System.out.println(" network "+network);
        for (Enterprise enterp: ntwk.getEnterpriseDirectory().getEnterpriseList() ){
            for (Organization organization : enterp.getOrganizationDirectory().getOrganizationList()){

             //   System.out.println(" organization "+organization);
                if (organization instanceof MaintenanceOrganization){
                    org = organization;
                   // System.out.println("checking isntance");
                    break;
                }
            }}
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(qmsRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(qmsRequest);
                submitjButton1.setEnabled(false);
                populateTable();
                JOptionPane.showMessageDialog(this, "The Request has been submitted to Maintenance Department", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                
            }
            
            
     }
        
        
    
    else if(lineDamageIssue.isSelected()){
        LineDefectMaintenanceWorkRequest ldsRequest = new LineDefectMaintenanceWorkRequest();
        ldsRequest.setMessage(result);
        ldsRequest.setSender(userAccount);
        ldsRequest.setStatus("Processing");
        ldsRequest.setPriority(priority);
        request.setStatus("Completed");
     
        
        Organization org = null;
      //  System.out.println(" network "+network);
        for (Enterprise enterp: ntwk.getEnterpriseDirectory().getEnterpriseList() ){
            for (Organization organization : enterp.getOrganizationDirectory().getOrganizationList()){

             //   System.out.println(" organization "+organization);s
                if (organization instanceof MaintenanceOrganization){
                    org = organization;
                   // System.out.println("checking isntance");
                    break;
                }
            }}
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(ldsRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(ldsRequest);
                submitjButton1.setEnabled(false);
                populateTable();
                JOptionPane.showMessageDialog(null, "The Request has been submitted to Maintenance Department", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
            }

    
    
    // TODO add your handling code here:
    }else{
         JOptionPane.showMessageDialog(null, "Please choose one Issue Option", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_submitjButton1ActionPerformed

    private void qualityIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualityIssueActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_qualityIssueActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton lineDamageIssue;
    private javax.swing.JComboBox medjComboBox1;
    private javax.swing.JRadioButton qualityIssue;
    private javax.swing.JTextArea resultjTextArea1;
    private javax.swing.JButton submitjButton1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
