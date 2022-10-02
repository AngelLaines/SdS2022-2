import javax.swing.*;
import java.awt.*;

public class Resultados extends JFrame {
    public Resultados() {
        initComponents();
    }

    public void initComponents() {
        Font fuente1 = new Font("Arial", 1, 24);

        Etiquetas titulo = new Etiquetas("Resultados obtenidos");
        titulo.setFont(fuente1);
        Etiquetas tiempo = new Etiquetas("Tiempo transcurrido: 00:00:00");
        Etiquetas subtitulo1 = new Etiquetas("Cantidad de Material Utilizado");
        Etiquetas subtitulo2 = new Etiquetas("Cantidad de Material Sobrante");
        Etiquetas subtitulo3 = new Etiquetas("Material");
        Etiquetas et1 = new Etiquetas("Tortilla");
        Etiquetas et2 = new Etiquetas("Carne Asada");
        Etiquetas et3 = new Etiquetas("Repollo");
        Etiquetas et4 = new Etiquetas("Tortilla");
        Etiquetas et5 = new Etiquetas("Verdura");
        Etiquetas et6 = new Etiquetas("Limon");
        Etiquetas et7 = new Etiquetas("Pepino");
        Etiquetas et8 = new Etiquetas("Salsa");
        Etiquetas et9 = new Etiquetas("Cebolla Morada");
        Etiquetas cantidadPedido = new Etiquetas("Cantidad de tacos pedidos: 000");

        titulo.setBounds(150, 10, 500, 18);
        tiempo.setBounds(10, 300, 300, 25);
        subtitulo3.setBounds(10, 40, 50, 25);
        subtitulo1.setBounds(120, 40, 200, 25);
        subtitulo2.setBounds(310, 40, 200, 25);

        et1.setBounds(10, 60, 100, 25);
        et2.setBounds(10, 80, 100, 25);
        et3.setBounds(10, 100, 100, 25);
        et4.setBounds(10, 120, 100, 25);
        et5.setBounds(10, 140, 100, 25);
        et6.setBounds(10, 160, 100, 25);
        et7.setBounds(10, 180, 100, 25);
        et8.setBounds(10, 200, 100, 25);
        et9.setBounds(10, 220, 100, 25);

        cantidadPedido.setBounds(10, 260, 400, 25);

        add(titulo);
        add(tiempo);
        add(subtitulo3);
        add(subtitulo1);
        add(subtitulo2);

        add(et1);
        add(et2);
        add(et3);
        add(et4);
        add(et5);
        add(et6);
        add(et7);
        add(et8);
        add(et9);

        add(cantidadPedido);

        setTitle("Resultados");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
    }
}