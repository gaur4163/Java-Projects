/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package userinterface.MaintenanceStaffRole;

import Business.Enterprise.Enterprise;
import Business.Organization.MaintenanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WaterQualityMonitoring;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author  Gaurav
 */
public class MaintenanceStaffWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private WaterQualityMonitoring business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private MaintenanceOrganization maintenanceOrg;
    private BufferedImage image;
    /** Creates new form AdminWorkAreaJPanel */
    public MaintenanceStaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, WaterQualityMonitoring business) {
        initComponents();
        this.setSize(650, 530);
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise=enterprise;
        this.business = business;
        this.maintenanceOrg = (MaintenanceOrganization)organization;
        setImg();
        valueLabel.setText(enterprise.getName());
        
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
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageDamageMaintenance = new javax.swing.JButton();
        manageQualityMaintenance = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Work Area - Maintenance Staff");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, 40));

        manageDamageMaintenance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageDamageMaintenance.setForeground(new java.awt.Color(0, 0, 153));
        manageDamageMaintenance.setText("Manage Line Damage Requests");
        manageDamageMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDamageMaintenanceActionPerformed(evt);
            }
        });
        add(manageDamageMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 260, 30));

        manageQualityMaintenance.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        manageQualityMaintenance.setForeground(new java.awt.Color(0, 0, 153));
        manageQualityMaintenance.setText("Manage Water Quality Maintenance");
        manageQualityMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageQualityMaintenanceActionPerformed(evt);
            }
        });
        add(manageQualityMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 260, 30));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(102, 0, 102));
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 120, 30));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(204, 0, 0));
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 380, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void manageDamageMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDamageMaintenanceActionPerformed

        LineDefectMaintenanceStaffWorkAreaJPanel lineDefectMaintenanceStaffWorkAreaJPanel = new LineDefectMaintenanceStaffWorkAreaJPanel(userProcessContainer,userAccount,maintenanceOrg,business);
        userProcessContainer.add("LineDefectMaintenanceStaffWorkAreaJPanel", lineDefectMaintenanceStaffWorkAreaJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_manageDamageMaintenanceActionPerformed

    private void manageQualityMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageQualityMaintenanceActionPerformed

        QualityMaintenanceStaffWorkAreaJPanel qualityMaintenanceStaffWorkAreaJPanel = new QualityMaintenanceStaffWorkAreaJPanel(userProcessContainer,userAccount,maintenanceOrg,business);
        userProcessContainer.add("QualityMaintenanceStaffWorkAreaJPanel", qualityMaintenanceStaffWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageQualityMaintenanceActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton manageDamageMaintenance;
    private javax.swing.JButton manageQualityMaintenance;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
