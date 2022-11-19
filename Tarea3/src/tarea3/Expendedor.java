package tarea3;

import javax.swing.*;
import java.awt.*;


class Expendedor{
    // PROPIEDADES
    private final int precioBebidas;
    private final Depositos depositos;
    private int x;
    private int y;
    // METODOS
    public void ComprarBebida(int BebidaElegida, Moneda moneda) throws DepositoBebidaSacarException, NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException{
        
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
            
        }else if(moneda.getValor() < precioBebidas){
            depositos.DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
            
        }else if(depositos.DepositoBebidaSacar != null){
            depositos.DepositoVuelto.add(moneda);
            throw new DepositoBebidaSacarException("Retire su bebida");
        }
        
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1 -> {
                if(depositos.DepositoCoca.isEmpty()){
                    depositos.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    depositos.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux ; i++){
                        depositos.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depositos.DepositoBebidaSacar = depositos.DepositoCoca.remove(0);
                }
            }
            case 2 -> {
                if(depositos.DepositoSprite.isEmpty()){
                    depositos.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    depositos.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depositos.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depositos.DepositoBebidaSacar = depositos.DepositoSprite.remove(0);
                }
            }
            case 3 -> {
                if(depositos.DepositoFanta.isEmpty()){
                    depositos.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    depositos.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depositos.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depositos.DepositoBebidaSacar = depositos.DepositoFanta.remove(0);
                }
            }
            case 4 -> {
                if(depositos.DepositoLimonSoda.isEmpty()){
                    depositos.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    depositos.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depositos.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depositos.DepositoBebidaSacar = depositos.DepositoLimonSoda.remove(0);
                }
            }
        }
    }
    
    public Moneda getVuelto() throws DepositoVueltoVacioException{
        if(depositos.DepositoVuelto.isEmpty()){
            throw new DepositoVueltoVacioException("No tiene vuelto que retirar");
         }else{
            return depositos.DepositoVuelto.remove(0);
         }
    }
    
    public Bebida getBebida(){
        if(depositos.DepositoBebidaSacar == null){
            throw new DepositoBebidaVacioException("No tiene bebida que retirar");
        }else{
            Bebida aux = depositos.DepositoBebidaSacar;
            depositos.DepositoBebidaSacar = null;
            return aux;
        }
    }
    
    public void Refill(){
        for(int i = depositos.DepositoCoca.size(); i< 5 ; i++){
            CocaCola aux = new CocaCola(Bebida.serieBebidas);
            depositos.DepositoCoca.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depositos.DepositoSprite.size(); i< 5; i++){
            Sprite aux = new Sprite(Bebida.serieBebidas);
            depositos.DepositoSprite.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depositos.DepositoFanta.size(); i< 5; i++){
            Fanta aux = new Fanta(Bebida.serieBebidas);
            depositos.DepositoFanta.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depositos.DepositoLimonSoda.size(); i< 5 ; i++){
            LimonSoda aux = new LimonSoda(Bebida.serieBebidas);
            depositos.DepositoLimonSoda.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
    }
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void paint(Graphics g, JPanel panel){
        try{ 
            // Expendedor
            Image i1 = new ImageIcon(this.getClass().getResource("../Textures/expendedor-cajon.png")).getImage();
            g.drawImage(i1, x, y, 562, 616, panel);
            // Boton Refill
            g.setColor(new Color(255,10,10)); 
            g.fillRect(x+492,y+29, 35,28);
            // Deposito de Bebida Comprada
            Image i2 = new ImageIcon(this.getClass().getResource("../Textures/BebidaSacar.png")).getImage();
            g.drawImage(i2, x+424, y+483, 126, 122, panel);
            // Deposito de Vuelto
            Image i3 = new ImageIcon(this.getClass().getResource("../Textures/Vuelto.png")).getImage();
            g.drawImage(i3, x+424, y+347, 126, 122, panel);
            // Botones  para Comprar Bebida
            Image i4 = new ImageIcon(this.getClass().getResource("../Textures/cocacola-logo.png")).getImage();
            g.drawImage(i4, x+428, y+72, 120, 50, panel);
            Image i5 = new ImageIcon(this.getClass().getResource("../Textures/sprite-logo.png")).getImage();
            g.drawImage(i5, x+428, y+132, 120, 50, panel);
            Image i6 = new ImageIcon(this.getClass().getResource("../Textures/fanta-logo.png")).getImage();
            g.drawImage(i6, x+428, y+192, 120, 50, panel);
            Image i7 = new ImageIcon(this.getClass().getResource("../Textures/limonsoda-logo.png")).getImage();
            g.drawImage(i7, x+428, y+252, 120, 50, panel);
         }catch(Exception e){
            System.out.println("No cargo alguna de las imagenes");                
         }
        Font newFont = new Font("Calibri", Font.BOLD, 15);
        g.setFont(newFont);
        // Todas las Bebidas Disponibles
        for(int j = 0; j < depositos.DepositoCoca.size() ; j++){
            depositos.DepositoCoca.get(j).setXY(x+95, y+591-((j+1)*100));
            depositos.DepositoCoca.get(j).paint(g, panel);
        }
        for(int j = 0; j < depositos.DepositoSprite.size() ; j++){
            depositos.DepositoSprite.get(j).setXY(x+175, y+591-((j+1)*100));
            depositos.DepositoSprite.get(j).paint(g, panel);
        }
        for(int j = 0; j < depositos.DepositoFanta.size() ; j++){
            depositos.DepositoFanta.get(j).setXY(x+255, y+591-((j+1)*100));
            depositos.DepositoFanta.get(j).paint(g, panel);
        }
        for(int j = 0; j < depositos.DepositoLimonSoda.size() ; j++){
            depositos.DepositoLimonSoda.get(j).setXY(x+335, y+591-((j+1)*100));
            depositos.DepositoLimonSoda.get(j).paint(g, panel);
        }
        // Bebida Comprada
        if(depositos.DepositoBebidaSacar!=null){
            depositos.DepositoBebidaSacar.setXY(x+464, y+500);
            depositos.DepositoBebidaSacar.paint(g, panel);
        }
        // Vuelto
        for(int j = 0; j < depositos.DepositoVuelto.size() ; j++){
            if(j<4){
                depositos.DepositoVuelto.get(j).paint(g, x+425+(j*25), y+416, 49, 49, panel);
            }else if(j<8){
                depositos.DepositoVuelto.get(j).paint(g, x+425+((j-4)*25), y+382, 49, 49, panel);
            }else if(j<12){
                depositos.DepositoVuelto.get(j).paint(g, x+425+((j-8)*25), y+348, 49, 49, panel);
            }
        }
    }
    
    public Expendedor(int numBebidas, int precioBebidas){
        depositos = new Depositos(numBebidas);
        x = 667;
        y = 28;
        this.precioBebidas = precioBebidas;
        depositos.DepositoBebidaSacar = null;
    }
}