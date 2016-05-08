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
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatriculas;
import modelo.Metodos_XML_Cursos;
import modelo.Metodos_XML_Estudiantes;
import modelo.Metodos_XML_Matricula;
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
    public Controlador_FRM_VentanaPrincipal controlador_Principal;
    
    public Controlador_FRM_Matricula(FRM_Matricula fRM_Matricula, MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos,Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal) 
    {
        this.frm_Matricula = fRM_Matricula;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.metodosMatriculas=new MetodosMatriculas(this, this.metodosCursos,this.metodosEstudiantes);
        this.controlador_Principal=controlador_FRM_VentanaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equalsIgnoreCase("ConsultarEstudiante"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    buscarEstudianteEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    buscarEstudianteEnBD();
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
//***************************************************************************************************************//
        if(e.getActionCommand().equalsIgnoreCase("ConsultarCurso"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    buscarCursoEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    buscarCursoEnBD();
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
            
        }
//*************************************************************************************************************************//
        if(e.getActionCommand().equalsIgnoreCase("Agregar"))
        {
             agregarmatricula();
            
        }
//***************************************************************************************************************************//
        if(e.getActionCommand().equalsIgnoreCase("Finalizar Matricula"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                   finalizarMatriculaEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    finalizarMatriculaEnBD();
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
//******************************************************************************************************************************//
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {      
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    modificarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    modificarEnBD();
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
//**********************************************************************************************************************************//
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            switch(controlador_Principal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    eliminarEnArchivosPlanos();
                break;
                
                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                    eliminarEnBD();
                break;
                default:
                    frm_Matricula.mostrarMensaje("Error 407 ha fallado el sistema");
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Consultar"))
        {
            //WE NEED THIS METHOD FOR ALL TIPES FILES
            frm_Matricula.resetearVentana();
           if(!metodosMatriculas.consultarMatricula(frm_Matricula.devolverCodigo()))
               frm_Matricula.mostrarMensaje("Código Invalido");
           else
               frm_Matricula.habililitarFinalizar();
        }
    }
    
    
    
 //****************************************METODOS ARCHIVOS PLANOS*************************************   
    
    public void buscarEstudianteEnArchivosPlanos()
    {
        if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
        {
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
    
    public void buscarCursoEnArchivosPlanos()
    {
        if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
        {
            frm_Matricula.mostrarInformacionCurso(metodosCursos.getArregloInformacion()[0]);
            verificarCurso=true;
            habilitarAgregar();
        }
        else
        {
            frm_Matricula.mostrarMensaje("La Sigla buscada no se encuentra en los archivos planos");
            frm_Matricula.resetearGUI();
        }
    }//fin del metodo buscar curso en archivo Planos
    
    public void modificarEnArchivosPlanos()
    {
                                                               //L sigla vieja del curso se cambia por la nueva
        metodosMatriculas.modificarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada(),frm_Matricula.devolverSigla());
            frm_Matricula.desabilitarBotones();
            frm_Matricula.limpiadoInicial();
            frm_Matricula.colocarCodigo();
    }//fin del metodo modificar en archivos planos
    
    public void eliminarEnArchivosPlanos()
    {
        metodosMatriculas.eliminarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada());
        frm_Matricula.borrarFila();
        frm_Matricula.desabilitarBotones();
    }//metodo de eliminar en archivos planos
    
    public void habilitarAgregar()
    {
        if(verificarEstudiante && verificarCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
    }
    
    public void agregarmatricula()
    {
        frm_Matricula.agregarMatricula();
        inicial();
        frm_Matricula.habililitarFinalizar();
        
    }//agrega la informacion a la tabla
  
    
    public void finalizarMatriculaEnArchivosPlanos()
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
    
    
    //**************************************METODOS BASE DE DATOS***********************************
    
    
    public void buscarEstudianteEnBD()
    {
        ConexionBD conexionBD=controlador_Principal.conexionBD;
        
        if(controlador_Principal.vericar.verificarVacio(frm_Matricula.devolverCedula()) && controlador_Principal.vericar.verificarNumero(frm_Matricula.devolverCedula()))
        {
            if(conexionBD.consultarEstudiante(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacionEstudiante(conexionBD.getArregloEstudiantes()[0]);
                verificarEstudiante=true;
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra en la Base de datos");
                frm_Matricula.resetearGUI();
            }
        }
        else
        frm_Matricula.mostrarMensaje("Debe digitar un número de cédula que contenga solo numeros");
    }//fin del metodo buscar Estudiante
    
    public void buscarCursoEnBD()
    {
        ConexionBD conexionBD=controlador_Principal.conexionBD;
        
        if(controlador_Principal.vericar.verificarVacio(frm_Matricula.devolverSigla()))
        {
            if(conexionBD.consultarCurso(frm_Matricula.devolverSigla()))
            {
                frm_Matricula.mostrarInformacionCurso(conexionBD.getArregloCursos()[0]);
                verificarCurso=true;
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra en la Base de Datos");
                frm_Matricula.resetearGUI();
            }
        }
        else
        frm_Matricula.mostrarMensaje("Debe digitar una sigla para buscar en la Base de Datos");
    }//fin del metodo buscar Curso
    
    public void modificarEnBD()
    {
        ConexionBD conexionBD=controlador_Principal.conexionBD;
        //                                                           La sigla vieja del curso se cambia por la nueva
        conexionBD.modificarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada(),frm_Matricula.devolverSigla());
        frm_Matricula.desabilitarBotones();
        frm_Matricula.limpiadoInicial();
        frm_Matricula.colocarCodigo();
    }//fin del metodo modificar en archivos planos
    
    public void eliminarEnBD()
    {
        ConexionBD conexionBD=controlador_Principal.conexionBD;
        conexionBD.eliminarMatricula(frm_Matricula.devolverCodigo(),frm_Matricula.devolverSiglaSeleccionada());
        frm_Matricula.borrarFila();
        frm_Matricula.desabilitarBotones();
    }//metodo de eliminar en archivos planos
    
    public void finalizarMatriculaEnBD()
    {
        ConexionBD conexionBD=controlador_Principal.conexionBD;
        String arreglo[] = new String [4];
            for (int contador = 0; contador < frm_Matricula.getCantidadFilas(); contador++) 
            {
                arreglo[0]=frm_Matricula.devolverCodigo();
                arreglo[1]=frm_Matricula.devolverDato(contador,1);
                arreglo[2]=frm_Matricula.devolverDato(contador, 2);
                arreglo[3]=frm_Matricula.devolverDato(contador,3);
                if(!conexionBD.consultarMatricula(arreglo[0],arreglo[3]))
                    conexionBD.registrarMatricula(arreglo);
            }
            frm_Matricula.desabililitarFinalizar();
            frm_Matricula.resetearVentana();
            verificarEstudiante=false;
            frm_Matricula.limpiadoInicial();
            frm_Matricula.colocarCodigo();
    }
    
    //***************************************METODOS ARCHIVOS XML************************************
    
    public void buscarEstudianteEnXML()
    {
        Metodos_XML_Estudiantes metodos_XML_Estudiantes=controlador_Principal.metodos_XML_Estudiantes;
        if(controlador_Principal.vericar.verificarVacio(frm_Matricula.devolverCedula()) && controlador_Principal.vericar.verificarNumero(frm_Matricula.devolverCedula()))
        {
            if(metodos_XML_Estudiantes.consultarInformacionDelXml(frm_Matricula.devolverCedula()))
            {
                frm_Matricula.mostrarInformacionEstudiante(metodos_XML_Estudiantes.getArregloInformacion()[1]);
                verificarEstudiante=true;
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La cédula buscada no se encuentra en Archivos XML");
                frm_Matricula.resetearGUI();
            }
        }
        else
        frm_Matricula.mostrarMensaje("Debe digitar un número de cédula que contenga solo numeros");
    }//fin del metodo buscar Estudiante
    
    public void buscarCursoEnXML()
    {
        Metodos_XML_Cursos metodos_XML_Cursos=controlador_Principal.metodos_XML_Cursos;
        
        if(controlador_Principal.vericar.verificarVacio(frm_Matricula.devolverSigla()))
        {
            if(metodos_XML_Cursos.consultarInformacionDelXml(frm_Matricula.devolverSigla()))
            {
                frm_Matricula.mostrarInformacionCurso(metodos_XML_Cursos.getArregloInformacion()[1]);
                verificarCurso=true;
                habilitarAgregar();
            }
            else
            {
                frm_Matricula.mostrarMensaje("La sigla buscada no se encuentra en la Base de Datos");
                frm_Matricula.resetearGUI();
            }
        }
        else
        frm_Matricula.mostrarMensaje("Debe digitar una sigla para buscar en la Base de Datos");
    }//fin del metodo buscar Curso
    
    public void modificarEnXML()
    {
        Metodos_XML_Matricula metodos_XML_Matricula=controlador_Principal.metodos_XML_Matricula;
        metodos_XML_Matricula.modificarInformacionDelXml(frm_Matricula.devolverInformacion());
        frm_Matricula.desabilitarBotones();
        frm_Matricula.limpiadoInicial();
        frm_Matricula.colocarCodigo();
    }//fin del metodo modificar en archivos planos
    
    public void eliminarEnXML()
    {
        Metodos_XML_Matricula metodos_XML_Matricula=controlador_Principal.metodos_XML_Matricula;
        metodos_XML_Matricula.eliminarInformacionDelXml(frm_Matricula.devolverCodigo());
        frm_Matricula.borrarFila();
        frm_Matricula.desabilitarBotones();
    }//metodo de eliminar en archivos planos
    
    public void finalizarMatriculaEnXML()
    {
        Metodos_XML_Matricula metodos_XML_Matricula=controlador_Principal.metodos_XML_Matricula;
        String arreglo[] = new String [4];
            for (int contador = 0; contador < frm_Matricula.getCantidadFilas(); contador++) 
            {
                arreglo[0]=frm_Matricula.devolverCodigo();
                arreglo[1]=frm_Matricula.devolverDato(contador,1);
                arreglo[2]=frm_Matricula.devolverDato(contador, 2);
                arreglo[3]=frm_Matricula.devolverDato(contador,3);
                if(!metodos_XML_Matricula.consultarInformacionDelXml(arreglo[0],  arreglo[3]))
                    metodos_XML_Matricula.guardarEnXML(arreglo);
            }
            frm_Matricula.desabililitarFinalizar();
            frm_Matricula.resetearVentana();
            verificarEstudiante=false;
            frm_Matricula.limpiadoInicial();
            frm_Matricula.colocarCodigo();
    }
}//FIN DE LA CLASE CONTROLADOR_FRM_MATRICULA
