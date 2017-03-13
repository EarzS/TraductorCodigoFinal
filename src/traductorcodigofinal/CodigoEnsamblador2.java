/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Victor
 */
public class CodigoEnsamblador2 {

	public static int DIRECCION = 0;
	public static int VALOR = 1;
	public static int ACUMULADOR = 2;
	public static int ETIQUETA = 3;

	ArrayList<CodigoEnsamblador2> codigos;

	static{
		codigos = new ArrayList();
		codigos.add(new CodigoEnsamblador2("MOVE", DIRECCION, DIRECCION));
		codigos.add(new CodigoEnsamblador2("MOVE", VALOR, DIRECCION));

		codigos.add(new CodigoEnsamblador2("ADD", DIRECCION, DIRECCION));
		codigos.add(new CodigoEnsamblador2("MUL", DIRECCION, DIRECCION));
		codigos.add(new CodigoEnsamblador2("DIV", DIRECCION, DIRECCION));
		codigos.add(new CodigoEnsamblador2("MOD", DIRECCION, DIRECCION));
		
		codigos.add(new CodigoEnsamblador2("MOVE", ACUMULADOR, DIRECCION));

		codigos.add(new CodigoEnsamblador2("MOVE", DIRECCION, DIRECCION));
	}

    private String instruccion;

    private int operador1;
    private int operador2;

    public CodigoEnsamblador2(String instruccion, int operador1, int operador2){
    	this.instruccion = instruccion;
    	this.operador1 = operador1;
    	this.operador2 = operador2;
    }

    public static ArrayList<CodigoEnsamblador2> getCodigoEnsamblador(CodigoTresDirecciones codigoTD){

    }
}
