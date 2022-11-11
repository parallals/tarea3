package tarea3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class PanelPrincipal extends JPanel{//se ve en el centro de la ventana 
    private final Comprador com; 
    private final Expendedor exp;
    
    public PanelPrincipal() { 
        this.exp = new Expendedor(5,500); 
        this.com = new Comprador(exp); 
        EscuchaRaton1 er1 = new EscuchaRaton1();
        this.addMouseListener(er1);
    }
    
    public void paint(Graphics g){ //el elemento del principio es el que va al fondo, el último el que está mas alfrente
        super.paint(g);
        Dimension size = this.getSize();
        int w = size.width;
        int h = size.height;
        this.setBackground(Color.gray);
        exp.paint(g,w,h,this);
        com.paint(g,w,h,this);
        try{ 
            Image i1 = new ImageIcon(this.getClass().getResource("../Textures/cocacola-logo.jpg")).getImage();
            g.drawImage(i1,1095, 100, 120, 50, this);
            Image i2 = new ImageIcon(this.getClass().getResource("../Textures/sprite-logo.jpg")).getImage();
            g.drawImage(i2,1095, 160, 120, 50, this);
            Image i3 = new ImageIcon(this.getClass().getResource("../Textures/fanta-logo.jpg")).getImage();
            g.drawImage(i3,1095, 220, 120, 50, this);
            Image i4 = new ImageIcon(this.getClass().getResource("../Textures/limonsoda-logo.png")).getImage();
            g.drawImage(i4,1095, 280, 120, 50, this);
         }catch(Exception e){
            System.out.println("No cargo alguna de las imagenes");                
         }
    }
           
    private class EscuchaRaton1 implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent me){
            
            if(me.getX() >= 1095 && me.getY() <= 100 +50 && me.getX() <= 1095+120 && me.getY() >= 100){
                try{
                    com.PagarBebida(1);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            
            if(me.getX() >= 1095 && me.getY() <= 160 +50 && me.getX() <= 1095+120 && me.getY() >= 160){
                try{
                    com.PagarBebida(2);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            
            if(me.getX() >= 1095 && me.getY() <= 220 +50 && me.getX() <= 1095+120 && me.getY() >= 220){
                try{
                    com.PagarBebida(3);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            
            if(me.getX() >= 1095 && me.getY() <= 280 +50 && me.getX() <= 1095+120 && me.getY() >= 280){
                try{
                    com.PagarBebida(4);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            
            if(exp.DepositoBebidaSacar != null){
                if(me.getX() >= 1131 && me.getY() <= 528 +50 && me.getX() <= 1131+75 && me.getY() >= 528){
                    com.RetirarBebida();
                    PanelPrincipal.this.repaint();
                }
            }
            
            if(me.getX()>=140 && me.getY()<=600+80 && me.getX()<=140+80 && me.getY()>=600){
                com.DarMoneda(1);      
                PanelPrincipal.this.repaint();          
            } 
            
            if(me.getX()>=240 && me.getY()<=600+80 && me.getX()<=240+80 && me.getY()>=600){
                com.DarMoneda(2);
                PanelPrincipal.this.repaint();            
            } 
            
            if(me.getX()>=340 && me.getY()<=600+80 && me.getX()<=340+80 && me.getY()>=600){
                com.DarMoneda(3);     
                PanelPrincipal.this.repaint();           
            } 
        }
        @Override
        public void mouseClicked(MouseEvent me) { 
        }    
        @Override
        public void mouseReleased(MouseEvent me) {
        } // el llamado al soltar el botón
        @Override
        public void mouseEntered(MouseEvent me) {
        }  // cursor entra al área
        @Override
        public void mouseExited(MouseEvent me) {
        }   // cursor sale del área 
    }
}