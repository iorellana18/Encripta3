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
import java.util.Scanner;
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
        String archivo1, archivo2;
        int num, numBloques;
        Acciones a = new Acciones();
        Scanner sc= new Scanner(System.in);
        System.out.println("Qué acción desea realizar? (Escoger número)");
        System.out.println("[1]Encriptar\n[2]Desencriptar");
        num=sc.nextInt();
        if(num==1){
            System.out.println("\nIngrese la ruta del archivo a encriptar");
            archivo1=sc.next();
            
            System.out.println("\nIngrese la ruta del archivo que contiene la clave");
            archivo2=sc.next();
            
            System.out.println("\nIngrese el tamaño de bloque deseado");
            numBloques=sc.nextInt();
            
            System.out.println("Texto encriptado:");
            a.Encripta(archivo1,archivo2,numBloques);
        }else if(num==2){
            System.out.println("\nIngrese la ruta del archivo a desencriptar");
            archivo1=sc.next();
            
            System.out.println("\nIngrese la ruta del archivo que contiene la clave");
            archivo2=sc.next();
            
            System.out.println("Texto desencriptado:");
            a.Desencripta(archivo1,archivo2);
        }
        
        
        
        
        
       
          

        
    }
    
}
