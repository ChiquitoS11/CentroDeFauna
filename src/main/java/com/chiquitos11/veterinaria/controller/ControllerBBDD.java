package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.model.Animal;
import com.chiquitos11.veterinaria.model.Ave;
import com.chiquitos11.veterinaria.model.AveDAO;
import com.chiquitos11.veterinaria.model.Conexion;
import com.chiquitos11.veterinaria.model.Mamifero;
import com.chiquitos11.veterinaria.model.MamiferoDAO;
import com.chiquitos11.veterinaria.model.Reptil;
import com.chiquitos11.veterinaria.model.ReptilDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerBBDD {

    public void darAlta(Animal a) throws SQLException {
//        new FabricanteDAO().insertarFabricante(f);

        ejecutarDarAlta(a);
    }

    public ResultSet obtenerListadoModificado(String tipoAnimal) throws SQLException {
        Statement statement = new Conexion().getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tipoAnimal + " WHERE motivoSalida is NULL");
        return rs;
    }
    
    public ResultSet obtenerListadoPorAnimal(String tipoAnimal) throws SQLException {
        Statement statement = new Conexion().getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tipoAnimal);
        return rs;
    }

    public void darBaja(String dni, String tipoAnimal, String veterinario) throws SQLException {
        Statement statement = new Conexion().getConnection().createStatement();
        int arows = statement.executeUpdate("UPDATE " + tipoAnimal + " SET fechaSalida=NOW(), motivoSalida='MUERTE', veterinario='" +veterinario+ "' WHERE dni =  '" + dni + "'");
    }
    
    public void darLiberacion(String dni, String tipoAnimal, String veterinario) throws SQLException {
        Statement statement = new Conexion().getConnection().createStatement();
        int arows = statement.executeUpdate("UPDATE " + tipoAnimal + " SET fechaSalida=NOW(), motivoSalida='LIBERACION', veterinario='" +veterinario+ "' WHERE dni =  '" + dni + "'");
    }
    
    public void darTratamiento(String dni, String tipoAnimal, String veterinario, String tratamiento) throws SQLException {
        Statement statement = new Conexion().getConnection().createStatement();
        int arows = statement.executeUpdate("UPDATE " + tipoAnimal + " SET tratamiento='" +tratamiento+ "', veterinario='" +veterinario+ "' WHERE dni =  '" + dni + "'");
    }

    private void ejecutarDarAlta(Animal animal) throws SQLException {
        if (animal instanceof Mamifero) {
            // El animal es un Mamifero
//            Mamifero mamifero = (Mamifero) animal;
            new MamiferoDAO().insertarMamifero((Mamifero) animal);

        } else if (animal instanceof Reptil) {
            // El animal es un Reptil
            Reptil reptil = (Reptil) animal;
            new ReptilDAO().insertarReptil(reptil);

        } else if (animal instanceof Ave) {
            // El animal es un Ave
            Ave ave = (Ave) animal;
            new AveDAO().insertarAve(ave);

        } else {
            // El tipo de animal no está reconocido
            System.out.println("Animal no reconocido en la base de datos, ERROR...");
        }
    }
}
