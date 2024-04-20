/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chiquitos11.veterinaria.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class Conexion {
    Connection c = null;

    String urlConnection = "jdbc:mysql://localhost:3306/veterinaria"; // CREAR LA BASE DATOS YA
    String user = "root";
    String password = "";
    
    public Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection(urlConnection, user, password);
        System.out.println("Conexión realizada");
        Statement s = con.createStatement();
        
        return con;
    }
}
