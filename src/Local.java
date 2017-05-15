
public final class Local {
    
    private String nombre;
    private int tipo;
    private String descripcion;
    //private Oferta oferta; - El local tendria asociado una oferta ?
    
    //Crear construcor sin parametros ?
    
    public Local(String elNombre,int elTipo,String laDescripcion){
            this.setNombre(elNombre);
            this.setTipo(elTipo);
            this.setDescripcion(laDescripcion);
     }
    
    
    
     public String getNombre(){
         return nombre;
     }
     public int getTipo(){
         return tipo;
     }
     public String getDescripcion(){
         return descripcion;
     }
     public void setNombre(String elNombre){
         nombre=elNombre;
     }
     public void setTipo(int elTipo){
         tipo=elTipo;
     }
     public void setDescripcion(String laDescripcion){
         descripcion=laDescripcion;
     }
    
     
      
    @Override
       public String toString(){
          return "Nombre:"+this.getNombre()
                  +"Tipo:"+this.getTipo()
                  +"Descripcion:"+this.getDescripcion();
       }
       
       
      
     
}

