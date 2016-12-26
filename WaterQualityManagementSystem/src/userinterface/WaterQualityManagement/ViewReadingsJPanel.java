/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.WaterQualityManagement;


import Business.Enterprise.Enterprise;
import Business.Enterprise.HouseholdCommunityEnterprise;
import Business.Measurements.WaterQualityMeasurement;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ResidentOrganization;
import Business.Organization.SurveyorOrganization;
import Business.Person.Residents;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SurveyorVisitWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
public class ViewReadingsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VitalSignManagerJJPanel
     */
    private Residents resident;
    private JPanel userProcessContainer;
    private Network ntwk;
    private UserAccount account;
    private BufferedImage image;
    public ViewReadingsJPanel(JPanel userProcessContainer, Network ntwk,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.resident= resident;
        this.ntwk=ntwk;
        this.account=account;
       
        popCombo();
        setImg();
      
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
    
    
      public void popCombo(){
       jComboBox1.removeAllItems();
   
    for(Enterprise etr: ntwk.getEnterpriseDirectory().getEnterpriseList()){
               if(etr instanceof HouseholdCommunityEnterprise)
               {
               for(Organization org: etr.getOrganizationDirectory().getOrganizationList()){
                   if( org instanceof ResidentOrganization){
                   for(Residents d:((ResidentOrganization)org).getResidentDirectory().getResidentList() ){
                   jComboBox1.addItem(d);
                   
                         }
                      }
                   }
               }
            }
       }
   
    public UserAccount searchUserAccountDirectory(Residents residentAcc){
        UserAccount userAcc = null;
        for(Enterprise etr: ntwk.getEnterpriseDirectory().getEnterpriseList()){
               if(etr instanceof HouseholdCommunityEnterprise)
               {
               for(Organization org: etr.getOrganizationDirectory().getOrganizationList()){
                   if( org instanceof ResidentOrganization){
                      userAcc= residentAcc.searchAccount(residentAcc, ((ResidentOrganization)org).getUserAccountDirectory());
                       
                      }
                   }
               }
            }
        return userAcc;
    }
    public void populateWaterQualityTable() {

        DefaultTableModel model = (DefaultTableModel) viewWaterQualityFactorJTable.getModel();
        model.setRowCount(0);
       
        Residents residentAcc = (Residents)jComboBox1.getSelectedItem();
            System.out.println(residentAcc.getFamily().getMeasurementList());
            
            ArrayList<WaterQualityMeasurement> measure = residentAcc.getFamily().getMeasurementList().getHistory();
//                if (measure.isEmpty()) {
//                    JOptionPane.showMessageDialog(this, "No Readings found. ", "Error", JOptionPane.INFORMATION_MESSAGE);
//                    return;
//                          }
             for (WaterQualityMeasurement waterQuality : measure) {
                Object[] row = new Object[9];
                row[0] =waterQuality;
                row[1]= waterQuality.getpHvalue();
                row[2]=waterQuality.getSalinity();
                row[3]=waterQuality.getIonNitrates();
                row[4]=waterQuality.getIonLead();
                row[5] = waterQuality.getIonBromide();
                row[6] = waterQuality.getIonFluoride();
                row[7] = waterQuality.getIonMercury();
                row[8] = waterQuality.getDissolvedOxygen();
                
                model.addRow(row);
                         }
                      }
                     
        
         
    
    
     public void populateWaterQualityStatusTable(WaterQualityMeasurement measure) {

        DefaultTableModel model = (DefaultTableModel) waterQualityStatusTable.getModel();
        model.setRowCount(0);
            if(measure==null)
        {
            JOptionPane.showMessageDialog(this, "Reading is not present. Hence Status can't be shown", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                 Residents residentAcc = (Residents)jComboBox1.getSelectedItem();
               
                Object[] row = new Object[2];
                row[0] =measure;
                row[1]=measure.getStatus();
              
                model.addRow(row);
               
             }
                      
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewStatus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        waterQualityStatusTable = new javax.swing.JTable();
        refreshVitalSignsJButton = new javax.swing.JButton();
        showChartJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        viewWaterQualityFactorJTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewStatus.setForeground(new java.awt.Color(0, 0, 153));
        viewStatus.setText("View Status");
        viewStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusActionPerformed(evt);
            }
        });
        add(viewStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 119, -1));

        waterQualityStatusTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        waterQualityStatusTable.setForeground(new java.awt.Color(51, 51, 255));
        waterQualityStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Measure Timestamp", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        waterQualityStatusTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(waterQualityStatusTable);
        if (waterQualityStatusTable.getColumnModel().getColumnCount() > 0) {
            waterQualityStatusTable.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 530, 140));

        refreshVitalSignsJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshVitalSignsJButton.setForeground(new java.awt.Color(0, 0, 153));
        refreshVitalSignsJButton.setText("Refresh Readings");
        refreshVitalSignsJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshVitalSignsJButtonActionPerformed(evt);
            }
        });
        add(refreshVitalSignsJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 140, -1));

        showChartJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        showChartJButton.setForeground(new java.awt.Color(0, 0, 153));
        showChartJButton.setText("Show Chart");
        showChartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showChartJButtonActionPerformed(evt);
            }
        });
        add(showChartJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 102));
        jLabel4.setText("View Water Quality Readings");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        viewWaterQualityFactorJTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        viewWaterQualityFactorJTable.setForeground(new java.awt.Color(51, 51, 255));
        viewWaterQualityFactorJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Timestamp", "pHValue", "Salinity", "IonNitrate", "IonLead", "IonBromide", "IonFluoride", "IonMercury", "Dissolved Oxygen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewWaterQualityFactorJTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(viewWaterQualityFactorJTable);
        if (viewWaterQualityFactorJTable.getColumnModel().getColumnCount() > 0) {
            viewWaterQualityFactorJTable.getColumnModel().getColumn(0).setResizable(false);
            viewWaterQualityFactorJTable.getColumnModel().getColumn(1).setResizable(false);
            viewWaterQualityFactorJTable.getColumnModel().getColumn(3).setHeaderValue("Resident Account");
            viewWaterQualityFactorJTable.getColumnModel().getColumn(4).setHeaderValue("IonLead");
            viewWaterQualityFactorJTable.getColumnModel().getColumn(5).setHeaderValue("IonBromide");
            viewWaterQualityFactorJTable.getColumnModel().getColumn(6).setHeaderValue("IonFluoride");
            viewWaterQualityFactorJTable.getColumnModel().getColumn(7).setResizable(false);
            viewWaterQualityFactorJTable.getColumnModel().getColumn(7).setHeaderValue("IonMercury");
            viewWaterQualityFactorJTable.getColumnModel().getColumn(8).setHeaderValue("Dissolved Oxygen");
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 820, 140));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 102));
        jLabel9.setText("Resident Account");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, 20));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 110, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("View Water Quality Readings");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WATER QUALITY  MANAGEMENT SYSTEM ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 90));

        backJButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backJButton.setForeground(new java.awt.Color(0, 0, 153));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 103, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void viewStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatusActionPerformed
        // TODO add your handling code here:
      try{
          int selectedRow = viewWaterQualityFactorJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        WaterQualityMeasurement measure1 = (WaterQualityMeasurement) viewWaterQualityFactorJTable.getValueAt(selectedRow, 0);
        populateWaterQualityStatusTable(measure1);
        }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        }
    }//GEN-LAST:event_viewStatusActionPerformed

    private void refreshVitalSignsJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshVitalSignsJButtonActionPerformed
        // TODO add your handling code here:
        refreshWaterQualityTable();
    }//GEN-LAST:event_refreshVitalSignsJButtonActionPerformed

    private void showChartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showChartJButtonActionPerformed
        // TODO add your handling code here:
     
        createChart();
    }//GEN-LAST:event_showChartJButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Residents residents = (Residents) jComboBox1.getSelectedItem();
        if (residents != null){
           populateWaterQualityTable();
           refreshWaterQualityStatusTable();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed
    private void refreshWaterQualityStatusTable() {
      
     DefaultTableModel model = (DefaultTableModel) waterQualityStatusTable.getModel();
        model.setRowCount(0);
    }
    
    private void refreshWaterQualityTable() {
      
       populateWaterQualityTable();
       refreshWaterQualityStatusTable();
    }

    private void createChart()
    {
        try{
        DefaultCategoryDataset vitalSignDataset=new DefaultCategoryDataset();
        ArrayList<WaterQualityMeasurement> measure1= null;
         for(Enterprise etr: ntwk.getEnterpriseDirectory().getEnterpriseList()){
               if(etr instanceof HouseholdCommunityEnterprise)
               {
               for(Organization org: etr.getOrganizationDirectory().getOrganizationList()){
                   if( org instanceof ResidentOrganization){
                   for(Residents d:((ResidentOrganization)org).getResidentDirectory().getResidentList() ){
                       if (d instanceof Residents )
                           measure1= d.getFamily().getMeasurementList().getHistory();
                       if (measure1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No Readings found. ", "Error", JOptionPane.INFORMATION_MESSAGE);
                    return;
                          }
                   }
                   }
               }
               }
               
         }
        
        /*At least 2 vital sign records needed to show chart */
        if (measure1.isEmpty() || measure1.size() == 1) {
            JOptionPane.showMessageDialog(this, "No readings or only one reading found. At least 2 readings needed to show chart!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
//       
            
            
        for (WaterQualityMeasurement wqMeasure : measure1) {
            vitalSignDataset.addValue(wqMeasure.getpHvalue(),"pH", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getSalinity(),"SA", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getIonNitrates(),"IN", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getIonLead(),"IL", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getIonBromide(),"IB", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getIonFluoride(),"IF", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getIonMercury(),"IM", wqMeasure.getTimestampOfMeasure());
            vitalSignDataset.addValue(wqMeasure.getDissolvedOxygen(),"DO", wqMeasure.getTimestampOfMeasure());
        }
        
        JFreeChart readingsChart= ChartFactory.createBarChart3D("Water Quality Chart", "Time Stamp", "Rate", vitalSignDataset, PlotOrientation.VERTICAL, true, false, false);
        readingsChart.setBackgroundPaint(Color.white);
        CategoryPlot vitalSignChartPlot = readingsChart.getCategoryPlot();
        vitalSignChartPlot.setBackgroundPaint(Color.lightGray);    
        
        CategoryAxis vitalSignDomainAxis = vitalSignChartPlot.getDomainAxis();
        vitalSignDomainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        
        NumberAxis vitalSignRangeAxis = (NumberAxis) vitalSignChartPlot.getRangeAxis();
        vitalSignRangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        ChartFrame chartFrame = new ChartFrame("Chart", readingsChart);
        chartFrame.setVisible(true);
        chartFrame.setSize(600, 520);
               }catch (Exception e){
                 JOptionPane.showMessageDialog(this, "No Data Found","ERROR",JOptionPane.ERROR_MESSAGE);
                 return; 
        } 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refreshVitalSignsJButton;
    private javax.swing.JButton showChartJButton;
    private javax.swing.JButton viewStatus;
    private javax.swing.JTable viewWaterQualityFactorJTable;
    private javax.swing.JTable waterQualityStatusTable;
    // End of variables declaration//GEN-END:variables
}
