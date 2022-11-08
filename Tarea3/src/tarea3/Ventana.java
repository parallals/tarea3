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
      this.setSize(1280,721);
      setResizable(true); // Fija el tamaño de la ventana.
      setLocationRelativeTo(null); // Centra la ventana.
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true); 
      this.add(new PanelPrincipal());
      this.setSize(1280,720);      
   } 
}

class PanelPrincipal extends JPanel implements MouseListener{//se ve en el centro de la ventana 
    private Comprador com; 
    private Expendedor exp;    
    public PanelPrincipal () { 
        this.exp = new Expendedor(5,1000); 
        this.com = new Comprador(null, 0, exp); 
    }
    public void paint(Graphics g){ //el elemento del principio es el que va al fondo, el último el que está mas alfrente
        super.paint(g);
        
        Dimension size = this.getSize();
        int w = size.width;
        int h = size.height;
        this.setBackground(Color.green);
        exp.paint(g,w,h);
        // aqui pasa la magia            
            try { Image i = new ImageIcon(this.getClass().getResource("cocacola.png")).getImage(); //HAY QUE DEJAR LOS SPRITES DE LAS COSAS EN EL PAQUETE JUNTO A LAS CLASES, hasta encontrar un método más elegante
            g.drawImage(i, 0+w/5, 0+h/3, w/3, h/3, this);
            } catch(Exception e){
                System.out.println("No cargo la imagen");                
            }
            //exp.paint(g,w,h);
            // aqui termina la magia (gracias rena)
            
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
            
// https://lineadecodigo.com/java/centrar-un-jframe/
// https://www.jairogarciarincon.com/clase/interfaces-de-usuario-con-java-swing/componentes-jframe-jlabel-y-jdialog-dialogos-modales