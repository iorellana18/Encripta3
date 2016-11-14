/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta3;

/**
 *
 * @author ian
 */
public class tools {
    public String ajustaClave(String texto, String clave){
        StringBuilder nuevaClave = new StringBuilder();
        int largoClave=clave.length(), largoTexto=texto.length();
         //si la clave es mas larga la ajusta al texto
           if(largoClave>largoTexto){
               
               int i=0;
               while(i<largoTexto){
                   nuevaClave.append(clave.charAt(i));
                   i++;
               }
               
           }else{
               int i=0, j=0;
               while(i<largoTexto){
                  if(j==largoClave){
                      j=0;
                  }
                  nuevaClave.append(clave.charAt(j));
                  j++;
                  i++;
               }
           }
        
        return nuevaClave.reverse().toString();
    }
    
    public void codifica(String texto){
        int largoTexto = texto.length();
        texto = texto.toUpperCase();
        char[] arreglo = texto.toCharArray();
        int numero, i=0;
        String codigo;
        
        while(i<largoTexto){
            numero = arreglo[i]-64;
            
            if (numero<10){
                
                if(numero<0){
                    numero = 0;
                }
                codigo ="0";
                codigo = codigo.concat(String.valueOf(numero));
                System.out.println(codigo);
                
            }else{
                codigo = String.valueOf(numero);
                System.out.println(codigo);
            }
            i++;
        }
        
    }
}
