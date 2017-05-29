
public final class Articulo {
    
    private String descripcion;
    private long codigoBarras; 
    private int rubro;
    private double precioRef;
    
    //Constructores
    public Articulo(){
        this.setDescripcion(null);
        this.setCodigoBarras(0);
        this.setPrecioRef(0);
        this.setRubro(0);
    }
    
    public Articulo(String laDescripcion, long elCodigoBarras, int elRubro,double elPrecioRef){
        this.setDescripcion(laDescripcion);
        this.setCodigoBarras(elCodigoBarras);
        this.setRubro(elRubro);
        this.setPrecioRef(elPrecioRef);
    }
    //Getters 
    public String getDescripcion(){
       return descripcion;          
    }
    public long getCodigoBarras(){
       return codigoBarras;
    }
    public int getRubro(){
       return rubro;
    }
    public double getPrecioRef(){
       return precioRef;
    }
    //Setters
    public void setDescripcion(String laDescripcion){
       descripcion=laDescripcion;
    }
     public void setCodigoBarras(long elCodigo){
       codigoBarras=elCodigo;
    }
    public void setRubro(int elRubro){
       rubro=elRubro;
    }
    public void setPrecioRef(double elPrecio){
       precioRef=elPrecio;
    }

    //Override de métodos de la clase Object.
    @Override
    public String toString(){
       return "La Descripcion es:"+this.getDescripcion()
               +"pertenece al rubro:"+this.getRubro()
               +"El precio de referencia es:"+this.getPrecioRef();
    }

    @Override
        public boolean equals(Object o){
          Articulo a=(Articulo)o;
          return this.getCodigoBarras()==a.getCodigoBarras();
    }
    
    //Métodos de la lógica de la aplicación.
    public String compararPrecio(double nuevoValor){
        String valor;
        if(this.getPrecioRef()>nuevoValor){ 
            valor="El precio de referencia ingresado es menor";
        } else if(this.getPrecioRef()==nuevoValor){
            valor="El precio de referencia ingresado es  igual";
        }else{
            valor="El precio de referencia ingresado es mayor";
        }
        return valor;
    }
}
