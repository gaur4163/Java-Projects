/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;



import Business.Enterprise.Enterprise;
import Business.Network.Network;

import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MakeAppointment;

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
 * @author Apoorva
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private USA_Smart_HealthCare business;
    private UserAccount userAccount;
    private DoctorOrganization doctorOrg;
    private Network network;
    private Enterprise enterprise;
    private BufferedImage image;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, USA_Smart_HealthCare business,Network network,Enterprise enterprise) {
        initComponents();
        
        try{this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.doctorOrg = (DoctorOrganization)organization;
        this.network = network;
        this.enterprise = enterprise;
        System.out.println(" enterp name "+enterprise);
        populateTable();
        setImg(); }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }
    
     public void setImg(){
    setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        try
        {
            image = ImageIO.read(new File(getClass().getResource("/userinterface/elderCare.jpg").toURI()));
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
        
        for(WorkRequest request : doctorOrg.getWorkQueue().getWorkRequestList()){
            if(request instanceof MakeAppointment){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getPerson().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
            row[3] = request.getStatus();
            row[4]=((MakeAppointment)request).getAppointmentDate();
            row[5]=((MakeAppointment)request).getReason();
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(0, 51, 204));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Patient", "Doctor Assigned", "Status", "Appointment Date", "Reason for Visit"
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 680, 130));

        assignJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(51, 0, 51));
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        processJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processJButton.setForeground(new java.awt.Color(51, 0, 51));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("View Critical Patients");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Smart Health Care System");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setText("View Appointment Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

       try{ int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        
if ( request.getStatus().equalsIgnoreCase("Pending")||request.getStatus().equalsIgnoreCase("Completed")||request.getStatus().equalsIgnoreCase("Processing")){
         JOptionPane.showMessageDialog(this, "This request is already Taken or Processed", "ERROR", JOptionPane.ERROR_MESSAGE);  
      return;
        } 
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateTable();
         }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        try{
                int selectedRow = workRequestJTable.getSelectedRow();
        
                if (selectedRow < 0){
                        return;
                    }
        
                MakeAppointment request = (MakeAppointment)workRequestJTable.getValueAt(selectedRow, 0);
        if ( request.getStatus().equalsIgnoreCase("Sent")){
         JOptionPane.showMessageDialog(this, "First take the Request", "ERROR", JOptionPane.ERROR_MESSAGE);  
            return;
        }
          if ( request.getStatus().equalsIgnoreCase("Completed"))
                  {     JOptionPane.showMessageDialog(this, "This request is already Taken or Processed", "ERROR", JOptionPane.ERROR_MESSAGE);  
            return;
        }
                request.setStatus("Processing");
                 ProcessAppointmentJPanel processAppointment = new ProcessAppointmentJPanel(userProcessContainer, request,business);
        userProcessContainer.add("ProcessAppointment", processAppointment);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
                //request.setEmergency("Coming to help you");
               // request.setStatus("Completed");
                //JOptionPane.showMessageDialog(this, "You need to go to location "+request.getLocation());  
          populateTable();
 }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CriticalPatientJPanel criticalPatientJPanel = new CriticalPatientJPanel(userProcessContainer, userAccount, doctorOrg, business, network,enterprise);
        userProcessContainer.add("CriticalPatientJPanel", criticalPatientJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
