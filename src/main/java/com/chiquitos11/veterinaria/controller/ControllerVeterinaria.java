/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.model.UTILImagen;
import com.chiquitos11.veterinaria.model.UTILPersonaje;
import com.chiquitos11.veterinaria.view.Veterinaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerVeterinaria {

    private Veterinaria v;
    private UTILPersonaje p;
    UTILImagen upP = new UTILImagen(getClass().getResource("/resources/up.gif"));
    UTILImagen downP = new UTILImagen(getClass().getResource("/resources/down.gif"));
    UTILImagen leftP = new UTILImagen(getClass().getResource("/resources/left.gif"));
    UTILImagen rightP = new UTILImagen(getClass().getResource("/resources/right.gif"));
    UTILImagen staticP = new UTILImagen(getClass().getResource("/resources/static.png"));
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
                    System.out.println("enfermera Joy");
                    JOptionPane.showMessageDialog(null, "Dar de alta y toda esa cosa");
                    break;
                default:
                    System.out.println("no hay interaccion");
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
            if (cargo == false) {
                sprayMovimiento(1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p.movimiento(2);
            if (cargo == false) {
                sprayMovimiento(2);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p.movimiento(3);
            if (cargo == false) {
                sprayMovimiento(3);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p.movimiento(4);
            if (cargo == false) {
                sprayMovimiento(4);
            }
        }
    }
    /**
     * Este metodo esta encargado ed realizar los sprays del personaje,
     * recordemos que el 'personaje' es un JLabel al que se le va cambiando el
     * setIcon este metodo es único y no esta permitido editarlo.
     */
    boolean cargo = false;

    private void sprayMovimiento(int direccion) {
        switch (direccion) {
            case 1:
                Timer timer1 = new Timer(0, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Acciones a realizar después de 1 segundo
                        v.personajeLABEL.setIcon(upP.getIconToContainer(v.personajeLABEL));
                        cargo = true;
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
                        cargo = true;
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
                        cargo = true;
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
                        cargo = true;
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer4.start();
                break;
        }

        Timer timerdos = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cargo = false;
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
