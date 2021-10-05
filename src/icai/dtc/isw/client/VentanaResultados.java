package icai.dtc.isw.client;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import icai.dtc.isw.domain.Customer;

public class VentanaResultados extends JFrame
{
    //Todas las variables

    JTextField txt;
    Client client;


    public VentanaResultados(Client client)
    {
        super("VentanaResultados");
        this.setLayout(new BorderLayout());

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.Y_AXIS));
        HashMap<String, String> customers = new HashMap<String, String>();
        ArrayList<Customer> customerList = client.getCustomerList();


        customers = client.getCustomers();

        for(Customer c: customerList)
        {
            txt = new JTextField();
            pnlNorte.add(txt);
            txt.setText("ID: "+c.getId() +" | Nombre: "+ c.getName() + " | Movil: "+ c.getMovil());
            txt.setPreferredSize( new Dimension( 400, 50 ) );
            txt.setForeground(Color.BLUE);
            txt.setBackground(Color.LIGHT_GRAY);
            txt.setFont(new Font("Serif", Font.BOLD, 13));



        }







        this.add(pnlNorte, BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
