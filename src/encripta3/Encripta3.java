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
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        FileReader file1, file2;
        BufferedReader bufferTexto, bufferClave;
        String texto, clave;
        String[] Bloques;
        String[] BloquesClave;
        String cadena ="";
        
       try{
           file1= new FileReader("/home/ian/Escritorio/mensaje"); //args[0]
           file2 = new FileReader("/home/ian/Escritorio/clave"); //args[1]
           final int numBloques = 5;
           bufferTexto = new BufferedReader(file1);
           bufferClave = new BufferedReader(file2);
           texto = bufferTexto.readLine();
           clave = bufferClave.readLine();
           int cantidadBloques=0;
           
           tools t = new tools();
           //Obtiene bloques - texto.length/blques+1
           if(texto.length()%numBloques==0){
                cantidadBloques=texto.length()/numBloques;
           }else{
               cantidadBloques=texto.length()/numBloques+1;
           }
           
           int i=1;
           
           System.out.println("Texto original :"+texto);
           System.out.println("Clave original :"+clave);
           System.out.println("texto codificado: "+t.codifica(texto));
           clave=t.ajustaClave(t.codifica(texto),t.codificaASCII(clave));
           
           
           Bloques=t.cortaBlques(numBloques, texto);
           BloquesClave=t.cortaBlques(numBloques, clave);
           
           
           System.out.println("Clave codificada: "+clave);
           while(i<=cantidadBloques){
               texto=Bloques[i];
               clave=BloquesClave[i];
               //mesnaje
                System.out.println("mensaje: "+texto);

                //clave
                System.out.println("clave: "+clave);

                //texto codificado
                texto = t.codifica(texto);
                System.out.println("mesaje codificado: "+texto);

                //clave ajustada
                clave = t.ajustaClave(texto,t.codificaASCII(clave));
                System.out.println("clave ajustada: "+clave);

                //Texto sustituido
                texto=t.Sustitucion(texto, clave);
                System.out.println("texto sustituido: "+texto);
                
                texto=t.Transposicion(numBloques, texto);
                System.out.println("texto traspuesto: "+texto);
                cadena=cadena+texto;
               i++;
           }
           System.out.println(cadena);
           cadena=t.Interpone(cadena);
           System.out.println(cadena);
           t.finalEncrypt(cadena);
          /*
           
           */
           
       }catch (FileNotFoundException e) {
           throw new RuntimeException("Error reading file");
        }
       
       
    }
    
}
