/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Conections {


    Connection conectar;

    String user = "root";
    String password = "root";
    String bd = "taller_mecanico";
    String ip = "localhost";
    String port = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + port + "/" + bd;

    public Connection EstableceConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, user, password);
          //  System.out.println("Se conectó correctamente a la base de datos");
        } catch (Exception e) {
            System.out.println("Problema en la conexión: " + e);
        }

        return conectar;
    }
}
