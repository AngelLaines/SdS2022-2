import javax.swing.*;

public class Imagenes extends JLabel implements Runnable {
   Imagenes img1;
   Botoncito btn1,btn2,btn3;
   Etiquetas nombreIngrediente, pedidosCompletados;
   Texto txt1;
   Timer tm1;
   String url[];
   String ingredientes[];
   String imagenes[];
   int[] tiempoImagenes;
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
      int n = 0, random = 0, posXopt3 = 495, time = 0, j = 0, pedidosListos = 0;
      out: while (j < ingredientes.length && pedidosListos < Integer.parseInt(txt1.getText().toString())) {
         nombreIngrediente.setText("Agregando " + ingredientes[j]);
         nombreIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
         random = getRandom(1, 3);
         for (int i = 400; i <= 450; i++) {
            try {
               synchronized (this) {
                  while (pausar) {
                     wait();
                  }
                  if (parar == true) {
                     break out;
                  }
               }
               time = (tiempoImagenes[j+1] * 1000) / 51;
               Thread.sleep(time);
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

               // }
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
                  Thread.sleep(tiempoImagenes[0]*1000);
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

   private static int getRandom(int min, int max) {
      int x = (int) (Math.random() * ((max - min) + 1)) + min;
      return x;
   }
}