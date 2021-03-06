/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CaretakerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.ResidentsEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Person;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AlertCaretaker;
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
import userinterface.Patient.ViewHealthRecordsJpanel;
import userinterface.Patient.ViewPresJPanel1;
import userinterface.Patient.ViewScheduleJpanel;

/**
 *
 * @author Apoorva
 */
public class CareTakerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CareTakerWorkAreaJPanel
     */
   
private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private USA_Smart_HealthCare business;
    private Network network;
    private UserAccount serAccount;
    private BufferedImage image;
    /**
     * Creates new form PatientWorkArea
     */
    public CareTakerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        initComponents();
       try{ this.userProcessContainer= userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise= enterprise;
        this.business= business;
        this.network = network;
        this.serAccount = searchSPerson(account.getPerson(),network);
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
        
        AlertCaretaker req = null;
             //System.out.println("patient "+serAccount.getPerson().getName());
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if(request.getSender().equals(serAccount)){
          req = (AlertCaretaker)request;
                //System.out.println("request "+req.getMessage());
        }}
        
        if(req!=null){
        
        
       // jLabel5.setForeground(Color.red);
       // jLabel5.setText("<html>First line <br>  and maybe second line</html>");
        jLabel5.setText("<html> Emergency Message for You <br> <b>"+req.getMessage()+"  which is critical <br> Blood Pressure: "+req.getSign().getBloodPressure()
        +"<br> Heart Rate: "+req.getSign().getHeartRate()
        +"<br> Respiration rate: "+req.getSign().getRespiratoryRate()
        +"<br> Hours of Sleep: "+req.getSign().getSleepinghours()
        +"<br> Activity Tracked: "+req.getSign().getStepCount()
        +"<br> Blood Sugar: "+req.getSign().getSugarLevel()
        +"<br> Weight: "+req.getSign().getWeight()
        +"<br> on "+req.getSign().getTimestamp()+"</b></html>");
        
        
        }
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
        monitorHealthjButton = new javax.swing.JButton();
        schedulejButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewPresjButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Welcome to Speed Help");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        monitorHealthjButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        monitorHealthjButton.setForeground(new java.awt.Color(51, 0, 51));
        monitorHealthjButton.setText("Monitor Dependent's Health");
        monitorHealthjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monitorHealthjButtonActionPerformed(evt);
            }
        });
        add(monitorHealthjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 210, 30));

        schedulejButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        schedulejButton.setForeground(new java.awt.Color(51, 0, 51));
        schedulejButton.setText("Monitor Their Appointments");
        schedulejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedulejButtonActionPerformed(evt);
            }
        });
        add(schedulejButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 210, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setText("We are here to serve you");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        viewPresjButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewPresjButton.setForeground(new java.awt.Color(51, 0, 51));
        viewPresjButton.setText("View Prescriptions");
        viewPresjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPresjButtonActionPerformed(evt);
            }
        });
        add(viewPresjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 210, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("jLabel6");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 370, 350));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Smart Health Care System");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void viewPresjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPresjButtonActionPerformed
        try{ ViewPresJPanel1 viewPresJPanel1 = new ViewPresJPanel1(userProcessContainer,serAccount,  enterprise, business, network);
        userProcessContainer.add("ViewPresJPanel1", viewPresJPanel1);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);  }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_viewPresjButtonActionPerformed

    private void schedulejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedulejButtonActionPerformed
       try{   ViewScheduleJpanel viewScheduleJpanel = new ViewScheduleJpanel(userProcessContainer,serAccount,  enterprise, business, network);
        userProcessContainer.add("view schedule", viewScheduleJpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);   }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_schedulejButtonActionPerformed

    private void monitorHealthjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monitorHealthjButtonActionPerformed
try{ ViewHealthRecordsJpanel   viewHealthRecordsJpanel = new ViewHealthRecordsJpanel(userProcessContainer, serAccount, organization, enterprise, business, network);
        userProcessContainer.add("ViewHealthRecordsJpanel", viewHealthRecordsJpanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);        // TODO add your handling code here:
      }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }    // TODO add your handling code here:
    }//GEN-LAST:event_monitorHealthjButtonActionPerformed

public UserAccount searchSPerson(Person careTaker,Network ntwk){

UserAccount us = null;
SeniorPerson sPer = null;
    for(Enterprise etr: ntwk.getEnterpriseDirectory().getEnterpriseList())
        {   if (etr instanceof ResidentsEnterprise)
            {
                for(Organization org: etr.getOrganizationDirectory().getOrganizationList())
                    {
                    if(org instanceof PatientOrganization)
                        {
                        for(SeniorPerson per : ((PatientOrganization)org).getPersonDir().getSerPersonList())
                        {
                            for(Person cTp : per.getCareTakers())
                            {
                            if(cTp.equals(careTaker)){
                            sPer = per;
                             //   System.out.println("list has: "+per.getName()+" "+per.getAppointmentList().size());
                            
                            }
                            }
                        }
                        
                        for (UserAccount a :((PatientOrganization)org).getUserAccountDirectory().getUserAccountList() )
                        {
                            if(a.getPerson().equals(sPer))
                            {
                            us = a;
                            }
                        
                        }
                            
                        }
                    }
            }
        }


return us;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton monitorHealthjButton;
    private javax.swing.JButton schedulejButton;
    private javax.swing.JButton viewPresjButton;
    // End of variables declaration//GEN-END:variables
}
