/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.model;

import java.sql.SQLException;

/**
 *
 * @author ChiquitoS11
 */
public class BBDD {
    public void darAlta(Animal a) throws SQLException {
//        new FabricanteDAO().insertarFabricante(f);
        ejecutarDarAlta(a);
    }
    
    private void ejecutarDarAlta(Animal a) throws SQLException{
        if (a instanceof Mamifero) {
            // El animal es un Mamifero
            Mamifero mamifero = (Mamifero) a;
            
        } else if (a instanceof Reptil) {
            // El animal es un Reptil
            Reptil reptil = (Reptil) a;

        } else if (a instanceof Ave) {
            // El animal es un Ave
            Ave ave = (Ave) a;
            new AveDAO().insertarAve(ave);
            
        } else {
            // El tipo de animal no está reconocido
            System.out.println("Animal no reconocido en la base de datos, ERROR...");
        }
    }
}
