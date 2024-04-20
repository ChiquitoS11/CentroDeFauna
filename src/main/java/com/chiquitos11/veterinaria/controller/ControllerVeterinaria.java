/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.deependency.UTILImagen;
import com.chiquitos11.veterinaria.deependency.UTILPersonaje;
import com.chiquitos11.veterinaria.view.Administracion;
import com.chiquitos11.veterinaria.view.Veterinaria;
import com.sun.tools.javac.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerVeterinaria {

    private Veterinaria v;
    private UTILPersonaje p;
    boolean animacionEnd = false;
    UTILImagen upP = new UTILImagen(Main.class.getClassLoader().getResource("up.gif"));
    UTILImagen downP = new UTILImagen(Main.class.getClassLoader().getResource("down.gif"));
    UTILImagen leftP = new UTILImagen(Main.class.getClassLoader().getResource("left.gif"));
    UTILImagen rightP = new UTILImagen(Main.class.getClassLoader().getResource("right.gif"));
    UTILImagen staticP = new UTILImagen(Main.class.getClassLoader().getResource("static.png"));
    final KeyListener pKeyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            moverPersonaje(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            estaticoPersonaje(e);
        }
    };

    final KeyListener pInteraccion = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (p.isInteractuable() ) {
                interactuarConPersonaje(e);
            }
        }
    };

    public ControllerVeterinaria(Veterinaria v) {
        this.v = v;
        this.p = new UTILPersonaje(v, v.personajeLABEL);

        v.addKeyListener(pKeyListener);
        v.addKeyListener(pInteraccion);

        
        p.addLimites(v.jPanel1);
        p.addLimites(v.jPanel2);
        
        
        p.addInteracciones(v.enfermera1);
        p.addInteracciones(v.enfermera2);
        p.addInteracciones(v.enfermera3);
        p.addInteracciones(v.enfermeraJoy);
    }


    private void interactuarConPersonaje(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_X) {
            
            switch (p.getNameInteraccion()) {
                case "enfermera1":
                    
                    System.out.println("enfermera 1");
                    JOptionPane.showMessageDialog(null, "Lets get hight uwu");
                    break;
                    
                case "enfermera2":
                    
                    System.out.println("enfermera 2");
                    JOptionPane.showMessageDialog(null, "Rodri es maricon");
                    break;
                    
                case "enfermera3":
                    System.out.println("enfermera 3");
                    JOptionPane.showMessageDialog(null, "Rodri es maricon");
                    break;
                
                case "enfermeraJoy":
                    
                    Administracion ad = new Administracion();
                    ad.setVisible(true);
                    ad.setResizable(false);
                    ad.setLocationRelativeTo(null);
//                    v.setEnabled(false);
                    ad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    
                    break;
                default:
                    System.out.println("no hay logica de JLabel (zona interactuable) para esta zona");
                    break;
            }
        }
    }

    /**
     * Logica de movimiento del personaje
     *
     * @param e
     */
    public void moverPersonaje(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p.movimiento(1);
            if (animacionEnd == false) {
                sprayMovimiento(1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p.movimiento(2);
            if (animacionEnd == false) {
                sprayMovimiento(2);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p.movimiento(3);
            if (animacionEnd == false) {
                sprayMovimiento(3);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p.movimiento(4);
            if (animacionEnd == false) {
                sprayMovimiento(4);
            }
        }
    }
    /**
     * Este metodo esta encargado ed realizar los sprays del personaje,
     * recordemos que el 'personaje' es un JLabel al que se le va cambiando el
     * setIcon este metodo es único y no esta permitido editarlo.
     */

    private void sprayMovimiento(int direccion) {
        switch (direccion) {
            case 1:
                Timer timer1 = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Acciones a realizar después de 1 segundo
                        v.personajeLABEL.setIcon(upP.getIconToContainer(v.personajeLABEL));
                        animacionEnd = true;
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer1.start();
                break;
            case 2:
                Timer timer2 = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        v.personajeLABEL.setIcon(downP.getIconToContainer(v.personajeLABEL));
                        animacionEnd = true;
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer2.start();
                break;
            case 3:
                Timer timer3 = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        v.personajeLABEL.setIcon(leftP.getIconToContainer(v.personajeLABEL));
                        animacionEnd = true;
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer3.start();
                break;
            case 4:
                Timer timer4 = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        v.personajeLABEL.setIcon(rightP.getIconToContainer(v.personajeLABEL));
                        animacionEnd = true;
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer4.start();
                break;
        }

        Timer timerdos = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                animacionEnd = false;
                ((Timer) e.getSource()).stop();
            }
        });
        timerdos.setInitialDelay(600);
        timerdos.setRepeats(true);
        timerdos.start();
    }

    /**
     * Otro metodo único que trabaja en conjunto del srayMovimiento No está
     * permitida la edición.
     *
     * @param e
     */
    public void estaticoPersonaje(KeyEvent e) {
        v.personajeLABEL.setIcon(staticP.getIconToContainer(v.personajeLABEL));
    }
}
