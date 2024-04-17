/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.model;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.List;

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

    private int velocidadMovimiento = 10;
    private JLabel labelCharacter;

    private List<JPanel> limites;
    private List<JLabel> interacciones;
    
    boolean isInteractuable;
    String nameInteraccion = "x";
    
    // constructor
    public UTILPersonaje(JFrame jg, JLabel labelCharacter) {
        this.jg = jg;
        this.labelCharacter = labelCharacter;
//        Sonido saltar = new Sonido(getClass().getResource("/resources/salto.wav"));
//        Sonido bajar = new Sonido(getClass().getResource("/resources/onichan.wav"));
        this.height = labelCharacter.getHeight();
        this.width = labelCharacter.getWidth();
        limites = new ArrayList<>();
        interacciones = new ArrayList<>();
        
        isInteractuable = false;
        nameInteraccion ="x";
    }

    /**
     * Posicion en el plano X de donde esta el personaje
     *
     * @return {@code int}
     */
    public int getX() {
        return labelCharacter.getX();
    }

    /**
     * Posicion en el plano Y de donde esta el personaje
     *
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

    /**
     * añadir limites al personaje
     *
     * @param jframe
     */
    public void addLimites(JPanel jframe) {
        limites.add(jframe);
    }
    
    public void addInteracciones(JLabel jlabel){
        interacciones.add(jlabel);
    }
    
    public List<JLabel> getInteracciones() {
        return interacciones;
    }
    
    public String getNameInteraccion() {
        return this.nameInteraccion;
    }
    
    public boolean isInteractuable() {
        for (JLabel interaccion : this.interacciones) {
            if (labelCharacter.getBounds().intersects(interaccion.getBounds())) {
                this.nameInteraccion = interaccion.getName();
                return true;
            }
        }
        return false;
    }

    // METODOS -----------------------------------------------------------------------------
    /**
     * 1 - ARRIBA
     * <P>
     * 2 - ABAJO
     * <P>
     * 3 - IZQUIERDA
     * <P>
     * 4 - DERECHA
     * <P>
     * @param opcion
     */
    public void movimiento(int opcion) {
        isInteractuable();
        boolean isLimite = isLimite();
        
        if(!isLimite) {
            switch (opcion) {
                    case 1 ->
                        labelCharacter.setLocation(getX(), (getY() - velocidadMovimiento));
                    case 2 ->
                        labelCharacter.setLocation(getX(), (getY() + velocidadMovimiento));
                    case 3 ->
                        labelCharacter.setLocation((getX() - velocidadMovimiento), (getY()));
                    case 4 ->
                        labelCharacter.setLocation((getX() + velocidadMovimiento), (getY()));
                }
        } else {
                    System.out.println("CHOCARON");
                    switch (opcion) {
                    case 1 ->
                        labelCharacter.setLocation(getX(), (getY() + velocidadMovimiento));
                    case 2 ->
                        labelCharacter.setLocation(getX(), (getY() - velocidadMovimiento));
                    case 3 ->
                        labelCharacter.setLocation((getX() + velocidadMovimiento), (getY()));
                    case 4 ->
                        labelCharacter.setLocation((getX() - velocidadMovimiento), (getY()));
                }
        }

        

        
        jg.repaint();
    }
    
    private boolean isLimite() {
        for (JPanel limite : this.limites) {
            if (labelCharacter.getBounds().intersects(limite.getBounds())) {
                return true;
            } 
        }
        return false;
    }
}
