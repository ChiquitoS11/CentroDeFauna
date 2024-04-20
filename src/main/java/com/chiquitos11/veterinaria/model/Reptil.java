package com.chiquitos11.veterinaria.model;

import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Reptil extends Animal {
    boolean infeccionBacteriana;

    public Reptil() {
        
    }
    
    public Reptil(String DNI, String nombre, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, LocalDate fechaMuerte, String veterinario, boolean infeccionBacteriana) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad, fechaMuerte, veterinario);
        this.infeccionBacteriana = infeccionBacteriana;
    }


    public boolean isInfeccionBacteriana() {
        return infeccionBacteriana;
    }

    public void setInfeccionBacteriana(boolean infeccionBacteriana) {
        this.infeccionBacteriana = infeccionBacteriana;
    }
    
   
}
