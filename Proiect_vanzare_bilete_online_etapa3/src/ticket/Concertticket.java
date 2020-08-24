package ticket;
import typeofevent.Concert;

public class Concertticket extends Concert
{

    private int pret;
    private int cod;

    public Concertticket()
    {

    }

    public Concertticket(int p,int c )
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
