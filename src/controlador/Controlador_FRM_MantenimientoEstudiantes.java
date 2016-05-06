/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import modelo.MetodosEstudiantes;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, MetodosEstudiantes metodosEstudiantes)
    {
        this.metodosEstudiantes=metodosEstudiantes;
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    registarConArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    registarConBD();
                break;
                default:
                    frm_MantenimientoEstudiantes.mostrarMensaje("Error 407 ha fallado el sistema");
            }
            
            
        }
        
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void buscar()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoEstudiantes.mostrarMensajeVerificacion("La cédula buscada no se encuentra, Desea agregarlo?.");
                System.out.println("Me devuelve "+ valor);
                if(valor==0)
                frm_MantenimientoEstudiantes.habilitarAgregar();
                else
                frm_MantenimientoEstudiantes.resetearGUI();
            }
    } 
    
    
    public void registarConArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarLetras(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    if(!controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_MantenimientoEstudiantes.devolverInformacion()[2]))
                    {
                            metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                            frm_MantenimientoEstudiantes.mostrarMensaje("Usuario registrado con exito");
                            frm_MantenimientoEstudiantes.resetearGUI();   
                    }
                    else
                    {
                        
                        frm_MantenimientoEstudiantes.mostrarMensaje("Debe digitar una direccion");
                    }
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre de usuario debe contener solo letras"); 
                }         
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula solo puede contener numeros"); 
        }
    }//fin del metodo agregar con archivos planos
    
    public void registarConBD()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarLetras(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    if(!controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_MantenimientoEstudiantes.devolverInformacion()[2]))
                    {
                            controlador_FRM_VentanaPrincipal.conexionBD.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                            frm_MantenimientoEstudiantes.mostrarMensaje("Usuario registrado con exito");
                            frm_MantenimientoEstudiantes.resetearGUI();   
                    }
                    else
                    {
                        
                        frm_MantenimientoEstudiantes.mostrarMensaje("Debe digitar una direccion");
                    }
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre de usuario debe contener solo letras"); 
                }         
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula solo puede contener numeros"); 
        }
    }//fin del metodo agregar con BD
    
    
    
}
