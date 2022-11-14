package tarea3;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;


class PanelPrincipal extends JPanel{
    // PROPIEDADES
    private final Comprador com; 
    private final Expendedor exp;
    // METODOS
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.setBackground(Color.gray);
        exp.paint(g, this);
        com.paint(g, this);
    }
           
    private class EscuchaRaton implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent me){
            // Boton para darle una Moneda de 100 al Comprador.
            if(me.getX()>=140 && me.getY()<=600+80 && me.getX()<=140+80 && me.getY()>=600){
                com.DarMoneda(1);      
                PanelPrincipal.this.repaint();
            }
            // Boton para darle una Moneda de 500 al Comprador.
            if(me.getX()>=240 && me.getY()<=600+80 && me.getX()<=240+80 && me.getY()>=600){
                com.DarMoneda(2);
                PanelPrincipal.this.repaint();            
            } 
            // Boton para darle una Moneda de 1000 al Comprador.
            if(me.getX()>=340 && me.getY()<=600+80 && me.getX()<=340+80 && me.getY()>=600){
                com.DarMoneda(3);     
                PanelPrincipal.this.repaint();           
            }
            // Boton para comprar CocaCola.
            if(me.getX() >= 1095 && me.getY() <= 100 +50 && me.getX() <= 1095+120 && me.getY() >= 100){
                try{
                    com.PagarBebida(1);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException  e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar Sprite.
            if(me.getX() >= 1095 && me.getY() <= 160 +50 && me.getX() <= 1095+120 && me.getY() >= 160){
                try{
                    com.PagarBebida(2);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar Fanta.
            if(me.getX() >= 1095 && me.getY() <= 220 +50 && me.getX() <= 1095+120 && me.getY() >= 220){
                try{
                    com.PagarBebida(3);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar LimonSoda.
            if(me.getX() >= 1095 && me.getY() <= 280 +50 && me.getX() <= 1095+120 && me.getY() >= 280){
                try{
                    com.PagarBebida(4);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            }
            // Para retirar una bebida comprada.
            if(me.getX() >= 1131 && me.getY() <= 528 +50 && me.getX() <= 1131+75 && me.getY() >= 528){
                com.RetirarBebida();
                PanelPrincipal.this.repaint();
            }
            // Boton para retirar vuelto.
            if(me.getX()>=1091 && me.getY()<=375+122 && me.getX()<=1091+126 && me.getY()>=375){
                com.RetirarVuelto();     
                PanelPrincipal.this.repaint();           
            }
            // Boton Refill
            if(me.getX()>=1158 && me.getY()<=57+28 && me.getX()<=1158+35 && me.getY()>=57){
                exp.Refill();
                PanelPrincipal.this.repaint();                
            } 
        }
        // Eventos del Mouse que no ocuparemos
        @Override
        public void mouseClicked(MouseEvent me) { 
        }    
        @Override
        public void mouseReleased(MouseEvent me) {
        }
        @Override
        public void mouseEntered(MouseEvent me) {
        }
        @Override
        public void mouseExited(MouseEvent me) {
        }
    }
    
    public PanelPrincipal() { 
        this.exp = new Expendedor(5,300); 
        this.com = new Comprador(exp); 
        EscuchaRaton er1 = new EscuchaRaton();
        this.addMouseListener(er1);
    }
}