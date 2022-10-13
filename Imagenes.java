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
      img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
      parar = false;
      int n = 0, random = 0, posXopt3 = 495, j = 0, pedidosListos = 0;
      double time = 0;
      //
      // Recorre el arreglo de los ingredientes
      //
      out: while (j < ingredientes.length && pedidosListos < Integer.parseInt(txt1.getText().toString())) {
         if (cnt.getTortilla() < cantTacos[0] || cnt.getCarne() < cantTacos[1] || cnt.getRepollo() < cantTacos[2]
               || cnt.getVerdura() < cantTacos[3] || cnt.getLimon() < cantTacos[4] || cnt.getPepino() < cantTacos[5]
               || cnt.getSalsa() < cantTacos[6] || cnt.getCebolla() < cantTacos[7]) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
            tm1.stopHilo();
            nombreIngrediente.setText("Faltan ingredientes. Fin del pedido");
            break out;
         }
         nombreIngrediente.setText("Agregando " + ingredientes[j]);
         nombreIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
         random = getRandom(1, 3);
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
               time = (tiempoImagenes[j + 1] * 1000) / 51;
               Thread.sleep((int) time);
               imagen1 = new ImageIcon(this.getClass().getResource(imagenes[j]));
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

               if (j == ingredientes.length - 1 && i == 450) {
                  if (!parar) {
                     pedidosListos += 1;
                     pedidosCompletados.setText(Integer.toString(pedidosListos));
                     img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
                  }
               }
            } catch (Exception e) {
            }
         }
         n = 0;
         posXopt3 = 495;
         if (pedidosListos == Integer.parseInt(txt1.getText().toString())) {
            restarIngredientes();
            tm1.stopHilo();
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
            nombreIngrediente.setText("Taco completo. Fin del pedido");
         } else {
            if (j < ingredientes.length - 1) {
               j++;
            } else if (j == ingredientes.length - 1) {
               try {
                  nombreIngrediente.setText("Taco completo. Colocando tortilla");
                  restarIngredientes();
                  Thread.sleep((int) (tiempoImagenes[0] * 1000));
                  img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
               } catch (Exception e) {
               }

               j = 0;
            }
         }

      }
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

   private void restarIngredientes() {
      cnt.setTortilla(cnt.getTortilla() - cantTacos[0]);
      cnt.setCarne(cnt.getCarne() - cantTacos[1]);
      cnt.setRepollo(cnt.getRepollo() - cantTacos[2]);
      cnt.setVerdura(cnt.getVerdura() - cantTacos[3]);
      cnt.setLimon(cnt.getLimon() - cantTacos[4]);
      cnt.setPepino(cnt.getPepino() - cantTacos[5]);
      cnt.setSalsa(cnt.getSalsa() - cantTacos[6]);
      cnt.setCebolla(cnt.getCebolla() - cantTacos[7]);
      txtIngredientes[0].setText(Integer.toString(cnt.getTortilla()));
      txtIngredientes[1].setText(Integer.toString(cnt.getCarne()));
      txtIngredientes[2].setText(Integer.toString(cnt.getRepollo()));
      txtIngredientes[3].setText(Integer.toString(cnt.getVerdura()));
      txtIngredientes[4].setText(Integer.toString(cnt.getLimon()));
      txtIngredientes[5].setText(Integer.toString(cnt.getPepino()));
      txtIngredientes[6].setText(Integer.toString(cnt.getSalsa()));
      txtIngredientes[7].setText(Integer.toString(cnt.getCebolla()));
   }

   private static int getRandom(int min, int max) {
      int x = (int) (Math.random() * ((max - min) + 1)) + min;
      return x;
   }
}