/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Patient;

import Business.Enterprise.Enterprise;
import Business.HealthCare.Medicine;
import Business.Network.Network;
import Business.SeniorPerson.SeniorPerson;
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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Apoorva
 */
public class ViewPresJPanel1 extends javax.swing.JPanel {


     private JPanel userProcessContainer;
    private UserAccount account;
   // private Organization organization;
    private Enterprise enterprise;
    private USA_Smart_HealthCare business;
    private Network network;
    private BufferedImage image;
    /**
     * Creates new form PatientWorkArea
     */
    public ViewPresJPanel1(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        initComponents();
    try{    this.userProcessContainer= userProcessContainer;
        this.account = account;
       // this.organization = organization;
        this.enterprise= enterprise;
        this.business= business;
        this.network = network;
        setImg();
     
    populateTable2();
       }
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
    
    public void populateTable2(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            if(request instanceof MakeAppointment&& request.getStatus().equals("Completed")){
            Object[] row = new Object[2];
            row[0] = request;
            row[1] = request.getReceiver() == null ? null : request.getReceiver().getPerson().getName();
           
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        presjTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultjTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        prresjTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Welcome to Speed Help");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setText("We are here to serve you");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 51, 204));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Appointments");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 140, -1));

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(0, 51, 204));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Appointment Date", "Doctor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 210, 90));

        presjTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        presjTable1.setForeground(new java.awt.Color(0, 51, 204));
        presjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine", "Directions"
            }
        ));
        jScrollPane2.setViewportView(presjTable1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 510, 110));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Visit Results/Reports");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        resultjTextArea1.setEditable(false);
        resultjTextArea1.setColumns(20);
        resultjTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resultjTextArea1.setForeground(new java.awt.Color(0, 51, 204));
        resultjTextArea1.setRows(5);
        jScrollPane3.setViewportView(resultjTextArea1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 279, 90));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Prescription");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        prresjTextArea2.setEditable(false);
        prresjTextArea2.setColumns(20);
        prresjTextArea2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        prresjTextArea2.setForeground(new java.awt.Color(0, 51, 204));
        prresjTextArea2.setRows(5);
        jScrollPane4.setViewportView(prresjTextArea2);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 510, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("View  Prescriptions");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Smart Health Care System");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try{     int selectedRow = workRequestJTable.getSelectedRow();
        
                if (selectedRow < 0){
                        
                        JOptionPane.showMessageDialog(this, "Please select a request");
                   return; }
        
                MakeAppointment request = (MakeAppointment)workRequestJTable.getValueAt(selectedRow, 0);
                SeniorPerson person = account.getSeniorPerson();
                ArrayList<Medicine> list = person.getPresMedForApp(request);
                 resultjTextArea1.setText(request.getResult());
                prresjTextArea2.setText(request.getPrescription());
                DefaultTableModel model = (DefaultTableModel)presjTable1.getModel();
        
        model.setRowCount(0);
               
                if(list.isEmpty()){
                  JOptionPane.showMessageDialog(this, "This prescription is too old.");
                  
                }
                else{
                for(Medicine med : list){
                Object[] row = new Object[2];
            row[0] = med.getProduct();
            row[1] = med.getDirections();           
            model.addRow(row);
                
                }
                
                }
                 }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable presjTable1;
    private javax.swing.JTextArea prresjTextArea2;
    private javax.swing.JTextArea resultjTextArea1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}