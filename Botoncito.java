import javax.swing.*;
import java.awt.event.*;

public class Botoncito extends JButton implements ActionListener {
  Imagenes img1;
  Texto txt1;
  Timer tm1;
  Etiquetas pedidos;
  Botoncito btn1, btn2, btn4;

  public Botoncito(String name) {
    setText(name);

  }

  public void actionPerformed(ActionEvent e) {
    // System.out.println("Hola");

    if (e.getActionCommand() == "Iniciar") {
      tm1.setText("00:00:00");
      pedidos.setText("0");
      Thread t1 = new Thread(img1);
      Thread t2 = new Thread(tm1);
      if (txt1.getText().toString().equals("")) {
        JOptionPane.showMessageDialog(null, "Ingrese un numero","Advertencia", JOptionPane.WARNING_MESSAGE);
      } else {
        if(Integer.parseInt(txt1.getText().toString())<1){
          JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0","Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
          img1.txt1=txt1;
          setEnabled(false);
          btn2.setEnabled(true);
          btn4.setEnabled(true);
          t1.start();
          t2.start();
        }
      }
    }
    if (e.getActionCommand() == "Pausar") {
      // System.out.println("Hola");
      img1.pausarHilo();
      tm1.pausarHilo();
      setText("Reanudar");

    }
    if (e.getActionCommand() == "Parar") {
      img1.stopHilo();
      tm1.stopHilo();
      setEnabled(false);
      btn1.setEnabled(true);
      btn2.setEnabled(false);
      btn2.setText("Pausar");
      // System.out.println("Hola");
    }
    if (e.getActionCommand() == "Reanudar") {
      img1.reanudarHilo();
      tm1.reanudarHilo();
      setText("Pausar");
      // System.out.println("Hola");
    }
    /*
     * etiqueta.setText("Hola");
     * 
     * Thread t1=new Thread(et1);
     * t1.start();
     */
  }// end actionPerformed
}