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
        datos.put("NOT","CMP #1"+linea.getDireccion1()+"\nBZ $"+(linea_ensamblador+5)+"\nMOVE #1,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #0,"+linea.getDireccion3());
        datos.put("MAYOR","CMP "+linea.getDireccion2()+","+linea.getDireccion1()+"\nBN $"+(linea_ensamblador+5)+"\nMOVE #O,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #1,"+linea.getDireccion3());
        datos.put("MENOR","CMP "+linea.getDireccion1()+","+linea.getDireccion1()+"\nBN $"+(linea_ensamblador+5)+"\nMOVE #0,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #1,"+linea.getDireccion3());
        datos.put("IGUAL","CMP "+linea.getDireccion1()+","+linea.getDireccion2()+"\nBZ $"+(linea_ensamblador+5)+"\nMOVE #0,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #1,"+linea.getDireccion3());////////
        datos.put("MAYORIGUAL","CMP "+linea.getDireccion1()+","+linea.getDireccion2()+"\nBN $"+(linea_ensamblador+5)+"\nMOVE #1,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #0,"+linea.getDireccion3());
        datos.put("MENORIGUAL","CMP "+linea.getDireccion2()+","+linea.getDireccion1()+"\nBN $"+(linea_ensamblador+5)+"\nMOVE #1,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #0,"+linea.getDireccion3());
        datos.put("DISTINTO","CMP  "+linea.getDireccion1()+","+linea.getDireccion2()+"\nBZ $"+(linea_ensamblador+5)+"\nMOVE #1,"+linea.getDireccion3()+"\nBR $"+(linea_ensamblador+3)+"\nMOVE #0,"+linea.getDireccion3());
        datos.put("ETIQUETA",linea.getDireccion3()+": NOP");
        datos.put("SALTAR_CONDICION","CMP #0,"+linea.getDireccion1()+"\nBZ /"+linea.getDireccion3());
        datos.put("SALTAR_ETIQUETA","BR /"+linea.getDireccion3());
        datos.put("IMPRIMIR_ENTERO","WRINT /"+linea.getDireccion1());
        datos.put("IMPRIMIR_CADENA","WRSTR /"+linea.getDireccion1());
        datos.put("PONER_CADENA",linea.getDireccion3()+": DATA "+linea.getDireccion1());
        datos.put("FIN","HALT");  
        
        String cadena = linea.getInstruccion();
        System.out.println(datos.get(cadena));
        cadena_final = datos.get(cadena);
        
        if("CARGAR_DIRECCION".equals(cadena) || "CARGAR_VALOR".equals(cadena)){
            linea_ensamblador+=1;
        }
        if("SUMAR".equals(cadena) || "RESTAR".equals(cadena)|| "MULTIPLICAR".equals(cadena)|| "DIVIDIR".equals(cadena)
                || "MODULO".equals(cadena) || "OR".equals(cadena) || "AND".equals(cadena) || "SALTAR_CONDICION".equals(cadena)){
            linea_ensamblador+=2;
        }
        if("NOT".equals(cadena) || "MAYOR".equals(cadena) || "MENOR".equals(cadena)|| "IGUAL".equals(cadena)|| "MAYORIGUAL".equals(cadena)
                || "MENORIGUAL".equals(cadena)|| "DISTINTO".equals(cadena) ){
            linea_ensamblador+=5;
        }
        if("ETIQUETA".equals(cadena) ||  "SALTAR_ETIQUETA".equals(cadena)|| "IMPRIMIR_ENTERO".equals(cadena)
                || "PONER_CADENA".equals(cadena)|| "FIN".equals(cadena)){
            linea_ensamblador+=1;
        }

    }

    @Override
    public String toString() {
        return cadena_final;
    }
    public int getCantidad() {
        return linea_ensamblador;
    }   
    
}


