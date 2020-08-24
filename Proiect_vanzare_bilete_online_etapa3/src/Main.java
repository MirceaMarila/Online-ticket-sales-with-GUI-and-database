import service.*;
import repository.*;
import client.Client;

import java.util.*;


public class Main
{
    public static void main(String[] args)
    {  ////////////////////////////////////////etapa1

        // informatiile biletelor sunt stocate in clasele din package-ul service, deoarece ele mostenesc clasele din package-ul ticket

        //exemplu eveniment sport
        Servicesport ev1;
        ev1=new Servicesport();
        ev1.setAdresa("Strada Principala nr.123");
        ev1.setDurata(90);
        ev1.setNumesport("fotbal");
        ev1.setEchipa1("FCSB");
        ev1.setEchipa2("Dinamo");
        ev1.setNrlocuri(30000);
        ev1.setAn(2020);
        ev1.setLuna(8);
        ev1.setZiua(18);
        ev1.setOra(21);
        ev1.setMin(45);
        ev1.setVarsta(67);
        ev1.setNumeloc("Arena Nationala");
        ev1.setNume("Giovani Becali");

        ev1.CalculatePrice();
        ev1.TicketInformation();

        Repsport TicketSportList= new Repsport();
        TicketSportList.newSportTicket(ev1);
        TicketSportList.removeSportTicket(ev1);
//et3
        ev1.create_db_table();
        ev1.add_ticket_to_db_table();



        //exemplu eveniment concert
        Serviceconcert ev2;
        ev2=new Serviceconcert();
        ev2.setAdresa("Strada Rada nr.231");
        ev2.setNrlocuri(500);
        ev2.setNumeloc("Kruhnen Club");
        ev2.setNume("Marila Mircea");
        ev2.setAn(2020);
        ev2.setDurata(100);
        ev2.setLuna(7);
        ev2.setZiua(2);
        ev2.setOra(23);
        ev2.setMin(30);
        ev2.setNumeformatie("Parazitii");
        ev2.setVarsta(20);
        ev2.setVarstaminima(18);



        ev2.AgeVerification();
        ev2.CalculatePrice();
        ev2.TicketInformation();

        //et3
        ev2.create_db_table();
        ev2.add_ticket_to_db_table();
        ev2.setNumeformatie("Bazooka");
        ev2.update_ticket_in_db_table();



        Repconcert TicketConcertList= new Repconcert();
        TicketConcertList.newConcertTicket(ev2);
        TicketConcertList.removeConcertTicket(ev2);

        //exemplu eveniment teatru

        Servicetheatre ev3;
        ev3=new Servicetheatre();
        ev3.setAdresa("Strada Secundara  nr.312");
        ev3.setNrlocuri(1000);
        ev3.setNumeloc("Teatrul Dramatic Reduta");
        ev3.setNume("Dorel Stoian");
        ev3.setAn(2020);
        ev3.setDurata(120);
        ev3.setLuna(12);
        ev3.setZiua(15);
        ev3.setOra(19);
        ev3.setMin(00);
        ev3.setNumetrupa("AS");
        ev3.setVarsta(15);
        ev3.setVarstaminima(16);

        ev3.AgeVerification();
        ev3.CalculatePrice();
        ev3.TicketInformation();
        ev3.setVarsta(17);
        ev3.TicketInformation();

        Reptheatre TicketTheatreList= new Reptheatre();
        TicketTheatreList.newTheatreTicket(ev3);
        TicketTheatreList.removeTheatreTicket(ev3);

        //et3
        ev3.create_db_table();
        ev3.add_ticket_to_db_table();
        ev3.setAn(2021);
        ev3.update_ticket_in_db_table();

        //etapa2

        Servicesport ev4=new Servicesport();
        ev4.fileread(1);       //citeste primul rand de dupa header
        ev4.setEchipa2("Sevilla");  //schimba un parametru
        ev4.addsportcsv();     //scrie in fisier noile date

        ev4.add_ticket_to_db_table();
        ev4.delete_ticket_from_db_table();



        Serviceconcert ev5=new Serviceconcert();
        ev5.fileread(3);
        ev5.setVarstaminima(15);
        ev5.addconcertcsv();

        //et3
        ev5.create_db_table();
        ev5.add_ticket_to_db_table();
        ev5.setVarstaminima(70);
        ev5.update_ticket_in_db_table();
        ev5.delete_ticket_from_db_table();

        Servicetheatre ev6=new Servicetheatre();
        ev6.fileread(2);
        ev6.setOra(16);
        ev6.addtheatrecsv();
//et3
        ev6.add_ticket_to_db_table();
        ev6.delete_ticket_from_db_table();




    }
}
