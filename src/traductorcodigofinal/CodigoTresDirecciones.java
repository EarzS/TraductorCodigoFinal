/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    	Pattern p = Pattern.compile("(([A-Z]*_[A-Z]*)|([A-Z]*))\\s([a-z]|[0-9])*,(\\s)*([a-z]|[0-9])*,(\\s)*([a-z]|[0-9])*");
    	Matcher m = p.matcher(cadena);
 		if(!m.matches()){
 			System.out.println("[CodigoTresDirecciones.constructor()] Sintaxis invalida.");
 		}

 		// Tokeniza la cadena
        String tmp = cadena.replaceAll("(,(\\s)*)|(,)", " ");
 		String[] tokens = tmp.split("\\s");
 		
 		// Asigna los elementos a la cadena
 		this.instruccion = tokens[0];
 		this.direccion1  = tokens[1];
 		this.direccion2  = tokens[2];
 		this.direccion3  = tokens[3];
    }

    public void setInstruccion(String instruccion){
    	this.instruccion = instruccion;
    }

    public String getInstruccion(){
		return this.instruccion;
    }

    public void setDireccion1(String direccion1){
    	this.direccion1 = direccion1;
    }

    public String getDireccion1(){
		return this.direccion1;
	}

	public void setDireccion2(String direccion2){
    	this.direccion2 = direccion2;
    }

    public String getDireccion2(){
		return this.direccion2;
	}

	public void setDireccion3(String direccion3){
    	this.direccion3 = direccion3;
    }

    public String getDireccion3(){
		return this.direccion3;
	}

	/**
	 * Retorna el codigo de tres direcciones en el formato:
	 * INSTRUCCION DIRECCION1, DIRECCION2, DIRECCION3
	 */
	public String toString(){
		return instruccion + " " + direccion1 + ", " + direccion2 + ", " + direccion3;
	}
}
