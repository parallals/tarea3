package tarea3;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;


public class Ventana extends JFrame {
    // METODOS
    public Ventana(){
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("Expendedor");
        setResizable(true); // Fija el tamaño de la ventana.
        this.setVisible(true); 
        this.add(new PanelPrincipal());
        this.setSize(1280,720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1280,720);      
        setLocationRelativeTo(null); // Centra la ventana.
        /*
        getContentPane().addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component)e.getSource();
                int w = c.getWidth();
                int h = c.getHeight();
                System.out.println("w = "+w+ "  y  h = "+h);
            }
        });
        */
   }   
}
// Resolucion: < w = 1264  y  h = 681 >