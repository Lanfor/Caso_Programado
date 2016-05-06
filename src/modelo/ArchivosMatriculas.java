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
public class ArchivosMatriculas 
{
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosMatriculas()
    {
    }
    public void crearArchivo()
    {
        try 
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("matricula.dat"));
            System.out.println("Archivo Creado");
        } catch (Exception e) 
        {
            System.err.println("Error al crear el archivo "+e.getMessage());
        }
        
    }
    public void escribirInformacionEnElArchivo(Matricula matricula)
    {
        try 
        {
            archivoSalida.writeObject(matricula);
            System.out.println("Se escribío el archivo de la forma correcta");
        } catch (Exception e) {
            System.err.println("Error al escribir en el Archivo "+e.getMessage());
        }
    }
    public String leerInformacion()
    {
        Matricula matricula=null;
        try 
        {
             archivoEntrada=new ObjectInputStream(new FileInputStream("matricula.dat"));
             matricula=(Matricula)archivoEntrada.readObject( );
        } catch (Exception e) 
        {
            System.err.println("Error al leer información en el Archivo "+e.getMessage());
        }
       
        return matricula.getInformacion();
    }
    public ArrayList<Matricula> leerInformacionCompleta()
    {
        ArrayList<Matricula> arrayMatricula=new ArrayList<Matricula>();
        try 
        {
            archivoEntrada=new ObjectInputStream(new FileInputStream("matricula.dat"));
            while (true)
            {
                arrayMatricula.add((Matricula)archivoEntrada.readObject( ));
            }
        } catch (Exception e) 
        {
            System.err.println("Fin del archivo: "+e.getMessage());
        }
        return arrayMatricula;
    }
}
