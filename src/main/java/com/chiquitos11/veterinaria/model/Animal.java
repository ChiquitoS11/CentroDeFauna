package com.chiquitos11.veterinaria.model;

/**
 *
 * @author ChiquitoS11
 */
public class Animal {
    private String DNI;
    private String Nombre;
    private String fechaEntrada;
    private TipoAnimal tipoAnimal;
    private double peso;
    private Gravedad gravedad;
    
    public Animal(){
        
    }
        
    public String GravedadSTR() {
        return gravedad.toString();
    }
    public String tipoAnimalSTR() {
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