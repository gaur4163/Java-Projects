/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.AssistantOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
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
public class CriticalPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CriticalPatientJPanel
     */
   

    private JPanel userProcessContainer;
    private USA_Smart_HealthCare business;
    private UserAccount userAccount;
    private DoctorOrganization doctorOrg;
    private Network network;
    private HospitalEnterprise enterprise;
    private BufferedImage image;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public CriticalPatientJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, USA_Smart_HealthCare business,Network network,Enterprise enterprise) {
        initComponents();
        try{
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.doctorOrg = (DoctorOrganization)organization;
        this.network = network;
        this.enterprise=(HospitalEnterprise) enterprise;
         //System.out.println("enterprise name " +enterprise);
        populateTable();
        populateDoctorsComboBox();
        setImg();
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
    
    
    public void populateTable(){
    
    DefaultTableModel model = (DefaultTableModel)seniorCitJTable.getModel();
        
        model.setRowCount(0);
        System.out.println(" list count"+enterprise.getCriticalPerson().getPatientList().size());
        for(SeniorPerson person : enterprise.getCriticalPerson().getPatientList()){
            
            Object[] row = new Object[7];
            row[0] = person.getid();
            row[1] = person;
            row[2] = person.isStayAlone();
            row[3] = person.getContactNumber();
            row[4]=person.getCareTakers().size();
            row[5]=person.getAddress();
            row[6]=person.getAssignedJdoc();
            model.addRow(row);
        }
    }
    
     public void populateDoctorsComboBox(){
        assistantjComboBox1.removeAllItems();
        
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList() ){
                
                    if(enterprise instanceof HospitalEnterprise)
                    {
                        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                        {     if(org instanceof AssistantOrganization){
                            for(Person p : org.getPersonDirectory().getPersonList())
                            { assistantjComboBox1.addItem(p);}
                        }
                        
                    }
                    }
                
            
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

        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        seniorCitJTable = new javax.swing.JTable();
        assignTojButton1 = new javax.swing.JButton();
        assistantjComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));

        seniorCitJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seniorCitJTable.setForeground(new java.awt.Color(0, 51, 204));
        seniorCitJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID of Person", "Name", "Staying Alone", "Contact Number", "Care Takers", "Address", "Assigned To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(seniorCitJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 690, 169));

        assignTojButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assignTojButton1.setForeground(new java.awt.Color(51, 0, 51));
        assignTojButton1.setText("Assign To");
        assignTojButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignTojButton1ActionPerformed(evt);
            }
        });
        add(assignTojButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        assistantjComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        assistantjComboBox1.setForeground(new java.awt.Color(0, 51, 204));
        assistantjComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(assistantjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 200, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 153));
        jLabel2.setText("Assign Critical Patients ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Smart Health Care System");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void assignTojButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignTojButton1ActionPerformed
       try{  Person selectedRow = (Person) assistantjComboBox1.getSelectedItem();
         int per = seniorCitJTable.getSelectedRow();
                if (selectedRow.equals("")||per<0)
                        
                {        JOptionPane.showMessageDialog(this, "Please select a Patient and a Junior doctor to assign Patient");
                   return; 
                }
                else{
                 SeniorPerson person = (SeniorPerson)seniorCitJTable.getValueAt(per, 1);
                 person.setAssignedJdoc(selectedRow);
                         JOptionPane.showMessageDialog(this,"The Junior Doctor "+selectedRow +" will contact patient "+person.getName());
                }
                populateTable(); }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_assignTojButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignTojButton1;
    private javax.swing.JComboBox assistantjComboBox1;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable seniorCitJTable;
    // End of variables declaration//GEN-END:variables
}