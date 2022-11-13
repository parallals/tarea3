package tarea3;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Color;


public class Comprador{
    // PROPIEDADES
    private final ArrayList<Bebida> bebidasCompradas;
    private final ArrayList<Moneda> Monedero;
    private final Expendedor exp;
    private Bebida bebida;
    private Moneda moneda;
    // METODOS
    public void DarMoneda(int opcion){
        switch(opcion){
            case 1 -> {
                if(moneda != null){
                    Monedero.add(moneda);
                }
                moneda = new Moneda100(Moneda.serieMonedas);
                Moneda.serieMonedas = Moneda.serieMonedas+1;
            }
            case 2 -> {
                if(moneda != null){
                    Monedero.add(moneda);
                }
                moneda = new Moneda500(Moneda.serieMonedas);
                Moneda.serieMonedas = Moneda.serieMonedas+1;
            }
            case 3 -> {
                if(moneda != null){
                    Monedero.add(moneda);
                }
                moneda = new Moneda1000(Moneda.serieMonedas);
                Moneda.serieMonedas = Moneda.serieMonedas+1;
            }
        }
    }
    
    public void PagarBebida(int BebidaElegida){
        try {
            exp.ComprarBebida(BebidaElegida, moneda);
        } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | DepositoBebidaSacarException e){
            System.out.println(e.getMessage());
        }
        moneda = null;
    }
    
    public void RetirarVuelto(){
        try {
            Monedero.add(exp.getVuelto());
        }catch(DepositoVueltoVacioException e){
            System.out.println(e.getMessage());
        }
    }
        
    public void RetirarBebida(){
        try {
            bebida = exp.getBebida();
        } catch(DepositoBebidaVacioException e){
            System.out.println(e.getMessage());
        }
    }
            
    public void paint(Graphics g, int w, int h, JPanel panel){
        
        g.setColor(new Color(150,10,10)); //Bebidas Compradas
        g.fillRect(w/72, h/48, 18*w/36, 6*h/24);
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/compracompleto.png")).getImage();
            g.drawImage(i,(int) (w/8.53), h/4, (int)(w/2.56), (int)(h/1.44), panel);
            //g.drawImage(i, 150, 180, 500, 500, panel););
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        g.setColor(new Color(150,10,10)); //Selecciona moneda
        g.fillRect(7*w/72,41*h/48, 9*w/36, 5*h/24);
        try {
            Image i1 = new ImageIcon(this.getClass().getResource("../Textures/Moneda100.png")).getImage();
            g.drawImage(i1, (int)(w/9.14), (int)(h/1.15), w/16, h/9, panel);
            Image i2 = new ImageIcon(this.getClass().getResource("../Textures/Moneda500.png")).getImage();
            g.drawImage(i2, (int)(w/9.14) +(int)(w/12.8), (int)(h/1.15), w/16, h/9, panel);
            Image i3 = new ImageIcon(this.getClass().getResource("../Textures/Moneda1000.png")).getImage();
            g.drawImage(i3, (int)(w/9.14) +(int)(2*w/12.8), (int)(h/1.15), w/16, h/9, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(moneda!=null && bebida == null){
            moneda.paint(g, (int)(w/2.24), (int)(h/1.44), w/16, h/9, panel);
        }
        for(int j = 0; j < bebidasCompradas.size() ; j++){ //Comprar bebida
            if(j<19){
                Bebida aux = bebidasCompradas.get(j);
                aux.setXY(j*30+50, 40);
                bebidasCompradas.get(j).paint(g, w/51, h/16, panel);
            }else if(j<37){
                Bebida aux = bebidasCompradas.get(j);
                aux.setXY(j*30-520, 95);
                bebidasCompradas.get(j).paint(g, w/51, h/16, panel);
            }           
        }
        if(bebida != null){ //Bebida en la mano despues de comprar
            bebida.setXY((int)(w/2.2),(int)(h/1.4));
            bebida.paint(g, (int)(w/25.6), (int)(h/9.6), panel);
            bebidasCompradas.add(bebida);
            bebida = null;
        }
        g.setColor(new Color(150,10,10)); // Monedero
        g.fillRect(1*w/72, 10*h/24, 3*w/36, 8*h/24);
        for(int j = 0; j < Monedero.size() ; j++){
            if(j<7){
                Monedero.get(j).paint(g, 3*w/144, j*30+21*h/48, (int)(w/42.6), h/24, panel);
            }else if(j<14){
                Monedero.get(j).paint(g, 5*w/144, (j-7)*30+21*h/48, (int)(w/42.6), h/24, panel);
            }else if(j<21){
                Monedero.get(j).paint(g, 7*w/144, (j-14)*30+21*h/48,  (int)(w/42.6), h/24, panel);
            }else if(j<28){
                Monedero.get(j).paint(g, 9*w/144, (j-21)*30+21*h/48,(int)(w/42.6), h/24, panel);
            }
        }
    }
    
    public Comprador(Expendedor expendedor){
        bebidasCompradas = new ArrayList<>();
        Monedero = new ArrayList<>();
        bebida = null;
        exp = expendedor;
    }
}