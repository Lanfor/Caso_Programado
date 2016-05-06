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
    
    public Verificar()
    {
    // String texto = "          2   5       ";
//        int numero = Integer.parseInt(texto.replaceAll(" ", "").trim());
//        System.out.print("El numero se convirtio bien y es: " +numero);
        //trim para quitar los espacios del texto
        
//        if(verificarNumero("1234567890"))
//        {
//            System.out.println("Solo contiene numero");
//        }
//        
//        else
//        {
//            System.out.println("Contiene letras");
//        }
        
//        if(verificarSimbolo("hola@hola.com", "@"))
//        {
//            System.out.println("Contiene arroba");
//        }
//        else
//        {
//            System.out.println("No Contiene arroba");
//        }
        
        /*if(verificarLetras("tome"))
        {
            System.out.println("Solo contiene Letras");
        }
        
        else
        {
            System.out.println("No contiene letras");
        }*/
    }
    
    public boolean verificarNumero(String texto)//metodo que sirve para verificar si en el txt existe un #
    {
        boolean esNumero = false;
        for (int i = 0; i < texto.length(); i++)
        {
            if(Character.isDigit(texto.charAt(i)))
            {
                esNumero = true;
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
    
}
