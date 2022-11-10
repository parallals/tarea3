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
        setResizable(false); // Fija el tamaño de la ventana.
        this.setVisible(true); 
        this.add(new PanelPrincipal());
      
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);      
        setLocationRelativeTo(null); // Centra la ventana.
   } 
    
    
}


