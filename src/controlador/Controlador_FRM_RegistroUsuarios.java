/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ConexionBD;
import modelo.MetodosUsuarios;
import vista.FRM_RegistroUsuarios;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author Lanfor
 */
public class Controlador_FRM_RegistroUsuarios implements ActionListener{
    
    MetodosUsuarios metodosUsuarios;
    FRM_RegistroUsuarios frm_RegistroUsuarios;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    public Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    ConexionBD conexionBD;
    public Controlador_FRM_RegistroUsuarios(MetodosUsuarios metodosUsuarios, FRM_RegistroUsuarios frm_RegistroUsuarios, FRM_VentanaPrincipal frm_VentanaPrincipal) {
        this.metodosUsuarios = metodosUsuarios;
        this.frm_RegistroUsuarios = frm_RegistroUsuarios;
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("Registrar"))
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
                    registrarConBD();
                break;
                default:
                    frm_RegistroUsuarios.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
    }
    public void registrarConXML()
    {
        
    }
    public  void registrarConBD()
    { 
        if(controlador_FRM_VentanaPrincipal.vericar.verificarLetras(frm_RegistroUsuarios.devolverInformacion()[0]))
            if(controlador_FRM_VentanaPrincipal.vericar.verificarSimbolo(frm_RegistroUsuarios.getCorreo()))
            {
                if(controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_RegistroUsuarios.getContrasena()))
                {
                        if(!conexionBD.consultarUsuario(frm_RegistroUsuarios.devolverInformacion()[0]))
                        {
                            conexionBD.registrarUsuario(frm_RegistroUsuarios.devolverInformacion());
                            frm_RegistroUsuarios.usuarioNegro();
                            frm_RegistroUsuarios.mostrarMensaje("Usuario registrado con exito");
                            frm_RegistroUsuarios.resetearVentana();
                            frm_RegistroUsuarios.hide();
                            frm_VentanaPrincipal.show();
                         }
                         else
                        {
                            frm_RegistroUsuarios.mostrarMensaje("Este nombre de usuario ya existe");
                            frm_RegistroUsuarios.usuarioRojo();
                        }
                }
                else
                {
                    frm_RegistroUsuarios.mostrarMensaje("Debe digitar una contraseña");
                }
            }
            else
            {
                frm_RegistroUsuarios.mostrarMensaje("El Correo debe contener @ y .");
            }
        else
            frm_RegistroUsuarios.mostrarMensaje("El nombre de usuario debe contener solo letras");
    }//fin del metodo registrar con BD
    
    public void registarConArchivosPlanos()
    {
        if(controlador_FRM_VentanaPrincipal.vericar.verificarLetras(frm_RegistroUsuarios.devolverInformacion()[0]))
            if(!metodosUsuarios.consultarUsuario(frm_RegistroUsuarios.devolverInformacion()[0]))
            {
                metodosUsuarios.agregarUsuario(frm_RegistroUsuarios.devolverInformacion());
                frm_RegistroUsuarios.usuarioNegro();
                frm_RegistroUsuarios.mostrarMensaje("Usuario registrado con exito");
                frm_RegistroUsuarios.resetearVentana();
                frm_RegistroUsuarios.hide();
                frm_VentanaPrincipal.show();
            }
            else
            {
                frm_RegistroUsuarios.mostrarMensaje("Este nombre de usuario ya existe");
                frm_RegistroUsuarios.usuarioRojo();
            }
        else
            frm_RegistroUsuarios.mostrarMensaje("El nombre de usuario debe contener solo letras");
    }
    
}
