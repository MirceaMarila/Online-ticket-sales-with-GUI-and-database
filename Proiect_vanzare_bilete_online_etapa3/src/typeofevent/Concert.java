package typeofevent;
import client.Client;

public class Concert extends Client
{
    private String numeformatie;
    private int varstaminima;
    private int durata;

    public Concert()
    {

    }

    public Concert(String nf,int vm,int d )
    {
        this.numeformatie = nf;
        this.varstaminima = vm;
        this.durata = d;
    }


    public String getNumeformatie()
    {
        return numeformatie;
    }

    public void setNumeformatie(String nf)
    {
        this.numeformatie = nf;
    }

    public int getVarstaminima()
    {
        return varstaminima;
    }

    public void setVarstaminima(int v)
    {
        this.varstaminima = v;
    }

    public int getDurata()
    {
        return durata;
    }

    public void setDurata(int d)
    {
        this.durata = d;
    }

}
