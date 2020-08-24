package service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReadService {

    public static ArrayList<String> readcsv(String numefisier) {
        String line = "";
        String splitBy = ",";
        ArrayList<String> matriceinfo=new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader(numefisier));
            while ((line = br.readLine()) != null)
            {
                String[] informatii = line.split(splitBy);
                int lungime=informatii.length;
                String stringinfo="";
                int i;
                for (i = 0; i < lungime; i++) {

                    stringinfo = stringinfo + informatii[i]+",";
                }

                matriceinfo.add(stringinfo);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return matriceinfo;
    }
}