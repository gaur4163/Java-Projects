/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Patient;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AssistantOrganization;
import Business.Organization.Organization;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssistanceHelp;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Apoorva
 */
public class AskAssistanceJPanel extends javax.swing.JPanel {
     private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private USA_Smart_HealthCare business;
    private Network network;
    private BufferedImage image;
   
    /**
     * Creates new form askAssistanceJPanel
     */
    public AskAssistanceJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        initComponents();
       try{ this.userProcessContainer= userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise= enterprise;
        this.business= business;
        this.network = network;
        setImg();  
       }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
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
        assisHelpJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        quesjTextArea1 = new javax.swing.JTextArea();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Welcome to Speed Help");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        assisHelpJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assisHelpJButton.setForeground(new java.awt.Color(51, 0, 51));
        assisHelpJButton.setText("Ask Help");
        assisHelpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assisHelpJButtonActionPerformed(evt);
            }
        });
        add(assisHelpJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setText("We are here to serve you");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Question: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 80, 30));

        quesjTextArea1.setColumns(20);
        quesjTextArea1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        quesjTextArea1.setForeground(new java.awt.Color(0, 51, 204));
        quesjTextArea1.setRows(5);
        jScrollPane1.setViewportView(quesjTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 390, 205));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Smart Health Care System");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void assisHelpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assisHelpJButtonActionPerformed
       try{
           if(quesjTextArea1.getText().length()==0){
        JOptionPane.showMessageDialog(this, "Please fill Question");
        }
        else{
        JOptionPane.showMessageDialog(this, "Your question is sent to an expert");
        AssistanceHelp request = new AssistanceHelp();
        request.setMessage(quesjTextArea1.getText());
        request.setSender(account);
        request.setStatus("Sent");
        Organization org = null;
      //  System.out.println(" network "+network);
        for (Enterprise enterp: network.getEnterpriseDirectory().getEnterpriseList() ){
            for (Organization organization : enterp.getOrganizationDirectory().getOrganizationList()){

             //   System.out.println(" organization "+organization);
                if (organization instanceof AssistantOrganization){
                    org = organization;
                   // System.out.println("checking isntance");
                    break;
                }
            }}
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
            }     }   }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_assisHelpJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
try{
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewPreviousAssisJpanel vswe = (ViewPreviousAssisJpanel) component;
        vswe.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
           }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assisHelpJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea quesjTextArea1;
    // End of variables declaration//GEN-END:variables
}
