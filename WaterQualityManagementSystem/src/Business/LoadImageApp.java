/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Gaurav Pc
 */
public class LoadImageApp extends JFrame {
           
//    BufferedImage img;
    
             
 private JLabel lbl;
    private ImageIcon image;
    
    public LoadImageApp(){
        image = new ImageIcon(getClass().getResource("water-background-2.jpg"));
        lbl = new JLabel(image);
        add(lbl);
    }
    public static void main(String args[]) {
        LoadImageApp app = new LoadImageApp();
        app.setTitle("Test Application");
        app.setVisible(true);
        app.pack();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    
    
    
//    public void paint(Graphics g) {
//        g.drawImage(img, 0, 0, null);
//    }
 
//    public LoadImageApp() {
//       try {
//           img = ImageIO.read(new File("water-background-2.jpg"));
//       } catch (IOException e) {
//       }
// 
//    }
// 
//    public Dimension getPreferredSize() {
//        if (img == null) {
//             return new Dimension(100,100);
//        } else {
//           return new Dimension(img.getWidth(null), img.getHeight(null));
//       }
//    }
 
//    public static void main(String[] args) {
// 
//        JFrame f = new JFrame("Load Image Sample");
//             
//        f.addWindowListener(new WindowAdapter(){
//                public void windowClosing(WindowEvent e) {
//                    System.exit(0);
//                }
//            });
// 
//        f.add(new LoadImageApp());
//        f.pack();
//        f.setVisible(true);
//    }
