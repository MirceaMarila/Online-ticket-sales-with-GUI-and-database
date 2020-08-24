package ticket;
import typeofevent.Theatre;

public class Theatreticket extends Theatre
{

    private int pret;
    private int cod;

    public Theatreticket()
    {

    }

    public Theatreticket(int p,int c)
    {
        this.pret=p;
        this.cod=c;
    }


    public int getPret()
    {
        return pret;
    }

    public void setPret(int p)
    {
        this.pret = p;
    }

    public int getCod()
    {
        return cod;
    }

    public void setCod(int c)
    {
        this.cod = c;
    }



}
