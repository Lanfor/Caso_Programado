/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosUsuarios;
import vista.FRM_LogIn;
import vista.FRM_RegistroUsuarios;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author Lanfor
 */
public class Controlador_FRM_LogIn implements ActionListener
{
    FRM_LogIn frm_Ventana_LogIn;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    MetodosUsuarios metodosUsuarios;
    FRM_RegistroUsuarios frm_RegistroUsuarios;
    public Controlador_FRM_LogIn(FRM_VentanaPrincipal frm_VentanaPrincipal, FRM_LogIn frm_Ventana_LogIn, MetodosUsuarios metodosUsuarios,FRM_RegistroUsuarios frm_RegistroUsuarios) 
    {
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        this.frm_Ventana_LogIn=frm_Ventana_LogIn;
        this.metodosUsuarios=metodosUsuarios;
        this.frm_RegistroUsuarios=frm_RegistroUsuarios;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("Aceptar"))
        {
            verificarUsuario();
        }
        if(e.getActionCommand().equalsIgnoreCase("Registrar Usuario"))
        {
            frm_RegistroUsuarios.show();
        }
        if(e.getActionCommand().equalsIgnoreCase("Salir"))
        {
            frm_Ventana_LogIn.dispose();
        }
    }
    
    public void verificarUsuario()
    {
        if(metodosUsuarios.consultarUsuario(frm_Ventana_LogIn.devolverUsuario()) && metodosUsuarios.getArregloInformacion()[1].equals(frm_Ventana_LogIn.devolverContraseña()))
        {
            frm_Ventana_LogIn.mostrarMensaje("Bienvenido(a) al sistema de matriculas\n"+"*******"+metodosUsuarios.getArregloInformacion()[2]+" "+frm_Ventana_LogIn.devolverUsuario()+"*******");
            if(metodosUsuarios.getArregloInformacion()[2].equalsIgnoreCase("Administrador"))
            {
                frm_Ventana_LogIn.soyAdministrador();
                frm_Ventana_LogIn.habitarRegistro();
            }
            else 
            {
                if(metodosUsuarios.getArregloInformacion()[2].equalsIgnoreCase("Usuario"))
                {
                    frm_Ventana_LogIn.soyUsuario();
                    frm_Ventana_LogIn.desabitarRegistro();
                }
                else 
                {
                    if(metodosUsuarios.getArregloInformacion()[2].equalsIgnoreCase("Desarrollador"))
                    {
                        frm_Ventana_LogIn.soyDesarrollador();
                        frm_Ventana_LogIn.habitarRegistro();
                    }   
                }
            }
            frm_Ventana_LogIn.limpiar();
            frm_Ventana_LogIn.dispose();
            frm_VentanaPrincipal.show();
        }
        else
        {
            if(frm_Ventana_LogIn.mostrarMensajeOpcional("El usuario y/o contraseña es incorrecto , deseavolver a intentarlo?")==1)
            {
                frm_Ventana_LogIn.limpiar();
                frm_Ventana_LogIn.dispose();
            }
        }
    }
 
    
    
}
