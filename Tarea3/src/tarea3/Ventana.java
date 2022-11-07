package tarea3;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana(){
       super();
      this.setLayout(new BorderLayout());
      this.setTitle("Tarea 3: Expendedor");
      this.setSize(1280,720);
      setResizable(false); // Fija el tamaño de la ventana.
      setLocationRelativeTo(null); // Centra la ventana.
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true); 
   } 
}
 
// https://lineadecodigo.com/java/centrar-un-jframe/
// https://www.jairogarciarincon.com/clase/interfaces-de-usuario-con-java-swing/componentes-jframe-jlabel-y-jdialog-dialogos-modales