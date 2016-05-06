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

/**
 *
 * @author Lanfor
 */
public class ArchivosEstudiantes 
{
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosEstudiantes()
    {
    }
    public void crearArchivo()
    {
        try 
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("estudiante.dat"));
            System.out.println("Archivo Creado");
        } catch (Exception e) 
        {
            System.err.println("Error al crear el archivo "+e.getMessage());
        }
        
    }
    public void escribirInformacionEnElArchivo(Estudiante estudiante)
    {
        try 
        {
            archivoSalida.writeObject(estudiante);
            System.out.println("Se escribío el archivo de la forma correcta");
        } catch (Exception e) {
            System.err.println("Error al escribir en el Archivo "+e.getMessage());
        }
    }
    public String leerInformacion()
    {
        Estudiante estudiante=null;
        try 
        {
             archivoEntrada=new ObjectInputStream(new FileInputStream("estudiante.dat"));
             estudiante=(Estudiante)archivoEntrada.readObject( );
        } catch (Exception e) 
        {
            System.err.println("Error al leer información en el Archivo "+e.getMessage());
        }
       
        return estudiante.getInformacion();
    }
    public ArrayList<Estudiante> leerInformacionCompleta()
    {
        ArrayList<Estudiante> arrayEstudiante=new ArrayList<Estudiante>();
        try 
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("estudiante.dat"));
            while (true)
            {
                arrayEstudiante.add((Estudiante)archivoEntrada.readObject( ));
            }
        } catch (Exception e) 
        {
            System.err.println("Fin del archivo: "+e.getMessage());
        }
        return arrayEstudiante;
    }
}
