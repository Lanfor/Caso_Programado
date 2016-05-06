/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_TipoAlmacenamiento;

/**
 *
 * @author Lanfor
 */
public class Controlador_FRM_TipoAlmacenamiento implements ActionListener
{
    FRM_TipoAlmacenamiento frm_TipoAlmacenamiento;
    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    public Controlador_FRM_TipoAlmacenamiento(FRM_TipoAlmacenamiento frm_TipoAlmacenamiento,Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal) 
    {
        this.frm_TipoAlmacenamiento=frm_TipoAlmacenamiento;
        this.controlador_FRM_VentanaPrincipal=controlador_FRM_VentanaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        switch(e.getActionCommand())
        {
            case "Aceptar":
//                System.out.println("Aceptar");
                controlador_FRM_VentanaPrincipal.frm_VentanaPrincipal.show();
                    if(frm_TipoAlmacenamiento.selecionArchivoPlano())
                    {
                        controlador_FRM_VentanaPrincipal.setTipoAlmacenamiento("Archivo Plano");
                        controlador_FRM_VentanaPrincipal.metodosUsuarios.cargarArray();
                        if(controlador_FRM_VentanaPrincipal.metodosUsuarios.getTamano()==0)
                            controlador_FRM_VentanaPrincipal.frm_RegistroUsuarios.show();
                        else
                            controlador_FRM_VentanaPrincipal.frm_LogIn.show();
                    }
                    else if(frm_TipoAlmacenamiento.selecionArchivoXML())
                        controlador_FRM_VentanaPrincipal.setTipoAlmacenamiento("Archivo XML");
                    else
                    {
                        controlador_FRM_VentanaPrincipal.setTipoAlmacenamiento("Base de Datos");
                        if(controlador_FRM_VentanaPrincipal.conexionBD.haveUsers())
                        controlador_FRM_VentanaPrincipal.frm_LogIn.show();
                        else
                             controlador_FRM_VentanaPrincipal.frm_RegistroUsuarios.show();
                    }
                frm_TipoAlmacenamiento.dispose();
            break;
//*******************************************************************************************************************************//
            case "Cancelar":
                frm_TipoAlmacenamiento.dispose();
                break;
        }
    }
    
}
