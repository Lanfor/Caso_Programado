/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lanfor Mena y Andy Carrillo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.JSType;



public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
      realizarConexion();
    }
    public void realizarConexion()
    {
        try 
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/caso_programado";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) 
        {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    public boolean registrarEstudiante(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    String arregloEstudiantes[] = new String[2];
    
    public String[] getArregloEstudiantes()
    {
        return arregloEstudiantes;
    }
    public boolean consultarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existo=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` WHERE cedula="+cedula);
                
                while (rs.next()) 
                {
//                    String nombre = rs.getString("nombre");
//                    String direccion = rs.getString("direccion");
//                    System.out.println("Información de la BD:\n\nNombre: "+nombre+"\nCedula: "+cedula+"\nDireccion: "+direccion); 
                      arregloEstudiantes[0]= rs.getString("nombre");
                      arregloEstudiantes[1]= rs.getString("direccion");
                      existo = true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existo;
    }
    public boolean modificarEstudiante(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `estudiantes` SET `cedula`='"+arreglo[0]+"',`nombre`='"+arreglo[1]+"',`direccion`='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarEstudiante(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `estudiantes` WHERE cedula='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Estudiante> crearArrayEstudiantes()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Estudiante> arrayEstudiantes = new ArrayList <Estudiante>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` ");
                
                while (rs.next()) 
                {
                    String cedula = rs.getString("cedula");
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    
                    Estudiante temporal = new Estudiante(cedula,nombre,direccion);
                    arrayEstudiantes.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayEstudiantes;
    }
    
    public boolean registrarCurso(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `cursos`(`sigla`, `nombre`, `creditos`, `horario`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+Integer.parseInt(arreglo[2])+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos` WHERE sigla="+sigla);
                
                while (rs.next()) 
                {
                    
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    System.out.println("Información de la BD:\n\nNombre: "+nombre+"\nSigla: "+sigla+"\nCreditos: "+creditos+"\nHorario: "+horario); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
    }
    public boolean modificarCurso(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `cursos` SET `sigla`='"+arreglo[0]+"',`nombre`='"+arreglo[1]+"',`creditos`='"+Integer.parseInt(arreglo[2])+"',`horario`='"+arreglo[3]+"' WHERE sigla='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarCurso(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `cursos` WHERE sigla='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Cursos> crearArrayCursos()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Cursos> arrayCursos = new ArrayList <Cursos>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos`");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    String nombre = rs.getString("nombre");
                    int creditos = rs.getInt("creditos");
                    String horario = rs.getString("horario");
                    Cursos temporal = new Cursos(sigla,nombre,creditos,horario);
                    arrayCursos.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return arrayCursos;
    }
    public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `datalle_matricula`(`codigo`, `cedula`, `sigla`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia registrarMatricula: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `datalle_matricula` WHERE codigo="+codigo);
                
                while (rs.next()) 
                {
                    
                    String cedula = rs.getString("cedula");
                    String sigla = rs.getString("sigla");
                    
                    //System.out.println("Información de la BD:\n\Codigo: "+codigo);
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia consultarMatricula: " + e.getMessage());
        }
    }
    public boolean modificarMatricula(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `detalle_matricula` SET `codigo`='"+arreglo[0]+"',`cedula`='"+arreglo[1]+"',`sigla`='"+arreglo[2]+"' WHERE codigo='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia modificarMatricula: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarMatricula(String codigo,String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `detalle_matricula` WHERE codigo='"+codigo+"' and sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia eliminarMatricula: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Matricula> crearArrayMatricula()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<Matricula> arrayMatricula= new ArrayList <Matricula>();
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `detalle_matricula`");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    String codigo = rs.getString("codigo");
                    String cedula = rs.getString("cedula");
                    Matricula temporal = new Matricula(codigo,cedula,sigla,true);
                    arrayMatricula.add(temporal);
                }
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia crearArrayMatricula: " + e.getMessage());
        }
        return arrayMatricula;
    }
//******************************************  Usuarios  ************************************************************//
    String[] arregloUsuario=new String[3];
    public boolean registrarUsuario(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try 
        {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO `usuario`(`nombreUsuario`, `correo`, `contrasena`, `tipo`) VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean consultarUsuario(String nombreUsuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existencia=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario` WHERE nombreUsuario='"+nombreUsuario+"'");
                
                while (rs.next()) 
                {
                    
                    arregloUsuario[0] = rs.getString("correo");
                    arregloUsuario[1] = rs.getString("contrasena");
                    arregloUsuario[2] = rs.getString("tipo");
                    
                    //System.out.println("Información de la BD:\n\Nombre Usuario: "+nombreUsuario+"\nCedula: "+cedula+"\nNombre Completo: "+nombreCompleto+"\nPassword: "+password+"\nTipo: "+tipo);
                    existencia=true;
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            existencia=false;
        }
        return existencia;
    }
    public String[] getArregloUsuario()
    {
        return arregloUsuario;
    }
    public boolean modificarUsuario(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `usuario` SET `nombreUsuario`='"+arreglo[0]+"',`password`='"+arreglo[1]+"',`tipo`='"+arreglo[2]+"',`nombreCompleto`='"+arreglo[3]+"',`cedula`='"+arreglo[4]+"' WHERE nombreUsuario='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean eliminarUsuario(String[] arreglo)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `usuario` WHERE nombreUsuario='"+arreglo[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    public boolean haveUsers()
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean weHave=false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario`");
                
                if(rs.next())
                    weHave=true;//Yes man XD
                
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            weHave=false;
        }
        return weHave;
    }
    
}
