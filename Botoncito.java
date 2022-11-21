import javax.swing.*;

import java.awt.Cursor;
import java.awt.event.*;

public class Botoncito extends JButton implements ActionListener {
  Imagenes img1;
  Etiquetas etiqueta;
  Texto txt1;
  Texto[] tiempos, cantidades;
  Container cnt;
  RContainer rcnt;
  Timer tm1;
  Etiquetas pedidos;
  Botoncito btn1, btn2, btn4, btn5;
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
    if (e.getSource() == btn1) { // boton start
      tm1.setText("00:00:00");  
      pedidos.setText("0");     
      Thread t1 = new Thread(img1);  
      Thread t2 = new Thread(tm1);
      if (txt1.getText().toString().equals("")) { // Evalua si se ingreso cantidad de pedidos
        JOptionPane.showMessageDialog(null, "Ingrese un numero en pedidos", "Advertencia", JOptionPane.WARNING_MESSAGE);
      } else if (Integer.parseInt(txt1.getText().toString()) < 1) {
        JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0 en pedidos", "Advertencia",
            JOptionPane.WARNING_MESSAGE);
      } else {
        img1.txt1 = txt1;
        tiempoIngrediente = new double[tiempos.length];
        for (int i = 0; i < tiempoIngrediente.length; i++) { // se rellena el arreglo de los tiempos mediante el arreglo de los txt
          tiempoIngrediente[i] = Double.parseDouble(tiempos[i].getText().toString());
        }
        // se asignan las cantidades de los txt a una clase contenedora para actualizar las cantidades
        setCantidades();
        // se asignan las cantidades de los txt a una clase contenedora para resultados sin alterar
        setRCantidades();
        // se manda el arreglo de tiempos a la variable img1
        img1.tiempoImagenes = tiempoIngrediente;
        // se manda la variable de la clase contenedora a img1
        img1.cnt = cnt;
        // se manda el txt de los pedidos a img1
        img1.txt9 = txt1;
        // se manda el arreglo de tiempos a la variable de la clase contenedora de resultados finales
        rcnt.setTimes(tiempoIngrediente);
        // se manda la cantidad de pedidos a la variable de la clase contenedora
        rcnt.setPedidos(Integer.parseInt(txt1.getText()));
        // se manda un arreglo de las cantidades de los txt a la variable img1
        img1.txtIngredientes = cantidades;
        // se bloquean todos los controles a excepcion de pausa/reanudar y stop
        setEnabled(false); 
        btn2.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(false);
        bloqDesbl(false);
        // se inician los hilos de las imagenes de los ingredientes(t1) y del cronometro(t2)
        t1.start();
        t2.start(); // temp
      }

    }
    if (e.getSource() == btn2) { // boton pausa - reanudar
      if (cont == 0) { // se evalua el contador para saber si se pausa o se reanuda el hilo
        // se pausan los hilos en ejecucion
        img1.pausarHilo();
        tm1.pausarHilo();
        // se cambia la imagen del boton
        setIcon(new ImageIcon(this.getClass().getResource("images/play.png")));
        // se cambia el valor del contador
        cont = 1;
        // se habilitan los controles para poder modificar cantidades y tiempos
        bloqDesbl(true);
      } else { /////////////////////////////////////////////
        // se bloquean los controles
        bloqDesbl(false);
        // se modifican los tiempos
        tiempoIngrediente = new double[tiempos.length];
        for (int i = 0; i < tiempoIngrediente.length; i++) {
          tiempoIngrediente[i] = Double.parseDouble(tiempos[i].getText().toString());
        }
        // se evalua si las cantidades es menor a la que ya estaba en el txt
        if (evaluarTxt()==false) {
          JOptionPane.showMessageDialog(null, new JLabel("No puede ingresar un numero menor de ingredientes que\n el numero que estaba en el campo de texto",JLabel.CENTER), "Advertencia",
            JOptionPane.WARNING_MESSAGE);
        } else {
          // se actualizan los tiempos en la clase contenedora de resultados finales
          rcnt.setTimes(tiempoIngrediente);
          // se evaluan las cantidades para actualizar la clase contenedora de resultados finales
          evaluarCantidades();
          // se establecen las nuevas cantiades en la clase contenedora del hilo
          setCantidades();
          // se mandan los tiempos a la variable img1 del hilo
          img1.tiempoImagenes = tiempoIngrediente;
          // se reanuda el hilo de las imagenes y el cronometro
          img1.reanudarHilo();
          tm1.reanudarHilo();
          // se cambia la imagen del boton de pausa/reanudar
          setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
          // se cambia el valor del contador
          cont = 0;
        }
      }

    }
    if (e.getSource() == btn4) { // boton stop
      // se manda a parar el hilo de las imagenes y del cronometro
      img1.stopHilo();
      tm1.stopHilo();
      // se restablecen los controles por defecto
      setEnabled(false);
      btn1.setEnabled(true);
      btn2.setEnabled(false);
      btn5.setEnabled(true);
      //bloqDesbl(true);
      // se cambia la imagen del boton pausa/reanudar por la que estaba por defecto
      btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
    }
    if (e.getSource() == btn5) { // boton reset
      // se restablecen los txt, los contadores y las clases contenedpras por los valores que tenian por defecto
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

    cantidades[0].setText("1");
    cantidades[1].setText("100");
    cantidades[2].setText("50");
    cantidades[3].setText("20");
    cantidades[4].setText("10");
    cantidades[5].setText("100");
    cantidades[6].setText("100");
    cantidades[7].setText("30");
    
    txt1.setText("0");
    cnt.setTortilla(0);
    cnt.setCarne(0);
    cnt.setRepollo(0);
    cnt.setVerdura(0);
    cnt.setLimon(0);
    cnt.setPepino(0);
    cnt.setSalsa(0);
    cnt.setCebolla(0);

    rcnt.setRTortilla(0);
    rcnt.setRCarne(0);
    rcnt.setRRepollo(0);
    rcnt.setRVerdura(0);
    rcnt.setRLimon(0);
    rcnt.setRPepino(0);
    rcnt.setRSalsa(0);
    rcnt.setRCebolla(0);
    tm1.setText("00:00:00");
    etiqueta.setText("0");
  }

  private void bloqDesbl(boolean a){
    
      for (int i = 0; i < cantidades.length; i++) {
        cantidades[i].setEnabled(a);
      }
      txt1.setEnabled(a);
      for (int i = 0; i < tiempos.length; i++) {
        tiempos[i].setEnabled(a);
      }
    
  }

  private void setCantidades() {
    cnt.setTortilla(Integer.parseInt(cantidades[0].getText()));
    cnt.setCarne(Integer.parseInt(cantidades[1].getText()));
    cnt.setRepollo(Integer.parseInt(cantidades[2].getText()));
    cnt.setVerdura(Integer.parseInt(cantidades[3].getText()));
    cnt.setLimon(Integer.parseInt(cantidades[4].getText()));
    cnt.setPepino(Integer.parseInt(cantidades[5].getText()));
    cnt.setSalsa(Integer.parseInt(cantidades[6].getText()));
    cnt.setCebolla(Integer.parseInt(cantidades[7].getText()));
  }

  private void comprobar() {
    System.out.println("Cantidad de tortillas: " + cnt.getTortilla());
    System.out.println("Cantidad de carne: " + cnt.getCarne());
    System.out.println("Cantidad de repollo: " + cnt.getRepollo());
    System.out.println("Cantidad de verdura: " + cnt.getVerdura());
    System.out.println("Cantidad de limon: " + cnt.getLimon());
    System.out.println("Cantidad de pepino: " + cnt.getPepino());
    System.out.println("Cantidad de salsa: " + cnt.getSalsa());
    System.out.println("Cantidad de cebolla: " + cnt.getCebolla());
    System.out.println("//////////////////////////////////////////////");
    System.out.println("Cantidad de rtortillas: " + rcnt.getRTortilla());
    System.out.println("Cantidad de rcarne: " + rcnt.getRCarne());
    System.out.println("Cantidad de rrepollo: " + rcnt.getRRepollo());
    System.out.println("Cantidad de rverdura: " + rcnt.getRVerdura());
    System.out.println("Cantidad de rlimon: " + rcnt.getRLimon());
    System.out.println("Cantidad de rpepino: " + rcnt.getRPepino());
    System.out.println("Cantidad de rsalsa: " + rcnt.getRSalsa());
    System.out.println("Cantidad de rcebolla: " + rcnt.getRCebolla());
  }

  private void setRCantidades() {
    rcnt.setRTortilla(Integer.parseInt(cantidades[0].getText()));
    rcnt.setRCarne(Integer.parseInt(cantidades[1].getText()));
    rcnt.setRRepollo(Integer.parseInt(cantidades[2].getText()));
    rcnt.setRVerdura(Integer.parseInt(cantidades[3].getText()));
    rcnt.setRLimon(Integer.parseInt(cantidades[4].getText()));
    rcnt.setRPepino(Integer.parseInt(cantidades[5].getText()));
    rcnt.setRSalsa(Integer.parseInt(cantidades[6].getText()));
    rcnt.setRCebolla(Integer.parseInt(cantidades[7].getText()));

  }

  public boolean evaluarTxt(){
    if (cnt.getTortilla() > Integer.parseInt(cantidades[0].getText()) ||
    cnt.getCarne() > Integer.parseInt(cantidades[1].getText()) ||
    cnt.getRepollo() > Integer.parseInt(cantidades[2].getText()) ||
    cnt.getVerdura() > Integer.parseInt(cantidades[3].getText()) ||
    cnt.getLimon() > Integer.parseInt(cantidades[4].getText()) ||
    cnt.getPepino() > Integer.parseInt(cantidades[5].getText()) ||
    cnt.getSalsa() > Integer.parseInt(cantidades[6].getText()) ||
    cnt.getCebolla() > Integer.parseInt(cantidades[7].getText())) {
      return false;
    } else {
      return true;
    }
  }

  private void evaluarCantidades() {
    if (Integer.parseInt(cantidades[0].getText()) != cnt.getTortilla()) {
      rcnt.setRTortilla(rcnt.getRTortilla() - cnt.getTortilla() + Integer.parseInt(cantidades[0].getText()));
      //System.out.println(rcnt.getRTortilla());
    }
    if (Integer.parseInt(cantidades[1].getText()) != cnt.getCarne()) {
      rcnt.setRCarne(rcnt.getRCarne() - cnt.getCarne() + Integer.parseInt(cantidades[1].getText()));
      //System.out.println(rcnt.getRCarne());
    }
    if (Integer.parseInt(cantidades[2].getText()) != cnt.getRepollo()) {
      rcnt.setRRepollo(rcnt.getRRepollo() - cnt.getRepollo() + Integer.parseInt(cantidades[2].getText()));
      //System.out.println(rcnt.getRRepollo());
    }
    if (Integer.parseInt(cantidades[3].getText()) != cnt.getVerdura()) {
      rcnt.setRVerdura(rcnt.getRVerdura() - cnt.getVerdura() + Integer.parseInt(cantidades[3].getText()));
      //System.out.println(rcnt.getRVerdura());
    }
    if (Integer.parseInt(cantidades[4].getText()) != cnt.getLimon()) {
      rcnt.setRLimon(rcnt.getRLimon() - cnt.getLimon() + Integer.parseInt(cantidades[4].getText()));
      //System.out.println(rcnt.getRLimon());
    }
    if (Integer.parseInt(cantidades[5].getText()) != cnt.getPepino()) {
      rcnt.setRPepino(rcnt.getRPepino() - cnt.getPepino() + Integer.parseInt(cantidades[5].getText()));
      //System.out.println(rcnt.getRPepino());
    }
    if (Integer.parseInt(cantidades[6].getText()) != cnt.getSalsa()) {
      rcnt.setRSalsa(rcnt.getRSalsa() - cnt.getSalsa() + Integer.parseInt(cantidades[6].getText()));
      //System.out.println(rcnt.getRSalsa());
    }
    if (Integer.parseInt(cantidades[7].getText()) != cnt.getCebolla()) {
      rcnt.setRCebolla(rcnt.getRCebolla() - cnt.getCebolla() + Integer.parseInt(cantidades[7].getText()));
      //System.out.println(rcnt.getRCebolla());
    }
  }
}