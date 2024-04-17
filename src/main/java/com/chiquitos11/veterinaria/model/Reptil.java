package com.chiquitos11.veterinaria.model;

/**
 *
 * @author ChiquitoS11
 */
public class Reptil extends Animal {
    boolean infeccionBacteriana;

    public Reptil(String DNI, String nombre, String fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, boolean infeccionBacteriana) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad);
        this.infeccionBacteriana = infeccionBacteriana;
    }
    
   
}
