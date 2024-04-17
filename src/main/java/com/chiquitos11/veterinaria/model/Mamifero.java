package com.chiquitos11.veterinaria.model;

/**
 *
 * @author ChiquitoS11
 */
public class Mamifero extends Animal {
    boolean atropello;

    public Mamifero(String DNI, String nombre, String fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, boolean atropello) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad);
        this.atropello = atropello;
    }
}
