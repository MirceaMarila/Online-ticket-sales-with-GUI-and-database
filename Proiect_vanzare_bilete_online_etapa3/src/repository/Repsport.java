package repository;
import service.Servicesport;
import java.util.ArrayList;

public class Repsport
{
    ArrayList<Servicesport> SportTicketQ = new ArrayList<>();
    public ArrayList<Servicesport> getSportTicket()
    {
        return SportTicketQ;
    }

    public void newSportTicket(Servicesport bilet)
    {
        SportTicketQ.add(bilet);
    }

    public void removeSportTicket(Servicesport bilet)
    {
        SportTicketQ.remove(bilet);
    }


}
