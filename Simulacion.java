import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Simulacion extends JFrame {
    public Simulacion() {
        initValues();
    }

    public void initValues() {
        Font fuente1 = new Font("Arial", 1, 24);

        Etiquetas titulo = new Etiquetas("Simulador de Tacos de Carne Asada");
        titulo.setFont(fuente1);

        Etiquetas et1 = new Etiquetas("Tortilla");
        Etiquetas et2 = new Etiquetas("Carne Asada");
        Etiquetas et3 = new Etiquetas("Repollo");
        Etiquetas et4 = new Etiquetas("Verdura");
        Etiquetas et5 = new Etiquetas("Limon");
        Etiquetas et6 = new Etiquetas("Pepino");
        Etiquetas et7 = new Etiquetas("Salsa");
        Etiquetas et8 = new Etiquetas("Cebolla Morada");
        Etiquetas et9 = new Etiquetas("Cantidad de pedidos:");
        Etiquetas et10 = new Etiquetas("Tiempo transcurrido:");

        Etiquetas nombreIngrediente = new Etiquetas();

        Timer tm1 = new Timer("00:00:00");

        String[] ingredientes = { "carne", "repollo", "verdura", "limon", "salsa", "cebolla", "pepino" };
        String[] imagenes = { "images/meatR.png", "images/cabbageR.png", "images/vegetableR.png", "images/lemonR.png",
                "images/molcajeteR.png",
                "images/onionR.png", "images/pepino.png" };
        int[] tiempoIngrediente = { 2, 2, 6, 3, 7, 3, 5 };
        String[] url = { "images/tortilla.png", "images/fullTaco.png" };

        Imagenes tortilla = new Imagenes(url);
        Imagenes ingrediente = new Imagenes();
        Texto txt1 = new Texto();
        Texto txt2 = new Texto();
        Texto txt3 = new Texto();
        Texto txt4 = new Texto();
        Texto txt5 = new Texto();
        Texto txt6 = new Texto();
        Texto txt7 = new Texto();
        Texto txt8 = new Texto();
        Texto txt9 = new Texto();
        ingrediente.nombreIngrediente = nombreIngrediente;
        ingrediente.tm1 = tm1;
        ingrediente.img1 = tortilla;
        ingrediente.url = url;
        ingrediente.ingredientes = ingredientes;
        ingrediente.imagenes = imagenes;
        ingrediente.tiempoImagenes = tiempoIngrediente;

        Botoncito btn1 = new Botoncito("Iniciar");
        Botoncito btn2 = new Botoncito("Pausar");
        // Botoncito btn3 = new Botoncito("Reanudar");
        Botoncito btn4 = new Botoncito("Parar");

        KeyAdapter ka = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume(); // if it's not a number, ignore the event
                }
            }
        };

        txt1.addKeyListener(ka);
        txt2.addKeyListener(ka);
        txt3.addKeyListener(ka);
        txt4.addKeyListener(ka);
        txt5.addKeyListener(ka);
        txt6.addKeyListener(ka);
        txt7.addKeyListener(ka);
        txt8.addKeyListener(ka);
        txt9.addKeyListener(ka);

        btn1.txt1 = txt9;

        btn2.setEnabled(false);
        btn4.setEnabled(false);

        btn1.img1 = ingrediente;
        btn2.img1 = ingrediente;
        // btn3.img1 = ingrediente;
        btn4.img1 = ingrediente;

        btn1.tm1 = tm1;
        btn2.tm1 = tm1;
        // btn3.img1 = ingrediente;
        btn4.tm1 = tm1;

        btn1.btn2 = btn2;
        btn1.btn4 = btn4;

        btn2.btn1 = btn1;
        btn2.btn4 = btn4;

        btn4.btn2 = btn2;
        btn4.btn1 = btn1;
        // Posicion
        // btn1.setBounds(5, 300, 90, 25); // posX , posY, width, height
        et1.setBounds(10, 50, 100, 25);
        et2.setBounds(10, 70, 100, 25);
        et3.setBounds(10, 90, 100, 25);
        et4.setBounds(10, 110, 100, 25);
        et5.setBounds(10, 130, 100, 25);
        et6.setBounds(10, 150, 100, 25);
        et7.setBounds(10, 170, 100, 25);
        et8.setBounds(10, 190, 100, 25);
        titulo.setBounds(90, 10, 500, 18);
        tortilla.setBounds(300, 50, 256, 256);
        nombreIngrediente.setBounds(330,320,200,25);
        et9.setBounds(10, 30, 120, 25);
        et10.setBounds(10, 320, 120, 25);
        tm1.setBounds(140, 320, 100, 25);

        txt1.setBounds(130, 50, 100, 20);
        txt2.setBounds(130, 70, 100, 20);
        txt3.setBounds(130, 90, 100, 20);
        txt4.setBounds(130, 110, 100, 20);
        txt5.setBounds(130, 130, 100, 20);
        txt6.setBounds(130, 150, 100, 20);
        txt7.setBounds(130, 170, 100, 20);
        txt8.setBounds(130, 190, 100, 20);
        txt9.setBounds(130, 30, 100, 20);

        btn1.setBounds(10, 230, 90, 20);
        btn2.setBounds(10, 260, 90, 20);
        // btn3.setBounds(10,290,90,20);
        btn4.setBounds(10, 290, 90, 20);
        // Acciones
        btn1.addActionListener(btn1);
        btn2.addActionListener(btn2);
        // btn3.addActionListener(btn3);
        btn4.addActionListener(btn4);

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
        add(et10);
        add(tm1);
        add(tortilla);
        add(nombreIngrediente);
        add(ingrediente);

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
        // add(btn3);
        add(btn4);

        setTitle("Simulador de Tacos de Carne Asada");
        setSize(700, 400);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
}