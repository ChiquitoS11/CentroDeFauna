/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.model;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class AveDAO {
        public void insertarAve(Ave ave) throws SQLException {
//        System.out.println("no se creo la statement");
        Statement s = new Conexion().getConnection().createStatement();
//        System.out.println("se creo la statement");
//        System.out.println("no se subio el value");
        int nFil = s.executeUpdate("insert into ave(//id,nombre//) values (//default,'"+ ave.getNombre() + "'//)");
//        System.out.println("se subio el value");
//////         + +
    }
}
