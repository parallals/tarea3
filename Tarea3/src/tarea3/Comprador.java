package tarea3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.ArrayList;

public class Comprador{
    
    protected Bebida bebida;
    private final ArrayList<Bebida> bebidasCompradas;
    private Moneda moneda;
    private final Expendedor exp;
    private int serieMonedas;

    public Comprador(Expendedor expendedor){
        bebida = null;
        bebidasCompradas = new ArrayList<>();
        exp = expendedor;
        serieMonedas = 0;
    }
    
    public void DarMoneda(int opcion){
        switch(opcion){
            case 1 -> {
                moneda = new Moneda100(serieMonedas);
                serieMonedas = serieMonedas+1;
            }
            case 2 -> {
                moneda = new Moneda500(serieMonedas);
                serieMonedas = serieMonedas+1;
            }
            case 3 -> {
                moneda = new Moneda1000(serieMonedas);
                serieMonedas = serieMonedas+1;
            }
        }
    }
    
    public void PagarBebida(int BebidaElegida){
        exp.ComprarBebida(BebidaElegida, moneda);
        moneda = null;
    }
    
    public void RetirarBebida(){
        bebida = exp.getBebida();
    }
            
    public void paint(Graphics g, int w, int h, JPanel panel){
        g.setColor(new Color(50, 10, 20)); //Bebidas Compradas
        g.fillRect(1*w/36, h/24, 17*w/36, 5*h/24);
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/compracompleto.png")).getImage();
            g.drawImage(i, 150, 180, 500, 500, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        g.setColor(new Color(50, 10, 20)); //Selecciona moneda
        g.fillRect(3*w/36,21*h/24, 10*w/36, 5*h/24);
        try {
            Image i1 = new ImageIcon(this.getClass().getResource("../Textures/Moneda100.png")).getImage();
            g.drawImage(i1, 140, 600, 80, 80, panel);
            Image i2 = new ImageIcon(this.getClass().getResource("../Textures/Moneda500.png")).getImage();
            g.drawImage(i2, 240, 600, 80, 80, panel);
            Image i3 = new ImageIcon(this.getClass().getResource("../Textures/Moneda1000.png")).getImage();
            g.drawImage(i3, 340, 600, 80, 80, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(moneda!=null){
            moneda.paint(g, 570, 500, 80, 80, panel);
        }
        for(int j = 0; j < bebidasCompradas.size() ; j++){
            if(j<19){
                bebidasCompradas.get(j).paint(g, j*30+50, 40, 25, 47, panel);
            }else if(j<37){
                bebidasCompradas.get(j).paint(g, j*30-520, 95, 25, 47, panel);
            }else{
                bebidasCompradas.remove(37);
            }           
        }
        if(bebida != null){
           bebida.paint(g, 590, 505, 50, 75, panel);
           bebidasCompradas.add(bebida);
           bebida = null;
        }
    }
}