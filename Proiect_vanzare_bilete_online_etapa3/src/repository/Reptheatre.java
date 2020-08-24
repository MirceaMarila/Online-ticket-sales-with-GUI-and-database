package repository;
import service.Servicetheatre;
import java.util.ArrayList;

public class Reptheatre
{
    ArrayList<Servicetheatre> TheratreTicketQ = new ArrayList<>();
    public ArrayList<Servicetheatre> getThearteTicket()
    {
        return TheratreTicketQ ;
    }

    public void newTheatreTicket(Servicetheatre bilet)
    {
        TheratreTicketQ.add(bilet);
    }

    public void removeTheatreTicket(Servicetheatre bilet)
    {
        TheratreTicketQ.remove(bilet);
    }



}
