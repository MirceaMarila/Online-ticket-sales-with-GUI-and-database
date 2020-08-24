package ticketinterface;
import service.Serviceconcert;
import service.Servicetheatre;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form2 {
    private JPanel panel2;
    private JPanel panel1;
    private JTextField nume;
    private JTextField varsta;
    private JTextField numetrupa;
    private JTextField varstamin;
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


    public form2() {
        creeazaBiletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Biletul dvs ("+nume.getText()+") la piesa de teatru a trupei " + numetrupa.getText() + "(care dureaza " + durata.getText() + " min) care are loc pe " + adresa.getText() + " la " + numeloc.getText() + " la data de " + ziua.getText() + "." + luna.getText() + "." +an.getText()+ ", ora " + ora.getText() + ":" + min.getText() + ", a fost inregistrat!");
                Servicetheatre ev2;
                ev2=new Servicetheatre();
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
                ev2.setNumetrupa(numetrupa.getText());
                ev2.setVarsta(Integer.parseInt(varsta.getText()));
                ev2.setVarstaminima(Integer.parseInt(varstamin.getText()));
                ev2.AgeVerification();
                ev2.CalculatePrice();
                ev2.TicketInformation();
                ev2.create_db_table();
                ev2.add_ticket_to_db_table();
            }
        });
    }

    public JPanel getPanel2() {
        return panel2;
    }
}