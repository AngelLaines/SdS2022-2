import javax.swing.*;

public class Imagenes extends JLabel implements Runnable {
   private String text="";
   Imagenes img1;
   Botoncito btn1, btn2, btn3,btn5;
   Etiquetas nombreIngrediente, pedidosCompletados;
   Texto txt1, txt9;
   Texto[] txtIngredientes, cantidades,tiempos;
   Timer tm1;
   private int[] cantTacos = { 1, 100, 50, 20, 10, 100, 100, 30 };
   Container cnt;
   RContainer rcnt;
   String url[];
   String ingredientes[];
   String imagenes[];
   double[] tiempoImagenes,tiemposTotales={0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
   ImageIcon imagen1;

   public Imagenes(String[] url) {
      imagen1 = new ImageIcon(this.getClass().getResource(url[0]));

      setIcon(imagen1);
   }

   public Imagenes() {
   }

   boolean pausar, parar;

   public void run() {
      for (int i = 0; i < tiemposTotales.length; i++) {
         tiemposTotales[i]=0.0;
      }
      double tiempoT=0.0;
      text="";
      tm1.rcnt = rcnt;
      rcnt.setTime("00:00:00");
      img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
      parar = false;
      int n = 0, random = 0, posXopt3 = 495, j = 0, pedidosListos = 0;
      double time = 0;
      //
      // Recorre el arreglo de los ingredientes
      //
      out: for (int a = 0; a < Integer.parseInt(txt1.getText().toString()); a++) {
         if (cnt.getTortilla() < cantTacos[0] || cnt.getCarne() < cantTacos[1] || cnt.getRepollo() < cantTacos[2]
               || cnt.getVerdura() < cantTacos[3] || cnt.getLimon() < cantTacos[4] || cnt.getPepino() < cantTacos[5]
               || cnt.getSalsa() < cantTacos[6] || cnt.getCebolla() < cantTacos[7] || tiempoImagenes[0] == 0.0 ||
               tiempoImagenes[1] == 0.0 || tiempoImagenes[2] == 0.0 || tiempoImagenes[3] == 0.0
               || tiempoImagenes[4] == 0.0 || tiempoImagenes[5] == 0.0 || tiempoImagenes[6] == 0.0 ||
               tiempoImagenes[7] == 0.0 ) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn5.setEnabled(true);
            btn2.setIcon(new ImageIcon(this.getClass().getResource("images/pause.png")));
            tm1.stopHilo();
            text = "Faltan ingredientes. Simulacion interrumpida.";

            
            break out;
         } else {
            for (int b = 0; b < 8; b++) {
               if (b == 0) {
                  try {
                     restarIngredientes(b);
                     tiempoT=tiemposTotales[0] + tiempoImagenes[0];
                     tiemposTotales[0] = tiempoT;
                     if(a>0){
                        nombreIngrediente.setText("Taco completo. Colocando Tortilla");
                     } else {
                        nombreIngrediente.setText("Colocando Tortilla");
                     }
                     
                  nombreIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
                     Thread.sleep((int) (tiempoImagenes[0] * 1000));
                     img1.setIcon(new ImageIcon(this.getClass().getResource(url[0])));
                  } catch (Exception e) {
                  }
               } else {
                  nombreIngrediente.setText("Agregando " + ingredientes[b-1]);
                  nombreIngrediente.setHorizontalAlignment(SwingConstants.CENTER);
                  random = getRandom(1, 3);
                  
                  for (int i = 400; i <= 450; i++) { // Cambio de posicion de imagenes de los ingredientes
                     try {
                        synchronized (this) {
                           while (pausar) {
                              wait();
                           }
                           if (parar == true) {
                              text = "Simulacion interrumpida. Resultados obtenidos";
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
   
                        /* if (a == ingredientes.length - 1 && i == 450) {
                           if (!parar) {
                              pedidosListos += 1;
                              pedidosCompletados.setText(Integer.toString(pedidosListos));
                              img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
                           }
                        } */
                     } catch (Exception e) {
                     }
   
                  }
                  
                  tiempoT=tiemposTotales[b] + tiempoImagenes[b];
                  tiemposTotales[b] = tiempoT;
                  restarIngredientes(b);
                  n = 0;
                  posXopt3 = 495;
               }
            }
            try {
               nombreIngrediente.setText("Taco completo.");
               // restarIngredientes();
               pedidosListos++;
               pedidosCompletados.setText(Integer.toString(pedidosListos));
               //Thread.sleep((int) (tiempoImagenes[0] * 1000));
               img1.setIcon(new ImageIcon(this.getClass().getResource(url[1])));
            } catch (Exception e) {
            }
         }
      }
      tm1.stopHilo();
      if(text.equals("")){
         text = "Resultados obtenidos";
      }
      btn1.setEnabled(true);
      btn2.setEnabled(false);
      btn3.setEnabled(false);
      btn5.setEnabled(true);
      bloqDesbl(true);
      setDefaults();
      Resultados r = new Resultados(rcnt, cnt,text,pedidosListos,tiemposTotales);
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
         case 0:
            cnt.setTortilla(cnt.getTortilla() - cantTacos[0]);
            txtIngredientes[0].setText(Integer.toString(cnt.getTortilla()));
            break;
         case 1:
            cnt.setCarne(cnt.getCarne() - cantTacos[1]);
            txtIngredientes[1].setText(Integer.toString(cnt.getCarne()));
            break;
         case 2:
            cnt.setRepollo(cnt.getRepollo() - cantTacos[2]);
            txtIngredientes[2].setText(Integer.toString(cnt.getRepollo()));
            break;
         case 3:
            cnt.setVerdura(cnt.getVerdura() - cantTacos[3]);
            txtIngredientes[3].setText(Integer.toString(cnt.getVerdura()));
            break;
         case 4:
            cnt.setLimon(cnt.getLimon() - cantTacos[4]);
            txtIngredientes[4].setText(Integer.toString(cnt.getLimon()));
            break;
         case 5:
            cnt.setPepino(cnt.getPepino() - cantTacos[5]);
            txtIngredientes[5].setText(Integer.toString(cnt.getPepino()));
            break;
         case 6:
            cnt.setSalsa(cnt.getSalsa() - cantTacos[6]);
            txtIngredientes[6].setText(Integer.toString(cnt.getSalsa()));
            break;
         case 7:
            cnt.setCebolla(cnt.getCebolla() - cantTacos[7]);
            txtIngredientes[7].setText(Integer.toString(cnt.getCebolla()));
            break;
      }

   }

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
      pedidosCompletados.setText("0");
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

   private static int getRandom(int min, int max) {
      int x = (int) (Math.random() * ((max - min) + 1)) + min;
      return x;
   }
}