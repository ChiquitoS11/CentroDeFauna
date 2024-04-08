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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerVeterinaria implements KeyListener {
    
    private Veterinaria v;
    private UTILPersonaje p;
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
        if (e.getKeyCode()==KeyEvent.VK_W) {
            p.moverArriba();
            
        }
        if (e.getKeyCode()==KeyEvent.VK_S) {
            p.moverAbajo();
            
        }
        if (e.getKeyCode()==KeyEvent.VK_A) {
            p.moverIzquierda();
        }
        if (e.getKeyCode()==KeyEvent.VK_D) {
            p.moverDerecha();

            if (cargo == false) {
                gifts();
            }
            
        }
        
    }
    
    boolean cargo = false;
    private void gifts() {
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acciones a realizar después de 1 segundo
                v.personajeLABEL.setIcon(rightP.imgToContainer(v.personajeLABEL));
                cargo = true;
                ((Timer) e.getSource()).stop(); // Detener el temporizador después de 1 segundo
            }
        });
        timer.setRepeats(true); // Configurar el temporizador para que no se repita
        timer.start(); // Iniciar el temporizador
        
        Timer timerdos = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cargo = false;
                ((Timer) e.getSource()).stop(); // Detener el temporizador después de 1 segundo
            }
        });
        timerdos.setInitialDelay(600);
        timerdos.setRepeats(true); // Configurar el temporizador para que no se repita
        timerdos.start(); // Iniciar el temporizador
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {
        v.personajeLABEL.setIcon(staticP.imgToContainer(v.personajeLABEL));
    }
}
