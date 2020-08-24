package client;
import datetimeplace.Place;
import service.AuditService;
import service.CsvReadService;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.io.File;

public class Client extends Place
{
    private String nume;
    private int varsta;
    private static int staticcod=0;
    private int cod;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public static int getStaticcod() {
        return staticcod;
    }

    public static void setStaticcod(int staticcod) {
        Client.staticcod = staticcod;
    }

    public Client()
    {
        staticcod++;
        this.setCod(staticcod);


    }

    public Client(String nume,int v )
    {
        this.nume = nume;
        this.varsta = v;
    }


    public String getNume()
    {
        return nume;
    }

    public void setNume(String n)
    {
        this.nume = n;
    }

    public int getVarsta()
    {
        return varsta;
    }

    public void setVarsta(int v)
    {
        this.varsta = v;
    }

    ////FUNCTII DE CREARE TABEL, INSERARE IN TABEL, UPDATE DATE DIN TABEL, STERGERE LINIE DIN TABEL
    public void create_db_table()
    {
        try {
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement create= connection.prepareStatement("CREATE TABLE IF NOT EXISTS tabelclient (id INT NOT NULL, Nume_client VARCHAR(255), Varsta_client INT NOT NULL)");
            create.executeUpdate();
            System.out.println("Table created");

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

            String sql="insert into tabelclient"+"(id,Nume_client,Varsta_client)"+"values("+this.getCod()+",'"+this.getNume()+"','"+this.getVarsta()+"')";   //valorile de adaugat in tabel
            myStmt.executeUpdate(sql);//update tabel
            System.out.println("Insert complete");//confirmare

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


            String sql="delete from tabelclient where id='"+this.getCod()+"'";//stergere linie din tabel
            myStmt.executeUpdate(sql);//update tabel
            //String sql3="commit";
            //myStmt.executeUpdate(sql3);
            String sql2="insert into tabelclient"+"(id,Nume_client,Varsta_client)"+"values("+this.getCod()+",'"+this.getNume()+"','"+this.getVarsta()+"')";
            myStmt.executeUpdate(sql2);//update tabel
            System.out.println("Update complete");//confirmare

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


            String sql="delete from tabelclient where id='"+this.getCod()+"'";//stergere linie din tabel
            myStmt.executeUpdate(sql);//update tabel

            System.out.println("Delete complete");//confirmare

        } catch (Exception e)   {
            e.printStackTrace();
        }

    }



    ///etapa 2
    public void addclientcsv() {

        File fisier = new File("C:/Users/Mircea/Desktop/FeMeI/AN2/sem2/Progr_av_ob/proiect/Proiect_vanzare_bilete_online/newClient.csv");

        if (fisier.length() == 0) {
            try  {


                FileWriter csvWriter = new FileWriter("newClient.csv");
                csvWriter.append("Nume client");
                csvWriter.append(",");
                csvWriter.append("Varsta client");



                csvWriter.append("\n");


                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        try(FileWriter csvWriter= new FileWriter("newClient.csv", true))
        {

            csvWriter.append(this.getNume());
            csvWriter.append(",");
            String s1 = String.valueOf(this.getVarsta());
            csvWriter.append(s1);

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
        ArrayList<String> als =ob.readcsv("ClientCSV.csv");
        String line ="";
        line= als.get(nr);
        String[] linie=line.split(",");
        this.setNume(linie[0]);
        this.setVarsta(Integer.parseInt(linie[1]));




    }

}