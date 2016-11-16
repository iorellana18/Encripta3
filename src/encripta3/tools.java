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
        String valorStr;
        //tienen mismo largo en este punto
        int largo = texto.length(), i=0, valor;
        
        while(i<largo){
            tempTexto.append(texto.charAt(i));
            tempClave.append(clave.charAt(i));
            if(tempTexto.length()==2){
                valor=Integer.parseInt(tempTexto.toString())+Integer.parseInt(tempClave.toString());
                valor=valor%28;
                if(valor<10){
                    valorStr="0";
                    valorStr=valorStr.concat(String.valueOf(valor));
                }else{
                    valorStr=String.valueOf(valor);
                }
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
    
    public void finalEncrypt(String texto){
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
        System.out.println(Encrypt+"");
       
    }
}
