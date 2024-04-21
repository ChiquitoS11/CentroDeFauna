package com.chiquitos11.veterinaria.model;

import com.chiquitos11.veterinaria.enums.Gravedad;
import com.chiquitos11.veterinaria.enums.MotivoSalida;
import com.chiquitos11.veterinaria.enums.TipoAnimal;
import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Reptil extends Animal {
    boolean infeccionBacteriana;

    public Reptil(String DNI, String nombre, String tratamiento, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, LocalDate fechaSalida, MotivoSalida motivoSalida, String veterinario, boolean infeccionBacteriana) {
        super(DNI, nombre, tratamiento, fechaEntrada, tipoAnimal, peso, gravedad, fechaSalida, motivoSalida, veterinario);
        this.infeccionBacteriana = infeccionBacteriana;
    }
    

    public boolean isInfeccionBacteriana() {
        return infeccionBacteriana;
    }

    public void setInfeccionBacteriana(boolean infeccionBacteriana) {
        this.infeccionBacteriana = infeccionBacteriana;
    }
    
   
}
