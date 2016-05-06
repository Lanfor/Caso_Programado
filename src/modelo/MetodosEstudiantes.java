/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author tecnologiamultimedia
 */
public class MetodosEstudiantes {
    
    private ArrayList <Estudiante> arrayEstudiantes;
    
    String[] arregloInformacionConsultada=new String[2];
    ArchivosEstudiantes archivosEstudiantes;
    int pos;
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
        archivosEstudiantes=new ArchivosEstudiantes();
        arrayEstudiantes=archivosEstudiantes.leerInformacionCompleta();
    }
    public void escribirSobreArchivo()
    {
        archivosEstudiantes.crearArchivo();
        for (int i = 0; i < arrayEstudiantes.size(); i++) 
        {
            archivosEstudiantes.escribirInformacionEnElArchivo(arrayEstudiantes.get(i));
        }
    }
    public void agregarEstudiante(String informacion[])
    {
        Estudiante objeto=new Estudiante(informacion[0], informacion[1], informacion[2]);
        arrayEstudiantes.add(objeto);

    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    
    }
    
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        //[][][][]
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombrecompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
                pos=contador;
            }
        }
        return existe;
    }
    
    public void modificarEstudiante(String arreglo[])
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(arreglo[0]))
            {
                arrayEstudiantes.get(contador).setNombrecompleto(arreglo[1]);
                arrayEstudiantes.get(contador).setDireccion(arreglo[2]);
            }
        }
    }
    
    public void eliminarEstudiante(String arreglo[])
    {
        arrayEstudiantes.remove(pos);
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
