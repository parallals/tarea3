package tarea3;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

/*______________________________________BEBIDA______________________________________*/
public abstract class Bebida{
    // PROPIEDADES
    private int numSerie;
    private int x;
    private int y;
    static int cocaGlobal = 41;
    static int spriteGlobal = 46;
    static int fantaGlobal = 51;
    static int limonsodaGlobal = 56;    
    // METODOS
    public abstract String beber();
    public abstract void paint(Graphics g, int w, int h, JPanel panel);
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
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
    public void paint(Graphics g, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola-lata.png")).getImage();
            g.drawImage(i, getX(), getY(), w, h, panel);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(w == 25 && h == 47 ){
            g.setColor(Color.black);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+45);
        }
        else{
            g.setColor(Color.black);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+70);
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
    public void paint(Graphics g, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/sprite-lata.png")).getImage();
            g.drawImage(i, getX(), getY(), w, h, panel); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(w == 25 && h == 47 ){
            g.setColor(Color.white);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+45);
        }
        else{
            g.setColor(Color.white);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+70);
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
    public void paint(Graphics g, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/fanta-lata.png")).getImage();
            g.drawImage(i, getX(), getY(), w, h, panel); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(w == 25 && h == 47 ){
            g.setColor(Color.black);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+45);
        }
        else{
            g.setColor(Color.black);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+70);
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
    public void paint(Graphics g, int w, int h, JPanel panel){
        try {
            Image i = new ImageIcon(this.getClass().getResource("../Textures/limonsoda-lata.png")).getImage();
            g.drawImage(i, getX(), getY(), w, h, panel); 
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(w == 25 && h == 47 ){
            g.setColor(Color.white);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+45);
        }
        else{
            g.setColor(Color.white);
            g.drawString(String.valueOf(this.getSerie()), getX()+2, getY()+70);
        }
    }
    
    public LimonSoda(int numSerie){
        super(numSerie);
    }
}