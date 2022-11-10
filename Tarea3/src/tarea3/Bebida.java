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
    public abstract void paint(Graphics g, int j, JPanel panel);
}

class CocaCola extends Bebida{
    @Override
    public String beber(){
        return "CocaCola";
    }
    @Override
    public void paint(Graphics g, int j, JPanel panel){
        Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola-lata.png")).getImage();
            g.drawImage(i, 725, 20+(j+1)*100, 50, 75, panel);
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
    public void paint(Graphics g, int j, JPanel panel){
        Image i = new ImageIcon(this.getClass().getResource("../Textures/sprite-lata.png")).getImage();
            g.drawImage(i, 795, 20+(j+1)*100, 50, 75, panel); 
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
    public Fanta(int numSerie){
        super(numSerie);
    }
    @Override
    public void paint(Graphics g, int j, JPanel panel){
        Image i = new ImageIcon(this.getClass().getResource("../Textures/fanta-lata.png")).getImage();
            g.drawImage(i, 885, 20+(j+1)*100, 50, 75, panel);
    }
}

class LimonSoda extends Bebida{
    @Override
    public String beber(){
        return "LimonSoda";
    }
    @Override
    public void paint(Graphics g, int j, JPanel panel){
        Image i = new ImageIcon(this.getClass().getResource("../Textures/limonsoda-lata.png")).getImage();
            g.drawImage(i, 965, 20+(j+1)*100, 50, 75, panel);
    }
    public LimonSoda(int numSerie){
        super(numSerie);
    }
}