import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Simulacion extends JFrame {
    private int n = 0;
    Container cnt;
    RContainer rcnt;

    public Simulacion() {
        cnt = new Container();
        rcnt = new RContainer();
        initValues();
    }

    public void initValues() {
        Font fuente1 = new Font("Arial", 1, 24);
        //
        // Etiquetas
        //
        Etiquetas titulo = new Etiquetas("Simulador de Tacos \"Carnitas Cuatrolitro\"");
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
        Etiquetas et11 = new Etiquetas("pz.");
        Etiquetas et12 = new Etiquetas("g.");
        Etiquetas et13 = new Etiquetas("g.");
        Etiquetas et14 = new Etiquetas("g.");
        Etiquetas et15 = new Etiquetas("g.");
        Etiquetas et16 = new Etiquetas("g.");
        Etiquetas et17 = new Etiquetas("ml.");
        Etiquetas et18 = new Etiquetas("g.");
        Etiquetas et19 = new Etiquetas("Pedidos Hechos: ");
        Etiquetas et20 = new Etiquetas("0");
        Etiquetas et21 = new Etiquetas("Tiempos (segs.)");
        Etiquetas nombreIngrediente = new Etiquetas();
        //
        // Temporizador
        //
        Timer tm1 = new Timer("00:00:00");
        //
        // Arreglos
        //
        String[] ingredientes = { "carne", "repollo", "verdura", "limon", "pepino", "salsa", "cebolla" };
        String[] imagenes = { "images/meatR.png", "images/cabbageR.png", "images/vegetableR.png", "images/lemonR.png",
                "images/pepino.png", "images/molcajeteR.png",
                "images/onionR.png" };
        String[] url = { "images/tortilla.png", "images/fullTaco.png" };
        //
        // Etiqueta - Imagenes
        //
        Imagenes tortilla = new Imagenes(url);
        Imagenes ingrediente = new Imagenes();
        //
        // Campos de texto
        //
        Texto txt1 = new Texto("1");
        Texto txt2 = new Texto("100");
        Texto txt3 = new Texto("50");
        Texto txt4 = new Texto("20");
        Texto txt5 = new Texto("10");
        Texto txt6 = new Texto("100");
        Texto txt7 = new Texto("100");
        Texto txt8 = new Texto("30");
        Texto txt9 = new Texto("0");
        Texto tTortilla = new Texto("4.0");
        Texto tCarne = new Texto("2.0");
        Texto tRepollo = new Texto("2.0");
        Texto tVerdura = new Texto("6.0");
        Texto tLimon = new Texto("3.0");
        Texto tPepino = new Texto("5.0");
        Texto tSalsa = new Texto("7.0");
        Texto tCM = new Texto("3.0");
        //
        // Arreglos de campos de texto
        //
        Texto[] tiempos = { tTortilla, tCarne, tRepollo, tVerdura, tLimon, tPepino, tSalsa, tCM };
        Texto[] cantidades = { txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8 };
        //
        // Botones
        //
        Botoncito btn1 = new Botoncito("images/start.png", "Iniciar");
        Botoncito btn2 = new Botoncito("images/pause.png", "Pausar");
        Botoncito btn4 = new Botoncito("images/stop.png", "Parar");
        Botoncito btn5 = new Botoncito("images/repeat.png", "Resetear");
        //
        // KeyAdapter
        //
        KeyAdapter ka = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c > '.')) {
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
        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i].addKeyListener(ka);
        }
        //
        // Atributos de clases
        //
        ingrediente.btn1 = btn1;
        ingrediente.btn2 = btn2;
        ingrediente.btn3 = btn4;
        ingrediente.btn5=btn5;
        ingrediente.rcnt = rcnt;
        ingrediente.pedidosCompletados = et20;
        ingrediente.nombreIngrediente = nombreIngrediente;
        ingrediente.tm1 = tm1;
        ingrediente.img1 = tortilla;
        ingrediente.url = url;
        ingrediente.ingredientes = ingredientes;
        ingrediente.imagenes = imagenes;
        btn1.txt1 = txt9;
        btn1.btn5 = btn5;
        btn5.txt1 = txt9;
        btn1.cnt = cnt;
        btn2.cnt = cnt;
        btn4.cnt = cnt;
        btn4.btn5 = btn5;
        btn5.cnt = cnt;
        btn5.etiqueta = et20;
        btn5.tm1 = tm1;
        btn1.rcnt = rcnt;
        btn2.rcnt = rcnt;
        btn1.tiempos = tiempos;
        btn2.tiempos = tiempos;
        btn4.tiempos = tiempos;
        btn5.tiempos = tiempos;
        btn1.cantidades = cantidades;
        btn2.cantidades = cantidades;
        btn4.cantidades = cantidades;
        btn4.cantidades = cantidades;
        btn5.cantidades = cantidades;
        btn2.setEnabled(false);
        btn4.setEnabled(false);
        btn1.img1 = ingrediente;
        btn2.img1 = ingrediente;
        btn4.img1 = ingrediente;
        btn5.img1 = ingrediente;
        btn1.pedidos = et20;
        btn1.tm1 = tm1;
        btn2.tm1 = tm1;
        btn4.tm1 = tm1;
        btn5.tm1 = tm1;
        btn1.btn1 = btn1;
        btn1.btn2 = btn2;
        btn1.btn4 = btn4;
        btn1.btn5 = btn5;
        btn2.btn1 = btn1;
        btn2.btn2 = btn2;
        btn2.btn4 = btn4;
        btn2.btn5 = btn5;
        btn4.btn4 = btn4;
        btn4.btn2 = btn2;
        btn4.btn1 = btn1;
        btn4.btn5 = btn5;
        btn5.btn1 = btn1;
        btn5.btn2 = btn2;
        btn5.btn4 = btn4;
        btn5.btn5 = btn5;
        //
        // Posicion Etiquetas
        //
        et1.setBounds(10, 50, 100, 25);
        et2.setBounds(10, 70, 100, 25);
        et3.setBounds(10, 90, 100, 25);
        et4.setBounds(10, 110, 100, 25);
        et5.setBounds(10, 130, 100, 25);
        et6.setBounds(10, 150, 100, 25);
        et7.setBounds(10, 170, 100, 25);
        et8.setBounds(10, 190, 100, 25);
        et9.setBounds(10, 30, 120, 25);
        et10.setBounds(10, 270, 120, 25);
        et11.setBounds(185, 50, 100, 20);
        et12.setBounds(185, 70, 100, 20);
        et13.setBounds(185, 90, 100, 20);
        et14.setBounds(185, 110, 100, 20);
        et15.setBounds(185, 130, 100, 20);
        et16.setBounds(185, 150, 100, 20);
        et17.setBounds(185, 170, 100, 20);
        et18.setBounds(185, 190, 100, 20);
        et19.setBounds(10, 290, 120, 25);
        et20.setBounds(120, 290, 50, 25);
        et21.setBounds(230, 30, 100, 20);
        tm1.setBounds(140, 270, 100, 25);
        titulo.setBounds(0, 10, 700, 25);
        tortilla.setBounds(400, 50, 256, 256);
        nombreIngrediente.setBounds(370, 270, 200, 25);
        //
        // Posicion campos de texto
        //
        txt1.setBounds(130, 52, 50, 20);
        txt2.setBounds(130, 72, 50, 20);
        txt3.setBounds(130, 92, 50, 20);
        txt4.setBounds(130, 112, 50, 20);
        txt5.setBounds(130, 132, 50, 20);
        txt6.setBounds(130, 152, 50, 20);
        txt7.setBounds(130, 172, 50, 20);
        txt8.setBounds(130, 192, 50, 20);
        txt9.setBounds(130, 32, 50, 20);
        for (int i = 0; i < tiempos.length; i++) {
            tiempos[i].setBounds(230, 52 + n, 50, 20);
            n += 20;
        }
        //
        // Posicion botones
        //
        btn1.setBounds(10, 230, 32, 32);
        btn2.setBounds(45, 230, 32, 32);
        btn4.setBounds(80, 230, 32, 32);
        btn5.setBounds(115, 230, 32, 32);
        //
        // Acciones
        //
        btn1.addActionListener(btn1);
        btn2.addActionListener(btn2);
        btn4.addActionListener(btn4);
        btn5.addActionListener(btn5);
        //
        //
        //
        titulo.setFont(fuente1);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        // Adicion a la ventana
        add(et1);
        add(et2);
        add(et3);
        add(et4);
        add(et5);
        add(et6);
        add(et7);
        add(et8);
        add(et9);
        for (int i = 0; i < tiempos.length; i++) {
            add(tiempos[i]);
        }
        add(et11);
        add(et12);
        add(et13);
        add(et14);
        add(et15);
        add(et16);
        add(et17);
        add(et18);
        add(et19);
        add(et20);
        add(et21);
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
        add(btn4);
        add(btn5);
        //
        // Configuracion ventana
        //
        setTitle("Simulador de Tacos de Carne Asada");
        setSize(700, 370);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
}