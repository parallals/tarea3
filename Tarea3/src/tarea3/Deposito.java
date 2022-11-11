package tarea3;
import java.util.ArrayList;

public abstract class Deposito {
    
    protected int serieBebidas;
    protected  ArrayList<CocaCola> DepositoCoca;
    protected ArrayList<Sprite> DepositoSprite;
    protected ArrayList<Fanta> DepositoFanta;
    protected ArrayList<LimonSoda> DepositoLimonSoda;
    protected Bebida DepositoBebidaSacar;
    
    protected ArrayList<Moneda> DepositoVuelto;
    protected ArrayList<Moneda> DepositoPagado;
    
    protected Deposito(int cantidad){
        
        serieBebidas = 0;
        DepositoCoca = new ArrayList<>();
        DepositoSprite = new ArrayList<>();
        DepositoFanta = new ArrayList<>();
        DepositoLimonSoda = new ArrayList<>();
        
        DepositoVuelto = new ArrayList<>();
        DepositoPagado = new ArrayList<>();
        DepositoBebidaSacar = null;
        
        for(int i=0 ; i<cantidad ; i++){
            DepositoCoca.add(new CocaCola(serieBebidas));
            DepositoSprite.add(new Sprite(serieBebidas+1));
            DepositoFanta.add(new Fanta(serieBebidas+2));
            DepositoLimonSoda.add(new LimonSoda(serieBebidas+3));
            serieBebidas = serieBebidas+4;
        }
    }
}
    
