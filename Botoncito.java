import javax.swing.*;

import java.awt.Cursor;
import java.awt.event.*;

public class Botoncito extends JButton implements ActionListener {
  Imagenes img1;
  Texto txt1;
  Texto[] tiempos;
  Timer tm1;
  Etiquetas pedidos;
  Botoncito btn1, btn2, btn4;
  private int cont = 0;
  private int[] tiempoIngrediente;

  public Botoncito(String url, String name) {
    ImageIcon img = new ImageIcon(this.getClass().getResource(url));
    setIcon(img);
    setName(name);
    setFocusPainted(false);
    setBorderPainted(false);
    setContentAreaFilled(false);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btn1) {
      tm1.setText("00:00:00");
      pedidos.setText("0");
      Thread t1 = new Thread(img1);
      Thread t2 = new Thread(tm1);
      if (txt1.getText().toString().equals("")) {
        JOptionPane.showMessageDialog(null, "Ingrese un numero", "Advertencia", JOptionPane.WARNING_MESSAGE);
      } else {
        if (Integer.parseInt(txt1.getText().toString()) < 1) {
          JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0", "Advertencia",
              JOptionPane.WARNING_MESSAGE);
        } else {
          img1.txt1 = txt1;
          tiempoIngrediente = new int[tiempos.length];
          for (int i = 0; i < tiempoIngrediente.length; i++) {
            tiempoIngrediente[i] = Integer.parseInt(tiempos[i].getText().toString());
          }
          img1.tiempoImagenes = tiempoIngrediente;
          setEnabled(false);
          btn2.setEnabled(true);
          btn4.setEnabled(true);
          t1.start();
          t2.start();
        }
      }
    }
    if (e.getSource() == btn2) {
      // System.out.println("Hola");
      if (cont == 0) {
        img1.pausarHilo();
        tm1.pausarHilo();
        setIcon(new ImageIcon(this.getClass().getResource("images/play.png")));
        cont = 1;
      } else {
        tiempoIngrediente = new int[tiempos.length];
        for (int i = 0; i < tiempoIngrediente.length; i++) {
          tiempoIngrediente[i] = Integer.parseInt(tiempos[i].getText().toString());
        }

        img1.tiempoImagenes = tiempoIngrediente;
        img1.reanudarHilo();
        tm1.reanudarHilo();
        setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
        cont = 0;
      }

    }
    if (e.getSource() == btn4) {
      setDefaults();
      img1.stopHilo();
      tm1.stopHilo();
      setEnabled(false);
      btn1.setEnabled(true);
      btn2.setEnabled(false);
      btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
    }

  }// end actionPerformed

  public void setDefaults() {
    tiempos[0].setText("4");
    tiempos[1].setText("2");
    tiempos[2].setText("2");
    tiempos[3].setText("6");
    tiempos[4].setText("3");
    tiempos[5].setText("5");
    tiempos[6].setText("7");
    tiempos[7].setText("3");
  }
}