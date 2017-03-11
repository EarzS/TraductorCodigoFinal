/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;

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
    	/* Todo - Validar la expresion regular de la cadena si es 
    	   codigo de tres direcciones. */

		// Obtencion de los tokens de la cadena
    	String[] tokens = cadena.split("\\s");

    	// Leer el primer token
    	String primerToken = tokens[0];
		/* Acceso la base de datos de traducciones
			y solicito que me retorne la cadena a construir */
		String cadenaTraduccion = traducciones.get(primerToken);
		// En caso de no existir el token indico un error de sintaxis
		if(cadenaTraduccion == null){
			System.out.println("[Traductor.traductor()] Error semantico: " + primerToken + 
			" no es una instruccion de codigo intermedio.");

			return null;
		}

    	// Leer los demas tokens
    		// Verifico en funcion del primer token temporal el comportamiento de
    	 	// las variables
    		// En funcion a su comportamiento, construyo la sentencia

    	// Retorno la cadena final
    }

    /**
     * Lee la cadena y compara el primer token con algun registro existente
     * en la base de datos de comandos.
     */
    public static String traductor2(String cadena){
    	// Obtengo el codigo de tres direcciones.
    	CodigoTresDirecciones codigoTD = new CodigoTresDirecciones(cadena);

    	// Obtengo la traduccion a ensamblador
    	List<CodigoEnsamblador> codigoE = CodigoEnsamblador.get(codigoTD);

    	// Creo la lista de instrucciones en funcion del codigo ensamblador
    	List<String> traduccion = new ArrayList<String>();
    	
    }
}
