package typeofevent;
import client.Client;

public class Theatre extends Client
{
    private String numetrupa;
    private int varstaminima;
    private int durata;

    public Theatre()
    {

    }

    public Theatre(String nt,int vm,int d )
    {
        this.numetrupa = nt;
        this.varstaminima = vm;
        this.durata = d;
    }


    public String getNumetrupa()
    {
        return numetrupa;
    }

    public void setNumetrupa(String nt)
    {
        this.numetrupa = nt;
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
