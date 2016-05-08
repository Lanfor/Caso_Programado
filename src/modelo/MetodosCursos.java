/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author administrador
 */
public class MetodosCursos 
{
    private ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[] = new String [3];
    ArchivosCursos archivosCursos;
    int pos;
    public MetodosCursos()
    {
        arrayCursos = new ArrayList <Cursos>();
        archivosCursos=new ArchivosCursos();
        arrayCursos=archivosCursos.leerInformacionCompleta();
    }
    
    
    public void escribirSobreArchivo()
    {
        archivosCursos.crearArchivo();
        for (int i = 0; i < arrayCursos.size(); i++) 
        {
            archivosCursos.escribirInformacionEnElArchivo(arrayCursos.get(i));
        }
    }
    public void agregarCursos(String informacion[])
    {
        Cursos temporal= new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
        arrayCursos.add(temporal);
        
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            System.out.println(arrayCursos.get(contador).getInformacion());
        
        }
    
    }
    
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayCursos.size();contador++)
        {
            if(arrayCursos.get(contador).getSigla().equals(sigla))
            {
                arregloInformacionConsultada[0]=arrayCursos.get(contador).getNombre();
                arregloInformacionConsultada[1]=""+arrayCursos.get(contador).getCreditos();
                arregloInformacionConsultada[2]=arrayCursos.get(contador).getHorario();
                existe=true;
                pos=contador;
            }
        
        }
        return existe;
    
    }
    
    public void modificarEstudiante(String arreglo[])
    {
                arrayCursos.get(pos).setNombre(arreglo[1]);
                arrayCursos.get(pos).setCreditos(Integer.parseInt(arreglo[2]));
                arrayCursos.get(pos).setHorario(arreglo[3]);
                System.out.println(arrayCursos.get(pos).getNombre()+" "+arrayCursos.get(pos).getCreditos()+" "+arrayCursos.get(pos).getHorario());
          
    }
    
    public void eliminarEstudiante()
    {
                arrayCursos.remove(pos);
            
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    
}
