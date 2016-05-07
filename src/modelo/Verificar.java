/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author AA_17
 */
public class Verificar 
{
    
    
    public boolean verificarNumero(String texto)//metodo que sirve para verificar si en el txt existe un #
    {
        boolean esNumero = true;
        for (int i = 0; i < texto.length(); i++)
        {
            if(!Character.isDigit(texto.charAt(i)))
            {
                esNumero = false;
                break;
            }
        }
        return esNumero;
    }
    
    public boolean verificarSimbolo(String texto)
    {
        if(texto.contains("@") && texto.contains("."))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean verificarLetras(String texto)
    {
        boolean esLetra = true;
        for (int i = 0; i < texto.length(); i++)
        {
            if(!Character.isLetter(texto.charAt(i)))
            {
                esLetra = false;
            }
        }
        return esLetra;
    }
    
    public boolean verificarLetrasYEspacios(String texto)
    {
        boolean esLetra = true;
        for (int i = 0; i < texto.length(); i++)
        {
            if(!Character.isLetter(texto.charAt(i)) && !texto.contains(" "))
            {
                esLetra = false;
            }
        }
        return esLetra;
    }
    
    public boolean verificarVacio(String texto)
    {
        return !texto.equalsIgnoreCase("");//si el texto esta vacio devuelve falso
    }
}
