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
public class CodigoEnsamblador {
    String cadena_final;
    private static HashMap<String,String> datos;
    public static void main(String[] args) {
        CodigoTresDirecciones x = new CodigoTresDirecciones();
        CodigoEnsamblador x2 = new CodigoEnsamblador(x);
    }
    
    public CodigoEnsamblador(CodigoTresDirecciones linea){
        datos = new HashMap<>();
        datos.put("CARGAR_DIRECCION","/");//
        datos.put("CARGAR_VALOR","MOVE");
        datos.put("SUMAR","ADD");
        datos.put("RESTAR","SUB");
        datos.put("MULTIPLICAR","MUL");
        datos.put("DIVIDIR","DIV");
        datos.put("MODULO","MOD");
        datos.put("OR","OR");
        datos.put("AND","AND");
        datos.put("NOT","NOT");
        datos.put("MAYOR","CMP");
        datos.put("MENOR","CMP");
        datos.put("IGUAL","CMP");
        datos.put("MAYORIGUAL","CMP");
        datos.put("MENORIGUAL","CMP");
        datos.put("DISTINTO","CMP");
        datos.put("ETIQUETA","CMP");//
        datos.put("SALTAR_CONDICION","CMP");//
        datos.put("IMPRIMIR_ENTERO","WRINT");
        datos.put("IMPRIMIR_CADENA","WRSTR");
        datos.put("PONER_CADENA","INSTR ");//
        datos.put("FIN","HALT");  
        
        String cadena = linea.getInstruccion();
 
        if(datos.get(cadena)=="MOVE"){
            cadena_final = datos.get(cadena)+linea.getDireccion1()+",/"+linea.getDireccion2();
        }
        if(datos.get(cadena)=="ADD"){
            System.out.println(datos.get(cadena)+" "+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMove .A,/"+linea.getDireccion3());
        }
        System.out.println(datos.get(cadena_final));
    }
    
    
}


