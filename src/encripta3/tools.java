/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
        
        return nuevaClave.toString();
    }
    
    public String codifica(String texto){
        int largoTexto = texto.length();
        texto = texto.toUpperCase();
        char[] arreglo = texto.toCharArray();
        int numero, i=0;
        String codigo;
        StringBuilder cadena = new StringBuilder();
        
        while(i<largoTexto){
            numero = arreglo[i]-64;
            
            if (numero<10){
                
                if(numero<0){
                    numero = 0;
                }
                codigo ="0";
                codigo = codigo.concat(String.valueOf(numero));
                cadena.append(codigo);
                
            }else{
                codigo = String.valueOf(numero);
                cadena.append(codigo);
            }
            i++;
        }
        return cadena.toString();
    }
    
    public String clarifica(String texto){
        int largo=texto.length(),i=0;
        String sustituto="", cadena= "";
        int numero;
        
        while(i<largo){
            sustituto=sustituto+texto.charAt(i);
            if(sustituto.length()==2){
                numero=Integer.parseInt(sustituto);
                numero=numero+64;
                cadena=cadena+(char)numero;
                sustituto="";
            }
            i++;
        }
        return cadena;
    }
        
    public String codificaASCII(String texto){
        int largoTexto = texto.length();
        texto = texto.toUpperCase();
        StringBuilder cadena = new StringBuilder();
        char[] arreglo = texto.toCharArray();
        int numero, i=0;
        String codigo;
        
        while(i<largoTexto){
            numero = arreglo[i];
            codigo = String.valueOf(numero);
            cadena.append(codigo);
            i++;
        }
        return cadena.toString();
    }
    
    public String Sustitucion(String texto, String clave){
        StringBuilder cadena = new StringBuilder(), tempTexto = new StringBuilder(), tempClave = new StringBuilder();
        String valorStr,valorGuardado;
        //tienen mismo largo en este punto
        int largo = texto.length(), i=0, valor;
        int guardado=0;
        while(i<largo){
            tempTexto.append(texto.charAt(i));
            tempClave.append(clave.charAt(i));
            if(tempTexto.length()==2){
                valor=Integer.parseInt(tempTexto.toString())+Integer.parseInt(tempClave.toString());
                guardado=valor/28;
                if(guardado<10){
                    valorGuardado="0";
                    valorGuardado=valorGuardado.concat(String.valueOf(guardado));
                }else{
                    valorGuardado=String.valueOf(guardado);
                }
                valor=valor%28;
                if(valor<10){
                    valorStr="0";
                    valorStr=valorStr.concat(String.valueOf(valor));
                }else{
                    valorStr=String.valueOf(valor);
                }
                cadena.append(valorGuardado);
                cadena.append(valorStr);
                tempTexto.delete(0, 2);
                tempClave.delete(0, 2);
                
            }
            
            i++;
        }
        return cadena.toString();
    }
    
    public String[] cortaBlques(int numBloques, String texto){
        int largo=texto.length(), i=0;
        String[] array;
        String cadena="";
        while(i<largo){
            
            if(i%numBloques==0){
                cadena=cadena+"&";
            }
            cadena=cadena+texto.charAt(i);
            i++;
        }
        
        //System.out.println(cadena);
        array=cadena.split("&");
        //System.out.println(array[4]);
        return array;
    }
    
    public String Transposicion(int numBloque, String texto){
        int largo = texto.length(), i=0,j=0;
        String cadena="";
        String traspuesta="";
        while(i<numBloque){
            while(j<largo){
                cadena=cadena+texto.charAt(j);
                j=j+numBloque;
            }
            traspuesta=traspuesta+cadena;
            cadena="";
            i++;
            j=i;
        }
        return traspuesta;
    }
    
    public String TransposicionInversa(String texto, int tamanoBloque){
        int largo = texto.length(), i=0,j=0;
        String cadena="";
        String traspuesta1="";
        while(i<largo/tamanoBloque){
            while(j<largo){
                traspuesta1=traspuesta1+texto.charAt(j);
                j=j+4;
            }
           
            i++;
            j=i;
        }
        cadena=traspuesta1;
        return cadena;
    }
    
    public String Interpone(String texto){
        int largo = texto.length(),i=0;
        boolean flag=true;
        String cadena="";
        
        while(i<largo){
            if(i%2==0){
                
                if(flag){
                    cadena=cadena+"1";
                    flag=false;
                }else{
                    cadena=cadena+"2";
                    flag=true;
                }
            }
            cadena=cadena+texto.charAt(i);
            i++;
        }
        return cadena;
        
    }
    
    public String finalEncrypt(String texto, int numBloques){
       int largo = texto.length(), i=0;
       String Encrypt="",temp="";
       int valor; char ascii;
       while(i<largo){
           if(i%3==0 && i!=0){
               valor=Integer.parseInt(temp);
               ascii=(char)valor;
               Encrypt=Encrypt+ascii;
               temp="";
           }
           temp=temp+texto.charAt(i);
           
           i++;
       }
        valor=Integer.parseInt(temp);
        ascii=(char)valor;
        Encrypt=Encrypt+ascii;
        OutputStream o;
        try{
                o = new FileOutputStream("/home/ian/Escritorio/results.txt");
                //mir_id, lncRNA transcript id, position of seed in transcript, dG duplex, dG binding, dG open, ddG
                o.write((numBloques+"-"+Encrypt).getBytes());
                o.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        return Encrypt;
       
    }
    
    
    public String desencripta(String texto){
        int largo=texto.length(), i=0, numero;
        String temp="", trueCadena="";
        
        while(i<largo){
            numero=texto.charAt(i);
            trueCadena=trueCadena+String.valueOf(numero).subSequence(1,3);
            
            i++;
        }
        return trueCadena;
    }
    
   public String inSustitucionModularZ(String texto){
       int largo=texto.length(),i=0, bloque=4;
       String sustituto="",temp="";
       String cadena="";
       int valor;
       while(i<largo){
           
           if(i%4==0 && i!=0){
               temp=sustituto.substring(0,2);
               sustituto=sustituto.substring(2,4);
               valor=Integer.parseInt(temp)*28+Integer.parseInt(sustituto);
               if(valor<10){
                   cadena=cadena+"0";
                   cadena=cadena+String.valueOf(valor);
               }else{
                   cadena=cadena+String.valueOf(valor);
               }
               temp="";
               sustituto="";
           }
           sustituto=sustituto+texto.charAt(i);
           i++;
       }
       temp=sustituto.substring(0,2);
        sustituto=sustituto.substring(2,4);
        valor=Integer.parseInt(temp)*28+Integer.parseInt(sustituto);
      if(valor<10){
            cadena=cadena+"0";
            cadena=cadena+String.valueOf(valor);
        }else{
            cadena=cadena+String.valueOf(valor);
        }
       
       return cadena;
    }
   
   public String desplaza(String texto, String clave){
       int largo=texto.length(),i=0, valor=0;
       String minuendo="";
       String sustraendo="";
       String cadena="";
       while(i<largo){
           minuendo=minuendo+texto.charAt(i);
           sustraendo=sustraendo+clave.charAt(i);
           if(minuendo.length()==2){
               valor=Integer.parseInt(minuendo)-Integer.parseInt(sustraendo);
               if(valor<10){
                   cadena=cadena+"0";
                   cadena=cadena+String.valueOf(valor);
                    minuendo="";
                    sustraendo="";
               }else{
                cadena=cadena+String.valueOf(valor);
               minuendo="";
               sustraendo="";
               }
           }
           
           i++;
          
       }
       
       return cadena;
   }
}
