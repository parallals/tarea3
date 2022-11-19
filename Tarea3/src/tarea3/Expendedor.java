package tarea3;

import javax.swing.*;
import java.awt.*;


class Expendedor{
    // PROPIEDADES
    private final int precioBebidas;
    private final DepositosBebidas depBebidas;
    private final DepositosMonedas depMonedas;
    private int x;
    private int y;
    // METODOS
    public void ComprarBebida(int BebidaElegida, Moneda moneda) throws DepositoBebidaSacarException, NoHayBebidaException, PagoInsuficienteException, PagoIncorrectoException{
        
        if(moneda == null){
            throw new PagoIncorrectoException("Inserte moneda valida");
            
        }else if(moneda.getValor() < precioBebidas){
            depMonedas.DepositoVuelto.add(moneda);
            throw new PagoInsuficienteException("Le faltan monedas");
            
        }else if(depBebidas.DepositoBebidaSacar != null){
            depMonedas.DepositoVuelto.add(moneda);
            throw new DepositoBebidaSacarException("Retire su bebida");
        }
        
        int Aux = (moneda.getValor()-precioBebidas)/100;
        switch(BebidaElegida){
            case 1 -> {
                if(depBebidas.DepositoCoca.isEmpty()){
                    depMonedas.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan CocaColas");
                }else{
                    depMonedas.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux ; i++){
                        depMonedas.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depBebidas.DepositoBebidaSacar = depBebidas.DepositoCoca.remove(0);
                }
            }
            case 2 -> {
                if(depBebidas.DepositoSprite.isEmpty()){
                    depMonedas.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Sprites");
                }else{
                    depMonedas.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depMonedas.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depBebidas.DepositoBebidaSacar = depBebidas.DepositoSprite.remove(0);
                }
            }
            case 3 -> {
                if(depBebidas.DepositoFanta.isEmpty()){
                    depMonedas.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan Fantas");
                }else{
                    depMonedas.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depMonedas.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depBebidas.DepositoBebidaSacar = depBebidas.DepositoFanta.remove(0);
                }
            }
            case 4 -> {
                if(depBebidas.DepositoLimonSoda.isEmpty()){
                    depMonedas.DepositoVuelto.add(moneda);
                    throw new NoHayBebidaException("No quedan LimonSoda");
                }else{
                    depMonedas.DepositoPagado.add(moneda);
                    for(int i=0 ;  i<Aux  ; i++){
                        depMonedas.DepositoVuelto.add(new Moneda100(Moneda.serieMonedas));
                        Moneda.serieMonedas = Moneda.serieMonedas+1;
                    }
                    depBebidas.DepositoBebidaSacar = depBebidas.DepositoLimonSoda.remove(0);
                }
            }
        }
    }
    
    public Moneda getVuelto() throws DepositoVueltoVacioException{
        if(depMonedas.DepositoVuelto.isEmpty()){
            throw new DepositoVueltoVacioException("No tiene vuelto que retirar");
         }else{
            return depMonedas.DepositoVuelto.remove(0);
         }
    }
    
    public Bebida getBebida(){
        if(depBebidas.DepositoBebidaSacar == null){
            throw new DepositoBebidaVacioException("No tiene bebida que retirar");
        }else{
            Bebida aux = depBebidas.DepositoBebidaSacar;
            depBebidas.DepositoBebidaSacar = null;
            return aux;
        }
    }
    
    public void Refill(){
        for(int i = depBebidas.DepositoCoca.size(); i< 5 ; i++){
            CocaCola aux = new CocaCola(Bebida.serieBebidas);
            depBebidas.DepositoCoca.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depBebidas.DepositoSprite.size(); i< 5; i++){
            Sprite aux = new Sprite(Bebida.serieBebidas);
            depBebidas.DepositoSprite.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depBebidas.DepositoFanta.size(); i< 5; i++){
            Fanta aux = new Fanta(Bebida.serieBebidas);
            depBebidas.DepositoFanta.add(aux);
            Bebida.serieBebidas = Bebida.serieBebidas+1;
        }
        for(int i = depBebidas.DepositoLimonSoda.size(); i< 5 ; i++){
            LimonSoda aux = new LimonSoda(Bebida.serieBebidas);
            depBebidas.DepositoLimonSoda.add(aux);
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
        for(int j = 0; j < depBebidas.DepositoCoca.size() ; j++){
            depBebidas.DepositoCoca.get(j).setXY(x+95, y+591-((j+1)*100));
            depBebidas.DepositoCoca.get(j).paint(g, panel);
        }
        for(int j = 0; j < depBebidas.DepositoSprite.size() ; j++){
            depBebidas.DepositoSprite.get(j).setXY(x+175, y+591-((j+1)*100));
            depBebidas.DepositoSprite.get(j).paint(g, panel);
        }
        for(int j = 0; j < depBebidas.DepositoFanta.size() ; j++){
            depBebidas.DepositoFanta.get(j).setXY(x+255, y+591-((j+1)*100));
            depBebidas.DepositoFanta.get(j).paint(g, panel);
        }
        for(int j = 0; j < depBebidas.DepositoLimonSoda.size() ; j++){
            depBebidas.DepositoLimonSoda.get(j).setXY(x+335, y+591-((j+1)*100));
            depBebidas.DepositoLimonSoda.get(j).paint(g, panel);
        }
        // Bebida Comprada
        if(depBebidas.DepositoBebidaSacar!=null){
            depBebidas.DepositoBebidaSacar.setXY(x+464, y+500);
            depBebidas.DepositoBebidaSacar.paint(g, panel);
        }
        // Vuelto
        for(int j = 0; j < depMonedas.DepositoVuelto.size() ; j++){
            if(j<4){
                depMonedas.DepositoVuelto.get(j).paint(g, x+425+(j*25), y+416, 49, 49, panel);
            }else if(j<8){
                depMonedas.DepositoVuelto.get(j).paint(g, x+425+((j-4)*25), y+382, 49, 49, panel);
            }else if(j<12){
                depMonedas.DepositoVuelto.get(j).paint(g, x+425+((j-8)*25), y+348, 49, 49, panel);
            }
        }
    }
    
    public Expendedor(int numBebidas, int precioBebidas){
        depBebidas = new DepositosBebidas(numBebidas);
        depMonedas = new DepositosMonedas();
        x = 667;
        y = 28;
        this.precioBebidas = precioBebidas;
        depBebidas.DepositoBebidaSacar = null;
    }
}