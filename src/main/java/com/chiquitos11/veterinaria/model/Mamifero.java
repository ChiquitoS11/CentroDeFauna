package com.chiquitos11.veterinaria.model;

import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Mamifero extends Animal {
    boolean atropello;

    public Mamifero(String DNI, String nombre, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, LocalDate fechaMuerte, String veterinario, boolean atropello) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad, fechaMuerte, veterinario);
        this.atropello = atropello;
    }

    public boolean isAtropello() {
        return atropello;
    }

    public void setAtropello(boolean atropello) {
        this.atropello = atropello;
    }
    
}
