/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdminRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Person.Person;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.ResidentOrganization;
import Business.UserAccount.UserAccount;
import Business.Validations.MyEmailAddressValidator;
import Business.Validations.MyStringVerifier;
import Business.WaterQualityMonitoring;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaurav
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    private BufferedImage image;
    WaterQualityMonitoring system;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,OrganizationDirectory organizationDir,WaterQualityMonitoring system) {
        initComponents();
        this.setSize(650, 530);
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.system=system;
        setImg();
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
         addVerifiers();
        
    }
    
    
    public boolean checkIfExists(String name ){
     boolean exist=false;
            //System.out.println(" count "+count);
            if(system.getNetworkList().size()!=0){
            for(Network n: system.getNetworkList()){
               // System.out.println("netw name "+n);
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList())
            {//System.out.println("etr name "+e);
                for(Person d: e.getPersonDirectory().getPersonList()){
                 if(d.getName().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           }
                }
            for (Organization org : e.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof ResidentOrganization){
            for(Person p :((ResidentOrganization)org).getResidentDirectory().getResidentList()){
          
             if(p.getName().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           }
            }}
               
            else{     // System.out.println("org name "+org);
            for(Person p :org.getPersonDirectory().getPersonList()){
           if(p.getName().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           } }
           
            }
            }
            }
           
           
            }
        }
    return exist;
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
    
    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            if(!organization.toString().equalsIgnoreCase("Admin Organization")){
            organizationJComboBox.addItem(organization);
        }
        }
    }
    
    private void addVerifiers() {
        InputVerifier stringVerifier = new MyStringVerifier();
        nameJTextField.setInputVerifier(stringVerifier);
        
    }
    public void populateOrganizationEmpComboBox(){
        organizationEmpJComboBox.removeAllItems();
        
        for (Organization organization : organizationDir.getOrganizationList()){
            if(!organization.toString().equalsIgnoreCase("Admin Organization")){
            organizationEmpJComboBox.addItem(organization);
        }
        }
    }

    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Person person : organization.getPersonDirectory().getPersonList()){
            Object[] row = new Object[2];
            
            row[0] = person;
            row[1] = person.getEmailAddress();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailAddress = new javax.swing.JTextField();

        setForeground(new java.awt.Color(102, 0, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        organizationJTable.setForeground(new java.awt.Color(51, 51, 255));
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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
        organizationJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 510, 120));

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addJButton.setForeground(new java.awt.Color(0, 0, 153));
        addJButton.setText("Create Person");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, -1, 30));

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(51, 51, 255));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Organization");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 20));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 40, 20));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 230, 30));

        organizationEmpJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        organizationEmpJComboBox.setForeground(new java.awt.Color(51, 51, 255));
        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });
        add(organizationEmpJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 230, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Organization");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Manage Person");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 129, -1, 30));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Email Address");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 100, 30));

        emailAddress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailAddress.setForeground(new java.awt.Color(51, 51, 255));
        add(emailAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
       try{        
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        String email = emailAddress.getText();
        
        MyEmailAddressValidator eav = new MyEmailAddressValidator();
        if (eav.isValidEmailAddress(email)==false){
        JOptionPane.showMessageDialog(null, "Please Enter the valid email address", "ERROR", JOptionPane.ERROR_MESSAGE); 
        return;
        }
        if (name.length()==0 || organization.equals("") ||email.length()==0){
              JOptionPane.showMessageDialog(this, "Please fill all Inputs","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
        if(checkIfExists(name))
        { JOptionPane.showMessageDialog(this, "The Person name already exists","ERROR",JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        organization.getPersonDirectory().createAdminPerson(name,email);
        populateTable(organization);
        clearFields();
        }
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        
    }//GEN-LAST:event_addJButtonActionPerformed
   }
    
      private void clearFields()
        {
            nameJTextField.setText("");
            emailAddress.setText("");
            
        }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField emailAddress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
