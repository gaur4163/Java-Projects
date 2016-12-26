/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.USA_Smart_HealthCare;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Enterprise.ResidentsEnterprise;
import Business.HealthCare.VitalSign;
import Business.HealthCare.VitalSignHistory;
import Business.Network.Network;
import Business.Organization.CareTakerOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Person;
import Business.SeniorPerson.SeniorPerson;
import Business.SeniorPerson.SeniorPersonDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.AlertCaretaker;
import java.awt.CardLayout;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private USA_Smart_HealthCare system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        initComponents();
       
     //   try{
        system = dB4OUtil.retrieveSystem();
        Person.setSys(system);
       sensor(system);
          
        dB4OUtil.storeSystem(system);
      
      this.setExtendedState(MAXIMIZED_BOTH);
 //       }
//        catch(Exception e)
//        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
//        }
        
    }
    
    
    public void sensor(USA_Smart_HealthCare system){
 // try{
     SeniorPersonDirectory list = getAllPatients(system);   
          final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
   for(SeniorPerson p :list.getSerPersonList()){
          service.scheduleWithFixedDelay(new Runnable()
      {
        @Override
        public void run()
        {
          System.out.println(new Date());
           
           
                
       
             // System.out.println("person name "+p.getName());
              VitalSignHistory vitalSignList1 = p.getVitalSignList();
              
                 VitalSign vitalSignObj = vitalSignList1.createAndAddVitalSign(); 
                 addVitalSigns(vitalSignObj,p,system);
                        
                     
                   
        }
        
      }, 0, 60, TimeUnit.SECONDS);}
        
//        }
//        catch(Exception e)
//        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
//        }
    
    }
    
    public void addVitalSigns(VitalSign vs, SeniorPerson p,USA_Smart_HealthCare system){
       // try{
            Random r = new Random();
        
        int bp = r.nextInt((140 - 90) + 1) + 90;
         int hr = r.nextInt((90 - 65) + 1) + 65;
          int rsr = r.nextInt((28 - 11) + 1) + 11;
           int wh = r.nextInt((47 - 25) + 1) + 25;
            int slh = r.nextInt((11 - 6) + 1) + 6;
             int stc = r.nextInt((1000 - 49) + 1) + 49;
              int sl = r.nextInt((110 - 70) + 1) + 70;
         Boolean isNormal = true;
                    vs.setBloodPressure(bp);
                    vs.setHeartRate(hr);
                    vs.setRespiratoryRate(rsr);
                    vs.setWeight(wh);
                    vs.setSleepinghours(slh);
                    vs.setStepCount(stc);
                    vs.setSugarLevel(sl);
                    
                     if(bp<90|| bp>=135) 
                   {        isNormal = false;   
                            
                   }
                   
                    if(hr<60|| hr>=100) 
                   {        isNormal = false;   
                   }
                    if(rsr<12|| rsr>=28) 
                   {        isNormal = false;   
                   }
                    if(wh<25|| wh>=45) 
                   {        isNormal = false;
                   }
                    if(slh<6|| slh>=10) 
                   {        isNormal = false;   
                   }
                    if(sl<72|| sl>=108) 
                   {        isNormal = false;   
                   }
                   
                    if(stc<50|| stc>=1000) 
                   {        isNormal = false;  
                   }
                   if(isNormal){vs.setStatus("Normal");}
                    else{
                        vs.setStatus("Abnormal");
                  
                        alertOthers(vs,"This system captured vital Signs and your dependent has abnormal vital signs ",p,system);
                    }
//                 }
//        catch(Exception e)
//        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
//        }   
                    
    }
    
    public SeniorPersonDirectory getAllPatients(USA_Smart_HealthCare system){
    SeniorPersonDirectory list = new SeniorPersonDirectory();
    
     for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                   
                    if (enterprise instanceof ResidentsEnterprise) {
                        //Step3: Check against each organization inside that enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            
                            if (organization instanceof PatientOrganization) {
                              PatientOrganization  org = (PatientOrganization)organization;
                              //for(SeniorPerson p : org.getPersonDir().getSerPersonList()){
                              for(UserAccount p : org.getUserAccountDirectory().getUserAccountList()){
                              list.addSeniorPer(p.getSeniorPerson());
                              }
                            }
                        }
                    }}}
    
    return list;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        loginJButton = new javax.swing.JButton();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginJLabel = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 36)); // NOI18N
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginJButton.setForeground(new java.awt.Color(51, 0, 51));
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(loginJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 344, 108, -1));

        userNameJTextField.setForeground(new java.awt.Color(0, 51, 204));
        jPanel2.add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 236, 110, -1));

        passwordField.setForeground(new java.awt.Color(0, 51, 204));
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 306, 110, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("User Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 211, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 274, -1, -1));
        jPanel2.add(loginJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 200, -1, -1));

        logoutJButton.setForeground(new java.awt.Color(51, 0, 51));
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 385, 108, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Login Here");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 177, -1, -1));

        jSplitPane1.setLeftComponent(jPanel2);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setForeground(new java.awt.Color(0, 51, 204));
        container.setLayout(new java.awt.CardLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/elderCare.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        container.add(jLabel5, "card2");

        jSplitPane1.setRightComponent(container);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
       try{ String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network inNetwork = null;
        if (userAccount == null) {
            //Step2: Go inside each network to check each enterprise
            for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
               // System.out.println("network list "+system.getNetworkList().size());
                
               // System.out.println("netwk "+network);
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                  //  System.out.println("enterp "+enterprise);
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    // inNetwork = network;
                    if (userAccount == null) {
                        //Step3: Check against each organization inside that enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                inNetwork = network;
                                break;
                            }
                        }
                    } else {
                        inEnterprise = enterprise;
                         inNetwork = network;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
                 if (inNetwork != null) {
                    break;
                }
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        } else {
            CardLayout layout = (CardLayout) container.getLayout();
            container.add("workArea", userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, system, inNetwork));
            layout.next(container);
        }
         loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll();
        JPanel blankJP = new JPanel();
        blankJP.add(jLabel5);
        container.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) container.getLayout();
        crdLyt.next(container);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    
    public void alertOthers(VitalSign vitalSignObj, String msg, SeniorPerson p,USA_Smart_HealthCare system) {
       
        
      // try{
        UserAccountDirectory dir = new UserAccountDirectory();
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    dir.addAccounDirectory(enterprise.getUserAccountDirectory().getUserAccountList());
                     for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                     dir.addAccounDirectory(organization.getUserAccountDirectory().getUserAccountList());
                     }
                }
        }
        UserAccount account = p.searchAccount(p, dir);
        if (account == null){
        //    System.out.println("Account didnt exists");
        //return;
        }
         AlertCaretaker request = new AlertCaretaker();
        request.setMessage("This is automatic alert!!! generated from "+p.getName()+" reports");
        request.setAlert(msg);
        request.setSign(vitalSignObj);
        request.setSender(account);
        request.setStatus("Sent");
        Organization org = null;
         Network network = p.getNetwork();
      //  System.out.println(" network "+network);
        for (Enterprise enterp: network.getEnterpriseDirectory().getEnterpriseList() ){
            if (enterp instanceof HospitalEnterprise)
                {  if(enterp==account.getSeniorPerson().getHospital())
                {
                   // System.out.println("enterprise name " +enterp);
                    ((HospitalEnterprise)enterp).getCriticalPerson().addPatient(account.getSeniorPerson());
                    
                }}
            for (Organization organization : enterp.getOrganizationDirectory().getOrganizationList()){

             //   System.out.println(" organization "+organization);
                if (organization instanceof CareTakerOrganization){
                    org = organization;
                   // System.out.println("checking isntance");
                    
                }
            }}
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
                 
            }
//            }
//        catch(Exception e)
//        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
//        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables

  


}
