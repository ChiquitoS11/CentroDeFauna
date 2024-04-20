package com.chiquitos11.veterinaria.model;

import java.time.LocalDate;

/**
 *
 * @author ChiquitoS11
 */
public class Animal {
    private String DNI;
    private String nombre;
    private LocalDate fechaEntrada;
    private TipoAnimal tipoAnimal;
    private double peso;
    private Gravedad gravedad;
    private LocalDate fechaMuerte;
    private String veterinario;

    public Animal() {
    }

    
    
    public Animal(String DNI, String nombre, LocalDate fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad, LocalDate fechaMuerte, String veterinario) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.fechaEntrada = fechaEntrada;
        this.tipoAnimal = tipoAnimal;
        this.peso = peso;
        this.gravedad = gravedad;
        this.fechaMuerte = fechaMuerte;
        this.veterinario = veterinario;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public double getPeso() {
        return peso;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }

    public LocalDate getFechaMuerte() {
        return fechaMuerte;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setGravedad(Gravedad gravedad) {
        this.gravedad = gravedad;
    }

    public void setFechaMuerte(LocalDate fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }
            
    public String GravedadSTR() {
        return gravedad.toString();
    }
    public String TipoAnimalSTR() {
        return tipoAnimal.toString();
    }
}

enum TipoAnimal {
    Ave,
    Mamifero,
    Reptil
}

enum Gravedad {
    LOW,
    MEDIUM,
    HIGH
}