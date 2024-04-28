package com.chiquitos11.veterinaria.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChiquitoS11
 */
public class MamiferoDAO {

    public void insertarMamifero(Mamifero mamifero) throws SQLException {
        System.out.println("no se creo la statement");
        Statement s = new Conexion().getConnection().createStatement();
        System.out.println("se creo la statement");
////        System.out.println("no se subio el value");
        int nFil = s.executeUpdate("insert into mamifero(dni, nombre, fechaEntrada, tipoAnimal, peso, gravedad, atropello)"
                + " values('" + mamifero.getDNI() + "', "
                + "'" + mamifero.getNombre() + "', "
//                                                    + "NOW(), "
                + "'" + mamifero.getFechaEntrada() + "', "
                + "'" + mamifero.getTipoAnimalSTR() + "', "
                + "" + mamifero.getPeso() + ", "
                + "'" + mamifero.getGravedadSTR() + "', "
                + mamifero.isAtropello()+ ");");
        System.out.println(mamifero.getFechaEntrada());
//            System.out.println("DATOS CARGADOS");
////        System.out.println(|"se subio el value");
////////         + +
    }
}
