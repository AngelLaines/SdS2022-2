import javax.swing.*;

import java.awt.Cursor;
import java.awt.event.*;

public class Botoncito extends JButton implements ActionListener {
  Imagenes img1;
  Texto txt1;
  Texto[] tiempos,cantidades;
  Container cnt;
  Timer tm1;
  Etiquetas pedidos;
  Botoncito btn1, btn2, btn4,btn5;
  private int cont = 0;
  private double[] tiempoIngrediente;

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
          tiempoIngrediente = new double[tiempos.length];
          for (int i = 0; i < tiempoIngrediente.length; i++) {
            tiempoIngrediente[i] = Double.parseDouble(tiempos[i].getText().toString());
          }
          cnt.setTortilla(Integer.parseInt(cantidades[0].getText()));
          cnt.setCarne(Integer.parseInt(cantidades[1].getText()));
          cnt.setRepollo(Integer.parseInt(cantidades[2].getText()));
          cnt.setVerdura(Integer.parseInt(cantidades[3].getText()));
          cnt.setLimon(Integer.parseInt(cantidades[4].getText()));
          cnt.setPepino(Integer.parseInt(cantidades[5].getText()));
          cnt.setSalsa(Integer.parseInt(cantidades[6].getText()));
          cnt.setCebolla(Integer.parseInt(cantidades[7].getText()));

          System.out.println("Cantidad de tortillas: "+cnt.getTortilla());
          System.out.println("Cantidad de carne: "+cnt.getCarne());
          System.out.println("Cantidad de repollo: "+cnt.getRepollo());
          System.out.println("Cantidad de verdura: "+cnt.getVerdura());
          System.out.println("Cantidad de limon: "+cnt.getLimon());
          System.out.println("Cantidad de pepino: "+cnt.getPepino());
          System.out.println("Cantidad de salsa: "+cnt.getSalsa());
          System.out.println("Cantidad de cebolla: "+cnt.getCebolla());

          img1.tiempoImagenes = tiempoIngrediente;
          img1.cnt=cnt;
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
        tiempoIngrediente = new double[tiempos.length];
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
      img1.stopHilo();
      tm1.stopHilo();
      setEnabled(false);
      btn1.setEnabled(true);
      btn2.setEnabled(false);
      btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
    }
    if (e.getSource()==btn5) {
      setDefaults();
    }

  }// end actionPerformed

  public void setDefaults() {
    tiempos[0].setText("4.0");
    tiempos[1].setText("2.0");
    tiempos[2].setText("2.0");
    tiempos[3].setText("6.0");
    tiempos[4].setText("3.0");
    tiempos[5].setText("5.0");
    tiempos[6].setText("7.0");
    tiempos[7].setText("3.0");
    for (int i = 0; i < cantidades.length; i++) {
      cantidades[i].setText("0");
    }
    txt1.setText("0");
    cnt.setTortilla(0);
    cnt.setCarne(0);
    cnt.setRepollo(0);
    cnt.setVerdura(0);
    cnt.setLimon(0);
    cnt.setPepino(0);
    cnt.setSalsa(0);
    cnt.setCebolla(0);
  }
}