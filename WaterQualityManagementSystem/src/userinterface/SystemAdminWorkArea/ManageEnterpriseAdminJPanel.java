/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;

import Business.WaterQualityMonitoring;
import Business.Person.Person;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.ResidentOrganization;
import Business.Organization.ResidentOrganization;
import Business.Role.HouseholdCommunityAdminRole;
import Business.Role.MunicipalCorpAdminRole;
import Business.Role.ResearchOrgAdminRole;
import Business.UserAccount.UserAccount;
import Business.Validations.MyStringVerifier;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaurav
 */
public class ManageEnterpriseAdminJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private WaterQualityMonitoring system;
    private BufferedImage image;
    /**
     * Creates new form ManageEnterpriseJPanel
     */
    public ManageEnterpriseAdminJPanel(JPanel userProcessContainer, WaterQualityMonitoring system) {
        initComponents();
        this.setSize(650, 500);
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        setImg();
        populateTable();
        populateNetworkComboBox();
        addVerifiers();
    }
    
     private void addVerifiers() {
       MyStringVerifier myStringVerifier= new MyStringVerifier();
         nameJTextField.setInputVerifier(myStringVerifier);
         passwordJPasswordField.setInputVerifier(myStringVerifier);
         usernameJTextField.setInputVerifier(myStringVerifier);
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
    
    
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();
        System.out.println("populate tanle");
        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            System.out.println("network "+network);
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                System.out.println("entr"+enterprise);
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println("user Account"+ userAccount.getUsername());
                    Object[] row = new Object[3];
                    row[0] = enterprise.getName();
                    row[1] = network.getCityName();
                    row[2] = userAccount.getUsername();

                    model.addRow(row);
                }
            }
        }
    }

    private void populateNetworkComboBox(){
        networkJComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterpriseJComboBox.removeAllItems();
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            enterpriseJComboBox.addItem(enterprise);
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
        networkJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        networkJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        networkJComboBox.setForeground(new java.awt.Color(51, 51, 255));
        networkJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });
        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Username");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        usernameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernameJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 270, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Enterprise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        enterpriseJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enterpriseJComboBox.setForeground(new java.awt.Color(51, 51, 255));
        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 270, 30));

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submitJButton.setForeground(new java.awt.Color(0, 0, 153));
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 80, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Password");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(51, 51, 255));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 270, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, -1, -1));

        passwordJPasswordField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordJPasswordField.setForeground(new java.awt.Color(51, 51, 255));
        add(passwordJPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 270, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setText("Manage Enterprise Administrators");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 30));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

        enterpriseJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enterpriseJTable.setForeground(new java.awt.Color(51, 51, 255));
        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Network", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        enterpriseJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 600, 140));
    }// </editor-fold>//GEN-END:initComponents

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed

        Network network = (Network) networkJComboBox.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }
        
        
    }//GEN-LAST:event_networkJComboBoxActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        try{
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        String type = String.valueOf(enterprise.getEnterpriseType().getValue());
        String username = usernameJTextField.getText();
        String password = String.valueOf(passwordJPasswordField.getPassword());
        String name = nameJTextField.getText();
         if (username.length()==0 || password.length()==0 || name.length()==0 ){
             JOptionPane.showMessageDialog(this, "Please fill or select all the Fields","ERROR",JOptionPane.ERROR_MESSAGE);
             return;
        }
        if(checkIfExists(name)||checkIfExistsUA(username)){
        JOptionPane.showMessageDialog(this, "Person name or Username is already in use.","ERROR",JOptionPane.ERROR_MESSAGE);
        return;}
         
        Person employee = enterprise.getPersonDirectory().createPerson(name);
        UserAccount account=null;
        if (type.equals("Municipal Corporation")){
         account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new MunicipalCorpAdminRole());
        }
         else if (type.equals("Household Community")){
         account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new HouseholdCommunityAdminRole());
        } else if (type.equals("Research Organization")){
         account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new ResearchOrgAdminRole());
        }
        
        populateTable();
        JOptionPane.showMessageDialog(null, "User Account Created Successfully","SUCCESS",JOptionPane.PLAIN_MESSAGE);
        clearFields();
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
         
    }//GEN-LAST:event_submitJButtonActionPerformed
     
    private void clearFields()
        {
            nameJTextField.setText("");
            passwordJPasswordField.setText("");
            usernameJTextField.setText("");
        }
    
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
         Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
