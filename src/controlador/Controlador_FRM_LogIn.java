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
import modelo.Metodos_XML_Usuarios;
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
            switch(frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    verificarUsuarioConArchivoPlano();
                break;
                case "Archivo XML":
                    verificarConXML();
                break;
                case "Base de Datos":
                    verificarConBD();
                break;
                default:
                    frm_RegistroUsuarios.mostrarMensaje("Error 407 ha fallado el sistema");
            }
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
    public void verificarConBD()
    {
        ConexionBD conexionBD=frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.conexionBD;
        if(frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverUsuario()) && frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverContraseña()))
        {
            if(conexionBD.consultarUsuario(frm_Ventana_LogIn.devolverUsuario()) && conexionBD.getArregloUsuario()[1].equals(frm_Ventana_LogIn.devolverContraseña()))
            {
                frm_Ventana_LogIn.mostrarMensaje("Bienvenido(a) al sistema de matriculas\n"+"* + * + * + * + * + * + * + "+conexionBD.getArregloUsuario()[2]+" "+frm_Ventana_LogIn.devolverUsuario()+" * + * + * + * + * + * + * +");
                
                switch(conexionBD.getArregloUsuario()[2])
                {
                    case "Administrador":
                        frm_Ventana_LogIn.soyAdministrador();
                        frm_Ventana_LogIn.habitarRegistro();
                        break;
                    case "Usuario":
                        frm_Ventana_LogIn.soyUsuario();
                        frm_Ventana_LogIn.desabitarRegistro();
                        break;
                    case "Desarrollador":
                        frm_Ventana_LogIn.soyDesarrollador();
                        frm_Ventana_LogIn.habitarRegistro();
                    break;
                    default:
                        frm_Ventana_LogIn.mostrarMensaje("No se encontró el tipo de este usuario");
                        break;
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
        else
            frm_Ventana_LogIn.mostrarMensaje("Debes digitar un nombre de usuario y una conotraseña para poder ingresar");
    }
    public void verificarConXML()
    {
        Metodos_XML_Usuarios metodos_XML_Usuarios=frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.metodos_XML_Usuarios;
        //NO encuentra el usuario con XML
        if(frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverUsuario()) && frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverContraseña()))
        {
            if(metodos_XML_Usuarios.consultarInformacionDelXml(frm_Ventana_LogIn.devolverUsuario()) && metodos_XML_Usuarios.getArregloInformacion()[2].equalsIgnoreCase(frm_Ventana_LogIn.devolverContraseña()))
            {
                frm_Ventana_LogIn.mostrarMensaje("Bienvenido(a) al sistema de matriculas\n"+"* + * + * + * + * + * + * + "+metodos_XML_Usuarios.getArregloInformacion()[3]+" "+frm_Ventana_LogIn.devolverUsuario()+" * + * + * + * + * + * + * +");
                if(metodos_XML_Usuarios.getArregloInformacion()[3].equalsIgnoreCase("Administrador"))
                {
                    frm_Ventana_LogIn.soyAdministrador();
                    frm_Ventana_LogIn.habitarRegistro();
                }
                else 
                {
                    if(metodos_XML_Usuarios.getArregloInformacion()[3].equalsIgnoreCase("Usuario"))
                    {
                        frm_Ventana_LogIn.soyUsuario();
                        frm_Ventana_LogIn.desabitarRegistro();
                    }
                    else 
                    {
                        if(metodos_XML_Usuarios.getArregloInformacion()[3].equalsIgnoreCase("Desarrollador"))
                        {
                            frm_Ventana_LogIn.soyDesarrollador();
                            frm_Ventana_LogIn.habitarRegistro();
                        }
                        else
                        {
                            frm_Ventana_LogIn.mostrarMensaje("No se encontró el tipo de este usuario");
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
        else
            frm_Ventana_LogIn.mostrarMensaje("Debes digitar un nombre de usuario y una conotraseña para poder ingresar");
    }
    public void verificarUsuarioConArchivoPlano()
    {
        if(frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverUsuario()) && frm_VentanaPrincipal.controlador_FRM_VentanaPrincipal.vericar.verificarVacio(frm_Ventana_LogIn.devolverContraseña()))
        {
            if(metodosUsuarios.consultarUsuario(frm_Ventana_LogIn.devolverUsuario()) && metodosUsuarios.getArregloInformacion()[1].equals(frm_Ventana_LogIn.devolverContraseña()))
            {
                frm_Ventana_LogIn.mostrarMensaje("Bienvenido(a) al sistema de matriculas\n"+"* + * + * + * + * + * + * + "+metodosUsuarios.getArregloInformacion()[2]+" "+frm_Ventana_LogIn.devolverUsuario()+" * + * + * + * + * + * + * +");
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
                        else
                            frm_Ventana_LogIn.mostrarMensaje("No se encontró el tipo de este usuario");
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
        else
            frm_Ventana_LogIn.mostrarMensaje("Debes digitar un nombre de usuario y una conotraseña para poder ingresar");
    }
}
