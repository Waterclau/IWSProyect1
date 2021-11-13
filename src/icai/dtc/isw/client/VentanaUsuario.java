package icai.dtc.isw.client;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import icai.dtc.isw.domain.Movil;


public class VentanaUsuario extends JFrame

{
    ArrayList<Movil> movilesUsuario;
    String nombreUsuario;

    public VentanaUsuario(Client cliente)
    {



        super("VentanaUsuario");
        this.setLayout(new BorderLayout());

        movilesUsuario=cliente.getMovilesUsuario();
        nombreUsuario = cliente.getNombreUsuario();
        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.Y_AXIS));


        JLabel lblUsuario = new JLabel("Usuario: "+nombreUsuario);
        lblUsuario.setFont(new Font("URIAL FONT", Font.BOLD, 40));
        lblUsuario.setForeground(new Color(255,69,0));
        pnlCentro.add(lblUsuario);


        if(!(movilesUsuario.isEmpty()))
        {
            for(Movil m: movilesUsuario) {
                JPanel pnlMovil = new JPanel(new FlowLayout());
                JButton btnEliminar = new JButton("Eliminar");
                JTextField txt = new JTextField();
                pnlMovil.add(txt);
                pnlMovil.add(btnEliminar);
                pnlMovil.setBackground(new Color(255, 170, 0));


                txt.setText("Marca: " + m.getMarca() + " | Precio: " + m.getPrecio() + " | Modelo: " + m.getModelo() + " | Almacenamiento: " + m.getAlmacenamiento() + " | Memoria: " + m.getMemoria());
                txt.setPreferredSize(new Dimension(800, 50));
                txt.setForeground(new Color(255, 69, 0));
                txt.setBackground(new Color(255, 170, 0));
                txt.setFont(new Font("URIAL FONT", Font.BOLD, 15));

                btnEliminar.setForeground(new Color(255, 69, 0));
                btnEliminar.setBackground(new Color(194, 197, 204));
                btnEliminar.setFont(new Font("URIAL FONT", Font.BOLD, 15));

                pnlCentro.add(pnlMovil);

            }
        }

        else
        {
            JLabel lblNoMoviles = new JLabel("No hay moviles guardados");
            lblNoMoviles.setFont(new Font("URIAL FONT", Font.BOLD, 20));
            lblNoMoviles.setForeground(new Color(255,69,0));
            pnlCentro.add(lblNoMoviles);
        }




        this.add(pnlCentro, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


}
