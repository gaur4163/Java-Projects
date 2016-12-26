/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentAdminRole;


import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PatientOrganization;
import Business.Person.Age;
import Business.Person.Person;
import Business.SeniorPerson.SeniorPerson;
import Business.USA_Smart_HealthCare;
import Business.Utils.MyPhoneNumberVerifier;
import Business.Utils.MyStringVerifier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ResidentManageElderPersonJPanel extends javax.swing.JPanel {

    private OrganizationDirectory organizationDir;
    private PatientOrganization seniorCitizens;
    private JPanel userProcessContainer;
    private  USA_Smart_HealthCare system;
    private Network network;
    private BufferedImage image;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ResidentManageElderPersonJPanel(JPanel userProcessContainer,OrganizationDirectory organizationDir,  USA_Smart_HealthCare system,Network network) {
        initComponents();
       try{
           this.network = network;
       
        this.userProcessContainer = userProcessContainer;
        this.organizationDir = organizationDir;
        this.system = system;
        this.seniorCitizens = (PatientOrganization) organizationDir.searchorg(Organization.Type.Patient);
        System.out.print("ghfd "+ seniorCitizens);
        populateTable();
        populateDoctorsComboBox();
        setImg();
        populateMonth();
        populateDate();
        
        populateYear();
       // populateOrganizationEmpComboBox();
        
        
        
 MyStringVerifier myStringVerifier= new MyStringVerifier();
        nameJTextField.setInputVerifier(myStringVerifier);
       MyPhoneNumberVerifier myPhoneNumberVerifier= new MyPhoneNumberVerifier();
       conNumberJTextField.setInputVerifier(myPhoneNumberVerifier);
       addressJTextField1.setInputVerifier(myStringVerifier);   }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
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
    
    public void populateDoctorsComboBox(){
        hospitalListjComboBox.removeAllItems();
        for (Network network:  system.getNetworkList()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList() ){
                
                    if(enterprise instanceof HospitalEnterprise)
                    {
                        
                             hospitalListjComboBox.addItem(enterprise);
                        
                    }
                
            }
        }
    }
    
//    public void populateOrganizationEmpComboBox(){
//        organizationEmpJComboBox.removeAllItems();
//        
//        for (Organization organization : organizationDir.getOrganizationList()){
//            organizationEmpJComboBox.addItem(organization);
//        }
//    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) seniorCitJTable.getModel();
        
        model.setRowCount(0);
        
        for (SeniorPerson employee : seniorCitizens.getPersonDir().getSerPersonList()){
                      
            Object[] row = new Object[6];
            row[0] = employee.getid();
            row[1] = employee.getName();
            row[2] = employee.getDateOfBirth();
            row[3] = employee.isStayAlone();
            row[4] = employee.getContactNumber();
            row[5] = employee.getCareTakers().size();
            
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
        seniorCitJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        stayAloneCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        hospitalListjComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        addressJTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailAddJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        conNumberJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dateCombo = new javax.swing.JComboBox();
        monthCombo = new javax.swing.JComboBox();
        yearCombo = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seniorCitJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seniorCitJTable.setForeground(new java.awt.Color(0, 51, 204));
        seniorCitJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date Of Birth", "Staying Alone", "Contact Number", "Care Takers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        seniorCitJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(seniorCitJTable);
        if (seniorCitJTable.getColumnModel().getColumnCount() > 0) {
            seniorCitJTable.getColumnModel().getColumn(0).setResizable(false);
            seniorCitJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 650, 140));

        addJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addJButton.setForeground(new java.awt.Color(51, 0, 51));
        addJButton.setText("Submit");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 126, 30));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(51, 0, 153));
        enterpriseLabel.setText("Senior Citizens in City :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 430, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Primary Hospital");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, -1));
        add(stayAloneCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Staying Alone");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        hospitalListjComboBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hospitalListjComboBox.setForeground(new java.awt.Color(0, 51, 204));
        hospitalListjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(hospitalListjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Address");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, 20));

        addressJTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addressJTextField1.setForeground(new java.awt.Color(0, 51, 204));
        add(addressJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 126, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Email Address");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));

        emailAddJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailAddJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(emailAddJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 170, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Contact Number");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, -1, -1));

        conNumberJTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        conNumberJTextField.setForeground(new java.awt.Color(0, 51, 204));
        add(conNumberJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Date Of Birth");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Smart Health Care System");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));

        dateCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(dateCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 40, -1));

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(monthCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 50, -1));

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(yearCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        try{
        String emailAddress = emailAddJTextField.getText();
        
        
        boolean stayAlone = (Boolean)stayAloneCheckBox1.isSelected();
        String address = addressJTextField1.getText();
         String contactNumber = conNumberJTextField.getText();
        String name = nameJTextField.getText();
        if(name.length()==0||address.length()==0||contactNumber.length()==0||hospitalListjComboBox.getSelectedItem() == null||emailAddress.length()==0)
        {JOptionPane.showMessageDialog(this, "Please fill all Inputs and select primary hospital");}
        else{
            HospitalEnterprise primaryDoctor = (HospitalEnterprise)hospitalListjComboBox.getSelectedItem();
          int date = (int) Integer.parseInt((String) dateCombo.getSelectedItem());
            String month = (String) monthCombo.getSelectedItem();
            int year  = (int) yearCombo.getSelectedItem();
        Age dateOfBirth = new Age(date,month,year);
       
        if(checkIfExists(name, system)){JOptionPane.showMessageDialog(this, "Person already created");}
        else{
        SeniorPerson p = seniorCitizens.getPersonDir().createPerson(name, dateOfBirth, emailAddress, contactNumber, primaryDoctor, stayAlone, address);
        p.setNetwork(network);
        JOptionPane.showMessageDialog(null, "Citizen Added", "Success", JOptionPane.PLAIN_MESSAGE);
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
    private javax.swing.JTextField addressJTextField1;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField conNumberJTextField;
    private javax.swing.JComboBox dateCombo;
    private javax.swing.JTextField emailAddJTextField;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox hospitalListjComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox monthCombo;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable seniorCitJTable;
    private javax.swing.JCheckBox stayAloneCheckBox1;
    private javax.swing.JComboBox yearCombo;
    // End of variables declaration//GEN-END:variables

 private void populateMonth() {
      monthCombo.removeAllItems();
            monthCombo.addItem("Jan");
            monthCombo.addItem("Feb");
            monthCombo.addItem("Mar");
            monthCombo.addItem("Apr");
            monthCombo.addItem("May");
            monthCombo.addItem("Jun");
            monthCombo.addItem("Jul");
            monthCombo.addItem("Aug");
            monthCombo.addItem("Sep");
            monthCombo.addItem("Oct");
            monthCombo.addItem("Nov");
            monthCombo.addItem("Dec");
           
            
        //To change body of generated methods, choose Tools | Templates.
    }
// 
// private void populateDate() {
//        dateCombo.removeAllItems();        
//             dateCombo.addItem("1");}

    private void populateDate() {
        dateCombo.removeAllItems();
         String mon = (String) monthCombo.getSelectedItem();
         System.out.println("-"+mon+"-");
         if (mon.equals("Jan") || mon.equals("Mar") || mon.equals("May") || mon.equals("Jul") || mon.equals("Aug") || mon.equals("Oct") || mon.equals("Dec")){
             dateCombo.addItem("1");
             dateCombo.addItem("2");
             dateCombo.addItem("3");
             dateCombo.addItem("4");
             dateCombo.addItem("5");
             dateCombo.addItem("6");
             dateCombo.addItem("7");
             dateCombo.addItem("8");
             dateCombo.addItem("9");
             dateCombo.addItem("10");
             dateCombo.addItem("11");
             dateCombo.addItem("12");
             dateCombo.addItem("13");
             dateCombo.addItem("14");
             dateCombo.addItem("15");
             dateCombo.addItem("16");
             dateCombo.addItem("17");
             dateCombo.addItem("18");
             dateCombo.addItem("19");
             dateCombo.addItem("20");
             dateCombo.addItem("21");
             dateCombo.addItem("22");
             dateCombo.addItem("23");
             dateCombo.addItem("24");
             dateCombo.addItem("25");
             dateCombo.addItem("26");
             dateCombo.addItem("27");
             dateCombo.addItem("28");
             dateCombo.addItem("29");
             dateCombo.addItem("30");
             dateCombo.addItem("31");
         }
             else if (mon.equals("Apr") || mon.equals("Jun") || mon.equals("Sep") || mon.equals("Nov")){
             dateCombo.addItem("1");
             dateCombo.addItem("2");
             dateCombo.addItem("3");
             dateCombo.addItem("4");
             dateCombo.addItem("5");
             dateCombo.addItem("6");
             dateCombo.addItem("7");
             dateCombo.addItem("8");
             dateCombo.addItem("9");
             dateCombo.addItem("10");
             dateCombo.addItem("11");
             dateCombo.addItem("12");
             dateCombo.addItem("13");
             dateCombo.addItem("14");
             dateCombo.addItem("15");
             dateCombo.addItem("16");
             dateCombo.addItem("17");
             dateCombo.addItem("18");
             dateCombo.addItem("19");
             dateCombo.addItem("20");
             dateCombo.addItem("21");
             dateCombo.addItem("22");
             dateCombo.addItem("23");
             dateCombo.addItem("24");
             dateCombo.addItem("25");
             dateCombo.addItem("26");
             dateCombo.addItem("27");
             dateCombo.addItem("28");
             dateCombo.addItem("29");
             dateCombo.addItem("30");
            
             }
             else {
             dateCombo.addItem("1");
             dateCombo.addItem("2");
             dateCombo.addItem("3");
             dateCombo.addItem("4");
             dateCombo.addItem("5");
             dateCombo.addItem("6");
             dateCombo.addItem("7");
             dateCombo.addItem("8");
             dateCombo.addItem("9");
             dateCombo.addItem("10");
             dateCombo.addItem("11");
             dateCombo.addItem("12");
             dateCombo.addItem("13");
             dateCombo.addItem("14");
             dateCombo.addItem("15");
             dateCombo.addItem("16");
             dateCombo.addItem("17");
             dateCombo.addItem("18");
             dateCombo.addItem("19");
             dateCombo.addItem("20");
             dateCombo.addItem("21");
             dateCombo.addItem("22");
             dateCombo.addItem("23");
             dateCombo.addItem("24");
             dateCombo.addItem("25");
             dateCombo.addItem("26");
             dateCombo.addItem("27");
             dateCombo.addItem("28");
             dateCombo.addItem("29");
             }
       
         //To change body of generated methods, choose Tools | Templates.
    }

    private void populateYear() {
        yearCombo.removeAllItems();
       
         int max=2015;
         for (int count=1900;count<max;count++  ){
             yearCombo.addItem(count);
         }
//To change body of generated methods, choose Tools | Templates.
    }


}
