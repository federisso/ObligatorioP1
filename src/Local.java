
public final class Local {
    
    private String nombre;
    private int tipo;
    private String direccion;
    
    //Constructores
    public Local(){
        this.setNombre(null);
        this.setTipo(0);
        this.setDireccion(null);
    }
    public Local(String elNombre,int elTipo,String laDireccion){
            this.setNombre(elNombre);
            this.setTipo(elTipo);
            this.setDireccion(laDireccion);
     }
    
    //Getters
    public String getNombre(){
        return nombre;
     }
    public int getTipo(){
        return tipo;
    }
    public String getDireccion(){
        return direccion;
    }
    //Setters
    public void setNombre(String elNombre){
        nombre=elNombre;
    }
    public void setTipo(int elTipo){
        tipo=elTipo;
    }
    public void setDireccion(String laDireccion){
        direccion=laDireccion;
    }
    
    //Override de métodos de la clase object.
    @Override
    public String toString(){
       return "Nombre:"+this.getNombre()
               +"Tipo:"+this.getTipo()
               +"Dirección:"+this.getDireccion();
    }
    @Override
    public boolean equals(Object o){
       Local l=(Local)o;
       return this.getNombre().equals(l.getNombre()) && 
              this.getTipo()==l.getTipo();
    }
}

