/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentAdminRole;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.ResidentOrganization;
import Business.Person.Residents;
import Business.Role.HouseholdResidentRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
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
public class ManageResidentUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageResidentUserAccountJPanel
     */
     private BufferedImage image;
    private JPanel container;
    private Enterprise enterprise;
    WaterQualityMonitoring system;

    public ManageResidentUserAccountJPanel(JPanel container, Enterprise enterprise,WaterQualityMonitoring system) {
        initComponents();
         this.setSize(650, 530);
        this.enterprise = enterprise;
        this.container = container;

       this.system=system  ;
        populateEmployeeComboBox(enterprise.getOrganizationDirectory().searchOrganization(Type.ResidentOrganization));
        popData();
        setImg();
        addVerifiers();
    }
       public boolean checkIfExistsUA(String name ){
     boolean exist=false;
            //System.out.println(" count "+count);
            if(system.getNetworkList().size()!=0){
            for(Network n: system.getNetworkList()){
               // System.out.println("netw name "+n);
            for (Enterprise e: n.getEnterpriseDirectory().getEnterpriseList())
            {//System.out.println("etr name "+e);
                 for(UserAccount d: e.getUserAccountDirectory().getUserAccountList()){
                 if(d.getUsername().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           }
                }
               
            for (Organization org : e.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof ResidentOrganization){
            for(UserAccount p :((ResidentOrganization)org).getUserAccountDirectory().getUserAccountList()){
          
             if(p.getUsername().equalsIgnoreCase(name))
           {
           exist = true;
           return exist;
           }
            }}
               
            else{     // System.out.println("org name "+org);
            for(UserAccount p :org.getUserAccountDirectory().getUserAccountList()){
           if(p.getUsername().equalsIgnoreCase(name))
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

    
    private void addVerifiers() {
       
        InputVerifier nameVerifier = new MyStringVerifier();
        nameJTextField.setInputVerifier(nameVerifier);
        passwordJTextField.setInputVerifier(nameVerifier);
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
   
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        if(organization.toString().equals(Type.ResidentOrganization.getValue())){
            ResidentOrganization residento = (ResidentOrganization)organization;
        for (Residents resident : residento.getResidentDirectory().getResidentList()){
           //  if(!organization.toString().equalsIgnoreCase("Admin Organization")){
            employeeJComboBox.addItem(resident);}
        }
    }
    
   

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
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

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(0, 0, 153));
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 80, 30));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 146, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        userJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userJTable.setForeground(new java.awt.Color(51, 51, 255));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(userJTable);
        if (userJTable.getColumnModel().getColumnCount() > 0) {
            userJTable.getColumnModel().getColumn(0).setResizable(false);
            userJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 460, 150));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, -1));

        passwordJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 146, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Residents");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 364, -1, 20));

        employeeJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        employeeJComboBox.setForeground(new java.awt.Color(51, 51, 255));
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeJComboBoxActionPerformed(evt);
            }
        });
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 146, 30));

        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(0, 0, 153));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 583, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Manage Resident User Accounts");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        try{
        if (checkBlankInput()){
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        if(checkIfExistsUA(userName)){
         JOptionPane.showMessageDialog(this, "Please enter a different username, this username is already in use", "Error", JOptionPane.ERROR_MESSAGE);
        return;}
        
        
        Organization organization = (ResidentOrganization)enterprise.getOrganizationDirectory().searchOrganization(Organization.Type.ResidentOrganization);
        Residents employee = (Residents) employeeJComboBox.getSelectedItem();
        Role role = new HouseholdResidentRole();
        
        organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        
        popData();
        JOptionPane.showMessageDialog(null, "Resident User Account is created successfully", "SUCCESS", JOptionPane.PLAIN_MESSAGE);
          clearFields();
      }
        else
        {
            JOptionPane.showMessageDialog(this, "Please enter all values", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_createUserJButtonActionPerformed
     private void clearFields()
        {
            nameJTextField.setText("");
            passwordJTextField.setText("");
            
        }
    private Boolean checkBlankInput()
    {
           if(nameJTextField.getText().length()==0
            ||passwordJTextField.getText().length()==0)
          
            {
                return false;
            }
        else{
            return true;
        }
    }
    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void employeeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
