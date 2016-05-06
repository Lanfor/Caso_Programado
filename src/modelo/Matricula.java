/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Lanfor
 */
public class Matricula implements Serializable
{
    private String codigo, cedula, sigla;
    private boolean habilitacion;

    public Matricula(String codigo, String cedula, String sigla,boolean habilitación) {
        this.codigo = codigo;
        this.cedula = cedula;
        this.sigla = sigla;
        this.habilitacion=habilitación;
    }

    public boolean getHabilitacion() {
        return habilitacion;
    }

    public void setHabilitacion(boolean habilitacion) {
        this.habilitacion = habilitacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

   public String  getInformacion()
   {
       return "Codigo: "+codigo+"\nCedula: "+cedula+"\nSiglas: "+sigla;
   }
    
}
