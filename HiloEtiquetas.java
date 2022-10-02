import javax.swing.*;
public class HiloEtiquetas extends JLabel implements Runnable{
 boolean pausar, parar;
 public void run(){
  
/*     for(int i = 240;i<=368;i++){
     setBounds(i,(2*i),42,42);
     synchronized(this){
     while(pausar){
      wait();
     }
     if (parar==true){
      break;
     }
    } */
   /*  synchronized(this){
     while(pausar){
      wait();
     }
     if (parar==true){
      break;
     } 
  }*/
 }
 synchronized void pausarHilo(){
  pausar = true;
 }
 synchronized void reanudarHilo(){
  pausar = false;
  notify();
 }
 synchronized void stopHilo(){
  parar = true;
  pausar = false;
  notify();
 }
}