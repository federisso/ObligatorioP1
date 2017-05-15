
public final class Articulo {
    
    private String descripcion;
    //private int codigoBarras; Comente codigo de barras porque el profe dijo que podia ir en la clase prueba.
    private int rubro;
    private double precioRef;
    
    public Articulo(String laDescripcion ,int elRubro,double elPrecioRef){
        this.setDescripcion(laDescripcion);
        this.setRubro(elRubro);
        this.setPrecioRef(elPrecioRef);
    }
    
    
        public String getDescripcion(){
           return descripcion;          
        }
        /*public int getCodigoBarras(){
           return codigoBarras;
        }*/
        public int getRubro(){
           return rubro;
        }
        public double getPrecioRef(){
           return precioRef;
        }
        public void setDescripcion(String laDescripcion){
           descripcion=laDescripcion;
        }
        /* public void setCodigoBarras(int elCodigo){
           codigoBarras=elCodigo;
        }*/
        public void setRubro(int elRubro){
           rubro=elRubro;
        }
        public void setPrecioRef(double elPrecio){
           precioRef=elPrecio;
        }
        
        @Override
        public String toString(){
           return "La Descripcion es:"+this.getDescripcion()
                   +"pertenece al rubro:"+this.getRubro()
                   +"El precio de referencia es:"+this.getPrecioRef();
        }
        
        /*
        Pensar un mejor metodo para comparar el precio!!
        
        public boolean precioMayor(double unPrecio){
           
              return this.getPrecioRef() < unPrecio;
        }
        public boolean precioMenor(double unPrecio){
             
              return this.getPrecioRef() > unPrecio;     
        }
        public boolean elMismoPrecio(double unPrecio){
              
              return this.getPrecioRef()== unPrecio;
        } */
 }

        

