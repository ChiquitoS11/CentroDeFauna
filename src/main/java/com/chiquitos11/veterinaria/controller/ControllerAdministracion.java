/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.view.Administracion;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerAdministracion {
    private Administracion ad;
    
    
    public ControllerAdministracion(Administracion ad) {
        this.ad = ad;
//        ad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ad.meow();
    }
    
}
