/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductorcodigofinal;
import java.io.*;
/**
 *
 * @author Victor
 */
public class TraductorCodigoFinal {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){
        // TODO code application logic here
            leer("C:\\Users\\Victor\\Desktop\\Codigo de tres direcciones.ci");
            
    }
    
    public static void leer(String archivo){
        
        try{
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            escribir("C:\\Users\\Victor\\Desktop\\ens2001.ens",b);
            b.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        };

    }
    
    public static void escribir(String archivo,BufferedReader b){
        File f;
        Traductor t = new Traductor();
        f = new File(archivo);
        int contador = 0;
        try{
           String cadena;
           FileWriter w = new FileWriter(f);
           BufferedWriter bw = new BufferedWriter(w);
           PrintWriter wr = new PrintWriter(bw);
          
           while((cadena = b.readLine())!=null) {
                wr.write(t.traductor(cadena,contador));
           }

           wr.close();
           bw.close();
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        };

    }


}
