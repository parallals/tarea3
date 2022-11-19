package tarea3;

import java.util.ArrayList;


class DepositosBebidas {
    // PROPIEDADES
    protected ArrayList<LimonSoda> DepositoLimonSoda;
    protected ArrayList<CocaCola> DepositoCoca;
    protected ArrayList<Sprite> DepositoSprite;
    protected ArrayList<Fanta> DepositoFanta;
    protected Bebida DepositoBebidaSacar;
    // METODOS
    protected DepositosBebidas(int cantidad){
        DepositoCoca = new ArrayList<>();
        DepositoSprite = new ArrayList<>();
        DepositoFanta = new ArrayList<>();
        DepositoLimonSoda = new ArrayList<>();
        DepositoBebidaSacar = null;
        for(int i=0 ; i<cantidad ; i++){
            DepositoCoca.add(new CocaCola(Bebida.serieBebidas));
            DepositoSprite.add(new Sprite(Bebida.serieBebidas+1));
            DepositoFanta.add(new Fanta(Bebida.serieBebidas+2));
            DepositoLimonSoda.add(new LimonSoda(Bebida.serieBebidas+3));
            Bebida.serieBebidas = Bebida.serieBebidas+4;
        }
    }
}
    
