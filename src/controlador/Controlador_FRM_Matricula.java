/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatriculas;
import vista.FRM_Matricula;

/**
 *
 * @author Lanfor
 */
public class Controlador_FRM_Matricula implements ActionListener
{
    public FRM_Matricula frm_Matricula;
    MetodosEstudiantes metodosEstudiantes;
    public MetodosCursos metodosCursos;
    public MetodosMatriculas metodosMatriculas;
    boolean verificarEstudiante=false, verificarCurso=false;
    
    public Controlador_FRM_Matricula(FRM_Matricula fRM_Matricula, MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos) {
        this.frm_Matricula = fRM_Matricula;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.metodosMatriculas=new MetodosMatriculas(this, this.metodosCursos,this.metodosEstudiantes);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("ConsultarEstudiante"))
        {
             switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    buscarEstudianteEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("ConsultarCurso"))
        {
            buscarCurso();
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Agregar"))
        {
            frm_Matricula.agregarMatricula();
            inicial();
            frm_Matricula.habililitarFinalizar();
        }
        if(e.getActionCommand().equalsIgnoreCase("Finalizar Matricula"))
        {
            finalizarMatricula();
        }
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {                                                                     
            metodosMatriculas.modificarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada(),frm_Matricula.devolverSigla());
            frm_Matricula.desabilitarBotones();
            frm_Matricula.limpiadoInicial();
            frm_Matricula.colocarCodigo();
        }
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            metodosMatriculas.eliminarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada());
            frm_Matricula.borrarFila();
            frm_Matricula.desabilitarBotones();
        }
        if(e.getActionCommand().equalsIgnoreCase("Consultar"))
        {
            frm_Matricula.resetearVentana();
           if(!metodosMatriculas.consultarMatricula(frm_Matricula.devolverCodigo()))
               frm_Matricula.mostrarMensaje("Código Invalido");
           else
               frm_Matricula.habililitarFinalizar();
        }
    }
    
    
    
    
    
    
    
    public void buscarEstudianteEnArchivosPlanos()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
            System.out.println("Lo encontré");
            frm_Matricula.mostrarInformacionEstudiante(metodosEstudiantes.getArregloInformacion()[0]);
            verificarEstudiante=true;
            habilitarAgregar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_Matricula.resetearGUI();
        }
    }//fin del metodo buscar Estudiante
    
    public void buscarCurso()
    {
        if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
        {
            System.out.println("Lo encontré");
            frm_Matricula.mostrarInformacionCurso(metodosCursos.getArregloInformacion()[0]);
            verificarCurso=true;
            habilitarAgregar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("La Sigla buscada no se encuentra.");
            frm_Matricula.resetearGUI();
        }
    }
    public void habilitarAgregar()
    {
        if(verificarEstudiante && verificarCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
    }
    
    public void finalizarMatricula()
    {
            String arreglo[] = new String [3];
            for (int contador = 0; contador < frm_Matricula.getCantidadFilas(); contador++) 
            {
                arreglo[0]=frm_Matricula.devolverCodigo();
                arreglo[1]=frm_Matricula.devolverDato(contador,1);
                arreglo[2]=frm_Matricula.devolverDato(contador,3);
                metodosMatriculas.agregarMatricula(arreglo);
            }
            frm_Matricula.desabililitarFinalizar();
            frm_Matricula.resetearVentana();
            verificarEstudiante=false;
            frm_Matricula.limpiadoInicial();
            frm_Matricula.colocarCodigo();
    }
    
    public void inicial()
    {
        frm_Matricula.resetearGUI();
        verificarCurso=false;
    }
}