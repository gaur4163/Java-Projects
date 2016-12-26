package userinterface.StoreRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.SmartMedicineDeliveryEnterprise;
import Business.Store.MedicineProduct;
import Business.Utils.MyIntegerVerifier;
import Business.Utils.MyStringVerifier;
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
public class CreateNewProductJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    SmartMedicineDeliveryEnterprise s;
    private BufferedImage image;
    
    public CreateNewProductJPanel(JPanel upc, Enterprise s){
        initComponents();
       try{ userProcessContainer = upc;
        this.s = (SmartMedicineDeliveryEnterprise)s;
        setImg();
        MyStringVerifier myStringVerifier= new MyStringVerifier();
        txtName.setInputVerifier(myStringVerifier);
        MyIntegerVerifier myIntegerVerifier = new MyIntegerVerifier();
        txtQuantity.setInputVerifier(myIntegerVerifier);
        txtPrice.setInputVerifier(myIntegerVerifier);
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
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("Create New Product");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 260, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Product ID:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 100, 30));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 51, 204));
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 271, 160, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Product Price:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 170, 30));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 51, 204));
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 160, 30));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(51, 0, 51));
        btnAdd.setText("Add Product");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, -1, 30));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Product Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 51, 204));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Product Quantity:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 140, 30));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(0, 51, 204));
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 160, 30));

        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Smart Health Care System");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
try{
        MedicineProduct p = s.getStore().getProductList().addProduct();
         String stringPrice = txtPrice.getText();
         if(stringPrice.isEmpty()==false&&txtName.getText().isEmpty()==false&&txtQuantity.getText().isEmpty()==false)
         {
        p.setProdName(txtName.getText());
        p.setAvailability(Integer.parseInt(txtQuantity.getText()));
       
     
       
            int price = Integer.parseInt(stringPrice);
          
            p.setPrice(price);
        JOptionPane.showMessageDialog(null, "Medicine Product added!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
         else {
         JOptionPane.showMessageDialog(null, "Product Cant be added please fill valid values", "Info", JOptionPane.INFORMATION_MESSAGE);
         }
            }
        catch(Exception x)
        { JOptionPane.showMessageDialog(this, "There is some problem please try again later");
        } 
}//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        StoreManagerWorkAreaJPanel manageProductCatalogJPanel = (StoreManagerWorkAreaJPanel) component;
        manageProductCatalogJPanel.refreshTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
