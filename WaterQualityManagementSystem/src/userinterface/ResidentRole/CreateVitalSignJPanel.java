/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentRole;


import Business.Enterprise.Enterprise;
import Business.Enterprise.MunicipalCorporationEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SurveyorOrganization;
import Business.Person.Person;
import Business.Person.Residents;
import Business.Person.VitalSign;
import Business.Validations.MyFloatVerifier;
import Business.Validations.MyNumericVerifier;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Gaurav
 */
public class CreateVitalSignJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVitalSignJPanel
     */
    private Residents residents;
    private JPanel userProcessContainer;
    private BufferedImage image;
    private Network ntw;
    public CreateVitalSignJPanel(JPanel upc, Residents residents,Network ntw) {
        initComponents();
        this.userProcessContainer = upc;
        this.residents = residents;
        this.ntw = ntw;
        addVerifiers();
        setImg();
    }

    private void addVerifiers() {
        InputVerifier numVerifier = new MyFloatVerifier();
        respiratoryRateJTextField.setInputVerifier(numVerifier);
        heartRateJTextField.setInputVerifier(numVerifier);
        bloodPressureJTextField.setInputVerifier(numVerifier);
        weightJTextField.setInputVerifier(numVerifier);
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
        saveJButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Respiratory rate");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 275, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Heart rate");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 327, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Systolic blood pressure");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 377, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Weight in pounds");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 417, 130, 30));

        respiratoryRateJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        respiratoryRateJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(respiratoryRateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 150, 30));

        heartRateJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        heartRateJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(heartRateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 150, 30));

        bloodPressureJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bloodPressureJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(bloodPressureJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 150, 30));

        weightJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        weightJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(weightJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 150, 30));

        saveJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveJButton.setForeground(new java.awt.Color(0, 0, 153));
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 100, -1));

        backJButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(0, 0, 153));
        backJButton1.setText("<<Back");
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Enter Vital Sign Details");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        // TODO add your handling code here:
         if (respiratoryRateJTextField.getText().length() ==0 || heartRateJTextField.getText().length() ==0 || bloodPressureJTextField.getText().length() ==0 ||weightJTextField.getText().length() ==0  ){
             JOptionPane.showMessageDialog(this, "Please fill all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
        try {
            int respiratoryRate = Integer.parseInt(respiratoryRateJTextField.getText());
            int heartRate = Integer.parseInt(heartRateJTextField.getText());
            int bloodPressure = Integer.parseInt(bloodPressureJTextField.getText());
            int weight = Integer.parseInt(weightJTextField.getText());
           
            VitalSign vitalSign = residents.getVitalSignHistory().createAndAddVitalSign();
            vitalSign.setRespiratoryRate(respiratoryRate);
            vitalSign.setHeartRate(heartRate);
            vitalSign.setBloodPressure(bloodPressure);
            vitalSign.setWeight(weight);
            /*Set current date and time as TimeStamp*/
            vitalSign.setTimestamp(new Date());
            String s = VitalSignStatus(residents.getAge(),vitalSign);
          vitalSign.setStatus(s);
            JOptionPane.showMessageDialog(this, "Vital signs added!!", "Update", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
            checkToSendMail(vitalSign);
            }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "Fill correct values","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
        }
    }//GEN-LAST:event_saveJButtonActionPerformed
    
    public void checkToSendMail(VitalSign vitalSign){
    if(vitalSign.getStatus()=="Abnormal")
    {   
        ArrayList<Person> list = new ArrayList<Person>();
        for(Enterprise etr: ntw.getEnterpriseDirectory().getEnterpriseList()){
               if(etr instanceof MunicipalCorporationEnterprise)
               {
               for(Organization org: etr.getOrganizationDirectory().getOrganizationList()){
                   if( org instanceof SurveyorOrganization){
                     for(Person p :org.getPersonDirectory().getPersonList()){
                     list.add(p);
                     }
                       
                      }
                   }
               }
            }
        
        
        sendMail(list);
    }
        
    
    }
    public void sendMail(ArrayList<Person> list){
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
      final String username = "gauravsweet123@gmail.com";//
     final String password = "41634163g";
 try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});
     
     
     
     for(Person p: list){
 try{

         Message msg = new MimeMessage(session);

  // -- Set the FROM and TO fields --
     msg.setFrom(new InternetAddress(username));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(p.getEmailAddress(),false));
        System.out.println("the mail address sweetpooh29");
     msg.setSubject("Attention Needed!!!");
     msg.setText("There is abnormal vital Signs caputured at "+residents+" house. Please schedule a survey.");
     msg.setSentDate(new Date());
     Transport.send(msg); 
 }
      catch (NullPointerException e)
      { 
      JOptionPane.showMessageDialog(this, "Invalid email address of Surveyor");
      }
     }
  
}

catch (Exception e){ 
  JOptionPane.showMessageDialog(this, "Email Address is invalid");
  }

}




    
    
    private String VitalSignStatus(int patientAge, VitalSign vitalSign) {
        
        String vitalSignStatus = "Normal";

        int respirationRate = vitalSign.getRespiratoryRate();
        int heartRate = vitalSign.getHeartRate();
        int bloodPressure = vitalSign.getBloodPressure();
        float weight = vitalSign.getWeight();

        /*Toddler*/
        if (patientAge >= 1 && patientAge <= 3) {
            if ((respirationRate < 20 || respirationRate > 30) /*Respiration Rate*/
                    || (heartRate < 80 || heartRate > 130) /*Heart Rate*/
                    || (bloodPressure < 80 || bloodPressure > 110) /*Blood Pressure*/
                    || (weight < 22 || weight > 31)) /*Weight*/ {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Preschooler*/
        if (patientAge >= 4 && patientAge <= 5) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 80 || heartRate > 120)
                    || (bloodPressure < 80 || bloodPressure > 110)
                    || (weight < 31 || weight > 40)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*School Age*/
        if (patientAge >= 6 && patientAge <= 12) {
            if ((respirationRate < 20 || respirationRate > 30)
                    || (heartRate < 70 || heartRate > 110)
                    || (bloodPressure < 80 || bloodPressure > 120)
                    || (weight < 41 || weight > 92)) {
                vitalSignStatus = "Abnormal";
            }
        }
        /*Adolescent*/
        if (patientAge >= 13) {
            if ((respirationRate < 12 || respirationRate > 20)
                    || (heartRate < 55 || heartRate > 105)
                    || (bloodPressure < 110 || bloodPressure > 120)
                    || (weight < 110)) {
                vitalSignStatus = "Abnormal";
            }
        }
        
        return vitalSignStatus;
        
    }
    
    
    
    
    
    
    
    private void clearFields() {
        respiratoryRateJTextField.setText("");
        heartRateJTextField.setText("");
        bloodPressureJTextField.setText("");
        weightJTextField.setText("");
    }
    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        // TODO add your handling code here:
          userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JTextField bloodPressureJTextField;
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