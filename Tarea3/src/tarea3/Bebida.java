package tarea3;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Bebida{
    private final int numSerie;
    public int getSerie(){
        return numSerie;
    }
    public abstract String beber();
    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }//../Textures/cocacola.png
    public abstract void paint(Graphics g, int x, int y, int w, int h, JPanel panel);
}

class CocaCola extends Bebida{
    @Override
    public String beber(){
        return "CocaCola";
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola-lata.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public CocaCola(int numSerie){
        super(numSerie);
    }
}


class Sprite extends Bebida{
    @Override
    public String beber(){
        return "Sprite";
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/sprite-lata.png")).getImage();
            g.drawImage(i, x, y, w, h, panel); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Sprite(int numSerie){
        super(numSerie);
    }
}


class Fanta extends Bebida{
    @Override
    public String beber(){
        return "Fanta";
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/fanta-lata.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Fanta(int numSerie){
        super(numSerie);
    }
}


class LimonSoda extends Bebida{
    @Override
    public String beber(){
        return "LimonSoda";
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/limonsoda-lata.png")).getImage();
            g.drawImage(i, x, y, w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public LimonSoda(int numSerie){
        super(numSerie);
    }
}