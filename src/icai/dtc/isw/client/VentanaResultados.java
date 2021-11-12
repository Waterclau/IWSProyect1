package icai.dtc.isw.client;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;

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


        /*customers = client.getCustomers();

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

         */

        ArrayList<Movil> movilList = client.getMovilList();


        for(Movil m: movilList)
        {
            JPanel pnlMovil = new JPanel(new FlowLayout());
            JButton btnGuardar = new JButton("Guardar");
            txt = new JTextField();
            pnlMovil.add(txt);
            pnlMovil.add(btnGuardar);
            pnlMovil.setBackground(new Color(255, 170, 0));


            txt.setText("Marca: "+m.getMarca() +" | Precio: "+ m.getPrecio() + " | Modelo: "+ m.getModelo()+ " | Almacenamiento: "+m.getAlmacenamiento()+ " | Memoria: "+ m.getMemoria());
            txt.setPreferredSize( new Dimension( 800, 50 ) );
            txt.setForeground(new Color(255,69,0));
            txt.setBackground(new Color(255, 170, 0));
            txt.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            btnGuardar.setForeground(new Color(255,69,0));
            btnGuardar.setBackground(new Color(194, 197, 204));
            btnGuardar.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            pnlNorte.add(pnlMovil);


        }





        this.add(pnlNorte, BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}