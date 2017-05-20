
public final class Oferta {
    private Local local;
    private Articulo articulo;
    private String descripcion;
    private double valor;
    private int vigencia;
    
    
    
    public Oferta(Local elLocal,Articulo elArticulo,String laDescripcion,double elValor ,int laVigencia){
        this.setLocal(elLocal);
        this.setArticulo(elArticulo);
        this.setDescripcion(laDescripcion);
        this.setValor(elValor);
        this.setVigencia(laVigencia);
    }
    
    public Oferta(){
        this.setLocal(null);
        this.setArticulo(null);
        this.setDescripcion(null);
        this.setValor(0);
        this.setVigencia(0);
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
    
    public double getValor(){
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
    
    public void setValor(double elValor){
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
    @Override
    public boolean equals(Object o){
        Oferta p=(Oferta)o;
        return this.getArticulo().equals(p.getArticulo())&&
                this.getValor()== p.getValor();
    }
    
    public static Oferta LaMayor(Oferta oferta1,Oferta oferta2){
        Oferta laMayor;
        if(oferta1.getValor()>oferta2.getValor()){
            laMayor=oferta1;
        }
        else{
            laMayor=oferta2;
        }
        
        return laMayor;
    }
    public static Oferta LaMenor(Oferta oferta1,Oferta oferta2){
        Oferta laMenor;
        if(oferta1.getValor()<oferta2.getValor()){
            laMenor=oferta1;
        }
        else{
            laMenor=oferta2;
        }
        return laMenor;
    }
    

}