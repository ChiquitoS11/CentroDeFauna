package com.chiquitos11.veterinaria.model;

/**
 *
 * @author ChiquitoS11
 */
public class Animal {
    private String DNI;
    private String nombre;
    private String fechaEntrada;
    private TipoAnimal tipoAnimal;
    private double peso;
    private Gravedad gravedad;

    public Animal(String DNI, String nombre, String fechaEntrada, TipoAnimal tipoAnimal, double peso, Gravedad gravedad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.fechaEntrada = fechaEntrada;
        this.tipoAnimal = tipoAnimal;
        this.peso = peso;
        this.gravedad = gravedad;
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