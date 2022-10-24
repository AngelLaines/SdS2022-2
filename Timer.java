import javax.swing.*;

public class Timer extends JLabel implements Runnable {
  boolean pausar, stop;
  RContainer rcnt;
  private String cronometro = "00:00:00";
  public Timer(String name) {
    setText(name);
  }

  public void run() {
    cronometro = "00:00:00";
    stop = false;
    int segundo = 1, minuto = 0, hora = 0;
    String segundos = "", minutos = "", horas = "";
    out: while (true) {
      try {
        synchronized (this) {
          while (pausar) {
            wait();
          }
          if (stop) {
            break out;
          }
        }
        Thread.sleep(1000);

        if (segundo < 10) {
          segundos = "0" + Integer.toString(segundo);
        } else {
          segundos = Integer.toString(segundo);
        }

        if (minuto < 10) {
          minutos = "0" + Integer.toString(minuto);
        } else {
          minutos = Integer.toString(minuto);
        }

        if (hora < 10) {
          horas = "0" + Integer.toString(hora);
        } else {
          horas = Integer.toString(hora);
        }

        cronometro = horas + ":" + minutos + ":" + segundos;
        if (segundo == 59) {
          minuto++;
          segundo = -1;
        }
        if (minuto == 59) {
          hora++;
          minuto = 0;
        }
        setText(cronometro);
        rcnt.setTime(cronometro);
        segundo++;

      } catch (Exception e) {
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
    stop = true;
    pausar = false;
    notify();
  }
}