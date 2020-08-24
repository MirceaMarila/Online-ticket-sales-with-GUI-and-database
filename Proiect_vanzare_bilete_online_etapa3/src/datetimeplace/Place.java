package datetimeplace;

public class Place extends DateTime
{
    private int nrlocuri;
    private String adresa;
    private String numeloc;

    public Place()
    {

    }

    public Place(int nrlocuri, String adresa, String nume)
    {
        this.nrlocuri = nrlocuri;
        this.adresa = adresa;
        this.numeloc = nume;
    }

    public int getNrlocuri()
    {
        return nrlocuri;
    }

    public void setNrlocuri(int nrl)
    {
        this.nrlocuri = nrl;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public void setAdresa(String adr)
    {
        this.adresa = adr;
    }

    public String getNumeloc() {
        return numeloc;
    }

    public void setNumeloc(String nume) {
        this.numeloc = nume;
    }

}
