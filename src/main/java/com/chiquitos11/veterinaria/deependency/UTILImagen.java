package com.chiquitos11.veterinaria.deependency;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UTILImagen extends JPanel {

    // atributos
    private URL rutaImagen;
    private Image imagenIMAGE;
    private ImageIcon imagenImageIcon;
    
    private ImageIcon imagenFlippeada;
    
    
    // constructor
    public UTILImagen(URL rutaImagen) {
        this.rutaImagen = rutaImagen;
        
        this.imagenImageIcon = new ImageIcon(rutaImagen);
        
        try {
            // Carga la imagen utilizando File
            this.imagenIMAGE = new ImageIcon(rutaImagen).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Image getImagenIMAGE() {
        return imagenIMAGE;
    }

    public ImageIcon getImagenImageIcon() {
        return imagenImageIcon;
    }
 

    // metodos

    /*
    *Con el Override sobreescribe el paintComponent con ayuda del 'this.setContentPane(img)'
    *en el JFrame
    **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen
        g.drawImage(imagenIMAGE, 0, 0, getWidth(), getHeight(), this);
    }
    
    public void imgToContainer(Component component) {
        
        
        JLabel nuevoLabel = null;
        if (component instanceof JLabel) {
            Icon icon = new ImageIcon(imagenImageIcon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_DEFAULT));

            nuevoLabel = (JLabel) component;
            nuevoLabel.setIcon(icon);
        }
        
                
    }
    
    public Icon getIconToContainer(Component jLabel) {
        Icon icon = new ImageIcon(imagenImageIcon.getImage().getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_DEFAULT));
        return icon;
    }

    
    public Icon imgToContainerInvert(Component imagen, boolean horizontal){
        int width = imagenIMAGE.getWidth(null);
        int height = imagenIMAGE.getHeight(null);
        BufferedImage imgFlipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = imgFlipped.createGraphics();
        if (horizontal) {
            g.drawImage(imagenIMAGE, width, 0, -width, height, null);
        } else {
            g.drawImage(imagenIMAGE, 0, 0, width, height, null);
        }
        g.dispose();
        this.imagenFlippeada = new ImageIcon(imgFlipped);
        
        Icon icon = new ImageIcon(imagenFlippeada.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        
        this.repaint();
        
        return icon;
    }
    
    public Icon cambiarOpacidad(float opacidad, Component actual) {
        Image image = null; // Variable para almacenar la imagen
        
        if (actual instanceof AbstractButton) {
            Icon icon = ((AbstractButton) actual).getIcon();
            if (icon instanceof ImageIcon) {
                image = ((ImageIcon) icon).getImage();
            }
        } else if (actual instanceof JLabel) {
            Icon icon = ((JLabel) actual).getIcon();
            if (icon instanceof ImageIcon) {
                image = ((ImageIcon) icon).getImage();
            }
        } else if (actual instanceof JMenuItem) {
            Icon icon = ((JMenuItem) actual).getIcon();
            if (icon instanceof ImageIcon) {
                image = ((ImageIcon) icon).getImage();
            }
        }
        
        int ancho = image.getWidth(null);
        int alto = image.getHeight(null);
        BufferedImage imagenBuffer = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = (Graphics2D) imagenBuffer.getGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
         
        Icon nuevaImg = new ImageIcon(imagenBuffer);
        
        return nuevaImg;
    }

}