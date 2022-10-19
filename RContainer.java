public class RContainer {
    private int rTortilla=0,rCarne=0,rRepollo=0,rVerdura=0,rLimon=0,rPepino=0,rSalsa=0,rCebolla=0,pedidos=0;
    private String time="";
    private double times[];
    //
    // SETTERS
    //
    public void setRTortilla(int rTortilla){this.rTortilla = rTortilla;}
    public void setRCarne(int rCarne){this.rCarne = rCarne;}
    public void setRRepollo(int rRepollo){this.rRepollo = rRepollo;}
    public void setRVerdura(int rVerdura){this.rVerdura = rVerdura;}
    public void setRLimon(int rLimon){this.rLimon = rLimon;}
    public void setRPepino(int rPepino){this.rPepino = rPepino;}
    public void setRSalsa(int rSalsa){this.rSalsa = rSalsa;}
    public void setRCebolla(int rCebolla){this.rCebolla = rCebolla;}
    public void setPedidos(int pedidos){this.pedidos = pedidos;}
    public void setTime(String time){this.time = time;}

    public void setTimes(double[] times){this.times = times;}
    //
    // GETTERS
    //
    public int getRTortilla(){return this.rTortilla;}
    public int getRCarne(){return this.rCarne;}
    public int getRRepollo(){return this.rRepollo;}
    public int getRVerdura(){return this.rVerdura;}
    public int getRLimon(){return this.rLimon;}
    public int getRPepino(){return this.rPepino;}
    public int getRSalsa(){return this.rSalsa;}
    public int getRCebolla(){return this.rCebolla;}
    public int getPedidos(){return pedidos;}
    public String getTime(){return this.time;}

    public double[] getTimes(){return times;};
}
