package icai.dtc.isw.client;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.lang.instrument.ClassDefinition;

import icai.dtc.isw.domain.Customer;

public class Ventana extends JFrame
{

    //Todas las variables


    JButton btnShowAll;

/*
    public static void main(String args[])
	{
		new Ventana();
	}
    */






    public Ventana(Client client)
    {
        super("Ventana");
        this.setLayout(new BorderLayout());

        btnShowAll = new JButton("Mostrar todos ");


        JPanel pnlNorte = new JPanel(new FlowLayout());

        pnlNorte.add(btnShowAll);



        btnShowAll.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new VentanaResultados(client);
            }
        });






        this.add(pnlNorte, BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
