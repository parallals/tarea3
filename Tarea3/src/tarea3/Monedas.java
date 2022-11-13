package tarea3;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

/*______________________________________MONEDA______________________________________*/
abstract class Moneda{
    //PROPIEDADES
    private final int serie;
    protected static int serieMonedas = 0 ;
    // METODOS
    abstract public int getValor();
    public abstract void paint(Graphics g, int x, int y, int w, int h, JPanel panel);
    
    public int getSerie(){
        return serie;
    }
    
    public Moneda(int serie){
        this.serie = serie;
    }
}

/*______________________________________MONEDA100______________________________________*/
class Moneda100 extends Moneda{
    // METODOS
    @Override
    public int getValor(){
        return 100;
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/Moneda100.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
            g.setColor(new Color(255, 255, 255));
            g.drawString(String.valueOf(this.getSerie()), x+w/3, y+5*h/6);
    }
    
    public Moneda100(int serie){
        super(serie);
    }
}
/*______________________________________MONEDA500______________________________________*/
class Moneda500 extends Moneda{
    // METODOS
    @Override
    public int getValor(){
        return 500;
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/Moneda500.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
            g.setColor(new Color(255, 255, 255));
            g.drawString(String.valueOf(this.getSerie()), x+w/3, y+5*h/6);
    }
    
    public Moneda500(int serie){
        super(serie);
    }
}

/*______________________________________MONEDA1000______________________________________*/
class Moneda1000 extends Moneda{
    // METODOS
    @Override
    public int getValor(){
        return 1000;
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/Moneda1000.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
            g.setColor(new Color(0, 0, 0));
            g.drawString(String.valueOf(this.getSerie()), x+w/3, y+5*h/6);
    }
    
    public Moneda1000(int serie){
        super(serie);
    }
}
