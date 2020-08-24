package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {

    public void addauditcsv(String actiune,String threadname) {

        File fisier = new File("C:/Users/Mircea/Desktop/FeMeI/AN2/sem2/Progr_av_ob/proiect/Proiect_vanzare_bilete_online_etapa3/AuditCSV.csv");

        if (fisier.length() == 0) {
            try  {


                FileWriter csvWriter = new FileWriter("AuditCSV.csv");
                csvWriter.append("Action");
                csvWriter.append(",");
                csvWriter.append("Date and time");
                csvWriter.append(",");
                csvWriter.append("thread_name");

                csvWriter.append("\n");


                csvWriter.flush();
                csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        try(FileWriter csvWriter= new FileWriter("AuditCSV.csv", true))
        {

            csvWriter.append(actiune);
            csvWriter.append(",");
            String datetime = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss").format(new Date());
            csvWriter.append(datetime);
            csvWriter.append(",");
            csvWriter.append(threadname);
            csvWriter.append("\n");



            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
