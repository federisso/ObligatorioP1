/*
Materia: Programación 1
Profesor: Sebastián Pesce
Grupo: N1B

Equipo de obligatorio
=====================
Federico Risso - #216516
Camilo Morasca - #164329
*/

import java.io.IOException;
import java.util.Scanner;

public class Prueba {  
    
//<editor-fold defaultstate="collapsed" desc="main">  
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
        
        //Se solicita el único local y el único artículo que tiene el sistema de momento.
        local = IngresarLocal();
        ImprimirMensaje('C', "El local se ingresó correctamente.");
        articulo = IngresarArticulo();
        ImprimirMensaje('C', "El artículo se ingresó correctamente.");
        PresioneParaContinuar();
        
        do {    
            //Buque del menú. Itera hasta que se verifique la condición salir=true
            LimpiarPantalla();
            ImprimirMenuPrincipal();
            opcionMenu = PedirEntero("Ingrese una opción", "La opción ingresada no existe", 1,4);
            
            switch(opcionMenu){
            
                case 1 :
                    //Actualizar el precio de referencia de un artículo.
                    double nuevoPrecio=PedirDouble("Ingrese el precio de referencia del artículo", "El precio no puede ser inferior a 1", 1, Double.MAX_VALUE);
                    System.out.println( articulo.compararPrecio(nuevoPrecio));
                    articulo.setPrecioRef(nuevoPrecio);
                    ImprimirMensaje('C', "El precio se actualizó correctamente");
                    PresioneParaContinuar();
                    break;
                case 2 : 
                    //Ingresar una dirección nueva para el local.
                    local.setDireccion(PedirString("Ingrese la dirección del local","La dirección del local no puede ser vacía"));
                    ImprimirMensaje('C', "La dirección se actualizó correctamente");
                    PresioneParaContinuar();
                    break;
                case 3 : 
                    //Submenú de ofertas
                    boolean volver = false;
                    
                    of1=IngresarOferta(local, articulo);
                    ImprimirMensaje('C', "La oferta se ingresó correctamente.");
                    of2=IngresarOferta(local, articulo);
                    ImprimirMensaje('C', "La oferta se ingresó correctamente.");
                    of3=IngresarOferta(local, articulo);
                    ImprimirMensaje('C', "La oferta se ingresó correctamente");

                    do {
                        //Itera hasta que se verifique la condición volver = true
                        LimpiarPantalla();
                        ImprimirMenuOfertas();
                        opcionMenu=PedirEntero("Ingrese una opción", "La opción ingresada no existe", 1, 4);
                        
                        switch(opcionMenu){
                            case 1: 
                                //Indica el rango entre el valor de la oferta de menor precio y la de mayor.
                                System.out.println("El rango es:"+RangoOferta(of1,of2,of3));
                                PresioneParaContinuar();
                                break;
                            case 2:
                                //Indica el promedio de precios de las tres ofertas
                                System.out.println("El promedio es:"+PromedioOferta(of1,of2,of3));
                                PresioneParaContinuar();
                                break;
                            case 3:
                                //Indica si un local está en infracción o no.
                                //La condición es que el precio de una de las ofertas no puede superar el doble
                                //del precio de referencia del artículo.
                                String mensaje="no esta en infraccion.";
                                if(Infracion(of1, of2, of3))
                                    mensaje="esta en infraccion.";
                                System.out.println("El local "+ mensaje);
                                PresioneParaContinuar();
                               break;
                            case 4: 
                                volver = true;
                                break;
                        }           
                    }while(!volver);
                    break;
                case 4 : 
                    salir = true;
                    break;  
            }//termina switch
        } while(!salir);
    } //termina main.
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Componentes visuales">
    //Imprime en pantalla el texto del menú principal
    public static void ImprimirMenuPrincipal(){
        System.out.println("MENÚ PRINCIPAL");
        System.out.println("==============");
        System.out.println("1 - Actualizar precio de artículo");
        System.out.println("2 - Actualizar dirección del local");
        System.out.println("3 - Gestión de ofertas");
        System.out.println("4 - Salir del programa");
    }
    
    //Imprime en pantalla el texto del submenú de ofertas
    public static void ImprimirMenuOfertas(){
        System.out.println("MENÚ OFERTAS");
        System.out.println("==============");
        System.out.println("1 - Consulta de rango de Precios");
        System.out.println("2 - Consulta de precio promedio");
        System.out.println("3 - Consulta de infracción");
        System.out.println("4 - Volver al menú principal");   
    }
    
    //De acuerdo al parámetro indicado, imprime un string con el tipo de mensaje y luego
    //se le concatena el mensaje.
    public static void ImprimirMensaje(char tipo, String mensaje){
        switch(tipo){
            case 'E' : mensaje = "***** ERROR: " + mensaje; break;
            case 'A' : mensaje = "***** ATENCIÓN: " + mensaje; break;
            case 'C' : mensaje = "***** CORRECTO: " + mensaje; break;
        }
        System.out.println(mensaje);
    }
    
    //A efectos de que la limpieza de pantalla tenga algún efecto en el output de netbeans
    //se optó por implementarla imprimiendo nuevas líneas en lugar de llamar a comandos del sistema.
    public static void LimpiarPantalla(){
       for (int i=0;i<20;i++)
           System.out.println();
    }
//</editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Métodos de solicitud de datos">
    
    //Read captura la entrada del primer caracter que se ingresa (no es necesario presionar enter).
    //No estamos guardando el valor porque solamente lo utilizamos para pausar el progama antes de limpiar la pantalla.
    //El método read() obliga a capturar la excepción, por eso se utilizó la estructura try - catch.
    public static void PresioneParaContinuar() {
        System.out.println();
        System.out.println("*** Presione una tecla para continuar...");
        try {
            System.in.read();
        } catch (IOException ex) {

        }
    }

    //Imprime el texto del parámetro y solicita ingresar un número. Para verificar si ingresó un salto de línea,
    //el dato es leído como string (de lo contrario Java deja seguir presionando "Enter" hasta que se ingrese un número.
    //El string se intepreta como entero.
    //Si el dato ingresado se puede interpretar exitosamente, se verifica luego que pertenezca al rango conformado por el 
    //tercer y cuarto parámetro. En este caso se imprime el mensaje de error del segundo parámetro.
    //Si no se puede interpretar el texto ingresado como entero, el programa da un error en tiempo de ejecución como esta previsto.
    //Se continuará solicitando un número mientras que lo ingresado no sea válido (no vacío y dentro del rango).
    
    public static int PedirEntero(String textoSolicitud, String textoError, int inicio, int fin){
        Scanner sc = new Scanner(System.in);
        int numero=0;
        String lectura;
        boolean error;

        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            lectura = sc.nextLine();
            if(lectura.isEmpty()){
                error=true;
                ImprimirMensaje('E',"El valor ingresado no puede ser vacío.");
            } else {
                //Se intepreta el string ingresado como entero y se asigna a una variable entera.
                numero=Integer.parseInt(lectura);
                if (!RangoNumericoValido(numero, inicio, fin)){
                    error=true;
                    ImprimirMensaje('E',textoError);
                }
            }
        } while(error);
        return numero;
    }

    //Imprime el texto del parámetro y solicita ingresar un número. Para verificar si ingresó un salto de línea,
    //el dato es leído como string (de lo contrario Java deja seguir presionando "Enter" hasta que se ingrese un número.
    //El string se intepreta como long.
    //Si el dato ingresado se puede interpretar exitosamente, se verifica luego que pertenezca al rango conformado por el 
    //tercer y cuarto parámetro. En este caso se imprime el mensaje de error del segundo parámetro.
    //Si no se puede interpretar el texto ingresado como long, el programa da un error en tiempo de ejecución como esta previsto.
    //Se continuará solicitando un número mientras que lo ingresado no sea válido (no vacío y dentro del rango).

    public static long PedirLong(String textoSolicitud, String textoError, long inicio, long fin){
        Scanner sc = new Scanner(System.in);
        String lectura;
        long numero=0;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            lectura = sc.nextLine();
            
            if (lectura.isEmpty()){
                error=true;
                ImprimirMensaje('E', "El valor ingresado no puede ser vacío.");
            }else{ 
                //Se interpreta el string leído como long
                numero=Long.parseLong(lectura);
                if (!RangoNumericoValido(numero, inicio, fin)){
                    error=true;
                    ImprimirMensaje('E',textoError);
                }
            }
        } while(error);     
        
        return numero;
    }
    
    //Imprime el texto del parámetro y solicita ingresar un número. Para verificar si ingresó un salto de línea,
    //el dato es leído como string (de lo contrario Java deja seguir presionando "Enter" hasta que se ingrese un número.
    //El string se intepreta como double.
    //Si el dato ingresado se puede interpretar exitosamente, se verifica luego que pertenezca al rango conformado por el 
    //tercer y cuarto parámetro. En este caso se imprime el mensaje de error del segundo parámetro.
    //Si no se puede interpretar el texto ingresado como double, el programa da un error en tiempo de ejecución como esta previsto.
    //Se continuará solicitando un número mientras que lo ingresado no sea válido (no vacío y dentro del rango).
    
    public static double PedirDouble(String textoSolicitud, String textoError, double inicio, double fin){
        Scanner sc = new Scanner(System.in);
        String lectura;
        double numero=0;
        boolean error;
        
        do{ 
            error=false;
            System.out.print(textoSolicitud + ": ");
            lectura=sc.nextLine();
            
            if(lectura.isEmpty()){
                ImprimirMensaje('E', "El valor ingresado no puede ser vacío");
                error=true;
            }else{
                //Se interpreta el string leído como double.
                numero=Double.parseDouble(lectura);
                if (!RangoNumericoValido(numero, inicio, fin)){
                    error=true;
                    ImprimirMensaje('E',textoError);
                }
            }
        } while(error);
         
        return numero;
    }

    //Imprime el texto del primer parámetro y solicita un texto.
    //Si el texto ingresado es vacío, imprime el error del segundo parámetro
    //y vuelve a solicitar que se ingrese un texto.
    
    public static String PedirString(String textoSolicitud, String textoError){
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
    
    //Sobrecarga del método PedirString que además de efectuar los controles mencionados anteriormente
    //verifica que el texto ingresado tenga alguna de las palabras especificadas en el segundo parámetro.
    //La lista de palabras ingresadas debe estar delimitada por ; (punto y coma).
    //Si el string ingresado no contiene las palabras requeridas, se vuelve a solicitar el ingreso de un texto.
    public static String PedirString(String textoSolicitud,String valoresAVerificar,  String textoError){
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
            //Llamada al método que verifica la presencia de las palabras requeridas
            }else if(!ContieneDeLaLista(cadena, valoresAVerificar)){
                error=true;
                ImprimirMensaje('E', "El valor ingresado debe contener alguna de las palabras: "+valoresAVerificar);
            }
        } while(error);
         
        return cadena;
    }

    
   //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="Cargar objetos">
    //Se solicitan los valores para crear un objeto de tipo Local y luego se retorna el objeto creado
    //cargado.
    public static Local IngresarLocal (){
        Local local = new Local();
        System.out.println("LOCAL");
        System.out.println("=====");
        local.setNombre(PedirString("Ingrese el nombre del local", "El nombre del local no puede ser vacío"));
        local.setTipo(PedirEntero("Ingrese el tipo (1-almacén, 2-supermercado, 3-hipermercado, 4- kiosko, 5- otro)","El tipo de local ingresado no existe" ,1, 5));
        local.setDireccion(PedirString("Ingrese la dirección del local","La dirección del local no puede ser vacía"));
       
        return local;
    }
    //Se solicitan los valores para crear un objeto del tipo Artículo y luego se retorna el objeto creado
    //cargado.
    public static Articulo IngresarArticulo(){
        Articulo articulo = new Articulo();
        System.out.println("ARTÍCULO");
        System.out.println("========");
        articulo.setCodigoBarras(PedirLong("Ingrese el código del artículo","Valor no permitido para el código", 1, Long.MAX_VALUE));
        articulo.setDescripcion(PedirString("Ingrese la descripción del artículo", "La descripción no puede ser vacía"));
        articulo.setPrecioRef(PedirDouble("Ingrese el precio de referencia del artículo", "El precio no puede ser inferior a 1", 1, Double.MAX_VALUE));
        articulo.setRubro(PedirEntero("Ingrese el rubro (1- congelado, 2 – bebida sin alcohol, 3- bebida con alcohol, 4 – fruta/verdura, \n5- alimento, 6 – producto para bebés, 7- limpieza, 8- otro)","El rubro ingresado no existe", 1, 8));
       
        return articulo;
    }
    //Se solicitan los valores para crear un objeto del tipo Artículo y luego se retorna el objeto creado
    //cargado. 
    public static Oferta IngresarOferta(Local local, Articulo articulo){
        Oferta oferta = new Oferta();
        oferta.setArticulo(articulo);
        oferta.setLocal(local);
        System.out.println("NUEVA OFERTA");
        System.out.println("============");
        oferta.setDescripcion(PedirString("Ingrese la descripción","voucher;oferta;tarjeta","La descripción no puede ser vacía"));
        oferta.setValor(PedirDouble("Ingrese el valor", "El precio ingresado debe ser un valor positivo",0, Double.MAX_VALUE));
        oferta.setVigencia(PedirEntero("Ingrese el mes de vigencia de la oferta", "El mes ingresado no es válido.", 1, 12));
       
        return oferta;
    }   
    // </editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Lógica de ofertas">    
    
    //Recibe tres ofertas como parámetro y devuelve el valor promedio de las 3.
    public static double PromedioOferta(Oferta of1 ,Oferta of2,Oferta of3){
        return ((of1.getValor() + of2.getValor() + of3.getValor())/3);
    }
    
    //Recibe tres ofertas como parámetro y devuelve un string indicando el menor valor y el mayor.
    //de la siguiente forma 10.0-80.0 (P.ej. si las tres fueran 10.0, 35.0 y 80.0)
    public static String RangoOferta(Oferta of1, Oferta of2, Oferta of3){
        Oferta may;
        Oferta men;
        may=of1.devolverLaMayor(of2);
        may=may.devolverLaMayor(of3);
        men=of1.devolverLaMenor(of2);
        men=men.devolverLaMenor(of3);
       
        return men.getValor() + "-" + may.getValor();
    }
    //Si alguna de las 3 ofertas recibidas como parámetro cumple con la condición de inválida
    //(su valor es más del doble del precio de refernecia del artículo) el método devuelve el valor 
    //verdadero.
    public static boolean Infracion(Oferta of1 ,Oferta of2,Oferta of3){
        return of1.precioInvalido() || of2.precioInvalido() || of3.precioInvalido();
    }
    
//   </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Validaciones">
    
    //Si el valor del primer parámetro se encuentra entre los valores del segundo y del tercer parámetro
    //(con los extremos incluidos) el método devuelve verdadero. En caso contrario, devuelve falso.
    //El método tiene sobrecargas para los distintos tipos de datos numéricos.
    public static boolean RangoNumericoValido(double valor, double inicio, double fin){
        return valor>=inicio && valor <=fin;
    }
    
    public static boolean RangoNumericoValido(int valor, int inicio, int fin){
        return valor>=inicio && valor <=fin;
    }
    
    public static boolean RangoNumericoValido(long valor, long inicio, long fin){
        return valor>=inicio && valor <=fin;
    }
    
    //Separa los valores del segundo string en un arreglo y luego verifica si esos valores existen en el primero
    //las palabras obligatoriamente deben venir separadas por ;
    public static boolean ContieneDeLaLista(String buscarEn, String buscados){
        String palabras[] = buscados.split(";");
        boolean contiene = false;
        
        for (int i=0; i<palabras.length;i++){
           if (buscarEn.toLowerCase().contains(palabras[i].toLowerCase()))
               contiene = true;
        }
        return contiene;
    }
    
// </editor-fold>
    
} // fin de la clase Prueba
