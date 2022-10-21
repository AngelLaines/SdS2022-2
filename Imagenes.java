import javax.swing.*;

public class Imagenes extends JLabel implements Runnable {
   Imagenes img1;
   Botoncito btn1, btn2, btn3;
   Etiquetas nombreIngrediente, pedidosCompletados;
   Texto txt1, txt9;
   Texto[] txtIngredientes;
   Timer tm1;
   private int[] cantTacos = { 1, 100, 50, 20, 10, 100, 100, 30 };
   Container cnt;
   RContainer rcnt;
   String url[];
   String ingredientes[];
   String imagenes[];
   double[] tiempoImagenes;
   ImageIcon imagen1;

   public Imagenes(String[] url) {
      imagen1 = new ImageIcon(this.getClass().getResource(url[0]));

      setIcon(imagen1);
   }

   public Imagenes() {
   }

   boolean pausar, parar;

   public void run() {
      tm1.rcnt = rcnt;
      img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
      parar = false;
      int n = 0, random = 0, posXopt3 = 495, j = 0, pedidosListos = 0;
      double time = 0;
      //
      // Recorre el arreglo de los ingredientes
      //
      out: for (int a = 0; a < Integer.parseInt(txt1.getText().toString()); a++) {
         if ((cnt.getTortilla() < cantTacos[0] || cnt.getCarne() < cantTacos[1] || cnt.getRepollo() < cantTacos[2]
               || cnt.getVerdura() < cantTacos[3] || cnt.getLimon() < cantTacos[4] || cnt.getPepino() < cantTacos[5]
               || cnt.getSalsa() < cantTacos[6] || cnt.getCebolla() < cantTacos[7] || tiempoImagenes[0] == 0.0 ||
               tiempoImagenes[1] == 0.0 || tiempoImagenes[2] == 0.0 || tiempoImagenes[3] == 0.0
               || tiempoImagenes[4] == 0.0 || tiempoImagenes[5] == 0.0 || tiempoImagenes[6] == 0.0 ||
               tiempoImagenes[7] == 0.0)) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
            tm1.stopHilo();
            JOptionPane.showMessageDialog(null, "Faltan ingredientes. Fin del pedido", "Advertencia",
                  JOptionPane.WARNING_MESSAGE);

            Resultados r = new Resultados(rcnt, cnt);
            break out;
         } else {
            for (int b = 0; b < 8; b++) {
               if (b == 0) {
                  try {
                     restarIngredientes(b);
                     Thread.sleep((int) (tiempoImagenes[0] * 1000));
                     img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
                     nombreIngrediente.setText("Colocando Tortilla");
                  } catch (Exception e) {
                  }
               } else {

                  for (int i = 400; i <= 450; i++) { // Cambio de posicion de imagenes de los ingredientes
                     try {
                        synchronized (this) {
                           while (pausar) {
                              wait();
                           }
                           if (parar == true) {
                              break out;
                           }
                        }
                        time = (tiempoImagenes[b] * 1000) / 51;
                        Thread.sleep((int) time);
                        imagen1 = new ImageIcon(this.getClass().getResource(imagenes[b-1]));
                        setIcon(imagen1);
                        if (random == 1) {
                           setBounds(i, 60 + n, 42, 42);
                           n += 2;
                        }
                        if (random == 2) {
                           setBounds(445, 45 + n, 42, 42);
                           n += 2;
                        }
                        if (random == 3) {
                           setBounds(posXopt3, 60 + n, 42, 42);
                           n += 2;
                           posXopt3 -= 1;
                        }
   
                        if (a == ingredientes.length - 1 && i == 450) {
                           if (!parar) {
                              pedidosListos += 1;
                              pedidosCompletados.setText(Integer.toString(pedidosListos));
                              img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
                           }
                        }
                     } catch (Exception e) {
                     }
   
                  }
                  restarIngredientes(b);
                  n = 0;
                  posXopt3 = 495;
               }
            }
            try {
               nombreIngrediente.setText("Taco completo.");
               // restarIngredientes();

               //Thread.sleep((int) (tiempoImagenes[0] * 1000));
               img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
            } catch (Exception e) {
            }
         }
      }
      /**
       * 
       * 
       * 
       * 
       * 
       * 
       * 
       * 
       * 
       * out: while (j < ingredientes.length && pedidosListos <
       * Integer.parseInt(txt1.getText().toString())) {
       * System.out.println(j);
       * if ((cnt.getTortilla() < cantTacos[0] || cnt.getCarne() < cantTacos[1] ||
       * cnt.getRepollo() < cantTacos[2]
       * || cnt.getVerdura() < cantTacos[3] || cnt.getLimon() < cantTacos[4] ||
       * cnt.getPepino() < cantTacos[5]
       * || cnt.getSalsa() < cantTacos[6] || cnt.getCebolla() < cantTacos[7] ||
       * tiempoImagenes[0] == 0.0 ||
       * tiempoImagenes[1] == 0.0 || tiempoImagenes[2] == 0.0 || tiempoImagenes[3] ==
       * 0.0
       * || tiempoImagenes[4] == 0.0 || tiempoImagenes[5] == 0.0 || tiempoImagenes[6]
       * == 0.0 ||
       * tiempoImagenes[7] == 0.0)) {
       * btn1.setEnabled(true);
       * btn2.setEnabled(false);
       * btn3.setEnabled(false);
       * btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
       * tm1.stopHilo();
       * JOptionPane.showMessageDialog(null, "Faltan ingredientes. Fin del pedido",
       * "Advertencia",
       * JOptionPane.WARNING_MESSAGE);
       * 
       * Resultados r = new Resultados(rcnt, cnt);
       * break out;
       * } else {
       * if (j == 0 && pedidosListos == 0) {
       * try {
       * restarIngredientes(j);
       * Thread.sleep((int) (tiempoImagenes[0] * 1000));
       * img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
       * nombreIngrediente.setText("Colocando Tortilla");
       * } catch (Exception e) {
       * }
       * }
       * nombreIngrediente.setText("Agregando " + ingredientes[j]);
       * nombreIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
       * random = getRandom(1, 3);
       * for (int i = 400; i <= 450; i++) { // Cambio de posicion de imagenes de los
       * ingredientes
       * try {
       * synchronized (this) {
       * while (pausar) {
       * wait();
       * }
       * if (parar == true) {
       * break out;
       * }
       * }
       * time = (tiempoImagenes[j + 1] * 1000) / 51;
       * Thread.sleep((int) time);
       * imagen1 = new ImageIcon(this.getClass().getResource(imagenes[j]));
       * setIcon(imagen1);
       * if (random == 1) {
       * setBounds(i, 60 + n, 42, 42);
       * n += 2;
       * }
       * if (random == 2) {
       * setBounds(445, 45 + n, 42, 42);
       * n += 2;
       * }
       * if (random == 3) {
       * setBounds(posXopt3, 60 + n, 42, 42);
       * n += 2;
       * posXopt3 -= 1;
       * }
       * 
       * if (j == ingredientes.length - 1 && i == 450) {
       * if (!parar) {
       * pedidosListos += 1;
       * pedidosCompletados.setText(Integer.toString(pedidosListos));
       * img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
       * }
       * }
       * } catch (Exception e) {
       * }
       * }
       * restarIngredientes(j + 1);
       * n = 0;
       * posXopt3 = 495;
       * if (pedidosListos == Integer.parseInt(txt1.getText().toString())) {
       * // restarIngredientes();
       * tm1.stopHilo();
       * btn1.setEnabled(true);
       * btn2.setEnabled(false);
       * btn3.setEnabled(false);
       * btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
       * nombreIngrediente.setText("Taco completo. Fin del pedido");
       * Resultados r = new Resultados(rcnt, cnt);
       * } else {
       * if (j < ingredientes.length - 1) {
       * j++;
       * } else if (j == ingredientes.length - 1) {
       * try {
       * nombreIngrediente.setText("Taco completo. Colocando tortilla");
       * // restarIngredientes();
       * 
       * Thread.sleep((int) (tiempoImagenes[0] * 1000));
       * img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
       * } catch (Exception e) {
       * }
       * 
       * j = 0;
       * }
       * }
       * 
       * }
       * 
       * }
       */
   }

   synchronized void pausarHilo() {
      pausar = true;
   }

   synchronized void reanudarHilo() {
      pausar = false;
      notify();
   }

   synchronized void stopHilo() {
      parar = true;
      pausar = false;
      notify();
   }

   private void restarIngredientes(int j) {
      switch (j) {
         case 1:
            cnt.setTortilla(cnt.getTortilla() - cantTacos[0]);
            txtIngredientes[0].setText(Integer.toString(cnt.getTortilla()));
            break;
         case 2:
            cnt.setCarne(cnt.getCarne() - cantTacos[1]);
            txtIngredientes[1].setText(Integer.toString(cnt.getCarne()));
            break;
         case 3:
            cnt.setRepollo(cnt.getRepollo() - cantTacos[2]);
            txtIngredientes[2].setText(Integer.toString(cnt.getRepollo()));
            break;
         case 4:
            cnt.setVerdura(cnt.getVerdura() - cantTacos[3]);
            txtIngredientes[3].setText(Integer.toString(cnt.getVerdura()));
            break;
         case 5:
            cnt.setLimon(cnt.getLimon() - cantTacos[4]);
            txtIngredientes[4].setText(Integer.toString(cnt.getLimon()));
            break;
         case 6:
            cnt.setPepino(cnt.getPepino() - cantTacos[5]);
            txtIngredientes[5].setText(Integer.toString(cnt.getPepino()));
            break;
         case 7:
            cnt.setSalsa(cnt.getSalsa() - cantTacos[6]);
            txtIngredientes[6].setText(Integer.toString(cnt.getSalsa()));
            break;
         case 8:
            cnt.setCebolla(cnt.getCebolla() - cantTacos[7]);
            txtIngredientes[7].setText(Integer.toString(cnt.getCebolla()));
            break;
      }

   }

   private static int getRandom(int min, int max) {
      int x = (int) (Math.random() * ((max - min) + 1)) + min;
      return x;
   }
}