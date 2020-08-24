package ticketinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfaceticket {
    private JRadioButton concertRadioButton;
    private JRadioButton teatruRadioButton;
    private JRadioButton sportRadioButton;
    private JButton OKButton;
    private JPanel mainPanel;




    public interfaceticket() {
        ButtonGroup group=new ButtonGroup();
        group.add(concertRadioButton);
        group.add(teatruRadioButton);
        group.add(sportRadioButton);




        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(concertRadioButton.isSelected())
                {
                    JFrame frame1=new JFrame();
                    frame1.setContentPane(new form1().getPanel1());
                    frame1.setSize(800,500);
                    frame1.setVisible(true);

                }

                if(teatruRadioButton.isSelected())
                {
                    JFrame frame2=new JFrame();
                    frame2.setContentPane(new form2().getPanel2());
                    frame2.setSize(800,500);
                    frame2.setVisible(true);
                }

                if(sportRadioButton.isSelected())
                {
                    JFrame frame3=new JFrame();
                    frame3.setContentPane(new form3().getPanel3());
                    frame3.setSize(800,500);
                    frame3.setVisible(true);
                }


            }
        });
    }

    public static void main(String[] args){
        JFrame frame= new JFrame("interfaceticket");
        frame.setContentPane(new interfaceticket().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
