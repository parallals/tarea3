package tarea3;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventana extends JFrame {

    public Ventana(){
       super();
      this.setLayout(new BorderLayout());
      this.setTitle("Tarea 3: Expendedor");
      setResizable(true); // Fija el tamaño de la ventana.
      this.setVisible(true); 
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.add(new PanelPrincipal());
      this.setSize(1280,720);      
      setLocationRelativeTo(null); // Centra la ventana.
   } 
}

class PanelPrincipal extends JPanel implements MouseListener{//se ve en el centro de la ventana 
    private Comprador com; 
    private Expendedor exp;
    public PanelPrincipal () { 
        this.setLayout(null);
        this.exp = new Expendedor(5,1000); 
        this.com = new Comprador(null, 0, exp); 
        Botones();
    }
    
    public void paint(Graphics g){ //el elemento del principio es el que va al fondo, el último el que está mas alfrente
        super.paint(g);
        int w = this.getSize().width;
        int h = this.getSize().height;
        exp.paint(g,w,h);
        // aqui pasa la magia            
            try { Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola.png")).getImage(); //HAY QUE DEJAR LOS SPRITES DE LAS COSAS EN EL PAQUETE JUNTO A LAS CLASES, hasta encontrar un método más elegante
            g.drawImage(i, 0+w/5, 0+h/3, w/3, h/3, this);
            } catch(Exception e){
                System.out.println("No cargo la imagen");                
            }
            // aqui termina la magia (gracias rena)   
    }
       
     private void Botones(){
        int w = this.getSize().width;
        int h = this.getSize().height;
        
        JButton Cocacola = new JButton();
        Cocacola.setBounds(h/2, w/2, 100,100);
        Cocacola.setEnabled(true);
        try {
            ImageIcon CocacolaLogo = new ImageIcon("../Textures/cocacola-logo.jpg");
            Cocacola.setIcon(new ImageIcon(CocacolaLogo.getImage().getScaledInstance(Cocacola.getWidth(), Cocacola.getHeight(), Image.SCALE_SMOOTH)));
        } catch(Exception e){
            System.out.println("No cargo la imagen cocacola-logo.jpg");                
        }
        this.add(Cocacola);
        
        JButton Fanta = new JButton();
        Fanta.setBounds(0, 0, h/4, w/4);
        Fanta.setEnabled(true);
        try {
            ImageIcon FantaLogo = new ImageIcon("../Textures/fanta-logo.jpg");
            Fanta.setIcon(new ImageIcon(FantaLogo.getImage().getScaledInstance(Fanta.getWidth(), Fanta.getHeight(), Image.SCALE_SMOOTH)));
        } catch(Exception e){
            System.out.println("No cargo la imagen fanta-logo.jpg");                
        }
        this.add(Fanta);
        
        JButton Sprite = new JButton();
        Sprite.setBounds(0, 0, h/4, w/4);
        Sprite.setEnabled(true);
        try {
            ImageIcon SpriteLogo = new ImageIcon("../Textures/sprite-logo.jpg");
            Sprite.setIcon(new ImageIcon(SpriteLogo.getImage().getScaledInstance(Sprite.getWidth(), Sprite.getHeight(), Image.SCALE_SMOOTH)));
        } catch(Exception e){
            System.out.println("No cargo la imagen sprite-logo.jpg");                
        }
        this.add(Sprite);
        
        JButton LimonSoda = new JButton();
        LimonSoda.setBounds(0, 0, h/4, w/4);
        LimonSoda.setEnabled(true);
        try {
            ImageIcon LimonSodaLogo = new ImageIcon("../Textures/limonsoda-logo.png");
            LimonSoda.setIcon(new ImageIcon(LimonSodaLogo.getImage().getScaledInstance(LimonSoda.getWidth(), LimonSoda.getHeight(), Image.SCALE_DEFAULT)));
        } catch(Exception e){
            System.out.println("No cargo la imagen limonsoda-logo.jpg");                
        }
        this.add(LimonSoda);
     }
    
    public void mouseClicked(MouseEvent me) {
        
    } // es llamado cuando el press y el release ocurren en el mismo pixel
    public void mousePressed(MouseEvent me) {
        System.out.println("press"); //se imprimirá press cada vez que se oprima un botón del mouse dentro del área
    }
    public void mouseReleased(MouseEvent me) {
    } // el llamado al soltar el botón
    public void mouseEntered(MouseEvent me) {
    }  // cursor entra al área
    public void mouseExited(MouseEvent me) {
    }   // cursor sale del área 
 
   
}



