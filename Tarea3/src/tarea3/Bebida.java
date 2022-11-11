package tarea3;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

/*______________________________________BEBIDA______________________________________*/
public abstract class Bebida{
    // PROPIEDADES
    private final int numSerie;
    // METODOS
    public abstract String beber();
    public abstract void paint(Graphics g, int x, int y, int w, int h, JPanel panel);
    
    public int getSerie(){
        return numSerie;
    }
    
    public Bebida(int numSerie){
        this.numSerie = numSerie;
    }
}

/*______________________________________COCACOLA______________________________________*/
class CocaCola extends Bebida{
    // METODOS
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

/*______________________________________SPRITE______________________________________*/
class Sprite extends Bebida{
    // METODOS
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

/*______________________________________FANTA______________________________________*/
class Fanta extends Bebida{
    // METODOS
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

/*______________________________________LIMONSODA______________________________________*/
class LimonSoda extends Bebida{
    // METODOS
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