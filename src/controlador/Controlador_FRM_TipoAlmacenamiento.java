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
                break;
            case "Cancelar":
                frm_TipoAlmacenamiento.dispose();
                break;
        }
    }
    
}
