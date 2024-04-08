/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.model;

import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ChiquitoS11
 */
public class UTILPersonaje {
    // atributos
    private final JFrame jg;
    
    public int width;
    public int height;
    
    private int velocidadMovimiento = 13;
    private JLabel labelCharacter;
    
    private Rectangle caja;
    
    // constructor
    public UTILPersonaje(JFrame jg, JLabel labelCharacter) {
        this.jg = jg;
        this.labelCharacter = labelCharacter;
//        Sonido saltar = new Sonido(getClass().getResource("/resources/salto.wav"));
//        Sonido bajar = new Sonido(getClass().getResource("/resources/onichan.wav"));
        this.height = labelCharacter.getHeight();
        this.width = labelCharacter.getWidth();
        this.caja = new Rectangle(getX(),getY(), getWidth(), getHeight());
    }
    
    /**
     * Posicion en el plano X de donde esta el personaje
     * @return {@code int}
     */
    public int getX() {
        return labelCharacter.getX();
    }

    /**
     * Posicion en el plano Y de donde esta el personaje
     * @return {@code int}
     */
    public int getY() {
        return labelCharacter.getY();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public Rectangle getRectangle(){
        return caja;
    }
    
    // metodos
    
    /**
     * mueve el personaje hacia arriba
     */
    public void moverArriba() {
        movimiento(1);
        jg.repaint();
    }
    
    /**
     * mueve el personaje hacia abajo
     */
    public void moverAbajo() {
        movimiento(2);
        jg.repaint();
    }
    
    /**
     * mueve el personaje a la izquierda
     */
    public void moverIzquierda() {
        movimiento(3);
        jg.repaint();
    }
    
    /**
     * mueve el personaje a la derecha
     */
    public void moverDerecha() {
        movimiento(4);
        jg.repaint();
    }
    
    /**
     * encargado de realizar el movimiento <P>
     * con un poco de logica, vemos como reposiciona <P>
     * en personaje sumando o restando la velocidad de movimiento <P>
     * @param {@code}
     */
    private void movimiento(int opcion) {
        switch(opcion){
            case 1 -> labelCharacter.setLocation(getX(), (getY() - velocidadMovimiento));
            case 2 -> labelCharacter.setLocation(getX(), (getY() + velocidadMovimiento));
            case 3 -> labelCharacter.setLocation((getX() - velocidadMovimiento), (getY()));
            case 4 -> labelCharacter.setLocation((getX() + velocidadMovimiento), (getY()));
        }
    }
}
