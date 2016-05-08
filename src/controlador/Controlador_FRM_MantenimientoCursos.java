/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import modelo.MetodosCursos;
import vista.FRM_MantenimientoCursos;

/**
 *
 * @author administrador
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener
{
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    MetodosCursos metodosCursos;
    public Controlador_FRM_VentanaPrincipal controlador_Principal;
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos, MetodosCursos metodosCursos)
    {
        this.frm_MantenimientoCursos = frm_MantenimientoCursos;
        this.metodosCursos = metodosCursos;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    registrarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    registarConBD();
                break;
                default:
                    frm_MantenimientoCursos.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    buscarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    buscarEnBD();
                break;
                default:
                    frm_MantenimientoCursos.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
        if(evento.getActionCommand().equals("Modificar"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    modificarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    modificarEnBD();
                break;
                default:
                    frm_MantenimientoCursos.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
        if(evento.getActionCommand().equals("Eliminar"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    eliminarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    eliminarEnBD();
                break;
                default:
                    frm_MantenimientoCursos.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
    }
    
    public void registrarEnArchivosPlanos()
    {
        if(controlador_Principal.vericar.verificarVacio(frm_MantenimientoCursos.devolverSigla()))
        {
            metodosCursos.agregarCursos(frm_MantenimientoCursos.devolverInformacion());
           frm_MantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta");
           frm_MantenimientoCursos.resetearGUI(); 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El campo de sigla tiene que estar lleno");
        }
          
    }//fin del metodo agregar en Archivos Planos
    
     public void registarConBD()
    {
         if(controlador_Principal.vericar.verificarVacio(frm_MantenimientoCursos.devolverSigla()))
        {
            controlador_Principal.conexionBD.registrarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("Usuario registrado con exito");
            frm_MantenimientoCursos.resetearGUI();   
        }
         else
         {
            JOptionPane.showMessageDialog(null, "El campo de sigla tiene que estar lleno");
         }
    }//fin del metodo agregar con BD
    
    public void buscarEnArchivosPlanos()
    {
        
        if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoCursos.mostrarMensajeVerificacion("La cédula buscada no se encuentra, Desea agregarlo?.");
                if(valor==0)
                frm_MantenimientoCursos.habilitarAgregar();
                else
                frm_MantenimientoCursos.resetearGUI();
            }
    }//fin del metodo buscar en archivos Planos
    
    public void buscarEnBD()
    {
        
            if(controlador_Principal.conexionBD.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(controlador_Principal.conexionBD.getArregloCursos());
                frm_MantenimientoCursos.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoCursos.mostrarMensajeVerificacion("La Sigla buscada no se encuentra, Desea agregarlo?.");
                if(valor==0)
                frm_MantenimientoCursos.habilitarAgregar();
                else
                frm_MantenimientoCursos.resetearGUI();
            }
        }//fin del metodo buscar en BD
    
    public void modificarEnArchivosPlanos()
    {
        metodosCursos.modificarEstudiante(frm_MantenimientoCursos.devolverInformacion());
        frm_MantenimientoCursos.resetearGUI();
    }//fin del metodo modificar en Archivos Planos
    
    public void modificarEnBD()
    {
            controlador_Principal.conexionBD.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El Curso fue modificado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
    }//fin del metodo modificar en BD
      
    public void eliminarEnArchivosPlanos()
    {
        metodosCursos.eliminarEstudiante();
        frm_MantenimientoCursos.resetearGUI();
    }//fin del metodo eliminar en archivos planos
    
    public void eliminarEnBD()
    {
            controlador_Principal.conexionBD.eliminarCurso(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.mostrarMensaje("El Curso fue eliminado de forma correcta.");
            frm_MantenimientoCursos.resetearGUI();
    }
    
    
    
}//fin de la clase Controlador_FRM_MantenimientoCursos
