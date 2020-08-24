package ticketinterface;

import service.Serviceconcert;
import service.Servicesport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form3 {

    private JPanel panel3;
    private JPanel panel1;
    private JTextField nume;
    private JTextField varsta;
    private JTextField numesport;
    private JTextField durata;
    private JTextField numeloc;
    private JTextField adresa;
    private JTextField nrlocuri;
    private JTextField ziua;
    private JTextField luna;
    private JTextField an;
    private JTextField ora;
    private JTextField min;
    private JButton creeazaBiletButton;
    private JTextField echipa1;
    private JTextField echipa2;

    public form3() {
        creeazaBiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //prompt pe ecran
                JOptionPane.showMessageDialog(null,"Biletul dvs ("+nume.getText()+") la meciul de "+numesport.getText()+" dintre "+echipa1.getText()+" si " +echipa2.getText() + "(care dureaza " + durata.getText() + " min) care are loc pe " + adresa.getText() + " la " + numeloc.getText() + " la data de " + ziua.getText() + "." + luna.getText() + "." +an.getText()+ ", ora " + ora.getText() + ":" + min.getText() + ", a fost inregistrat!");
                //adaug datele adaugate la database
                Servicesport ev2;
                ev2=new Servicesport();
                ev2.setAdresa(adresa.getText());
                ev2.setNrlocuri(Integer.parseInt(nrlocuri.getText()));
                ev2.setNumeloc(numeloc.getText());
                ev2.setNume(nume.getText());
                ev2.setAn(Integer.parseInt(an.getText()));
                ev2.setDurata(Integer.parseInt(durata.getText()));
                ev2.setLuna(Integer.parseInt(luna.getText()));
                ev2.setZiua(Integer.parseInt(ziua.getText()));
                ev2.setOra(Integer.parseInt(ora.getText()));
                ev2.setMin(Integer.parseInt(min.getText()));
                ev2.setNumesport(numesport.getText());
                ev2.setVarsta(Integer.parseInt(varsta.getText()));
                ev2.setEchipa1(echipa1.getText());
                ev2.setEchipa2(echipa2.getText());
                ev2.CalculatePrice();
                ev2.TicketInformation();
                ev2.create_db_table();
                ev2.add_ticket_to_db_table();
            }
        });
    }

    public JPanel getPanel3() {
        return panel3;
    }
}