package userinterface.StoreRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.SmartMedicineDeliveryEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Store.MedicineProduct;
import Business.USA_Smart_HealthCare;
import Business.UserAccount.UserAccount;
import Business.Utils.MyIntegerVerifier;
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
public class StoreManagerWorkAreaJPanel extends javax.swing.JPanel {

        private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private SmartMedicineDeliveryEnterprise enterprise;
    private USA_Smart_HealthCare business;
    private Network network;
    private UserAccount serAccount;
   private BufferedImage image;
    /**
     * Creates new form PatientWorkArea
     */
    public StoreManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, USA_Smart_HealthCare business,
            Network network) {
        initComponents();
       try{ this.userProcessContainer= userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise= (SmartMedicineDeliveryEnterprise)enterprise;
        this.business= business;
        this.network = network;
        refreshTable();
        setImg();
        MyIntegerVerifier ms = new MyIntegerVerifier();
        serchjTextField1.setInputVerifier(ms);   }
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
    
     public void refreshTable() {
        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel)productCatalog.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(MedicineProduct p : enterprise.getStore().getProductList().getProductcatalog()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getPrice();
            row[3] = p.getAvailability();
            
            model.addRow(row);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalog = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        serchjTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setForeground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Manage Product Catalog");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        productCatalog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        productCatalog.setForeground(new java.awt.Color(0, 51, 204));
        productCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product ID", "Price", "Availability"
            }
        ));
        productCatalog.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(productCatalog);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 630, 120));

        btnView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnView.setForeground(new java.awt.Color(51, 0, 51));
        btnView.setText("View Product Detail >>");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 220, 30));

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(51, 0, 51));
        btnCreate.setText("Create New Product >>");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 450, -1, 30));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(51, 0, 51));
        btnSearch.setText("Search >>");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 130, 30));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 90, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(51, 0, 51));
        btnDelete.setText("Delete Product(s)");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 190, 30));

        serchjTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        serchjTextField1.setForeground(new java.awt.Color(0, 51, 204));
        serchjTextField1.setText("0");
        serchjTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serchjTextField1ActionPerformed(evt);
            }
        });
        add(serchjTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 150, 30));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Smart Health Care System");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
try{
        int row = productCatalog.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
       return; }
        MedicineProduct p = (MedicineProduct)productCatalog.getValueAt(row, 0);
        SearchResultJPanel vpdjp = new SearchResultJPanel(userProcessContainer, p);
        userProcessContainer.add("SearchResultJPanel", vpdjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
           }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
       
        CreateNewProductJPanel cnpjp = new CreateNewProductJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("CreateNewProductJPanel", cnpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
       try{
        MedicineProduct p;
        int productId = Integer.parseInt(serchjTextField1.getText());
        p = enterprise.getStore().getProductList().searchProduct(productId);
        if(p!=null){
        SearchResultJPanel cvpdjp = new SearchResultJPanel(userProcessContainer, p);
        userProcessContainer.add("SearchResultJPanel", cvpdjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Nothing found", "No result found matching your criteria!!", JOptionPane.WARNING_MESSAGE);
            //return;
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Nothing found", "No result found matching your criteria!!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
try{
        int row = productCatalog.getSelectedRow();
        
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MedicineProduct s = (MedicineProduct)productCatalog.getValueAt(row, 0);
         enterprise.getStore().getProductList().getProductcatalog().remove(s);
        refreshTable();
           }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void serchjTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serchjTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serchjTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productCatalog;
    private javax.swing.JTextField serchjTextField1;
    // End of variables declaration//GEN-END:variables
}
