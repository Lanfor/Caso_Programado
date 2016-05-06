/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lanfor
 */
public class ArchivosUsuarios 
{
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosUsuarios()
    {
    }
    public void crearArchivo()
    {
        try 
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("usuario.dat"));
            System.out.println("Archivo Creado");
        } catch (Exception e) 
        {
            System.err.println("Error al crear el archivo "+e.getMessage());
        }
        
    }
    public void escribirInformacionEnElArchivo(Usuario persona)
    {
        try 
        {
            archivoSalida.writeObject(persona);
            System.out.println(persona.getInformacion());
            System.out.println("Se escribío el archivo de usuario de la forma correcta");
        } catch (Exception e) {
            System.err.println("Error al escribir en el Archivo "+e.getMessage());
        }
    }
    public String leerInformacion()
    {
        Usuario usuario=null;
        try 
        {
             archivoEntrada=new ObjectInputStream(new FileInputStream("usuario.dat"));
             usuario=(Usuario)archivoEntrada.readObject( );
        } catch (Exception e) 
        {
            System.err.println("Error al leer información en el Archivo "+e.getMessage());
        }
       
        return usuario.getInformacion();
    }
    public ArrayList<Usuario> leerInformacionCompleta()
    {
        ArrayList<Usuario> arrayUsuario=new ArrayList<Usuario>();
        try 
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("usuario.dat"));
            
            while (true)
            {
                arrayUsuario.add((Usuario)archivoEntrada.readObject());
            }
            
        } catch (Exception e) 
        {
            System.err.println("Fin del archivo: "+e.getMessage());
        }
        return arrayUsuario;
    }
}
