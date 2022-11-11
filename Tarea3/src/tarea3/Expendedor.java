package tarea3;

import javax.swing.*;
import java.awt.*;


class Expendedor extends Deposito{
    // PROPIEDADES
    private final int precioBebidas;
    protected int serieMonedas;
    // METODOS
    public void ComprarBebida(int BebidaElegida, Moneda moneda) throws DepositoBebidaSacarException, NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException{
        
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
            
        }else if(moneda.getValor() < precioBebidas){
            DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
            
        }else if(DepositoBebidaSacar != null){
            DepositoVuelto.add(moneda);
            throw new DepositoBebidaSacarException("Retire su bebida");
        }
        
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            
            case 1 -> {
                if(DepositoCoca.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(serieMonedas));
                        serieMonedas = serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux ; i++){
                        DepositoVuelto.add(new Moneda100(serieMonedas));
                        serieMonedas = serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoCoca.remove(0);
                }
            }
                
            case 2 -> {
                if(DepositoSprite.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(serieMonedas));
                        serieMonedas = serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(serieMonedas));
                        serieMonedas = serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoSprite.remove(0);
                }
            }
                
            case 3 -> {
                if(DepositoFanta.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(serieMonedas));
                        serieMonedas = serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(serieMonedas));
                        serieMonedas = serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoFanta.remove(0);
                }
            }
                
            case 4 -> {
                if(DepositoLimonSoda.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(serieMonedas));
                        serieMonedas = serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(serieMonedas));
                        serieMonedas = serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoLimonSoda.remove(0);
                }
            }
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
        serieMonedas = 5000;
        this.precioBebidas = precioBebidas;
        DepositoBebidaSacar = null;
    }
    
    public void paint(Graphics g,int w, int h, JPanel panel){
        
        g.setColor(new Color(150,10,10)); //cajon
        g.fillRect(19*w/36,h/24, 16*w/36,22*h/24);
        
        g.setColor(new Color(200,190,190)); //ventanilla
        g.fillRect(20*w/36,h/24+h/36, 3*w/10,12*h/14);
        
        g.setColor(new Color(240,120,125)); //DepositoBebidaSacar
        g.fillRect(221*w/256, 30*h/40, w/10, 5*h/28);
        
        g.setColor(new Color(200,150,250)); //DepositoVuelto
        g.fillRect(221*w/256, 22*h/40, w/10, 5*h/28);
        
        for(int j = 0; j < DepositoCoca.size() ; j++){
            DepositoCoca.get(j).paint(g, 725, 20+(j+1)*100, 50, 75, panel);
        }
        for(int j = 0; j < DepositoSprite.size() ; j++){
            DepositoSprite.get(j).paint(g, 795, 20+(j+1)*100, 50, 75, panel);
        }
        for(int j = 0; j < DepositoFanta.size() ; j++){
            DepositoFanta.get(j).paint(g, 885, 20+(j+1)*100, 50, 75, panel);
        }
        for(int j = 0; j < DepositoLimonSoda.size() ; j++){
            DepositoLimonSoda.get(j).paint(g, 965, 20+(j+1)*100, 50, 75, panel);
        }
        
        if(DepositoBebidaSacar != null){
            DepositoBebidaSacar.paint(g, 229*w/256, 31*h/40, 50, 75, panel);
        }
        
        for(int j = 0; j < DepositoVuelto.size() ; j++){
            if(j<4){
                DepositoVuelto.get(j).paint(g, 221*w/256+(j*25), 26*h/40, 50, 50, panel);
            }else if(j<8){
                DepositoVuelto.get(j).paint(g, 221*w/256+((j-4)*25), 24*h/40, 50, 50, panel);
            }else if(j<12){
                DepositoVuelto.get(j).paint(g, 221*w/256+((j-8)*25), 22*h/40, 50, 50, panel);
            }else{
                //Error>retire vuelto
            }
        }
        
    }
}