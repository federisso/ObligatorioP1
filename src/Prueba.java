
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Camilo
 */
public class Prueba {
    
    public static void main (String[] args){
        
        //Variables
        int opcionMenu;
        
        //Variables de objeto
        Oferta of1;
        Oferta of2;
        Oferta of3;
        Local local;
        Articulo articulo;
        
        
        
        do {
            
            ImprimirMenuPrincipal();
            opcionMenu = pedirEntero("Ingrese una opción");
            
            switch(opcionMenu){
            
                case 1 : break;
                case 2 : break;
                case 3 : break;
                case 4 : break;
            
            }
            
        } while(true);
        
    
    }

    public static void ImprimirMenuPrincipal(){
        System.out.println("1 - Actualizar precio de artículo");
        System.out.println("2 - Actualizar dirección del local");
        System.out.println("3 - Gestión de ofertas");
        System.out.println("4 - Salir");
    }
    
    public static int pedirEntero(String textoSolicitud){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        System.out.print(textoSolicitud + ": ");
        return sc.nextInt();
    }    
}
