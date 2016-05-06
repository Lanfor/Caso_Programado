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
public class ArchivosCursos 
{
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosCursos()
    {
    }
    public void crearArchivo()
    {
        try 
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("curso.dat"));
            System.out.println("Archivo Creado");
        } catch (Exception e) 
        {
            System.err.println("Error al crear el archivo "+e.getMessage());
        }
        
    }
    public void escribirInformacionEnElArchivo(Cursos curso)
    {
        try 
        {
            archivoSalida.writeObject(curso);
            System.out.println("Se escribío el archivo de la forma correcta");
        } catch (Exception e) {
            System.err.println("Error al escribir en el Archivo "+e.getMessage());
        }
    }
    public String leerInformacion()
    {
        Cursos persona=null;
        try 
        {
             archivoEntrada=new ObjectInputStream(new FileInputStream("curso.dat"));
             persona=(Cursos)archivoEntrada.readObject( );
        } catch (Exception e) 
        {
            System.err.println("Error al leer información en el Archivo "+e.getMessage());
        }
       
        return persona.getInformacion();
    }
    public ArrayList<Cursos> leerInformacionCompleta()
    {
        ArrayList<Cursos> arrayCursos=new ArrayList<Cursos>();
        try 
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("curso.dat"));
            while (true)
            {
                arrayCursos.add((Cursos)archivoEntrada.readObject( ));
            }
        } catch (Exception e) 
        {
            System.err.println("Fin del archivo: "+e.getMessage());
        }
        return arrayCursos;
    }
}
