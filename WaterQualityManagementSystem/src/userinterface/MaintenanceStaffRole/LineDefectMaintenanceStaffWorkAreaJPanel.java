/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MaintenanceStaffRole;




import Business.Organization.MaintenanceOrganization;
import Business.Organization.Organization;

import Business.UserAccount.UserAccount;
import Business.WaterQualityMonitoring;
import Business.WorkQueue.LineDefectMaintenanceWorkRequest;


import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class LineDefectMaintenanceStaffWorkAreaJPanel extends javax.swing.JPanel {

     JPanel userProcessContainer;
     WaterQualityMonitoring business;
     UserAccount userAccount;
    MaintenanceOrganization maintenanceOrg;
    private BufferedImage image;
    
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public LineDefectMaintenanceStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, WaterQualityMonitoring business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.maintenanceOrg = (MaintenanceOrganization)organization;
        setImg();   
        populateTable();
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
        
        for(WorkRequest request : maintenanceOrg.getWorkQueue().getWorkRequestList()){
            if(request instanceof LineDefectMaintenanceWorkRequest){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getPerson().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
            row[3] = request.getStatus();
            row[4]=request.getRequestDate();
            row[5] = ((LineDefectMaintenanceWorkRequest)request).getPriority();
            model.addRow(row);
        }}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(51, 51, 255));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Request Date", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
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
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 770, 150));

        assignJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(0, 0, 153));
        assignJButton.setText("Take Request");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, -1, 30));

        processJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processJButton.setForeground(new java.awt.Color(0, 0, 153));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 110, 30));

        refreshJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshJButton.setForeground(new java.awt.Color(0, 0, 153));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("View Line Defect Work Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        try{
        int selectedRow = workRequestJTable.getSelectedRow();
        
         if (selectedRow < 0){
        JOptionPane.showMessageDialog(null, "Please choose Atleast one Request", "WARNING", JOptionPane.WARNING_MESSAGE);   
            return;
        }
        
        WorkRequest requestB = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
         if (requestB.getStatus().equals("Assigned") || requestB.getStatus().equalsIgnoreCase("Completed")){
          JOptionPane.showMessageDialog(null, "This request is already Assigned or completed", "ERROR", JOptionPane.ERROR_MESSAGE);   
        }else{
        requestB.setReceiver(userAccount);
        requestB.setStatus("Assigned");
        populateTable();
         }
         }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
                try{               
                int selectedRow = workRequestJTable.getSelectedRow();
        
                if (selectedRow < 0){
                    
               JOptionPane.showMessageDialog(null, "Please choose Atleast one Request", "WARNING", JOptionPane.WARNING_MESSAGE); 
                        return;
                    }
        
                LineDefectMaintenanceWorkRequest requestA = (LineDefectMaintenanceWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
          if ( requestA.getStatus().equalsIgnoreCase("Completed")){
          JOptionPane.showMessageDialog(null, "This request is already processed", "ERROR", JOptionPane.ERROR_MESSAGE);   
        }else if( requestA.getStatus().equalsIgnoreCase("Processing")) {
          JOptionPane.showMessageDialog(null, "First Assign the Request to you", "ERROR", JOptionPane.ERROR_MESSAGE);    
        }else{
                
        ProcessLineDefectRequestJPanel processLineDefectRequestJPanel = new ProcessLineDefectRequestJPanel(userProcessContainer, requestA);
        userProcessContainer.add("ProcessLineDefectRequestJPanel", processLineDefectRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
                //request.setEmergency("Coming to help you");
               // request.setStatus("Completed");
                //JOptionPane.showMessageDialog(this, "You need to go to location "+request.getLocation());  
          
          }
          }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
