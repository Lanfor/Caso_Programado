/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosUsuarios;
import vista.FRM_LogIn;
import vista.FRM_MantenimientoCursos;
import vista.FRM_MantenimientoEstudiantes;
import vista.FRM_Matricula;
import vista.FRM_RegistroUsuarios;
import vista.FRM_TipoAlmacenamiento;
import vista.FRM_VentanaPrincipal;

/**
 *
 * @author tecnologiamultimedia
 */


    
public class Controlador_FRM_VentanaPrincipal implements ActionListener
{

    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    
    FRM_MantenimientoCursos frm_MantenimientosCursos;
    FRM_Matricula frm_Matricula;
    public FRM_LogIn frm_LogIn;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    FRM_VentanaPrincipal frm_VentanaPrincipal;
    FRM_TipoAlmacenamiento frm_TipoAlmacenamiento;
    public FRM_RegistroUsuarios frm_RegistroUsuarios;
    String TipoAlmacenamiento="";
    
    public MetodosUsuarios metodosUsuarios;
            
    public Controlador_FRM_VentanaPrincipal(FRM_VentanaPrincipal frm_VentanaPrincipal)
    {
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        metodosEstudiantes=new MetodosEstudiantes();
        metodosCursos=new MetodosCursos();
        frm_MantenimientoEstudiantes= new FRM_MantenimientoEstudiantes(metodosEstudiantes);
        frm_MantenimientosCursos = new FRM_MantenimientoCursos(metodosCursos);
        frm_Matricula=new FRM_Matricula(metodosEstudiantes, metodosCursos);
        
        metodosUsuarios=new MetodosUsuarios();
        frm_RegistroUsuarios=new FRM_RegistroUsuarios(metodosUsuarios, frm_VentanaPrincipal);
        frm_LogIn=new FRM_LogIn(frm_VentanaPrincipal, frm_RegistroUsuarios, metodosUsuarios);
        
        frm_TipoAlmacenamiento=new FRM_TipoAlmacenamiento(this);
    }

    public String getTipoAlmacenamiento() {
        return TipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(String TipoAlmacenamiento) {
        this.TipoAlmacenamiento = TipoAlmacenamiento;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("Salir"))
        {
            System.exit(0);
        }
        if(e.getActionCommand().equalsIgnoreCase("Estudiantes"))
        {
            frm_MantenimientoEstudiantes.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Cursos"))
        {
            frm_MantenimientosCursos.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Matricula"))
        {
            frm_Matricula.show();
        }
        if(e.getActionCommand().equalsIgnoreCase("Login"))
        {
            frm_LogIn.show();
        }
        if(e.getActionCommand().equalsIgnoreCase("Tipo Almacenamiento"))
            frm_TipoAlmacenamiento.show();
    }
    
}