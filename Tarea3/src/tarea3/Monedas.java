package tarea3;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

abstract class Moneda{
    private final int serie;
    abstract public int getValor();
    public int getSerie(){
        return serie;
    }
    public Moneda(int serie){
        this.serie = serie;
    }
    public abstract void paint(Graphics g, int x, int y, int w, int h, JPanel panel);
}

class Moneda1000 extends Moneda{
    
    public Moneda1000(int serie){
        super(serie);
    }
    
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
    }
}


class Moneda500 extends Moneda{
    
    public Moneda500(int serie){
        super(serie);
    }
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
    }
}


class Moneda100 extends Moneda{
    
    public Moneda100(int serie){
        super(serie);
    }
    
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
    }
}