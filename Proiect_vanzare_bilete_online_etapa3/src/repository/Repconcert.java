package repository;
import service.Serviceconcert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class Repconcert
{
    static ArrayList<Serviceconcert> ConcertTicketQ = new ArrayList<>();
    public ArrayList<Serviceconcert> getConcerticket()
    {
        return ConcertTicketQ ;
    }

    public void newConcertTicket(Serviceconcert bilet)
    {
        ConcertTicketQ.add(bilet);
    }

    public void removeConcertTicket(Serviceconcert bilet)
    {
        ConcertTicketQ.remove(bilet);
    }


    //////////////////////////vv BAZE DE DATE vv




}
