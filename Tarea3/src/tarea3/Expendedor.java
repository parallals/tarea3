package tarea3;
import javax.swing.*;
import java.awt.*;

class Expendedor extends Deposito{
    private final int precioBebidas;
    public Bebida ComprarBebida(int BebidaElegida, Moneda moneda) throws NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException, EleccionInexistenteException{
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
        }else if(moneda.getValor() < precioBebidas){
            DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
        }
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1:
                if(DepositoCoca.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    for(int i=0 ;  i<Aux ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoCoca.remove(0);
                }
            case 2:
                if(DepositoSprite.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoSprite.remove(0);
                }
            case 3:
                if(DepositoFanta.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoFanta.remove(0);
                }
            case 4:
                if(DepositoLimonSoda.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100());
                    }
                    moneda = null;
                    return DepositoLimonSoda.remove(0);
                }
            default:
                DepositoVuelto.add(moneda);
                throw new EleccionInexistenteException("Error de seleccion");
            
        }
    }
    public Moneda getVuelto(){
        if(DepositoVuelto.isEmpty()){
            return null;
         }else{
            return DepositoVuelto.remove(0);
         }
    }
    public Expendedor(int numBebidas, int precioBebidas){
        super(numBebidas);
        this.precioBebidas = precioBebidas;
    }
    public void paint (Graphics g,int w, int h){
        super.paint(g);
        g.setColor(Color.blue);
        g.fillRect(w/2,h/3, w/4,h/3);
    }
}

