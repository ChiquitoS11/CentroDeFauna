package com.chiquitos11.veterinaria.model;

import com.chiquitos11.veterinaria.enums.Gravedad;
import com.chiquitos11.veterinaria.enums.MotivoSalida;
import com.chiquitos11.veterinaria.enums.TipoAnimal;
import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Animal {
    // LOS ENUMS ESTAN AL FINAL DEL PROYECTO
    private String DNI;
    private String nombre;
    private String tratamiento;
    private LocalDate fechaEntrada;
    private TipoAnimal tipoAnimal;
    private double peso;
    private Gravedad gravedad;
    private LocalDate fechaSalida;
    private MotivoSalida motivoSalida;
    private String veterinario;
    
    
    public Animal(String DNI, String nombre, String tratamiento, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.tratamiento = tratamiento;
        this.fechaEntrada = fechaEntrada;
        this.tipoAnimal = tipoAnimal;
        this.peso = peso;
        this.gravedad = gravedad;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }

    public void setGravedad(Gravedad gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public MotivoSalida getMotivoSalida() {
        return motivoSalida;
    }

    public void setMotivoSalida(MotivoSalida motivoSalida) {
        this.motivoSalida = motivoSalida;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
    
    
    public String getGravedadSTR() {
        return gravedad.toString();
    }
    public String getTipoAnimalSTR() {
        return tipoAnimal.toString();
    }
}