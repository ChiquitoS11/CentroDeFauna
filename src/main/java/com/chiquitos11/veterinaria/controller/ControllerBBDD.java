/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.model.Animal;
import com.chiquitos11.veterinaria.model.Ave;
import com.chiquitos11.veterinaria.model.AveDAO;
import com.chiquitos11.veterinaria.model.Mamifero;
import com.chiquitos11.veterinaria.model.Reptil;
import java.sql.SQLException;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerBBDD {
    
    
    public void darAlta(Animal a) throws SQLException {
//        new FabricanteDAO().insertarFabricante(f);

        ejecutarDarAlta(a);
    }
    
    private void ejecutarDarAlta(Animal animal) throws SQLException{
        if (animal instanceof Mamifero) {
            // El animal es un Mamifero
            Mamifero mamifero = (Mamifero) animal;
            
            
        } else if (animal instanceof Reptil) {
            // El animal es un Reptil
            Reptil reptil = (Reptil) animal;
            
            
        } else if (animal instanceof Ave) {
            // El animal es un Ave
            Ave ave = (Ave) animal;
            new AveDAO().insertarAve(ave);
            
        } else {
            // El tipo de animal no está reconocido
            System.out.println("Animal no reconocido en la base de datos, ERROR...");
        }
    }
}
