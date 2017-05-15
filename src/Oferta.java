
public final class Oferta {
    private Local local;
    private Articulo articulo;
    private String descripcion;
    private int valor;
    private int vigencia;
    
    public Oferta(Local elLocal,Articulo elArticulo,String laDescripcion,int elValor ,int laVigencia){
                  
                  this.setLocal(elLocal);
                  this.setArticulo(elArticulo);
                  this.setDescripcion(laDescripcion);
                  this.setValor(elValor);
                  this.setVigencia(laVigencia);
   
    }
    
    
    public Local getLocal(){
       return local;
    }
    public Articulo getArticulo(){
       return articulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public int getValor(){
        return valor;
    }
    public int getVigencia(){
        return vigencia;
    }
    public void setLocal(Local elLocal){
        local=elLocal;
    }
    public void setArticulo(Articulo elArticulo){
        articulo=elArticulo;
    }
    public void setDescripcion(String laDescripcion){
        descripcion=laDescripcion;
    }
    public void setValor(int elValor){
        valor=elValor;
    }
    public void setVigencia(int laVigencia){
        vigencia=laVigencia;
    }
    
    @Override
    public String toString(){
       return "El local :"+this.getLocal()+
               "El Articulo :"+this.getArticulo()+
               "Descripcion :"+this.getDescripcion()+
               "El valor es :"+this.getValor();
    }
    

    
    
}
