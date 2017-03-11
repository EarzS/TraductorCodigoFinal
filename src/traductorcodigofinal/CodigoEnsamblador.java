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
    private String cadena_final;
    private static int linea_ensamblador=0; 
    private static HashMap<String,String> datos;
    
    public CodigoEnsamblador(CodigoTresDirecciones linea){
        datos = new HashMap<>();
        datos.put("CARGAR_DIRECCION","MOVE /"+linea.getDireccion1()+",/"+linea.getDireccion3());//
        datos.put("CARGAR_VALOR","MOVE #"+linea.getDireccion1()+",/"+linea.getDireccion3());
        datos.put("SUMAR","ADD "+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("RESTAR","SUB"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MULTIPLICAR","MUL"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("DIVIDIR","DIV"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MODULO","MOD"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("OR","OR"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("AND","AND"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("NOT","NOT"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MAYOR","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MENOR","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("IGUAL","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MAYORIGUAL","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("MENORIGUAL","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("DISTINTO","CMP"+linea.getDireccion1()+",/"+linea.getDireccion2()+"\nMOVE .A,/"+linea.getDireccion3());
        datos.put("ETIQUETA",linea.getDireccion3()+": NOP");//
        datos.put("SALTAR_CONDICION","BZ /"+linea.getDireccion3());//
        datos.put("SALTAR_ETIQUETA","B /"+linea.getDireccion3());
        datos.put("IMPRIMIR_ENTERO","WRINT");
        datos.put("IMPRIMIR_CADENA","WRSTR");
        datos.put("PONER_CADENA","INSTR ");//
        datos.put("FIN","HALT");  

        String cadena = linea.getInstruccion();
        System.out.println(datos.get(cadena));
        cadena_final = datos.get(cadena);
    }

    @Override
    public String toString() {
        return cadena_final;
    }
    public int getCantidad() {
        return linea_ensamblador;
    }


    
    
    
    
    
}


