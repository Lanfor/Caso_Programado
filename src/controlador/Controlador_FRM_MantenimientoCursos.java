/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos, MetodosCursos metodosCursos)
    {
        this.frm_MantenimientoCursos = frm_MantenimientoCursos;
        this.metodosCursos = metodosCursos;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
           metodosCursos.agregarCursos(frm_MantenimientoCursos.devolverInformacion());
           frm_MantenimientoCursos.mostrarMensaje("El estudiante fue registrado de forma correcta");
           frm_MantenimientoCursos.resetearGUI();
        }
        
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        
        if(evento.getActionCommand().equals("Modificar"))
        {
            metodosCursos.modificarEstudiante(frm_MantenimientoCursos.devolverInformacion());
            frm_MantenimientoCursos.resetearGUI();
        }
        
        if(evento.getActionCommand().equals("Eliminar"))
        {
            metodosCursos.eliminarEstudiante();
            frm_MantenimientoCursos.resetearGUI();
        }
        
    }
    
    
    public void buscar()
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
    }
}
