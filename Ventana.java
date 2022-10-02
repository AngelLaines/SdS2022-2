import javax.swing.*;
import java.awt.*;
public class Ventana extends JFrame{
 public Ventana(){
  initValues();
 }

 public void initValues(){
  // Objetos
  Font fuente1 = new Font("Arial",1,24);
  /*Botoncito miBoton1 = new Botoncito("Mi boton");
  miBoton1.etiqueta=txt1;

  et1.setFont(fuente1);
  miBoton1.et1=et1;*/

  Etiquetas titulo = new Etiquetas("Simulador de Tacos de Carne Asada");
  titulo.setFont(fuente1);


  Etiquetas et1 = new Etiquetas("Tortilla");
  Etiquetas et2 = new Etiquetas("Carne Asada");
  Etiquetas et3 = new Etiquetas("Repollo");
  Etiquetas et4 = new Etiquetas("Tortilla");
  Etiquetas et5 = new Etiquetas("Verdura");
  Etiquetas et6 = new Etiquetas("Limon");
  Etiquetas et7 = new Etiquetas("Pepino");
  Etiquetas et8 = new Etiquetas("Salsa");
  Etiquetas et9 = new Etiquetas("Cebolla Morada");

  Texto txt1 = new Texto();
  Texto txt2 = new Texto();
  Texto txt3 = new Texto();
  Texto txt4 = new Texto();
  Texto txt5 = new Texto();
  Texto txt6 = new Texto();
  Texto txt7 = new Texto();
  Texto txt8 = new Texto();
  Texto txt9 = new Texto();

  Botoncito btn1 = new Botoncito("Iniciar");
  Botoncito btn2 = new Botoncito("Pausar");
  Botoncito btn3 = new Botoncito("Reanudar");
  Botoncito btn4 = new Botoncito("Parar");

  // Posicion
  // btn1.setBounds(5, 300, 90, 25); // posX , posY, width, height
  et1.setBounds(10,30,100,25);
  et2.setBounds(10,50,100,25);
  et3.setBounds(10,70,100,25);
  et4.setBounds(10,90,100,25);
  et5.setBounds(10,110,100,25);
  et6.setBounds(10,130,100,25);
  et7.setBounds(10,150,100,25);
  et8.setBounds(10,170,100,25);
  et9.setBounds(10,190,100,25);
  titulo.setBounds(90,10,500,18);

  txt1.setBounds(110,30,100,20);
  txt2.setBounds(110,50,100,20);
  txt3.setBounds(110,70,100,20);
  txt4.setBounds(110,90,100,20);
  txt5.setBounds(110,110,100,20);
  txt6.setBounds(110,130,100,20);
  txt7.setBounds(110,150,100,20);
  txt8.setBounds(110,170,100,20);
  txt9.setBounds(110,190,100,20);

  btn1.setBounds(10,230,90,20);
  btn2.setBounds(10,260,90,20);
  btn3.setBounds(10,290,90,20);
  btn4.setBounds(10,320,90,20);
  // Acciones
  
  /*
  btn1.addActionListener(listener);
  btn2.addActionListener(listener);*/

  // Adicion al formulario
  //add(btn1);
  add(et1);
  add(et2);
  add(et3);
  add(et4);
  add(et5);
  add(et6);
  add(et7);
  add(et8);
  add(et9);
  add(titulo);

  add(txt1);
  add(txt2);
  add(txt3);
  add(txt4);
  add(txt5);
  add(txt6);
  add(txt7);
  add(txt8);
  add(txt9);

  add(btn1);
  add(btn2);
  add(btn3);
  add(btn4);

  setTitle("Simulador de Tacos de Carne Asada");
  setSize(600,400);
  setResizable(false);
  setLayout(null);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  setVisible(true);
 }
}