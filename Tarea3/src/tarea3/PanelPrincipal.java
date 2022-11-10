package tarea3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel{//se ve en el centro de la ventana 
    private Comprador com; 
    private Expendedor exp;
    public PanelPrincipal() { 
        this.exp = new Expendedor(5,1000); 
        this.com = new Comprador(null, 0, exp); 
        EscuchaRaton1 er1 = new EscuchaRaton1();
        this.addMouseListener(er1);
    }
    
    public void paint(Graphics g){ //el elemento del principio es el que va al fondo, el último el que está mas alfrente
        super.paint(g);
        Dimension size = this.getSize();
        int w = size.width;
        int h = size.height;
        this.setBackground(Color.gray);
        exp.paint(g,w,h);          
        // aqui pasa la magia            
            try { Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola.png")).getImage(); //HAY QUE DEJAR LOS SPRITES DE LAS COSAS EN EL PAQUETE JUNTO A LAS CLASES, hasta encontrar un método más elegante
            //g.drawImage(i, w/5, h/3, w/3, h/3, this);
            g.drawImage(i, 200, 200, 200, 200, this);
            } catch(Exception e){
                System.out.println("No cargo la imagen");                
            }
        
            /*for(int j = 0; j < exp.DepositoCoca.size() ; j++){            
                Image i = new ImageIcon(this.getClass().getResource("../Textures/cocacola-lata.png")).getImage();
                g.drawImage(i, 725, 620-(j+1)*100, 50, 75, this);            
            } */   
    }
             
    private class EscuchaRaton1 implements MouseListener{
        public void mouseClicked(MouseEvent me) {
            
        }    
        public void mousePressed(MouseEvent me){
            if(me.getX() >= 200 && me.getY() <= 400&& me.getX() <= 400 && me.getY() >= 200){
                System.out.println("presionada la coca");
            } 
        //se imprimirá press cada vez que se oprima un botón del mouse dentro del área
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
    
}