
public final class Oferta {
    //Atributos
    private Local local;
    private Articulo articulo;
    private String descripcion;
    private double valor;
    private int vigencia;
    
    
    //Constructores
    public Oferta(){
        this.setLocal(null);
        this.setArticulo(null);
        this.setDescripcion(null);
        this.setValor(0);
        this.setVigencia(0);
    }
    
    public Oferta(Local elLocal,Articulo elArticulo,String laDescripcion,double elValor ,int laVigencia){
        this.setLocal(elLocal);
        this.setArticulo(elArticulo);
        this.setDescripcion(laDescripcion);
        this.setValor(elValor);
        this.setVigencia(laVigencia);
    }
    
    //Getters
    public Local getLocal(){
       return local;
    }
    
    public Articulo getArticulo(){
       return articulo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public double getValor(){
        return valor;
    }
    
    public int getVigencia(){
        return vigencia;
    }
    
    //setters
    public void setLocal(Local elLocal){
        local=elLocal;
    }
    
    public void setArticulo(Articulo elArticulo){
        articulo=elArticulo;
    }
    
    public void setDescripcion(String laDescripcion){
        descripcion=laDescripcion;
    }
    
    public void setValor(double elValor){
        valor=elValor;
    }
    
    public void setVigencia(int laVigencia){
        vigencia=laVigencia;
    }
    
    //Overrides de métodos de Object (toString y equals)
    @Override
    public String toString(){
       return "El local :"+this.getLocal()+
               "El Articulo :"+this.getArticulo()+
               "Descripcion :"+this.getDescripcion()+
               "El valor es :"+this.getValor();
    }
    @Override
    public boolean equals(Object o){
        Oferta p=(Oferta)o;
        return this.getArticulo().equals(p.getArticulo())&&
               this.getValor()== p.getValor();
    }
    
    //Se evalúa el valor de la oferta de la instancia con el de la oferta pasada como parámetro. 
    //El método devuelve la que tiene mayuor valor.
    public  Oferta devolverLaMayor(Oferta of){
        Oferta laMayor;
        if(this.getValor()>of.getValor())
            laMayor=this;
        else
            laMayor=of;
        
        return laMayor;
    }
    //Se evalúa el valor de la oferta de la instancia con el de la oferta pasada como parámetro. 
    //El método devuelve la que tiene mayuor valor.
    public Oferta devolverLaMenor(Oferta of){
        Oferta laMenor;
        if(this.getValor()<of.getValor())
            laMenor=this;
        else
            laMenor=of;
        
        return laMenor;
    }
    //Indica si un precio de oferta es inválido. Esto es, que el valor supere el doble 
    //del precio de referencia del artículo.
    public boolean precioInvalido(){        
         return this.getValor() > this.getArticulo().getPrecioRef()*2;
    }
    
}
    


