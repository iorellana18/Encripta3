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
           int numBloques = 5;
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
           
           System.out.println("Texto original: "+texto+"\n");
           clave=t.ajustaClave(t.codifica(texto),t.codificaASCII(clave));
           numBloques=5;
           
           Bloques=t.cortaBlques(numBloques, texto);
           BloquesClave=t.cortaBlques(numBloques, clave);
           
           
           while(i<=cantidadBloques){
               texto=Bloques[i];
               clave=BloquesClave[i];

                //texto codificado
                texto = t.codifica(texto);

                //clave ajustada
                clave = t.ajustaClave(texto,t.codificaASCII(clave));

                //Texto sustituido
                texto=t.Sustitucion(texto, clave);
                
                if(texto.length()==numBloques*4){
                texto=t.Transposicion(numBloques, texto);
                }
                cadena=cadena+texto;
               i++;
           }
           cadena=t.Interpone(cadena);
           t.finalEncrypt(cadena);
           /////////////////////////////////////////////////////////////////
           
           
           
          /*
           
           */
         
       }catch (FileNotFoundException e) {
           throw new RuntimeException("Error reading file");
        }
       
             try{
           file1= new FileReader("/home/ian/Escritorio/results.txt"); //args[0]
           file2 = new FileReader("/home/ian/Escritorio/clave"); //args[1]
            int numBloques = 5;
           bufferTexto = new BufferedReader(file1);
           bufferClave = new BufferedReader(file2);
           texto = bufferTexto.readLine();
           clave = bufferClave.readLine();
           int cantidadBloques=0;
           
           tools t = new tools();
           
           
           int i=1;
           
            clave=t.codificaASCII(clave);
           BloquesClave=t.cortaBlques(numBloques, clave);
          numBloques=numBloques*4;
           
           texto=t.desencripta(texto);
           //Obtiene bloques - texto.length/blques+1
           if(texto.length()%numBloques==0){
                cantidadBloques=texto.length()/numBloques;
           }else{
               cantidadBloques=(texto.length()/numBloques+1);
           }
                
           Bloques=t.cortaBlques(numBloques, texto);
           
          
           cadena = "";
            while(i<=cantidadBloques){
               texto=Bloques[i];
               clave=BloquesClave[i];
               
               
               if(texto.length()==numBloques){
                    texto=t.TransposicionInversa(texto);
               }
               
               texto=t.inSustitucionModularZ(texto);
               clave=t.ajustaClave(texto, t.codificaASCII(clave));
               texto=t.desplaza(texto, clave);
               texto=t.clarifica(texto);
               cadena=cadena+texto;
               i++;
           }
                System.out.println(cadena.replace('@',' ').toLowerCase());
                cadena=cadena.replace('@',' ').toLowerCase();
           /////////////////////////////////////////////////////////////////
           
           
           
          
           
       }catch (FileNotFoundException e) {
           throw new RuntimeException("Error reading file");
        }

    }
    
}
