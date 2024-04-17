package com.chiquitos11.veterinaria.model;

/**
 *
 * @author ChiquitoS11
 */
public class Ave extends Animal {
    boolean cazaFurtiva;

    public Ave(String DNI, String nombre, String fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, boolean cazaFurtiva) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad);
        this.cazaFurtiva = cazaFurtiva; 
    }
}
