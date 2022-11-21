import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Resultados extends JDialog {
    Container cnt;
    RContainer rcnt;
    private double tiempoTotal = 0.0;
    private int pedidos = 0;
    private String text;
    private int[] cantTacos = { 1, 100, 50, 20, 10, 100, 100, 30 };
    private double[] times, tiemposTotales;

    public Resultados(RContainer rcnt, Container cnt, String text, int pedidos, double[] tiemposTotales) {
        this.rcnt = rcnt;
        this.cnt = cnt;
        this.text = text;
        this.pedidos = pedidos;
        this.tiemposTotales = tiemposTotales;
        initComponents();
    }

    public void initComponents() {
        times = rcnt.getTimes();
        Font fuente1 = new Font("Arial", 1, 24);
        DecimalFormat df = new DecimalFormat("###.##");

        Etiquetas titulo = new Etiquetas(text);
        titulo.setFont(fuente1);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Etiquetas tiempo = new Etiquetas("Tiempo transcurrido: " + rcnt.getTime());
        Etiquetas subtitulo1 = new Etiquetas("Material Utilizado");
        Etiquetas subtitulo2 = new Etiquetas("Material Sobrante");
        Etiquetas subtitulo3 = new Etiquetas("Material");
        Etiquetas subtitulo4 = new Etiquetas("Material/Taco");
        Etiquetas subtitulo5 = new Etiquetas("Tiempos/Taco (s)");
        Etiquetas subtitulo6 = new Etiquetas("Tiempos totales");

        Etiquetas et1 = new Etiquetas("Tortilla");
        Etiquetas et2 = new Etiquetas("Carne Asada");
        Etiquetas et3 = new Etiquetas("Repollo");
        Etiquetas et5 = new Etiquetas("Verdura");
        Etiquetas et6 = new Etiquetas("Limon");
        Etiquetas et7 = new Etiquetas("Pepino");
        Etiquetas et8 = new Etiquetas("Salsa");
        Etiquetas et9 = new Etiquetas("Cebolla Morada");
        //
        // Cantidades sin modificar
        //
        Etiquetas RTortilla = new Etiquetas(Integer.toString(rcnt.getRTortilla()) + " pz.");
        Etiquetas RCarne = new Etiquetas(Integer.toString(rcnt.getRCarne()) + " g.");
        Etiquetas RRepollo = new Etiquetas(Integer.toString(rcnt.getRRepollo()) + " g.");
        Etiquetas RVerdura = new Etiquetas(Integer.toString(rcnt.getRVerdura()) + " g.");
        Etiquetas RLimon = new Etiquetas(Integer.toString(rcnt.getRLimon()) + " g.");
        Etiquetas RPepino = new Etiquetas(Integer.toString(rcnt.getRPepino()) + " g.");
        Etiquetas RSalsa = new Etiquetas(Integer.toString(rcnt.getRSalsa()) + " ml.");
        Etiquetas RCebolla = new Etiquetas(Integer.toString(rcnt.getRCebolla()) + " g.");
        //
        // Cantidades modificadas
        //
        Etiquetas CTortilla = new Etiquetas(Integer.toString(cnt.getTortilla()) + " pz.");
        Etiquetas CCarne = new Etiquetas(Integer.toString(cnt.getCarne()) + " g.");
        Etiquetas CRepollo = new Etiquetas(Integer.toString(cnt.getRepollo()) + " g.");
        Etiquetas CVerdura = new Etiquetas(Integer.toString(cnt.getVerdura()) + " g.");
        Etiquetas CLimon = new Etiquetas(Integer.toString(cnt.getLimon()) + " g.");
        Etiquetas CPepino = new Etiquetas(Integer.toString(cnt.getPepino()) + " g.");
        Etiquetas CSalsa = new Etiquetas(Integer.toString(cnt.getSalsa()) + " ml.");
        Etiquetas CCebolla = new Etiquetas(Integer.toString(cnt.getCebolla()) + " g.");
        //
        // Cantidades por taco
        //
        Etiquetas CPTortilla = new Etiquetas(Integer.toString(cantTacos[0]) + " pz.");
        Etiquetas CPCarne = new Etiquetas(Integer.toString(cantTacos[1]) + " g.");
        Etiquetas CPRepollo = new Etiquetas(Integer.toString(cantTacos[2]) + " g.");
        Etiquetas CPVerdura = new Etiquetas(Integer.toString(cantTacos[3]) + " g.");
        Etiquetas CPLimon = new Etiquetas(Integer.toString(cantTacos[4]) + " g.");
        Etiquetas CPPepino = new Etiquetas(Integer.toString(cantTacos[5]) + " g.");
        Etiquetas CPSalsa = new Etiquetas(Integer.toString(cantTacos[6]) + " ml.");
        Etiquetas CPCebolla = new Etiquetas(Integer.toString(cantTacos[7]) + " g.");
        //
        // Tiempos por taco
        //
        Etiquetas TPTortilla = new Etiquetas(Double.toString(times[0]));
        Etiquetas TPCarne = new Etiquetas(Double.toString(times[1]));
        Etiquetas TPRepollo = new Etiquetas(Double.toString(times[2]));
        Etiquetas TPVerdura = new Etiquetas(Double.toString(times[3]));
        Etiquetas TPLimon = new Etiquetas(Double.toString(times[4]));
        Etiquetas TPPepino = new Etiquetas(Double.toString(times[5]));
        Etiquetas TPSalsa = new Etiquetas(Double.toString(times[6]));
        Etiquetas TPCebolla = new Etiquetas(Double.toString(times[7]));
        //
        // Tiempos totales
        //
        Etiquetas TTTortilla = new Etiquetas((df.format(tiemposTotales[0])));
        Etiquetas TTCarne = new Etiquetas((df.format(tiemposTotales[1])));
        Etiquetas TTRepollo = new Etiquetas((df.format(tiemposTotales[2])));
        Etiquetas TTVerdura = new Etiquetas((df.format(tiemposTotales[3])));
        Etiquetas TTLimon = new Etiquetas((df.format(tiemposTotales[4])));
        Etiquetas TTPepino = new Etiquetas((df.format(tiemposTotales[5])));
        Etiquetas TTSalsa = new Etiquetas((df.format(tiemposTotales[6])));
        Etiquetas TTCebolla = new Etiquetas((df.format(tiemposTotales[7])));

        Etiquetas TPTotal = new Etiquetas(); // tiempo total por taco

        Etiquetas TTTotal = new Etiquetas(); // tiempo total por todos los tacos

        JButton btnAceptar = new JButton("Aceptar");

        for (int i = 0; i < times.length; i++) {
            tiempoTotal += times[i];
        }
        Etiquetas tot = new Etiquetas("Total: ");
        TPTotal.setText(df.format(tiempoTotal));
        tiempoTotal = 0.0;
        for (int i = 0; i < tiemposTotales.length; i++) {
            tiempoTotal += tiemposTotales[i];
        }
        TTTotal.setText(df.format(tiempoTotal));

        Etiquetas cantidadPedido = new Etiquetas("Cantidad de tacos pedidos: " + rcnt.getPedidos());
        
        Etiquetas pedidosCompletos = new Etiquetas("Pedidos completados: " + Integer.toString(pedidos));

        titulo.setBounds(1, 10, 750, 25);
        tiempo.setBounds(10, 300, 300, 25);
        subtitulo3.setBounds(10, 40, 50, 25);
        subtitulo1.setBounds(120, 40, 200, 25);
        subtitulo2.setBounds(235, 40, 200, 25);
        subtitulo4.setBounds(350, 40, 200, 25);
        subtitulo5.setBounds(465, 40, 200, 25);
        subtitulo6.setBounds(580, 40, 200, 25);

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
        tot.setBounds(430, 240, 200, 25);
        TPTotal.setBounds(465, 240, 200, 25);

        TTTortilla.setBounds(580, 80, 200, 25);
        TTCarne.setBounds(580, 100, 200, 25);
        TTRepollo.setBounds(580, 120, 200, 25);
        TTVerdura.setBounds(580, 140, 200, 25);
        TTLimon.setBounds(580, 160, 200, 25);
        TTPepino.setBounds(580, 180, 200, 25);
        TTSalsa.setBounds(580, 200, 200, 25);
        TTCebolla.setBounds(580, 220, 200, 25);
        TTTotal.setBounds(580, 240, 200, 25);

        cantidadPedido.setBounds(10, 260, 400, 25);
        pedidosCompletos.setBounds(10, 280, 400, 25);

        btnAceptar.setBounds(310,320,100,25);

        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        };

        btnAceptar.addActionListener(listener);

        add(titulo);
        add(tiempo);
        add(subtitulo3);
        add(subtitulo1);
        add(subtitulo2);
        add(subtitulo4);
        add(subtitulo5);
        add(subtitulo6);

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
        add(TPTotal);
        add(tot);

        add(TTTortilla);
        add(TTCarne);
        add(TTRepollo);
        add(TTVerdura);
        add(TTLimon);
        add(TTPepino);
        add(TTSalsa);
        add(TTCebolla);
        add(TTTotal);

        add(cantidadPedido);
        add(pedidosCompletos);

        add(btnAceptar);

        setTitle("Resultados");
        setSize(750, 400);
        setResizable(false);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}