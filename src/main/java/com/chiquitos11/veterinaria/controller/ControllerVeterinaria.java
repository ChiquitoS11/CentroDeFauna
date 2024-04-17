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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerVeterinaria implements KeyListener {
    
    private Veterinaria v;
    private UTILPersonaje p;
    UTILImagen upP = new UTILImagen(getClass().getResource("/resources/up.gif"));
    UTILImagen downP = new UTILImagen(getClass().getResource("/resources/down.gif"));
    UTILImagen leftP = new UTILImagen(getClass().getResource("/resources/left.gif"));
    UTILImagen rightP = new UTILImagen(getClass().getResource("/resources/right.gif"));
    UTILImagen staticP = new UTILImagen(getClass().getResource("/resources/static.png"));
    
    
    
    public ControllerVeterinaria(Veterinaria v){
        this.v = v;
        this.p = new UTILPersonaje(v, v.personajeLABEL);
        v.addKeyListener(this);
        
    }
    
    public void moverPersonaje() {
        
    }

    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p.moverArriba();
            if (cargo == false) {
                sprayMovimiento(1);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p.moverAbajo();
            if (cargo == false) {
                sprayMovimiento(2);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            p.moverIzquierda();
            if (cargo == false) {
                sprayMovimiento(3);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            p.moverDerecha();
            if (cargo == false) {
                sprayMovimiento(4);
            }
        }

    }
    
    
    
    
    

    /*
    * No tocar, la clase es un implements de key event
    * por lo que necesitamos este metodo pero en realidad no lo usamos nunca
    */
    @Override
    public void keyTyped(KeyEvent e) {}
    
    /*
    * Este metodo esta encargado ed realizar los sprays del personaje, 
    * recordemos que el 'personaje' es un JLabel al que se le va cambiando el setIcon
    * este metodo es único y no esta permitido editarlo.
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
    
    /*
    * Otro metodo único que trabaja en conjunto del srayMovimiento
    * No está permitida la edición.
    */
    @Override
    public void keyReleased(KeyEvent e) {
        v.personajeLABEL.setIcon(staticP.getIconToContainer(v.personajeLABEL));
    }
}
