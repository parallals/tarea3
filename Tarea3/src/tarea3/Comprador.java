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
            
    public void paint(Graphics g, JPanel panel){
        // Comprador 
        try {
            Image i1 = new ImageIcon(this.getClass().getResource("../Textures/compracompleto.png")).getImage();
            g.drawImage(i1, 148, 170, 494, 473, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // "Mueble" para las Bebidas
        g.setColor(new Color(150,10,10)); 
        g.fillRect(18, 14, 632, 170);
        // Bebidas Compradas
        for(int j = 0; j < bebidasCompradas.size() ; j++){
            if(j<19){
                bebidasCompradas.get(j).setXY(40+(j*30), 25);
                bebidasCompradas.get(j).paint(g, panel);
            }else if(j<37){
                bebidasCompradas.get(j).setXY(-530+(j*30), 100);
                bebidasCompradas.get(j).paint(g, panel);
            }           
        }
        // "Mueble" seleccion de moneda
        g.setColor(new Color(150,10,10));
        g.fillRect(123, 582, 316, 142);
        // Monedas a Seleccionar
        try {
            Image i2 = new ImageIcon(this.getClass().getResource("../Textures/Moneda100.png")).getImage();
            g.drawImage(i2, 138, 592, 79, 79, panel);
            Image i3 = new ImageIcon(this.getClass().getResource("../Textures/Moneda500.png")).getImage();
            g.drawImage(i3, 237, 592, 79, 79, panel);
            Image i4 = new ImageIcon(this.getClass().getResource("../Textures/Moneda1000.png")).getImage();
            g.drawImage(i4, 336, 592, 79, 79, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Bebida en mano
        if(bebida!=null){
            bebida.setXY(575, 486);
            bebida.paint(g, panel);
            bebidasCompradas.add(bebida);
            bebida = null;
        }
        // Moneda Seleccionada
        if(moneda!=null && bebida == null){
            moneda.paint(g, 564, 473, 79, 79, panel);
        }
        // Monedero
        g.setColor(new Color(150,10,10));
        g.fillRect(18, 284, 105, 227);
        // Monedas vuelto
        for(int j = 0; j < Monedero.size() ; j++){
            if(j<7){
                Monedero.get(j).paint(g, 26, 298+(j*30), 29, 29, panel);
            }else if(j<14){
                Monedero.get(j).paint(g, 44, 298+((j-7)*30), 29, 29, panel);
            }else if(j<21){
                Monedero.get(j).paint(g, 62, 298+((j-14)*30),  29, 29, panel);
            }else if(j<28){
                Monedero.get(j).paint(g, 80, 298+((j-21)*30), 29, 29, panel);
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