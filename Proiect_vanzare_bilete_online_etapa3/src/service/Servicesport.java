package service;
import ticket.Sportticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;

public class Servicesport extends Sportticket
{
    private static int staticcod=0;
    public Servicesport()
    {
staticcod++;
this.setCod(staticcod);
    }

    public void CalculatePrice()
    {
        Random rand = new Random();
        int nr=rand.nextInt(20);
        int price;
        price=10+nr;
        if(getVarsta()<18)
            price=price/2;
        setPret(price); //pentru evenimentele sportive, preturile variaza intre 10 si 30 de lei. minorii platesc jumatate din pret.
    }

    public void TicketInformation()
    {
        //Random rand = new Random();
        //int nr=rand.nextInt(getNrlocuri());
        //setCod(nr);
        //setCod(staticcod);

        System.out.println("Biletul dvs ("+getNume()+") cu codul "+ getCod()+" la meciul de "+getNumesport()+" dintre "+getEchipa1()+" si " +getEchipa2()+"(care dureaza "+getDurata()+" min) care are loc pe "+getAdresa()+" la "+getNumeloc()+" la data de "+getZiua()+"."+getLuna()+"."+getAn()+", ora "+getOra()+":"+getMin()+", costa "+getPret()+" RON." );
    }


    ////FUNCTII DE CREARE TABEL, INSERARE IN TABEL, UPDATE DATE DIN TABEL, STERGERE LINIE DIN TABEL
    public void create_db_table()
    {
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement create= connection.prepareStatement("CREATE TABLE IF NOT EXISTS biletesport (id INT NOT NULL, Nume_client VARCHAR(255), Varsta_client INT NOT NULL, Nume_sport VARCHAR(255), Echipa1 VARCHAR(255), Echipa2 VARCHAR(255), Durata_meciului INT NOT NULL, Nume_locatie VARCHAR(255), Adresa VARCHAR(255), Nr_locuri INT NOT NULL, Ziua INT NOT NULL, Luna INT NOT NULL, Anul INT NOT NULL, Ora INT NOT NULL, Min INT NOT NULL, PRIMARY KEY(id))");
            create.executeUpdate();
            System.out.println("Table created");

            Thread th = new Thread(String.valueOf(create));
            th.start();
            AuditService obj=new AuditService();
            obj.addauditcsv("Table for sport tickets created",th.currentThread().getName());

        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

    public void add_ticket_to_db_table() {

        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement myStmt=connection.createStatement();

            String sql="insert into biletesport"+"(id,Nume_client,Varsta_client,Nume_sport,Echipa1,Echipa2,Durata_meciului,Nume_locatie,Adresa,Nr_locuri,Ziua,Luna,Anul,Ora,Min)"+"values("+this.getCod()+",'"+this.getNume()+"','"+this.getVarsta()+"','"+this.getNumesport()+"','"+this.getEchipa1()+"','"+this.getEchipa2()+"','"+this.getDurata()+"','"+this.getNumeloc()+"','"+this.getAdresa()+"','"+this.getNrlocuri()+"','"+this.getZiua()+"','"+this.getLuna()+"','"+this.getAn()+"','"+this.getOra()+"','"+this.getMin()+"')";   //valorile de adaugat in tabel
            myStmt.executeUpdate(sql);//update tabel
            System.out.println("Insert complete");//confirmare

            Thread th = new Thread(String.valueOf(myStmt));
            th.start();
            AuditService obj=new AuditService();
            obj.addauditcsv("New raw in the table for sport tickets!",th.currentThread().getName());

        } catch (Exception e)   {
            e.printStackTrace();
        }

    }

    public void update_ticket_in_db_table() {

        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement myStmt=connection.createStatement();


            String sql="delete from biletesport where id='"+this.getCod()+"'";//stergere linie din tabel
            myStmt.executeUpdate(sql);//update tabel
            //String sql3="commit";
            //myStmt.executeUpdate(sql3);
            String sql2="insert into biletesport"+"(id,Nume_client,Varsta_client,Nume_sport,Echipa1,Echipa2,Durata_meciului,Nume_locatie,Adresa,Nr_locuri,Ziua,Luna,Anul,Ora,Min)"+"values("+this.getCod()+",'"+this.getNume()+"','"+this.getVarsta()+"','"+this.getNumesport()+"','"+this.getEchipa1()+"','"+this.getEchipa2()+"','"+this.getDurata()+"','"+this.getNumeloc()+"','"+this.getAdresa()+"','"+this.getNrlocuri()+"','"+this.getZiua()+"','"+this.getLuna()+"','"+this.getAn()+"','"+this.getOra()+"','"+this.getMin()+"')";
            myStmt.executeUpdate(sql2);//update tabel
            System.out.println("Update complete");//confirmare

            Thread th = new Thread(String.valueOf(myStmt));
            th.start();
            AuditService obj=new AuditService();
            obj.addauditcsv("Table for concert sport updated",th.currentThread().getName());

        } catch (Exception e)   {
            e.printStackTrace();
        }

    }

    public void delete_ticket_from_db_table() {

        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement myStmt=connection.createStatement();


            String sql="delete from biletesport where id='"+this.getCod()+"'";//stergere linie din tabel
            myStmt.executeUpdate(sql);//update tabel

            System.out.println("Delete complete");//confirmare

            Thread th = new Thread(String.valueOf(myStmt));
            th.start();
            AuditService obj=new AuditService();
            obj.addauditcsv("Row of table for sport tickets deleted",th.currentThread().getName());

        } catch (Exception e)   {
            e.printStackTrace();
        }

    }






//////////////////////////////////////////////////////////////////////////////////////////////
    public void addsportcsv() {

        File fisier = new File("C:/Users/Mircea/Desktop/FeMeI/AN2/sem2/Progr_av_ob/proiect/Proiect_vanzare_bilete_online_etapa3/newSport.csv");

        if (fisier.length() == 0) {
            try  {


                FileWriter csvWriter = new FileWriter("newSport.csv");
                csvWriter.append("Nume client");
                csvWriter.append(",");
                csvWriter.append("Varsta client");
                csvWriter.append(",");
                csvWriter.append("Name sport");
                csvWriter.append(",");
                csvWriter.append("Echipa1");
                csvWriter.append(",");
                csvWriter.append("Echipa2");
                csvWriter.append(",");
                csvWriter.append("Durata(min)");
                csvWriter.append(",");
                csvWriter.append("Nume locatie");
                csvWriter.append(",");
                csvWriter.append("Adresa");
                csvWriter.append(",");
                csvWriter.append("Nr locuri");
                csvWriter.append(",");
                csvWriter.append("Ziua");
                csvWriter.append(",");
                csvWriter.append("Luna");
                csvWriter.append(",");
                csvWriter.append("Anul");
                csvWriter.append(",");
                csvWriter.append("Ora");
                csvWriter.append(",");
                csvWriter.append("Min");
                csvWriter.append("\n");




                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        try(FileWriter csvWriter= new FileWriter("newSport.csv", true))
        {

            csvWriter.append(this.getNume());
            csvWriter.append(",");
            String s1 = String.valueOf(this.getVarsta());
            csvWriter.append(s1);
            csvWriter.append(",");
            csvWriter.append(this.getNumesport());
            csvWriter.append(",");
            csvWriter.append(this.getEchipa1());
            csvWriter.append(",");
            csvWriter.append(this.getEchipa2());
            csvWriter.append(",");
            String s3 = String.valueOf(this.getDurata());
            csvWriter.append(s3);
            csvWriter.append(",");
            csvWriter.append(this.getNumeloc());
            csvWriter.append(",");
            csvWriter.append(this.getAdresa());
            csvWriter.append(",");
            String s4 = String.valueOf(this.getNrlocuri());
            csvWriter.append(s4);
            csvWriter.append(",");
            String s5 = String.valueOf(this.getZiua());
            csvWriter.append(s5);
            csvWriter.append(",");
            String s6 = String.valueOf(this.getLuna());
            csvWriter.append(s6);
            csvWriter.append(",");
            String s7 = String.valueOf(this.getAn());
            csvWriter.append(s7);
            csvWriter.append(",");
            String s8 = String.valueOf(this.getOra());
            csvWriter.append(s8);
            csvWriter.append(",");
            String s9 = String.valueOf(this.getMin());
            csvWriter.append(s9);
            csvWriter.append("\n");





            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void fileread (int nr)
    {
        CsvReadService ob=new CsvReadService();
        ArrayList<String> als =ob.readcsv("SportCSV.csv");
        String line ="";
        line= als.get(nr);
        String[] linie=line.split(",");
        this.setNume(linie[0]);
        this.setVarsta(Integer.parseInt(linie[1]));
        this.setNumesport(linie[2]);
        this.setEchipa1(linie[3]);
        this.setEchipa2(linie[4]);
        this.setDurata(Integer.parseInt(linie[5]));
        this.setNumeloc(linie[6]);
        this.setAdresa(linie[7]);
        this.setNrlocuri(Integer.parseInt(linie[8]));
        this.setZiua(Integer.parseInt(linie[9]));
        this.setLuna(Integer.parseInt(linie[10]));
        this.setAn(Integer.parseInt(linie[11]));
        this.setOra(Integer.parseInt(linie[12]));
        this.setMin(Integer.parseInt(linie[13]));



    }

}
