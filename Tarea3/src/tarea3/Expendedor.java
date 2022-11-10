package tarea3;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Expendedor extends Deposito{
    private final int precioBebidas;
    public void ComprarBebida(int BebidaElegida, Moneda moneda) throws NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException, EleccionInexistenteException{
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
                    DepositoBebidaSacar = DepositoCoca.remove(0);
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
                    DepositoBebidaSacar = DepositoSprite.remove(0);
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
                    DepositoBebidaSacar = DepositoFanta.remove(0);
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
                    DepositoBebidaSacar = DepositoLimonSoda.remove(0);
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
    public Bebida getBebida(){
                Bebida aux = DepositoBebidaSacar;
                DepositoBebidaSacar = null;
                return aux;
    }
    public Expendedor(int numBebidas, int precioBebidas){
        super(numBebidas);
        this.precioBebidas = precioBebidas;
    }
    public void paint(Graphics g,int w, int h){
        g.setColor(new Color(50,10,10)); //cajón
        g.fillRect(19*w/36,h/24, 16*w/36,22*h/24);
        g.setColor(new Color(170,150,150)); //ventanilla
        g.fillRect(20*w/36,h/24+h/36, 3*w/10,12*h/14);
        g.setColor(new Color(140,120,125));
        g.fillRect(221*w/256, 27*h/40, w/10, 7*h/28);
        /*int j;
        for(j = 0; j < DepositoCoca.size() ; j++){
            //Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola.png")).getImage();
            //g.drawImage(i, 725, 620-(j+1)*100, 50, 75, this);
            g.setColor(Color.red);
            g.fillRect(725, 620-(j+1)*100, 50, 75);
        }
        */
        paintDepositos(g,1,DepositoCoca);
        paintDepositos(g,2,DepositoSprite);
        paintDepositos(g,3,DepositoFanta);
        paintDepositos(g,4,DepositoLimonSoda);
        
    }
    public void paintDepositos(Graphics g,int bebida, ArrayList deposito){
        int j; 
        Color color = null;
        for(j = 0; j < deposito.size() ; j++){
            switch (bebida) {
                case 1:
                    color = new Color(255,0,0);
                    break;
                case 2:
                    color = new Color(0,250,100);
                    break;
                case 3:
                    color = new Color(250,150,0);
                    break;
                case 4:
                    color = new Color(250,243,120);
                    break;
                default:
                    break;
            }
            g.setColor(color);
            g.fillRect(725+(bebida-1)*80, 620-(j+1)*100, 50, 75);
        }    
    }
}

