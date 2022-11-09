package tarea3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;

class Botones extends JButton {
    
    public Botones(){

        //this.addActionListener(new EscuchadorButton());
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(250, 50, 50));
    }
    }


