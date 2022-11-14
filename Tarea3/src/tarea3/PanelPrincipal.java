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
            if(me.getX()>=138 && me.getY()<=592+79 && me.getX()<=138+79 && me.getY()>=592){
                com.DarMoneda(1);      
                PanelPrincipal.this.repaint();
            }
            // Boton para darle una Moneda de 500 al Comprador.
            if(me.getX()>=237 && me.getY()<=592+79 && me.getX()<=237+79 && me.getY()>=592){
                com.DarMoneda(2);
                PanelPrincipal.this.repaint();            
            } 
            // Boton para darle una Moneda de 1000 al Comprador.
            if(me.getX()>=336 && me.getY()<=592+79 && me.getX()<=336+79 && me.getY()>=592){
                com.DarMoneda(3);     
                PanelPrincipal.this.repaint();           
            }
            // Boton para comprar CocaCola.
            if(me.getX() >= exp.getX()+428 && me.getY() <= exp.getY()+72+50 && me.getX() <= exp.getX()+428+120 && me.getY() >= exp.getY()+72){
                try{
                    com.PagarBebida(1);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException  e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar Sprite.
            if(me.getX() >= exp.getX()+428 && me.getY() <= exp.getY()+132+50 && me.getX() <= exp.getX()+428+120 && me.getY() >= exp.getY()+132){
                try{
                    com.PagarBebida(2);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar Fanta.
            if(me.getX() >= exp.getX()+428 && me.getY() <= exp.getY()+192+50 && me.getX() <= exp.getX()+428+120 && me.getY() >= exp.getY()+192){
                try{
                    com.PagarBebida(3);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            } 
            // Boton para comprar LimonSoda.
            if(me.getX() >= exp.getX()+428 && me.getY() <= exp.getY()+252+50 && me.getX() <= exp.getX()+428+120 && me.getY() >= exp.getY()+252){
                try{
                    com.PagarBebida(4);
                } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException e){
                    System.out.println(e.getMessage());
                }
                PanelPrincipal.this.repaint();
            }
            // Para retirar una bebida comprada.
            if(me.getX() >= exp.getX()+424 && me.getY() <= exp.getY()+483+122 && me.getX() <= exp.getX()+424+126 && me.getY() >= exp.getY()+483){
                com.RetirarBebida();
                PanelPrincipal.this.repaint();
            }
            // Boton para retirar vuelto.
            if(me.getX()>=exp.getX()+424 && me.getY()<=exp.getY()+347+122 && me.getX()<=exp.getX()+424+126 && me.getY()>=exp.getY()+347){
                com.RetirarVuelto();     
                PanelPrincipal.this.repaint();           
            }
            // Boton Refill
            if(me.getX()>=exp.getX()+492 && me.getY()<=exp.getY()+29+28 && me.getX()<=exp.getX()+492+35 && me.getY()>=exp.getY()+29){
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