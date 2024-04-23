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

    public Reptil(String DNI, String nombre, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, boolean infeccionBacteriana) {
        super(DNI, nombre, fechaEntrada, tipoAnimal, peso, gravedad);
        this.infeccionBacteriana = infeccionBacteriana;
    }
    

    public boolean isInfeccionBacteriana() {
        return infeccionBacteriana;
    }

    public void setInfeccionBacteriana(boolean infeccionBacteriana) {
        this.infeccionBacteriana = infeccionBacteriana;
    }
    
   
}
