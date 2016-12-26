/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ResidentRole;


import Business.Network.Network;
import Business.Person.Residents;
import Business.Person.VitalSign;
import Business.Validations.MyStringVerifier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;



/**
 *
 * @author Gaurav
 */
public class ManageVitalSignsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VitalSignManagerJJPanel
     */
    private Residents resident;
    private JPanel userProcessContainer;
    private BufferedImage image;
    private Network ntw;
    
    public ManageVitalSignsJPanel(JPanel userProcessContainer, Residents resident,Network ntw) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.resident= resident;
        InputVerifier stringVerifier = new MyStringVerifier();
        this.ntw = ntw;
                
        setImg(); 
          populateVitalSignTable();
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

    public void populateVitalSignTable() {

        DefaultTableModel model = (DefaultTableModel) viewVitalSignsJTable.getModel();
        model.setRowCount(0);
        if (resident != null) {
            
            int age = resident.getAge();
      
            ArrayList<VitalSign> vitalSignList = resident.getVitalSignHistory().getHistory();

            if (vitalSignList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No vital signs found. Please add vital signs", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            for (VitalSign vitalSign : vitalSignList) {
                Object[] row = new Object[6];
                row[0] = vitalSign;
                row[1]= vitalSign.getBloodPressure();
                row[2]=vitalSign.getHeartRate();
                row[3]=vitalSign.getRespiratoryRate();
                row[4]=vitalSign.getWeight();
                row[5] = vitalSign.getStatus();
                model.addRow(row);
            }
        }
    }

//    private String VitalSignStatus(int patientAge, VitalSign vitalSign) {
//        String vitalSignStatus = "Normal";
//
//        int respirationRate = vitalSign.getRespiratoryRate();
//        int heartRate = vitalSign.getHeartRate();
//        int bloodPressure = vitalSign.getBloodPressure();
//        float weight = vitalSign.getWeight();
//
//        /*Toddler*/
//        if (patientAge >= 1 && patientAge <= 3) {
//            if ((respirationRate < 20 || respirationRate > 30) /*Respiration Rate*/
//                    || (heartRate < 80 || heartRate > 130) /*Heart Rate*/
//                    || (bloodPressure < 80 || bloodPressure > 110) /*Blood Pressure*/
//                    || (weight < 22 || weight > 31)) /*Weight*/ {
//                vitalSignStatus = "Abnormal";
//            }
//        }
//        /*Preschooler*/
//        if (patientAge >= 4 && patientAge <= 5) {
//            if ((respirationRate < 20 || respirationRate > 30)
//                    || (heartRate < 80 || heartRate > 120)
//                    || (bloodPressure < 80 || bloodPressure > 110)
//                    || (weight < 31 || weight > 40)) {
//                vitalSignStatus = "Abnormal";
//            }
//        }
//        /*School Age*/
//        if (patientAge >= 6 && patientAge <= 12) {
//            if ((respirationRate < 20 || respirationRate > 30)
//                    || (heartRate < 70 || heartRate > 110)
//                    || (bloodPressure < 80 || bloodPressure > 120)
//                    || (weight < 41 || weight > 92)) {
//                vitalSignStatus = "Abnormal";
//            }
//        }
//        /*Adolescent*/
//        if (patientAge >= 13) {
//            if ((respirationRate < 12 || respirationRate > 20)
//                    || (heartRate < 55 || heartRate > 105)
//                    || (bloodPressure < 110 || bloodPressure > 120)
//                    || (weight < 110)) {
//                vitalSignStatus = "Abnormal";
//            }
//        }
//        return vitalSignStatus;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editVitalSignsJButton = new javax.swing.JButton();
        addVitalSignsJButton = new javax.swing.JButton();
        deleteVitalSignJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewVitalSignsJTable = new javax.swing.JTable();
        viewVitalSignJButton = new javax.swing.JButton();
        refreshVitalSignsJButton = new javax.swing.JButton();
        showChartJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editVitalSignsJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editVitalSignsJButton.setForeground(new java.awt.Color(0, 0, 153));
        editVitalSignsJButton.setText("Edit Vital Signs");
        editVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVitalSignsJButtonActionPerformed(evt);
            }
        });
        add(editVitalSignsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 130, -1));

        addVitalSignsJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addVitalSignsJButton.setForeground(new java.awt.Color(0, 0, 153));
        addVitalSignsJButton.setText("Add Vital Sign");
        addVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVitalSignsJButtonActionPerformed(evt);
            }
        });
        add(addVitalSignsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, -1));

        deleteVitalSignJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteVitalSignJButton.setForeground(new java.awt.Color(0, 0, 153));
        deleteVitalSignJButton.setText("Delete Vital Sign");
        deleteVitalSignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVitalSignJButtonActionPerformed(evt);
            }
        });
        add(deleteVitalSignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 103, -1));

        viewVitalSignsJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewVitalSignsJTable.setForeground(new java.awt.Color(51, 51, 255));
        viewVitalSignsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Timestamp", "Blood Pressure", "Heart Rate", "Respiratory rate", "Weight", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewVitalSignsJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(viewVitalSignsJTable);
        if (viewVitalSignsJTable.getColumnModel().getColumnCount() > 0) {
            viewVitalSignsJTable.getColumnModel().getColumn(0).setResizable(false);
            viewVitalSignsJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 740, 170));

        viewVitalSignJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewVitalSignJButton.setForeground(new java.awt.Color(0, 0, 153));
        viewVitalSignJButton.setText("View Vital Signs");
        viewVitalSignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewVitalSignJButtonActionPerformed(evt);
            }
        });
        add(viewVitalSignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 130, -1));

        refreshVitalSignsJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshVitalSignsJButton.setForeground(new java.awt.Color(0, 0, 153));
        refreshVitalSignsJButton.setText("Refresh Vital Sign");
        refreshVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshVitalSignsJButtonActionPerformed(evt);
            }
        });
        add(refreshVitalSignsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 190, 150, -1));

        showChartJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showChartJButton.setForeground(new java.awt.Color(0, 0, 153));
        showChartJButton.setText("Show Chart");
        showChartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChartJButtonActionPerformed(evt);
            }
        });
        add(showChartJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("Manage Vital Signs");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewVitalSignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVitalSignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = viewVitalSignsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        VitalSign vitalSign = (VitalSign) viewVitalSignsJTable.getValueAt(selectedRow, 0);
        ViewUpdateVitalSignsJPanel vuvsJPanel = new ViewUpdateVitalSignsJPanel(userProcessContainer, vitalSign, Boolean.FALSE);
        userProcessContainer.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewVitalSignJButtonActionPerformed

    private void editVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = viewVitalSignsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        VitalSign vitalSign = (VitalSign) viewVitalSignsJTable.getValueAt(selectedRow, 0);

        ViewUpdateVitalSignsJPanel vuvsJPanel = new ViewUpdateVitalSignsJPanel(userProcessContainer, vitalSign, Boolean.TRUE);
        userProcessContainer.add("vuvsJPanel", vuvsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_editVitalSignsJButtonActionPerformed

    private void addVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
      try{
        if(resident!=null)
        {
            CreateVitalSignJPanel cvsJPanel = new CreateVitalSignJPanel(userProcessContainer, resident, ntw);
            userProcessContainer.add("cvsJPanel", cvsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Resident not created.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_addVitalSignsJButtonActionPerformed

    private void deleteVitalSignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVitalSignJButtonActionPerformed
        // TODO add your handling code here:
        try{
        if(resident==null)
        {
            JOptionPane.showMessageDialog(this, "Resident not present", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int selectedRow = viewVitalSignsJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        VitalSign vitalSign = (VitalSign) viewVitalSignsJTable.getValueAt(selectedRow, 0);

        int flag= JOptionPane.showConfirmDialog(this, "Are you sure want to remove?","Warning", JOptionPane.YES_NO_OPTION);
        if(flag==0)
        {
            resident.getVitalSignHistory().deleteVitalSign(vitalSign);
            refreshVialSigns();
        }
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_deleteVitalSignJButtonActionPerformed

    private void refreshVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        refreshVialSigns();
    }//GEN-LAST:event_refreshVitalSignsJButtonActionPerformed

    private void showChartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showChartJButtonActionPerformed
        // TODO add your handling code here:
     
        createChart();
    }//GEN-LAST:event_showChartJButtonActionPerformed
    private void refreshVialSigns() {
       
//            if(resident!=null)
//            {
//                populateVitalSignTable();
//            }
//            else
//            {
//                populateVitalSignTable(null);
//            }
       populateVitalSignTable();
    }

    private void createChart()
    {
        try{
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
       
        if(resident==null)
        {
            JOptionPane.showMessageDialog(this, "resident not present, Please create resident first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println(resident);
         System.out.println(resident.getVitalSignHistory());
          System.out.println(resident.getVitalSignHistory().getHistory());
        
        ArrayList<VitalSign> vitalSignList = resident.getVitalSignHistory().getHistory();
        /*At least 2 vital sign records needed to show chart */
        if (vitalSignList.isEmpty() || vitalSignList.size() == 1) {
            JOptionPane.showMessageDialog(this, "No vital signs or only one vital sign found. At least 2 vital sign records needed to show chart!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (VitalSign vitalSign : vitalSignList) {
            vitalSignDataset.addValue(vitalSign.getRespiratoryRate(),"RR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getHeartRate(),"HR", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getBloodPressure(),"BP", vitalSign.getTimestamp());
            vitalSignDataset.addValue(vitalSign.getWeight(),"WT", vitalSign.getTimestamp());
        }
        
        JFreeChart vitalSignChart= ChartFactory.createBarChart3D("Vital Sign Chart", "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        vitalSignChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = vitalSignChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
        vitalSignDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartFrame chartFrame = new ChartFrame("Chart", vitalSignChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(600, 520);
            }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVitalSignsJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteVitalSignJButton;
    private javax.swing.JButton editVitalSignsJButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshVitalSignsJButton;
    private javax.swing.JButton showChartJButton;
    private javax.swing.JButton viewVitalSignJButton;
    private javax.swing.JTable viewVitalSignsJTable;
    // End of variables declaration//GEN-END:variables
}
