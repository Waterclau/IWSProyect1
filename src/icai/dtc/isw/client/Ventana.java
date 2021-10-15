package icai.dtc.isw.client;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.instrument.ClassDefinition;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;

public class Ventana extends JFrame
{

    //Todas las variables


    JButton btnShowAll;


    public static void main(String args[])
    {
        new Ventana();
    }









    public Ventana()
    {
        super("Ventana");
        this.setLayout(new BorderLayout());




        btnShowAll = new JButton("Mostrar todos ");
        JLabel lblTitulo = new JLabel("PhoneFitter");
        lblTitulo.setFont(new Font("URIAL FONT", Font.BOLD, 90));
        JLabel lblCuestion1 = new JLabel("Marca  ");
        lblCuestion1.setFont(new Font("URIAL FONT", Font.BOLD, 30));
        JLabel lblCuestion2 = new JLabel("Precio: ");
        lblCuestion2.setFont(new Font("URIAL FONT", Font.BOLD, 30));
        JLabel lblCuestion3 = new JLabel("Modelo: ");
        lblCuestion3.setFont(new Font("URIAL FONT", Font.BOLD, 30));
        JLabel lblCuestion4 = new JLabel("Almacenamiento: ");
        lblCuestion4.setFont(new Font("URIAL FONT", Font.BOLD, 30));
        JLabel lblCuestion5 = new JLabel("Memoria: ");
        lblCuestion5.setFont(new Font("URIAL FONT", Font.BOLD, 30));


        JTextField txtSeleccion1 = new JTextField();
        JTextField txtSeleccion2 = new JTextField();
        JTextField txtSeleccion3 = new JTextField();
        JTextField txtSeleccion4 = new JTextField();
        JTextField txtSeleccion5 = new JTextField();



        JPanel pnlCuestionario = new JPanel(new GridLayout(1,2));
        JPanel pnlCuestiones = new JPanel(new GridLayout(5,1));
        JPanel pnlSeleciones = new JPanel(new GridLayout(5,1));
        JPanel pnlNorte = new JPanel(new FlowLayout());
        JPanel pnlSur= new JPanel(new FlowLayout());
        //JLabel lblFondo = new JLabel(new ImageIcon("C:\\Users\\Claudio Esteban\\1\\POO\\pf\\ui\\Phones1.jpg"));


        pnlNorte.add(lblTitulo);
        pnlNorte.setBackground(new Color(173,216,230));
        /*btnShowAll.setOpaque(false);
        btnShowAll.setContentAreaFilled(false);
        btnShowAll.setBorderPainted(false);*/
        pnlSur.add(btnShowAll);
        pnlSur.setBackground(new Color(173,216,230));

        pnlCuestiones.add(lblCuestion1);
        pnlCuestiones.add(lblCuestion2);
        pnlCuestiones.add(lblCuestion3);
        pnlCuestiones.add(lblCuestion4);
        pnlCuestiones.add(lblCuestion5);
        pnlCuestiones.setBackground(new Color(173,216,230));


        pnlSeleciones.add(txtSeleccion1);
        pnlSeleciones.add(txtSeleccion2);
        pnlSeleciones.add(txtSeleccion3);
        pnlSeleciones.add(txtSeleccion4);
        pnlSeleciones.add(txtSeleccion5);




        pnlCuestionario.add(pnlCuestiones);
        pnlCuestionario.add(pnlSeleciones);









        btnShowAll.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                String marca = "marca";
                String precio = "10000";
                String modelo = "modelo";
                String almacenamiento = "10000";
                String memoria = "10000";

                if(!txtSeleccion1.getText().equals(""))
                {
                    marca = txtSeleccion1.getText();
                }

                if(!txtSeleccion2.getText().equals(""))
                {
                    precio = txtSeleccion2.getText();
                }

                if(!txtSeleccion3.getText().equals(""))
                {
                    modelo = txtSeleccion3.getText();
                }

                if(!txtSeleccion4.getText().equals(""))
                {
                    almacenamiento = txtSeleccion4.getText();
                }

                if(!txtSeleccion5.getText().equals(""))
                {
                    memoria = txtSeleccion5.getText();
                }



                Client cliente = new Client();
                HashMap<String,Object> session = new HashMap<String,Object>();

                session.put("Marca",marca);
                session.put("Precio", precio);
                session.put("Modelo", modelo);
                session.put("Almacenamiento",almacenamiento);
                session.put("Memoria", memoria);



                cliente.enviar(session,"/getMovil");

                new VentanaResultados(cliente);
            }
        });





        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);
        this.add(pnlCuestionario, BorderLayout.CENTER);
        //this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Claudio Esteban\\1\\POO\\pf\\ui\\Phones.jpg")));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
