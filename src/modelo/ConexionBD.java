/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lanfor
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
        realizarConexion();
        consultarEmpleado("'1-1617-0659'");
         
         
    }
    public void realizarConexion()
    {
        try 
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    public boolean registrarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+cedula+"','"+nombre+"','"+direccion+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarEmpleado(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
         String nombre="", direccion="";

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes WHERE cedula="+cedula);
                
                while (rs.next()) 
                {
                   nombre = rs.getString("nombre");
                   direccion = rs.getString("direccion");
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: Nombre: "+nombre+" Direccion: "+direccion);
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
}