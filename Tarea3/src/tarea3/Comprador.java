package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Comprador{
    private int vuelto;
    private String sabor;
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return sabor;
    }

    /*public void ComprarOtra(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        Bebida bebida;
        try{
            bebida = expendedor.ComprarBebida(BebidaElegida, moneda);
            this.sabor =  bebida.beber();
        } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
            System.out.println(e.getMessage());
            bebida = null;
            this.sabor = null;
        }
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }else{
                i=10;
            }
        }
    }*/
    public Comprador(Moneda moneda, int BebidaElegida, Expendedor expendedor){
        Bebida bebida;
        try{
            //bebida = expendedor.ComprarBebida(BebidaElegida, moneda);
            expendedor.ComprarBebida(BebidaElegida, moneda);
            bebida = expendedor.getBebida();
            this.sabor =  bebida.beber();
        } catch (NoHayBebidaException | PagoInsuficienteException | PagoIncorrectoException | EleccionInexistenteException e){
            System.out.println(e.getMessage());
            bebida = null;
            this.sabor = null;
        }
        this.vuelto = 0;
        for(int i=0 ; i<10 ; i++){
            Moneda Aux = expendedor.getVuelto();
            if(Aux != null){
                this.vuelto = this.vuelto + Aux.getValor();
            }else{
                i=10;
            }
        }
    }
    public void paint(Graphics g, JPanel panel){
        Image i = new ImageIcon(this.getClass().getResource("../Textures/compracompleto.png")).getImage();
        g.drawImage(i, 150,180,500,500, panel);
    }
}