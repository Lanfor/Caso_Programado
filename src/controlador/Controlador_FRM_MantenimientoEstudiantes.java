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
    public Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    
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
                    registrarConArhivosXML();
                break;
                case "Base de Datos":
                    registarConBD();
                break;
                default:
                    frm_MantenimientoEstudiantes.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }//fin del action command agregar
        
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {
            switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    buscarArchivosPlanos();
                break;

                case "Archivo XML":
                    buscarEnArchivosXML();
                break;
                case "Base de Datos":
                      buscarEnBD();
                break;
                default:
                    frm_MantenimientoEstudiantes.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }//fin del actionCommand Consultar
        
        if(e.getActionCommand().equals("Modificar"))
        {
            switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    modificarArchivosPlanos();
                break;

                case "Archivo XML":
                    modificarEnArchivosXML();
                break;
                case "Base de Datos":
                     modificarEnBD();
                break;
                default:
                    frm_MantenimientoEstudiantes.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }//fin del ActionCommand Modificar
        
        if(e.getActionCommand().equals("Eliminar"))
        {
            switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    eliminarEnArchivosPlanos();
                break;

                case "Archivo XML":
                    eliminarEnArhivosXML();
                break;
                case "Base de Datos":
                     eliminarEnBD();
                break;
                default:
                    frm_MantenimientoEstudiantes.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }//fin del action command Eliminar
    }//fin del
    
//******************************************INICIO DE LOS METODOS**********************************
    
    
    //**********************************************METODOS DE BUSCAR***************************
    public void buscarArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            if(metodosEstudiantes.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoEstudiantes.mostrarMensajeVerificacion("La cédula buscada no se encuentra, Desea agregarlo?.");
                if(valor==0)
                frm_MantenimientoEstudiantes.habilitarAgregar();
                else
                frm_MantenimientoEstudiantes.resetearGUI();
            }
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener numeros");
        }
    }//fin del metodo buscar en archivos planos 
    
    
    public void buscarEnArchivosXML()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            if(controlador_FRM_VentanaPrincipal.metodos_XML_Estudiantes.consultarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoEstudiantes.mostrarMensajeVerificacion("La cédula buscada no se encuentra, Desea agregarlo?.");
                if(valor==0)
                frm_MantenimientoEstudiantes.habilitarAgregar();
                else
                frm_MantenimientoEstudiantes.resetearGUI();
            }
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener numeros");
        }
    }//fin del metodo buscar en archivos XML
    
    
    public void buscarEnBD()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            if(controlador_FRM_VentanaPrincipal.conexionBD.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
            {
                frm_MantenimientoEstudiantes.mostrarInformacion(controlador_FRM_VentanaPrincipal.conexionBD.getArregloEstudiantes());
                frm_MantenimientoEstudiantes.habilitarEdicion();
            }
            else
            {
                int valor=frm_MantenimientoEstudiantes.mostrarMensajeVerificacion("La cédula buscada no se encuentra, Desea agregarlo?.");
                if(valor==0)
                frm_MantenimientoEstudiantes.habilitarAgregar();
                else
                frm_MantenimientoEstudiantes.resetearGUI();
            }
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener numeros");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    } //fin del metodo buscar en BD
    
    
    
    //********************************************METODOS DE REGISTRAR*******************************
    public void registarConArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarLetrasYEspacios(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    if(controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_MantenimientoEstudiantes.devolverInformacion()[2]))
                    {
                            metodosEstudiantes.agregarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                            frm_MantenimientoEstudiantes.mostrarMensaje("Estudiante registrado con exito, en archivos planos");
                            frm_MantenimientoEstudiantes.resetearGUI();   
                    }
                    else
                    {
                        
                        frm_MantenimientoEstudiantes.mostrarMensaje("Debe digitar una direccion");
                    }
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre debe contener solo letras"); 
                }         
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula solo puede contener numeros"); 
        }
    }//fin del metodo agregar con archivos planos
    
    public void registrarConArhivosXML()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarLetrasYEspacios(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    if(controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_MantenimientoEstudiantes.devolverInformacion()[2]))
                    {
                            controlador_FRM_VentanaPrincipal.metodos_XML_Estudiantes.guardarEnXML(frm_MantenimientoEstudiantes.devolverInformacion());
                            frm_MantenimientoEstudiantes.mostrarMensaje("Estudiante registrado con exito, en archivos planos");
                            frm_MantenimientoEstudiantes.resetearGUI();   
                    }
                    else
                    {
                        
                        frm_MantenimientoEstudiantes.mostrarMensaje("Debe digitar una direccion");
                    }
                }
                else
                {
                    frm_MantenimientoEstudiantes.mostrarMensaje("El nombre debe contener solo letras"); 
                }         
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula solo puede contener numeros"); 
        }
    }//fin del metodo registrar con arhivos XML
    
    
    public void registarConBD()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarLetrasYEspacios(frm_MantenimientoEstudiantes.devolverInformacion()[1]))
                {
                    if(controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_MantenimientoEstudiantes.devolverInformacion()[2]))
                    {
                            controlador_FRM_VentanaPrincipal.conexionBD.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
                            frm_MantenimientoEstudiantes.mostrarMensaje("Estudiante registrado con exito, en la Base de Datos");
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
    
    //************************************* METODOS DE MODIFICAR **************************************
    
    public void modificarArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            metodosEstudiantes.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta, en los Arhivos Planos.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
               
    }//fin del metodo modificar en archivos planos
    
    
    public void modificarEnArchivosXML()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            controlador_FRM_VentanaPrincipal.metodos_XML_Estudiantes.modificarInformacionDelXml(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta, en los Arhivos Planos.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
    }
    
    
    public void modificarEnBD()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            controlador_FRM_VentanaPrincipal.conexionBD.modificarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta, en la Base de Datos.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
    }//fin del metodo modificar en BD
    
    
    //************************************** METODOS DE ELIMINAR *********************************
    public void eliminarEnArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            metodosEstudiantes.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
    }//fin del metodo eliminar en Archivos Planos
    
    public void eliminarEnArhivosXML()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            controlador_FRM_VentanaPrincipal.metodos_XML_Estudiantes.eliminarInformacionDelXml(frm_MantenimientoEstudiantes.devolverCedula());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
    }
    
    public void eliminarEnBD()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarNumero(frm_MantenimientoEstudiantes.devolverCedula()))
        {
            controlador_FRM_VentanaPrincipal.conexionBD.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        else
        {
            frm_MantenimientoEstudiantes.mostrarMensaje("La cedula digitada solo debe contener");
        }
    }//fin de la clase eliminar en BD
    
}//fin de la clase controlador FRM_MantenimeientoEstudiantes
