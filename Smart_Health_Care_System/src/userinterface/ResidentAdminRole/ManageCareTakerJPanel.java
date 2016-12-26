/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentAdminRole;


import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CareTakerOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PatientOrganization;
import Business.Person.Person;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.Utils.MyEmailAddressValidator;
import Business.Utils.MyPhoneNumberVerifier;
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
 * @author Apoorva
 */
public class ManageCareTakerJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private JPanel userProcessContainer;
    private CareTakerOrganization relatives;
    private Enterprise enterprise;
    private BufferedImage image;
    private USA_Smart_HealthCare sys;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageCareTakerJPanel(JPanel userProcessContainer,Enterprise enterprise,OrganizationDirectory organizationDir,USA_Smart_HealthCare sys) {
        initComponents();
       try{ this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.enterprise = enterprise;    
        this.sys=sys;
        setImg();
        this.relatives = (CareTakerOrganization) organizationDir.searchorg(Organization.Type.CareTaker);
        //System.out.print("ghfd "+ seniorCitizens);
        populateTable();
        populateSeniorCitiComboBox();
        
 MyStringVerifier myStringVerifier= new MyStringVerifier();
        nameJTextField.setInputVerifier(myStringVerifier);
       MyPhoneNumberVerifier myPhoneNumberVerifier= new MyPhoneNumberVerifier();
       conNumberJTextField.setInputVerifier(myPhoneNumberVerifier);
      
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
    

    private void populateTable(){
          DefaultTableModel model = (DefaultTableModel) relativeJTable.getModel();
        
        model.setRowCount(0);
        
        for (Person employee : relatives.getPersonDirectory().getPersonList()){
                      
            Object[] row = new Object[5];
            row[1] = employee.getid();
            row[2] = employee.getName();
            row[0] = employee.getDependent();
            row[3] = employee.getContactNumber();
            row[4] = employee.getEmailAddress();
            
            model.addRow(row);
        }
    }
    
     public boolean checkIfExists(String name,USA_Smart_HealthCare sys ){
     boolean exist=false;
            //System.out.println(" count "+count);
            if(sys.getNetworkList().size()!=0){ 
            for(Network n: sys.getNetworkList()){
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
                if(org instanceof PatientOrganization){
            for(Person p :((PatientOrganization)org).getPersonDir().getSerPersonList()){
           
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        relativeJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailAddJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        conNumberJTextField = new javax.swing.JTextField();
        seniorCitjComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        relativeJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        relativeJTable.setForeground(new java.awt.Color(0, 51, 204));
        relativeJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Senior Citizen", "ID", "Name", "Contact Number", "Email Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(relativeJTable);
        if (relativeJTable.getColumnModel().getColumnCount() > 0) {
            relativeJTable.getColumnModel().getColumn(1).setResizable(false);
            relativeJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 590, 170));

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addJButton.setText("Submit");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 126, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(51, 0, 153));
        enterpriseLabel.setText("Care Takers or Relatives of Senior Citizens :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 550, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Email Address");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));

        emailAddJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailAddJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(emailAddJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 126, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Senior Citizen Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, -1, 20));

        conNumberJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        conNumberJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(conNumberJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 399, 130, -1));

        seniorCitjComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seniorCitjComboBox1.setForeground(new java.awt.Color(0, 51, 204));
        seniorCitjComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(seniorCitjComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 130, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Contact Number");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, 20));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Smart Health Care System");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        try{
          MyEmailAddressValidator e = new MyEmailAddressValidator();
       // emailAddJTextField.setInputVerifier();
        
        String name = nameJTextField.getText();
        String emailAddress = emailAddJTextField.getText();
        String contactNumber = conNumberJTextField.getText();
        SeniorPerson dependent = (SeniorPerson)seniorCitjComboBox1.getSelectedItem();
        if(e.isValidEmailAddress(emailAddress)==false){
            JOptionPane.showMessageDialog(this, "Please fill Valid Email Address");
            return;
        }
        
        if(name.length()==0||emailAddress.length()==0||contactNumber.length()==0||dependent.equals("")){JOptionPane.showMessageDialog(this, "Please fill all Inputs and select a dependent");}
        else{
            if(checkIfExists(name, sys)){JOptionPane.showMessageDialog(this, "Person already created");}
            else{Person p = relatives.getPersonDirectory().createPerson(name);
        p.setContactNumber(contactNumber);
        p.setDependent(dependent);
        p.setEmailAddress(emailAddress);
        dependent.getCareTakers().add(p);
         JOptionPane.showMessageDialog(null, "Relatives or care takers Added", "Success", JOptionPane.PLAIN_MESSAGE);
         populateTable();
        }}
           }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField conNumberJTextField;
    private javax.swing.JTextField emailAddJTextField;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable relativeJTable;
    private javax.swing.JComboBox seniorCitjComboBox1;
    // End of variables declaration//GEN-END:variables

    private void populateSeniorCitiComboBox() {
        seniorCitjComboBox1.removeAllItems();
        PatientOrganization org = (PatientOrganization) organizationDir.searchorg(Organization.Type.Patient);
       
         
                        for (SeniorPerson p: org.getPersonDir().getSerPersonList())
                        {
                             seniorCitjComboBox1.addItem(p);
                        }
    }
}
