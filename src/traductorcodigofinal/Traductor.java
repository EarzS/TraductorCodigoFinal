/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;

import java.util.List;

/**
 * Modulo dedicado a traducir las cadenas de texto ingresadas por el lector
 * de archivos.
 * @author Hector
 */
public class Traductor {
    
    /**
     * Lee la cadena y compara el primer token con algun registro existente
     * en la base de datos de comandos.
     */
    public static String traductor(String cadena){
    	
        // Obtengo el codigo de tres direcciones.
    	CodigoTresDirecciones codigoTD = new CodigoTresDirecciones(cadena);
        
        // Obtengo la traduccion a codigo intermedio.
        CodigoEnsamblador codigoE = new CodigoEnsamblador(codigoTD);
        
        // Retorno la traduccion a codigo ensamblador.
        return codigoE.toString();
    }
}
