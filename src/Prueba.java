
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Prueba {  

   
    public String rangoOferta(Oferta laOferta1 ,Oferta laOferta2,Oferta laOferta3){
        Oferta laMayor=laOferta1;
        Oferta laMenor=laOferta1;
        
        
        
        
        if(laOferta2.getValor()>laMayor.getValor()){
           
            laMayor=laOferta2;
            
        
        }
        else {
            laMenor=laOferta2;
            
        }
        if(laOferta3.getValor()>laMayor.getValor()){
            laMayor=laOferta3;
            
        }
        if(laOferta3.getValor()<laMenor.getValor()){
            laMenor=laOferta3;
        }
        
        return laMenor+"-"+laMayor;
        
            
        
          
        
    
    }
    
    
    public static void main (String[] args){
        
        //Variables
        int opcionMenu;
        boolean salir = false;
        
        //Variables de objeto
        Oferta of1;
        Oferta of2;
        Oferta of3;
        Local local;
        Articulo articulo;
        
        local = IngresarLocal();
        articulo = IngresarArticulo();
        
        do {    
            ImprimirMenuPrincipal();
            opcionMenu = PedirEntero("Ingrese una opción");
            
            switch(opcionMenu){
            
                case 1 : break;
                case 2 : break;
                case 3 : 
                    boolean volver = false;
                    do {
                        ImprimirMenuOfertas();
                        opcionMenu=PedirEntero("Ingrese una opción");
                        
                        switch(opcionMenu){
                            case 1: break;
                            case 2: break;
                            case 3: break; 
                            case 4: volver = true;
                        }           
                    }while(!volver);
                    break;
                case 4 : 
                    salir = true;
                    break;  
            }
        } while(!salir);
    }

    public static void ImprimirMenuPrincipal(){
        System.out.println("1 - Actualizar precio de artículo");
        System.out.println("2 - Actualizar dirección del local");
        System.out.println("3 - Gestión de ofertas");
        System.out.println("4 - Salir del programa");
    }
    
    public static void ImprimirMenuOfertas(){
    
        System.out.println("1 - Consulta de artículo");
        System.out.println("2 - Consulta de precio promedio");
        System.out.println("3 - Consulta de infracción");
        System.out.println("4 - Volver al menú principal");   
    }
    
    public static int PedirEntero(String textoSolicitud){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        System.out.print(textoSolicitud + ": ");
        return sc.nextInt();
    }

    public static String PedirString(String textoSolicitud){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        System.out.print(textoSolicitud + ": ");
        return sc.nextLine();
    }
    
    public static double PedirDouble(String textoSolicitud){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        System.out.print(textoSolicitud + ": ");
        return sc.nextDouble();
    }
    
    public static long PedirLong(String textoSolicitud){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        System.out.print(textoSolicitud + ": ");
        return sc.nextLong();
    }
    
    public static Local IngresarLocal (){
        Local local = new Local();
        
        local.setNombre(PedirString("Ingrese el nombre del local"));
        local.setTipo(PedirEntero("Ingrese el tipo (1-almacén, 2-supermercado, 3-hipermercado, 4- kiosko, 5- otro)"));
        local.setDireccion(PedirString("Ingrese la dirección del local"));
    
        return local;
    }
    
    public static Articulo IngresarArticulo(){
        Articulo articulo = new Articulo();
        
        articulo.setCodigoBarras(PedirLong("Ingrese el código del artículo"));
        articulo.setDescripcion(PedirString("Ingrese la descripción del artículo"));
        articulo.setPrecioRef(PedirDouble("Ingrese el precio de referencia del artículo"));
        articulo.setRubro(PedirEntero("Ingrese el rubro (1- congelado, 2 – bebida sin alcohol, 3- bebida con alcohol, 4 – fruta/verdura, 5- alimento, 6 – producto para bebés, 7- limpieza, 8- otro)"));
        
        return articulo;
    }
    
}
