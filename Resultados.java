import javax.swing.*;
import java.awt.*;

public class Resultados extends JDialog {
    Container cnt;
    RContainer rcnt;
    public Resultados(RContainer rcnt, Container cnt) {
        this.rcnt=rcnt;
        this.cnt=cnt;
        initComponents();
    }

    public void initComponents() {
        Font fuente1 = new Font("Arial", 1, 24);

        Etiquetas titulo = new Etiquetas("Resultados obtenidos");
        titulo.setFont(fuente1);
        Etiquetas tiempo = new Etiquetas("Tiempo transcurrido: "+rcnt.getTime());
        Etiquetas subtitulo1 = new Etiquetas("Cantidad de Material Utilizado");
        Etiquetas subtitulo2 = new Etiquetas("Cantidad de Material Sobrante");
        Etiquetas subtitulo3 = new Etiquetas("Material");

        Etiquetas et1 = new Etiquetas("Tortilla");
        Etiquetas et2 = new Etiquetas("Carne Asada");
        Etiquetas et3 = new Etiquetas("Repollo");
        Etiquetas et5 = new Etiquetas("Verdura");
        Etiquetas et6 = new Etiquetas("Limon");
        Etiquetas et7 = new Etiquetas("Pepino");
        Etiquetas et8 = new Etiquetas("Salsa");
        Etiquetas et9 = new Etiquetas("Cebolla Morada");

        Etiquetas RTortilla = new Etiquetas(Integer.toString(rcnt.getRTortilla()));
        Etiquetas RCarne = new Etiquetas(Integer.toString(rcnt.getRCarne()));
        Etiquetas RRepollo = new Etiquetas(Integer.toString(rcnt.getRRepollo()));
        Etiquetas RVerdura = new Etiquetas(Integer.toString(rcnt.getRVerdura()));
        Etiquetas RLimon = new Etiquetas(Integer.toString(rcnt.getRLimon()));
        Etiquetas RPepino = new Etiquetas(Integer.toString(rcnt.getRPepino()));
        Etiquetas RSalsa = new Etiquetas(Integer.toString(rcnt.getRSalsa()));
        Etiquetas RCebolla = new Etiquetas(Integer.toString(rcnt.getRCebolla()));

        Etiquetas CTortilla = new Etiquetas(Integer.toString(cnt.getTortilla()));
        Etiquetas CCarne = new Etiquetas(Integer.toString(cnt.getCarne()));
        Etiquetas CRepollo = new Etiquetas(Integer.toString(cnt.getRepollo()));
        Etiquetas CVerdura = new Etiquetas(Integer.toString(cnt.getVerdura()));
        Etiquetas CLimon = new Etiquetas(Integer.toString(cnt.getLimon()));
        Etiquetas CPepino = new Etiquetas(Integer.toString(cnt.getPepino()));
        Etiquetas CSalsa = new Etiquetas(Integer.toString(cnt.getSalsa()));
        Etiquetas CCebolla = new Etiquetas(Integer.toString(cnt.getCebolla()));

        
        Etiquetas cantidadPedido = new Etiquetas("Cantidad de tacos pedidos: "+rcnt.getPedidos());

        titulo.setBounds(150, 10, 500, 18);
        tiempo.setBounds(10, 300, 300, 25);
        subtitulo3.setBounds(10, 40, 50, 25);
        subtitulo1.setBounds(120, 40, 200, 25);
        subtitulo2.setBounds(310, 40, 200, 25);

        et1.setBounds(10, 80, 100, 25);
        et2.setBounds(10, 100, 100, 25);
        et3.setBounds(10, 120, 100, 25);
        et5.setBounds(10, 140, 100, 25);
        et6.setBounds(10, 160, 100, 25);
        et7.setBounds(10, 180, 100, 25);
        et8.setBounds(10, 200, 100, 25);
        et9.setBounds(10, 220, 100, 25);

        RTortilla.setBounds(120, 80, 200, 25);
        RCarne.setBounds(120, 100, 200, 25);
        RRepollo.setBounds(120, 120, 200, 25);
        RVerdura.setBounds(120, 140, 200, 25);
        RLimon.setBounds(120, 160, 200, 25);
        RPepino.setBounds(120, 180, 200, 25);
        RSalsa.setBounds(120, 200, 200, 25);
        RCebolla.setBounds(120, 220, 200, 25);

        CTortilla.setBounds(310, 80, 200, 25);
        CCarne.setBounds(310, 100, 200, 25);
        CRepollo.setBounds(310, 120, 200, 25);
        CVerdura.setBounds(310, 140, 200, 25);
        CLimon.setBounds(310, 160, 200, 25);
        CPepino.setBounds(310, 180, 200, 25);
        CSalsa.setBounds(310, 200, 200, 25);
        CCebolla.setBounds(310, 220, 200, 25);

        cantidadPedido.setBounds(10, 260, 400, 25);

        add(titulo);
        add(tiempo);
        add(subtitulo3);
        add(subtitulo1);
        add(subtitulo2);

        add(et1);
        add(et2);
        add(et3);
        add(et5);
        add(et6);
        add(et7);
        add(et8);
        add(et9);

        add(RTortilla);
        add(RCarne);
        add(RRepollo);
        add(RVerdura);
        add(RLimon);
        add(RPepino);
        add(RSalsa);
        add(RCebolla);

        add(CTortilla);
        add(CCarne);
        add(CRepollo);
        add(CVerdura);
        add(CLimon);
        add(CPepino);
        add(CSalsa);
        add(CCebolla);

        add(cantidadPedido);

        setTitle("Resultados");
        setSize(600, 400);
        setResizable(false);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}