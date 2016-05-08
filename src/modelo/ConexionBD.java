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
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` WHERE cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
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
        Statement cmd = null;
        try {
                cmd = con.createStatement();
                cmd.execute("UPDATE `estudiantes` SET `cedula`='"+arreglo[0]+"',`nombre`='"+arreglo[1]+"',`direccion`='"+arreglo[2]+"' WHERE cedula='"+arreglo[0]+"'");
                
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
    String arregloCursos[] = new String[3];
    public String[] getArregloCursos()
    {
        return arregloCursos;
    }
    public boolean consultarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean existo = false;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos` WHERE sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    arregloCursos[0] = rs.getString("nombre");
                    arregloCursos[1] = Integer.toString(rs.getInt("creditos"));
                    arregloCursos[2] = rs.getString("horario");
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
    
//********************************************** M  A  T  R  I  C  U  L  A ************************************************************************//
    public boolean registrarMatricula(String arreglo[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try 
        {
            cmd = con.createStatement();
            ejecuto = cmd.execute("SELECT * FROM `detalle_matricula` WHERE codigo='"+arreglo[0]+"' AND sigla='"+arreglo[3]+"'");
            //       NO ESTOY SEGURO DE ESTE METODO, MI CABEZA ESTÁ CERRADA
            if(ejecuto)
            {
                ejecuto = cmd.execute("INSERT INTO `detalle_matricula`(`codigo`, `cedula`, `nombre`, `sigla`)  VALUES ('"+arreglo[0]+"','"+arreglo[1]+"','"+arreglo[2]+"','"+arreglo[3]+"')");

                return true;
            }
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia registrarMatricula: " + e.getMessage());
            return false;
        }
       return false;
    }
    public void consultarMatricula(String codigo)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `detalle_matricula` WHERE codigo='"+codigo+"'");
                
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
    public String devolverCodigo()
    {
        ResultSet rs = null;
        Statement cmd = null;
        ArrayList<String> arrayMatricula=new ArrayList<String>();
        String codigo="0000";
        try 
        {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `detalle_matricula`");
                
                while (rs.next()) 
                {
                    arrayMatricula.add(rs.getString("codigo"));
                }
                if(arrayMatricula.size()==0)
                {
                   codigo+=1;
                }
                else
                {
                    int numero=Integer.parseInt((arrayMatricula.get(arrayMatricula.size()-1)));
                    numero++;

                    codigo="0000"+numero;
                }
                codigo=codigo.substring(codigo.length()-5, codigo.length());
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia consultarMatricula: " + e.getMessage());
        }
        return  codigo;
    }
    public boolean modificarMatricula(String codigo,String siglaVieja, String siglaNueva)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `detalle_matricula` SET `sigla`='"+siglaNueva+"' WHERE codigo='"+codigo+"' AND sigla='"+siglaVieja+"'");
                
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
                ejecuto = cmd.execute("DELETE FROM `detalle_matricula` WHERE codigo='"+codigo+"' AND sigla='"+sigla+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia eliminarMatricula: " + e.getMessage());
            return false;
        }
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
