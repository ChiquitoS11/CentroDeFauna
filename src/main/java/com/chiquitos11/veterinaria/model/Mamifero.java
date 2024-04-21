package com.chiquitos11.veterinaria.model;

import com.chiquitos11.veterinaria.enums.Gravedad;
import com.chiquitos11.veterinaria.enums.MotivoSalida;
import com.chiquitos11.veterinaria.enums.TipoAnimal;
import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Mamifero extends Animal {
    boolean atropello;

    public Mamifero(String DNI, String nombre, String tratamiento, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, boolean atropello) {
        super(DNI, nombre, tratamiento, fechaEntrada, tipoAnimal, peso, gravedad);
        this.atropello = atropello;
    }

    public boolean isAtropello() {
        return atropello;
    }

    public void setAtropello(boolean atropello) {
        this.atropello = atropello;
    }
    
}
