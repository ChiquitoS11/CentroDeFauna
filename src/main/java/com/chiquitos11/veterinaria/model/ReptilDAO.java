package com.chiquitos11.veterinaria.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChiquitoS11
 */
public class ReptilDAO {

    public void insertarReptil(Reptil reptil) throws SQLException {
        System.out.println("no se creo la statement");
        Statement s = new Conexion().getConnection().createStatement();
        System.out.println("se creo la statement");
////        System.out.println("no se subio el value");
        int nFil = s.executeUpdate("insert into reptil(dni, nombre, fechaEntrada, tipoAnimal, peso, gravedad, infeccionBacteriana)"
                + " values('" + reptil.getDNI() + "', "
                + "'" + reptil.getNombre() + "', "
                //                                    + "NOW(), "
                + "'" + reptil.getFechaEntrada() + "', "
                + "'" + reptil.getTipoAnimalSTR() + "', "
                + "" + reptil.getPeso() + ", "
                + "'" + reptil.getGravedadSTR() + "', "
                + reptil.isInfeccionBacteriana()+ ");");
        System.out.println(reptil.getFechaEntrada());
//            System.out.println("DATOS CARGADOS");
////        System.out.println(|"se subio el value");
////////         + +
    }
}
