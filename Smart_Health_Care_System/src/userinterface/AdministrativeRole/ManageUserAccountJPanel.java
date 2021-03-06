/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;


import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.Utils.MyStringVerifier;
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
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private BufferedImage image;
    private USA_Smart_HealthCare sys;

    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise,USA_Smart_HealthCare sys) {
        initComponents();
       
        try{this.enterprise = enterprise;
        this.container = container;
        this.sys=sys;
        popOrganizationComboBox();
        setImg();
        popData();
        
        MyStringVerifier myStringVerifier= new MyStringVerifier();
        nameJTextField.setInputVerifier(myStringVerifier);
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
    
    
    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(!organization.toString().equalsIgnoreCase("Admin Organization")){
            organizationJComboBox.addItem(organization);
        }}
    }
    
    public void populateEmployeeComboBox(Organization organization){
        PersonJComboBox.removeAllItems();
        System.out.println(" emp combo box "+organization);
        System.out.println(" org emp count : "+organization.getPersonDirectory().getPersonList().size());
        for (Person employee : organization.getPersonDirectory().getPersonList()){
            PersonJComboBox.addItem(employee);
            System.out.println(" employee name"+ employee.getName());
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role);
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
        PersonJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        enterpriseLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(51, 0, 51));
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 100, 30));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 146, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        userJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userJTable.setForeground(new java.awt.Color(0, 51, 204));
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 375, 170));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));

        passwordJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 146, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        PersonJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonJComboBox.setForeground(new java.awt.Color(0, 51, 204));
        PersonJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(PersonJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 146, -1));

        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(0, 51, 204));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 146, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));

        roleJComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        roleJComboBox.setForeground(new java.awt.Color(0, 51, 204));
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 146, -1));

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseLabel1.setForeground(new java.awt.Color(51, 0, 153));
        enterpriseLabel1.setText("Manage UserAccount ");
        add(enterpriseLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 430, 30));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Smart Health Care System");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
       try{ String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Person employee = (Person) PersonJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();
        
        if(userName.length()==0||userName.length()==0||organization.equals("")||employee.equals("")||role.equals(""))
           { JOptionPane.showMessageDialog(this, "Please fill all Inputs");}
        else{
            
        if(checkIfExists(userName)){ JOptionPane.showMessageDialog(this, "Please fill a different User Name, Username already in use");}
        else{
        organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        JOptionPane.showMessageDialog(this, "User Created Successfully");
        }
        }
        popData();
         }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        }
    }//GEN-LAST:event_createUserJButtonActionPerformed

             public boolean checkIfExists(String name ){
             boolean exist=false;
                    //System.out.println(" count "+count);
                    if(sys.getNetworkList().size()!=0){ 
                    for(Network n: sys.getNetworkList()){
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
                        if(org instanceof PatientOrganization){
                    for(UserAccount p :((PatientOrganization)org).getUserAccountDirectory().getUserAccountList()){

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
    
    
    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox PersonJComboBox;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
