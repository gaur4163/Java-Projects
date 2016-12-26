/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentRole;


import Business.Person.VitalSign;
import Business.Validations.MyFloatVerifier;
import Business.Validations.MyNumericVerifier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gaurav
 */
public class ViewUpdateVitalSignsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewUpdateVitalSignsJPanel
     */
    VitalSign vitalSign;
    JPanel userProcessContainer;
    Boolean isEdit = Boolean.FALSE;
    private BufferedImage image; 

    public ViewUpdateVitalSignsJPanel(JPanel upc, VitalSign vitalSign, Boolean isEdit) {
        initComponents();
        this.userProcessContainer = upc;
        this.vitalSign = vitalSign;
        this.isEdit = isEdit;
        addVerifiers();
        populateVitalSignDetails();
        modifyTextFields(this.isEdit);
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
    
    private void addVerifiers() {
        InputVerifier numVerifier = new MyFloatVerifier();
        respiratoryRateJTextField.setInputVerifier(numVerifier);
        heartRateJTextField.setInputVerifier(numVerifier);
        bloodPressureJTextField.setInputVerifier(numVerifier);
        weightJTextField.setInputVerifier(numVerifier);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        respiratoryRateJTextField = new javax.swing.JTextField();
        heartRateJTextField = new javax.swing.JTextField();
        bloodPressureJTextField = new javax.swing.JTextField();
        weightJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        editVitalSignJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Respiratory rate");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 130, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Heart rate");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Systolic blood pressure");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Weight in pounds");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 130, -1));

        respiratoryRateJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        respiratoryRateJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(respiratoryRateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 160, 30));

        heartRateJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        heartRateJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(heartRateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 160, 30));

        bloodPressureJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bloodPressureJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(bloodPressureJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 160, 30));

        weightJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weightJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(weightJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 160, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 100, -1));

        editVitalSignJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editVitalSignJButton.setForeground(new java.awt.Color(0, 0, 153));
        editVitalSignJButton.setText("Edit");
        editVitalSignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVitalSignJButtonActionPerformed(evt);
            }
        });
        add(editVitalSignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 100, 30));

        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveJButton.setForeground(new java.awt.Color(0, 0, 153));
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("View/Update Vital Signs");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
//        userProcessContainer.remove(this);
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        layout.previous(userProcessContainer);
        
         userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageVitalSignsJPanel mvsjp = (ManageVitalSignsJPanel) component;
        mvsjp.populateVitalSignTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        // TODO add your handling code here:
        try{
         if (respiratoryRateJTextField.getText().length() ==0 || heartRateJTextField.getText().length() ==0 || bloodPressureJTextField.getText().length() ==0 ||weightJTextField.getText().length() ==0  ){
             JOptionPane.showMessageDialog(this, "Please fill  all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {
            int respiratoryRate = Integer.parseInt(respiratoryRateJTextField.getText());
            int heartRate = Integer.parseInt(heartRateJTextField.getText());
            int bloodPressure = Integer.parseInt(bloodPressureJTextField.getText());
            int weight = Integer.parseInt(weightJTextField.getText());
            vitalSign.setRespiratoryRate(respiratoryRate);
            vitalSign.setHeartRate(heartRate);
            vitalSign.setBloodPressure(bloodPressure);
            vitalSign.setWeight(weight);
            /*Set current date and time as TimeStamp*/
            vitalSign.setTimestamp(new Date());
            JOptionPane.showMessageDialog(this, "Vital signs updated!!", "Update", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter correct values", "Error", JOptionPane.ERROR_MESSAGE);
        }
        modifyTextFields(false);
         }
         }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void editVitalSignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVitalSignJButtonActionPerformed
        // TODO add your handling code here:
        modifyTextFields(true);
    }//GEN-LAST:event_editVitalSignJButtonActionPerformed
    private void modifyTextFields(Boolean isEdit) {
        if (isEdit) {
            respiratoryRateJTextField.setEnabled(true);
            heartRateJTextField.setEnabled(true);
            bloodPressureJTextField.setEnabled(true);
            weightJTextField.setEnabled(true);
        } else {
            respiratoryRateJTextField.setEnabled(false);
            heartRateJTextField.setEnabled(false);
            bloodPressureJTextField.setEnabled(false);
            weightJTextField.setEnabled(false);
        }
    }

    private void populateVitalSignDetails() {
        respiratoryRateJTextField.setText(String.valueOf(vitalSign.getRespiratoryRate()));
        heartRateJTextField.setText(String.valueOf(vitalSign.getHeartRate()));
        bloodPressureJTextField.setText(String.valueOf(vitalSign.getBloodPressure()));
        weightJTextField.setText(String.valueOf(vitalSign.getWeight()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bloodPressureJTextField;
    private javax.swing.JButton editVitalSignJButton;
    private javax.swing.JTextField heartRateJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField respiratoryRateJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JTextField weightJTextField;
    // End of variables declaration//GEN-END:variables
}
