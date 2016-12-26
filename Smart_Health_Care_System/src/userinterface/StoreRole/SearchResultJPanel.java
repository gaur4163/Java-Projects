package userinterface.StoreRole;



import Business.Store.MedicineProduct;
import static com.db4o.qlin.QLinSupport.p;
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

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class SearchResultJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private MedicineProduct product;
       public BufferedImage image;
    
    public SearchResultJPanel(JPanel upc, MedicineProduct p)
 
    {
        initComponents();
      try{  userProcessContainer = upc;
        product = p;
        txtName.setText(p.getProdName());
        txtId.setText(String.valueOf(p.getModelNumber()));
        txtPrice.setText(String.valueOf(p.getPrice()));
        txtPavail.setText(String.valueOf(p.getAvailability()));
       setImg();     }
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
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPavail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 153));
        jLabel1.setText("View Product Detail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Product Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, 30));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 51, 204));
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 249, 230, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Product Price:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, 30));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 51, 204));
        txtPrice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 230, 30));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(51, 0, 51));
        btnUpdate.setText("Update Product");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 140, 30));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, -1, -1));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 51, 204));
        txtId.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 289, 230, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Product ID:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(51, 0, 51));
        btnSave.setText("SAVE");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 70, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Product Availablity:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 170, 30));

        txtPavail.setEditable(false);
        txtPavail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPavail.setForeground(new java.awt.Color(0, 51, 204));
        add(txtPavail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 230, 30));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Smart Health Care System");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        //txtId.setEditable(true);
        txtName.setEditable(true);
        txtPrice.setEditable(true);
        btnSave.setEnabled(true);
        txtPavail.setEditable(true);
             
                btnUpdate.setEnabled(false);
}//GEN-LAST:event_btnUpdateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        backAction();
    }//GEN-LAST:event_btnBackActionPerformed

      private void backAction() {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        product.setPrice(Integer.parseInt(txtPrice.getText()));
        product.setProdName(txtName.getText());
        product.setAvailability(Integer.parseInt(txtPavail.getText()));
       
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
    }//GEN-LAST:event_btnSaveActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPavail;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
