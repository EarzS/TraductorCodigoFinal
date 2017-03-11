/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;

/**
 * Representacion del codigo de tres direcciones, el cual posee una etiqueta
 * identificadora, y tres direcciones.
 * 
 * El codigo de tres direcciones viene de la forma: 
 * instruccion direccion1, direccion2, direccion3
 * 
 * Es importante señalar la importancia del orden en el que se agregue las direcciones.
 * 
 * @author Hector
 */
public class CodigoTresDirecciones {
    
    /**
     * Instruccion de codigo intermedio.
     */
    private String instruccion;

    /**
     * Primer direccion.
     */
    private String direccion1;

    /**
     * Segunda direccion.
     */
    private String direccion2;

    /**
     * Tercera direccion.
     */
    private String direccion3;

    /**
     * Constructor default.
     */
    public CodigoTresDirecciones(){
    	this.instruccion = "CARGAR_VALOR";
    	this.direccion1  = "15";
    	this.direccion2	 = "null";
    	this.direccion3  = "10000";
    }

    /**
     * Constructor personalizado, donde validara el lexico y la sintaxis de la
     * cadena, la semantica sera verificada desde el traductor.
     */
    public CodigoTresDirecciones(String cadena){
    	// Validar la expresion regular.
    	Pattern p = Pattern.compile("(([A-Z]*_[A-Z]*)|([A-Z]*))\s([a-z]|[0-9])*,([a-z]|[0-9])*,([a-z]|[0-9])*");
    	Matcher m = p.matcher(cadena);
 		if(!m.matches()){
 			System.out.println("[CodigoTresDirecciones.constructor()] Sintaxis invalida.");
 		}

 		// 
    }
}
