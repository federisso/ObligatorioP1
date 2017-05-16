
public final class Local {
    
    private String nombre;
    private int tipo;
    private String direccion;
    
    //Crear construcor sin parametros ?
    
    public Local(String elNombre,int elTipo,String laDireccion){
            this.setNombre(elNombre);
            this.setTipo(elTipo);
            this.setDireccion(laDireccion);
     }
    
     public Local(){
        this.setNombre(null);
        this.setTipo(0);
        this.setDireccion(null);
     }
    
    
     public String getNombre(){
         return nombre;
     }
     public int getTipo(){
         return tipo;
     }
     public String getDireccion(){
         return direccion;
     }
     public void setNombre(String elNombre){
         nombre=elNombre;
     }
     public void setTipo(int elTipo){
         tipo=elTipo;
     }
     public void setDireccion(String laDireccion){
         direccion=laDireccion;
     }
    
     
      
    @Override
       public String toString(){
          return "Nombre:"+this.getNombre()
                  +"Tipo:"+this.getTipo()
                  +"Dirección:"+this.getDireccion();
       }
       
       
      
     
}

