package com.chiquitos11.veterinaria.model;

import com.chiquitos11.veterinaria.enums.Gravedad;
import com.chiquitos11.veterinaria.enums.MotivoSalida;
import com.chiquitos11.veterinaria.enums.TipoAnimal;
import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Ave extends Animal {
    boolean cazaFurtiva;

    public Ave(String DNI, String nombre, String tratamiento, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, LocalDate fechaSalida, MotivoSalida motivoSalida, String veterinario, boolean cazaFurtiva) {
        super(DNI, nombre, tratamiento, fechaEntrada, tipoAnimal, peso, gravedad, fechaSalida, motivoSalida, veterinario);
        this.cazaFurtiva = cazaFurtiva;
    }

    

    public boolean isCazaFurtiva() {
        return cazaFurtiva;
    }

    public void setCazaFurtiva(boolean cazaFurtiva) {
        this.cazaFurtiva = cazaFurtiva;
    }
}
