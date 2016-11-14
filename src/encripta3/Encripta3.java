/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author ian
 */
public class Encripta3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileReader texto, clave;
        BufferedReader bufferTexto, bufferClave;
        String secuencia, pass;
        
       try{
           texto= new FileReader("/home/ian/Escritorio/mensaje"); //args[0]
           clave = new FileReader("/home/ian/Escritorio/clave"); //args[1]
           bufferTexto = new BufferedReader(texto);
           bufferClave = new BufferedReader(clave);
           secuencia = bufferTexto.readLine();
           pass = bufferClave.readLine();
           
           tools t = new tools();
           t.codifica(secuencia);
           
           
           
       }catch (FileNotFoundException e) {
           throw new RuntimeException("Error reading file");
        }
       
       
    }
    
}
