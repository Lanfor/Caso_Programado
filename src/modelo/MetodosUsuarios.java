/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lanfor
 */
public class MetodosUsuarios 
{
    
     private ArrayList <Usuario> arrayUsuario;
    
    String[] arregloInformacionConsultada=new String[3];
    ArchivosUsuarios archivosUsuarios;
    int pos;
    public MetodosUsuarios()
    {
        archivosUsuarios=new ArchivosUsuarios();
        arrayUsuario=new ArrayList<Usuario>();
        arrayUsuario=archivosUsuarios.leerInformacionCompleta();            
    }
    
    public void agregarUsuario(String informacion[])
    {
        Usuario objeto=new Usuario(informacion[0], informacion[1], informacion[2], informacion[3]);
        arrayUsuario.add(objeto);
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
           // System.out.println(arrayUsuario.get(contador).getInformacion());
        
        }
    
    }
    
    public boolean consultarUsuario(String nombUsuario)
    {
        boolean existe=false;
        
        //[][][][]
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getNombre().equals(nombUsuario))
            {
                arregloInformacionConsultada[0]=arrayUsuario.get(contador).getCorreo();
                arregloInformacionConsultada[1]=arrayUsuario.get(contador).getContraseña();
                arregloInformacionConsultada[2]=arrayUsuario.get(contador).getTipoUsuario();
                existe=true;
                pos=contador;
            }
        }
        return existe;
    }
    
    public void modificarUsuario(String arreglo[])
    {
        arrayUsuario.get(pos).setCorreo(arreglo[1]);
        arrayUsuario.get(pos).setContraseña(arreglo[2]);
        arrayUsuario.get(pos).setTipoUsuario(arreglo[3]);
            
    }
    public void escribirSobreArchivo()
    {
        archivosUsuarios.crearArchivo();
        for (int i = 0; i < arrayUsuario.size(); i++) 
        {
            archivosUsuarios.escribirInformacionEnElArchivo(arrayUsuario.get(i));
        }
    }
    public int getTamano()
    {
        return arrayUsuario.size();
    }
    public void eliminarUsuario()
    {
        arrayUsuario.remove(pos);
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }  
}
