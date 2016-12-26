/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Gaurav Pc
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelExample
{
    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame();

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBorder(
                    BorderFactory.createMatteBorder(
                                    5, 5, 5, 5, Color.WHITE));
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new BorderLayout(10, 10));

        ImagePanel imagePanel = new ImagePanel();
        //imagePanel.createGUI();
        BlankPanel blankPanel = new BlankPanel();

        contentPane.add(blankPanel, BorderLayout.LINE_START);
        contentPane.add(imagePanel, BorderLayout.CENTER);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    
}

class ImagePanel extends JPanel
{
    private BufferedImage image;

    public ImagePanel()
    {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        try
        {
            image = ImageIO.read(new File(getClass().getResource("/userinterface/water-background-2.jpg").toURI()));
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
}

class BlankPanel extends JPanel
{
    public BlankPanel()
    {
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        setBackground(Color.WHITE);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(100, 300));
    }
}