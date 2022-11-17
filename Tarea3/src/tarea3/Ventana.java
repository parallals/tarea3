package tarea3;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Ventana extends JFrame {
    // METODOS
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Tarea 3: Expendedor");
        setResizable(false);
        this.setVisible(true); 
        this.add(new PanelPrincipal());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);      
        setLocationRelativeTo(null);
   }   
}
// Resolucion: < w = 1264  y  h = 681 >