import javax.swing.*;
import java.awt.*;

public class Resultados extends JDialog {
    Container cnt;
    RContainer rcnt;
    private int[] cantTacos = { 1, 100, 50, 20, 10, 100, 100, 30 };
    private double[] times;
    public Resultados(RContainer rcnt, Container cnt) {
        this.rcnt=rcnt;
        this.cnt=cnt;
        initComponents();
    }

    public void initComponents() {
        times = rcnt.getTimes();
        Font fuente1 = new Font("Arial", 1, 24);

        Etiquetas titulo = new Etiquetas("Resultados obtenidos");
        titulo.setFont(fuente1);
        Etiquetas tiempo = new Etiquetas("Tiempo transcurrido: "+rcnt.getTime());
        Etiquetas subtitulo1 = new Etiquetas("Material Utilizado");
        Etiquetas subtitulo2 = new Etiquetas("Material Sobrante");
        Etiquetas subtitulo3 = new Etiquetas("Material");
        Etiquetas subtitulo4 = new Etiquetas("Material/Taco");
        Etiquetas subtitulo5 = new Etiquetas("Tiempos/Taco (s)");

        Etiquetas et1 = new Etiquetas("Tortilla");
        Etiquetas et2 = new Etiquetas("Carne Asada");
        Etiquetas et3 = new Etiquetas("Repollo");
        Etiquetas et5 = new Etiquetas("Verdura");
        Etiquetas et6 = new Etiquetas("Limon");
        Etiquetas et7 = new Etiquetas("Pepino");
        Etiquetas et8 = new Etiquetas("Salsa");
        Etiquetas et9 = new Etiquetas("Cebolla Morada");

        Etiquetas RTortilla = new Etiquetas(Integer.toString(rcnt.getRTortilla())+" pz.");
        Etiquetas RCarne = new Etiquetas(Integer.toString(rcnt.getRCarne())+" g.");
        Etiquetas RRepollo = new Etiquetas(Integer.toString(rcnt.getRRepollo())+" g.");
        Etiquetas RVerdura = new Etiquetas(Integer.toString(rcnt.getRVerdura())+" g.");
        Etiquetas RLimon = new Etiquetas(Integer.toString(rcnt.getRLimon())+" g.");
        Etiquetas RPepino = new Etiquetas(Integer.toString(rcnt.getRPepino())+" g.");
        Etiquetas RSalsa = new Etiquetas(Integer.toString(rcnt.getRSalsa()) + " ml.");
        Etiquetas RCebolla = new Etiquetas(Integer.toString(rcnt.getRCebolla())+" g.");

        Etiquetas CTortilla = new Etiquetas(Integer.toString(cnt.getTortilla())+" pz.");
        Etiquetas CCarne = new Etiquetas(Integer.toString(cnt.getCarne())+" g.");
        Etiquetas CRepollo = new Etiquetas(Integer.toString(cnt.getRepollo())+" g.");
        Etiquetas CVerdura = new Etiquetas(Integer.toString(cnt.getVerdura())+" g.");
        Etiquetas CLimon = new Etiquetas(Integer.toString(cnt.getLimon())+" g.");
        Etiquetas CPepino = new Etiquetas(Integer.toString(cnt.getPepino())+" g.");
        Etiquetas CSalsa = new Etiquetas(Integer.toString(cnt.getSalsa())+" ml.");
        Etiquetas CCebolla = new Etiquetas(Integer.toString(cnt.getCebolla())+" g.");

        Etiquetas CPTortilla = new Etiquetas(Integer.toString(cantTacos[0])+" pz.");
        Etiquetas CPCarne = new Etiquetas(Integer.toString(cantTacos[1])+" g.");
        Etiquetas CPRepollo = new Etiquetas(Integer.toString(cantTacos[2])+" g.");
        Etiquetas CPVerdura = new Etiquetas(Integer.toString(cantTacos[3])+" g.");
        Etiquetas CPLimon = new Etiquetas(Integer.toString(cantTacos[4])+" g.");
        Etiquetas CPPepino = new Etiquetas(Integer.toString(cantTacos[5])+" g.");
        Etiquetas CPSalsa = new Etiquetas(Integer.toString(cantTacos[6])+" ml.");
        Etiquetas CPCebolla = new Etiquetas(Integer.toString(cantTacos[7])+" g.");

        Etiquetas TPTortilla = new Etiquetas(Double.toString(times[0]));
        Etiquetas TPCarne = new Etiquetas(Double.toString(times[1]));
        Etiquetas TPRepollo = new Etiquetas(Double.toString(times[2]));
        Etiquetas TPVerdura = new Etiquetas(Double.toString(times[3]));
        Etiquetas TPLimon = new Etiquetas(Double.toString(times[4]));
        Etiquetas TPPepino = new Etiquetas(Double.toString(times[5]));
        Etiquetas TPSalsa = new Etiquetas(Double.toString(times[6]));
        Etiquetas TPCebolla = new Etiquetas(Double.toString(times[7]));

        
        Etiquetas cantidadPedido = new Etiquetas("Cantidad de tacos pedidos: "+rcnt.getPedidos());

        titulo.setBounds(150, 10, 500, 18);
        tiempo.setBounds(10, 300, 300, 25);
        subtitulo3.setBounds(10, 40, 50, 25);
        subtitulo1.setBounds(120, 40, 200, 25);
        subtitulo2.setBounds(235, 40, 200, 25);
        subtitulo4.setBounds(350,40,200,25);
        subtitulo5.setBounds(465,40,200,25);

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

        CTortilla.setBounds(235, 80, 200, 25);
        CCarne.setBounds(235, 100, 200, 25);
        CRepollo.setBounds(235, 120, 200, 25);
        CVerdura.setBounds(235, 140, 200, 25);
        CLimon.setBounds(235, 160, 200, 25);
        CPepino.setBounds(235, 180, 200, 25);
        CSalsa.setBounds(235, 200, 200, 25);
        CCebolla.setBounds(235, 220, 200, 25);

        CPTortilla.setBounds(350, 80, 200, 25);
        CPCarne.setBounds(350, 100, 200, 25);
        CPRepollo.setBounds(350, 120, 200, 25);
        CPVerdura.setBounds(350, 140, 200, 25);
        CPLimon.setBounds(350, 160, 200, 25);
        CPPepino.setBounds(350, 180, 200, 25);
        CPSalsa.setBounds(350, 200, 200, 25);
        CPCebolla.setBounds(350, 220, 200, 25);
        
        TPTortilla.setBounds(465, 80, 200, 25);
        TPCarne.setBounds(465, 100, 200, 25);
        TPRepollo.setBounds(465, 120, 200, 25);
        TPVerdura.setBounds(465, 140, 200, 25);
        TPLimon.setBounds(465, 160, 200, 25);
        TPPepino.setBounds(465, 180, 200, 25);
        TPSalsa.setBounds(465, 200, 200, 25);
        TPCebolla.setBounds(465, 220, 200, 25);

        cantidadPedido.setBounds(10, 260, 400, 25);

        add(titulo);
        add(tiempo);
        add(subtitulo3);
        add(subtitulo1);
        add(subtitulo2);
        add(subtitulo4);
        add(subtitulo5);

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

        add(CPTortilla);
        add(CPCarne);
        add(CPRepollo);
        add(CPVerdura);
        add(CPLimon);
        add(CPPepino);
        add(CPSalsa);
        add(CPCebolla);

        add(TPTortilla);
        add(TPCarne);
        add(TPRepollo);
        add(TPVerdura);
        add(TPLimon);
        add(TPPepino);
        add(TPSalsa);
        add(TPCebolla);

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