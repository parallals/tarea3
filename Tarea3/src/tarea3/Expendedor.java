package tarea3;

import javax.swing.*;
import java.awt.*;


class Expendedor extends Deposito{
    // PROPIEDADES
    private final int precioBebidas;
    private int x;
    private int y;
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
            
            case 1 :
                if(DepositoCoca.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux ; i++){
                        DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoCoca.remove(0);
                }
            break;
            case 2 :
                if(DepositoSprite.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoSprite.remove(0);
                }
            break;
            case 3 :
                if(DepositoFanta.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoFanta.remove(0);
                }
            break;
            case 4:
                if(DepositoLimonSoda.isEmpty()){
                    DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    DepositoPagado.add(moneda);
                    if(Aux>4){
                        DepositoVuelto.add(new Moneda500(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                        Aux = Aux-5;
                    }
                    for(int i=0 ;  i<Aux  ; i++){
                        DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    DepositoBebidaSacar = DepositoLimonSoda.remove(0);
                }
            break;
        }
    }
    
    public Moneda getVuelto() throws DepositoVueltoVacioException{
        if(DepositoVuelto.isEmpty()){
            throw new DepositoVueltoVacioException("No tiene vuelto que retirar");
         }else{
            return DepositoVuelto.remove(0);
         }
    }
    
    public Bebida getBebida(){
        if(DepositoBebidaSacar == null){
            throw new DepositoBebidaVacioException("No tiene bebida que retirar");
        }else{
            Bebida aux = DepositoBebidaSacar;
            DepositoBebidaSacar = null;
            return aux;
        }
    }
    
    public void Refill(){
        for(int i = DepositoCoca.size(); i< 5 ; i++){
            CocaCola aux = new CocaCola(Bebida.serieBebidas);
            DepositoCoca.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = DepositoSprite.size(); i< 5; i++){
            Sprite aux = new Sprite(Bebida.serieBebidas);
            DepositoSprite.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = DepositoFanta.size(); i< 5; i++){
            Fanta aux = new Fanta(Bebida.serieBebidas);
            DepositoFanta.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = DepositoLimonSoda.size(); i< 5 ; i++){
            LimonSoda aux = new LimonSoda(Bebida.serieBebidas);
            DepositoLimonSoda.add(aux);
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
        // Ajustes a la fuente de las series
        Font currentFont = g.getFont();
        //Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.3f);
        Font newFont = new Font("Calibri", Font.BOLD, 15);
        g.setFont(newFont);
        // Todas las Bebidas Disponibles
        for(int j = 0; j < DepositoCoca.size() ; j++){
            DepositoCoca.get(j).setXY(x+95, y+591-((j+1)*100));
            DepositoCoca.get(j).paint(g, panel);
        }
        for(int j = 0; j < DepositoSprite.size() ; j++){
            DepositoSprite.get(j).setXY(x+175, y+591-((j+1)*100));
            DepositoSprite.get(j).paint(g, panel);
        }
        for(int j = 0; j < DepositoFanta.size() ; j++){
            DepositoFanta.get(j).setXY(x+255, y+591-((j+1)*100));
            DepositoFanta.get(j).paint(g, panel);
        }
        for(int j = 0; j < DepositoLimonSoda.size() ; j++){
            DepositoLimonSoda.get(j).setXY(x+335, y+591-((j+1)*100));
            DepositoLimonSoda.get(j).paint(g, panel);
        }
        // Bebida Comprada
        if(DepositoBebidaSacar!=null){
            DepositoBebidaSacar.setXY(x+464, y+500);
            DepositoBebidaSacar.paint(g, panel);
        }
        // Vuelto
        for(int j = 0; j < DepositoVuelto.size() ; j++){
            if(j<4){
                DepositoVuelto.get(j).paint(g, x+425+(j*25), y+416, 49, 49, panel);
            }else if(j<8){
                DepositoVuelto.get(j).paint(g, x+425+((j-4)*25), y+382, 49, 49, panel);
            }else if(j<12){
                DepositoVuelto.get(j).paint(g, x+425+((j-8)*25), y+348, 49, 49, panel);
            }
        }
    }
    
    public Expendedor(int numBebidas, int precioBebidas){
        super(numBebidas);
        x = 667;
        y = 28;
        this.precioBebidas = precioBebidas;
        DepositoBebidaSacar = null;
    }
}