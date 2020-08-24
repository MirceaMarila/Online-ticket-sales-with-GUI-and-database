package typeofevent;
import client.Client;

public class Sport extends Client
{
    private String numesport;
    private String echipa1;
    private String echipa2;
    private int durata;

    public Sport()
    {

    }

    public Sport(String ns, String e1, String e2,int durata)
    {
        this.numesport = ns;
        this.echipa1 = e1;
        this.echipa2 = e2;
        this.durata=durata;
    }


    public String getNumesport()
    {
        return numesport;
    }

    public void setNumesport(String ns)
    {
        this.numesport = ns;
    }

    public String getEchipa1()
    {
        return echipa1;
    }

    public void setEchipa1(String e1)
    {
        this.echipa1 = e1;
    }

    public String getEchipa2()
    {
        return echipa2;
    }

    public void setEchipa2(String e2)
    {
        this.echipa2 = e2;
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
