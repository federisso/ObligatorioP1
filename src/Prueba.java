
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Prueba {  
    
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
            LimpiarPantalla();
            ImprimirMenuPrincipal();
            opcionMenu = PedirEntero("Ingrese una opción", "La opción ingresada no existe", 1,4);
            
            switch(opcionMenu){
            
                case 1 : break;
                case 2 : break;
                case 3 : 
                    boolean volver = false;
                    
                    of1=IngresarOferta(local, articulo);
                    of2=IngresarOferta(local, articulo);
                    of3=IngresarOferta(local, articulo);
                    
                    do {
                        LimpiarPantalla();
                        ImprimirMenuOfertas();
                        opcionMenu=PedirEntero("Ingrese una opción", "La opción ingresada no existe", 1, 4);
                        
                        switch(opcionMenu){
                            case 1: 
                                System.out.println("El rango es:"+RangoOferta(of1,of2,of3));
                                break;
                            case 2: 
                                System.out.println("El promedio es:"+PromedioOferta(of1,of2,of3));
                                break;
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

    public static void ImprimirMensaje(char tipo, String mensaje){
        
        switch(tipo){
            case 'E' : mensaje = "***** ERROR: " + mensaje; break;
            case 'A' : mensaje = "***** ATENCIÓN: " + mensaje; break;
            case 'C' : mensaje = "***** CORRECTO: " + mensaje; break;
        }
        
        System.out.println(mensaje);
            
    }
    
    public static double PromedioOferta(Oferta laOferta1 ,Oferta laOferta2,Oferta laOferta3){
        return ((laOferta1.getValor()+laOferta2.getValor()+laOferta3.getValor())/3);
    }
    
    public static String RangoOferta(Oferta of1 ,Oferta of2,Oferta of3){
        Oferta may;
        Oferta men;
        may=of1.laMayor(of2);
        may=may.laMayor(of3);
        men=of1.laMenor(of2);
        men=men.laMenor(of3); 
        return may.getValor()+"-"+men.getValor();
        
    }
   
    
    public static void LimpiarPantalla(){
       for (int i=0;i<20;i++)
           System.out.println();
    }
   
//<editor-fold defaultstate="collapsed" desc="Impresión de menús">
    public static void ImprimirMenuPrincipal(){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1 - Actualizar precio de artículo");
        System.out.println("2 - Actualizar dirección del local");
        System.out.println("3 - Gestión de ofertas");
        System.out.println("4 - Salir del programa");
    }
    
    public static void ImprimirMenuOfertas(){
        System.out.println("MENÚ OFERTAS");
        System.out.println("==============");
        System.out.println("1 - Consulta de rango de Precios");
        System.out.println("2 - Consulta de precio promedio");
        System.out.println("3 - Consulta de infracción");
        System.out.println("4 - Volver al menú principal");   
    }
//</editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Métodos de solicitud de datos">
    
         public static int PedirEntero(String textoSolicitud, String textoError, int inicio, int fin){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        int numero;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            numero = sc.nextInt();
            if (!RangoNumericoValido(numero, inicio, fin)){
                error=true;
                ImprimirMensaje('E',textoError);
            }
        } while(error);
         
        return numero;
    }

    
    public static String PedirString(String textoSolicitud, String textoError){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        String cadena;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            cadena = sc.nextLine();
            if (cadena.isEmpty()){
                error=true;
                ImprimirMensaje('E',textoError);
            }
        } while(error);
         
        return cadena;
    }
    
    public static String PedirString(String textoSolicitud,String valoresAVerificar,  String textoError){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        String cadena;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            cadena = sc.nextLine();
            if (cadena.isEmpty()){
                error=true;
                ImprimirMensaje('E',textoError);
            }else if(!ContieneDeLaLista(cadena, valoresAVerificar)){
                error=true;
                ImprimirMensaje('E', "El valor ingresados debe contener alguna de las palabras: "+valoresAVerificar);
            }
        } while(error);
         
        return cadena;
    }
    
    
    public static double PedirDouble(String textoSolicitud, String textoError, double inicio, double fin){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        double numero;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            numero = sc.nextDouble();
            if (!RangoNumericoValido(numero, inicio, fin)){
                error=true;
                ImprimirMensaje('E',textoError);
            }
        } while(error);
         
        return numero;
    }
    
    public static long PedirLong(String textoSolicitud, String textoError, long inicio, long fin){
        //Imprime el texto del parámetro y luego pide un entero.
        Scanner sc = new Scanner(System.in);
        long numero;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
             numero = sc.nextLong();
            if (!RangoNumericoValido(numero, inicio, fin)){
                error=true;
                ImprimirMensaje('E',textoError);
            }
        } while(error);
         
        return numero;
    }
    
   //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="Cargar objetos">
     public static Local IngresarLocal (){
        Local local = new Local();
        System.out.println("LOCAL");
        System.out.println("=====");
        local.setNombre(PedirString("Ingrese el nombre del local", "El nombre del local no puede ser vacío"));
        local.setTipo(PedirEntero("Ingrese el tipo (1-almacén, 2-supermercado, 3-hipermercado, 4- kiosko, 5- otro)","El tipo de local ingresado no existe" ,1, 5));
        local.setDireccion(PedirString("Ingrese la dirección del local","La dirección del local no puede ser vacía"));
    
        return local;
    }
    
        public static Articulo IngresarArticulo(){
        Articulo articulo = new Articulo();
        System.out.println("ARTÍCULO");
        System.out.println("========");
        articulo.setCodigoBarras(PedirLong("Ingrese el código del artículo","Valor no permitido para el código", 0, Long.MAX_VALUE));
        articulo.setDescripcion(PedirString("Ingrese la descripción del artículo", "La descripción no puede ser vacía"));
        articulo.setPrecioRef(PedirDouble("Ingrese el precio de referencia del artículo", "El precio no puede ser inferior a 1", 1, Double.MAX_VALUE));
        articulo.setRubro(PedirEntero("Ingrese el rubro (1- congelado, 2 – bebida sin alcohol, 3- bebida con alcohol, 4 – fruta/verdura, \n5- alimento, 6 – producto para bebés, 7- limpieza, 8- otro)","El rubro ingresado no existe", 1, 8));
        
        return articulo;
    }
     
    public static Oferta IngresarOferta(Local local, Articulo articulo){
        Oferta oferta = new Oferta();
        oferta.setArticulo(articulo);
        oferta.setLocal(local);
        System.out.println("NUEVA OFERTA");
        System.out.println("============");
        oferta.setDescripcion(PedirString("Ingrese la descripción","voucher;oferta;tarjeta","La descripción no puede ser vacía"));
        oferta.setValor(PedirDouble("Ingrese el valor", "El precio ingresado debe ser un valor positivo",0, Double.MAX_VALUE));
        oferta.setVigencia(PedirEntero("Ingrese la vigencia de la oferta en días", "La vigencia debe ser mayor a 0", 0, Integer.MAX_VALUE));
        return oferta;
    }   
    // </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Validaciones">
 
    public static boolean RangoNumericoValido(double valor, double inicio, double fin){
        return valor>=inicio && valor <=fin;
    }
    
    public static boolean RangoNumericoValido(int valor, int inicio, int fin){
        return valor>=inicio && valor <=fin;
    }
    
    public static boolean RangoNumericoValido(long valor, long inicio, long fin){
        return valor>=inicio && valor <=fin;
    }
    
    public static boolean ContieneDeLaLista(String buscarEn, String buscados){
        //Separa los valores del segundo string en un arreglo y luego verifica si esos valores existen en el primero
        //las palabras obligatoriamente deben venir separadas por ;
        String palabras[] = buscados.split(";");
        boolean contiene = false;
        
        for (int i=0; i<palabras.length;i++){
           if (buscarEn.contains(palabras[i]))
               contiene = true;
        }
        return contiene;
    }
    
// </editor-fold>
} // fin de la clase Prueba
