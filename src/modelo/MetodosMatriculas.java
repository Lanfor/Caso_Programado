/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Controlador_FRM_Matricula;
import java.util.ArrayList;

/**
 *
 * @author Lanfor
 */
public class MetodosMatriculas 
{
    private ArrayList <Matricula> arrayMatricula;
    Controlador_FRM_Matricula controlador;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    String arregloInformacionConsultada[]=new String[4];
    ArchivosMatriculas archivosMatriculas;
    int pos;
    public MetodosMatriculas(Controlador_FRM_Matricula controlador, MetodosCursos metodosCursos, MetodosEstudiantes metodosEstudiantes)
    {
        arrayMatricula=new ArrayList <Matricula>();
        this.controlador=controlador;
        this.metodosCursos=metodosCursos;
        this.metodosEstudiantes=metodosEstudiantes;
        archivosMatriculas=new ArchivosMatriculas();
        arrayMatricula=archivosMatriculas.leerInformacionCompleta();
    }
    
    public void escribirSobreArchivo()
    {
        archivosMatriculas.crearArchivo();
        for (int i = 0; i < arrayMatricula.size(); i++) 
        {
            archivosMatriculas.escribirInformacionEnElArchivo(arrayMatricula.get(i));
        }
    }
    
    public void agregarMatricula(String informacion[])
    {
        int posicion=0;
        boolean localizado=false;
        Matricula objeto=new Matricula(informacion[0], informacion[1], informacion[2], true);
        for (int i = 0; i < arrayMatricula.size(); i++) 
        {
            if(arrayMatricula.get(i).getCodigo().equalsIgnoreCase(informacion[0]) )
            {
                if(arrayMatricula.get(i).getSigla().equalsIgnoreCase(informacion[2]))
                {
                    localizado=true;
                    break;
                }
                posicion=i+1;
            }
        }
        if(arrayMatricula.size()!=0)
        {
            if(!localizado)
            {
                if(posicion==0)
                arrayMatricula.add(objeto);
                else
                arrayMatricula.add(posicion,objeto);
            }
        }
        else
        {
            arrayMatricula.add(objeto);
        }
    }
    
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador)!=null)
            {
                if(arrayMatricula.get(contador).getCodigo().equals(codigo))
                {   
                    if(arrayMatricula.get(contador).getHabilitacion())//.trim() Elimina espacios vacios
                    {
                        
                            arregloInformacionConsultada[0]=arrayMatricula.get(contador).getCodigo();
                            arregloInformacionConsultada[1]=arrayMatricula.get(contador).getCedula();
                            metodosEstudiantes.consultarEstudiante(arrayMatricula.get(contador).getCedula());
                            arregloInformacionConsultada[2]=metodosEstudiantes.getArregloInformacion()[0];
                            arregloInformacionConsultada[3]=arrayMatricula.get(contador).getSigla();
                            controlador.frm_Matricula.agregarMatricula(arregloInformacionConsultada);
                            existe=true;
                            pos=contador;
                    }
                }
            }
        
        }
        return existe;
    
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            System.out.println(arrayMatricula.get(contador).getInformacion());
        
        }
    
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
    
    public void modificarMatricula(String codigo, String siglaVieja, String nuevaSigla)
    {
        for (int i = 0; i < arrayMatricula.size(); i++) 
        {
            if(arrayMatricula.get(i).getCodigo().equalsIgnoreCase(codigo) && arrayMatricula.get(i).getSigla().equalsIgnoreCase(siglaVieja))
            {   
                arrayMatricula.get(i).setSigla(nuevaSigla);
                System.out.println("Codigo:"+arrayMatricula.get(i).getCodigo()+" Cedula: "+arrayMatricula.get(i).getCedula()+" Sigla: "+arrayMatricula.get(i).getSigla());
            }
        }
    }
    
    public void eliminarMatricula(String codigo, String sigla)
    {
        for (int i = 0; i < arrayMatricula.size(); i++) 
        {
            if(arrayMatricula.get(i).getCodigo().equalsIgnoreCase(codigo) && arrayMatricula.get(i).getSigla().equalsIgnoreCase(sigla))
            {   
                arrayMatricula.get(i).setHabilitacion(false);
            }
        }
    }
    public  String devolverCodigo()
    {
        String codigo="0000";
        
        if(arrayMatricula.size()==0)
        {
           codigo+=1;
        }
        else
        {
            int numero=Integer.parseInt((arrayMatricula.get(arrayMatricula.size()-1).getCodigo()));
            numero++;
            
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        
        return codigo;
    }
}
