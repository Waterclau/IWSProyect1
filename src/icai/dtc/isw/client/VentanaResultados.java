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
    String nombreUsuario;


    public VentanaResultados(Client client)
    {
        super("VentanaResultados");
        this.setLayout(new BorderLayout());

        JPanel pnlNorte = new JPanel();
        pnlNorte.setLayout(new BoxLayout(pnlNorte, BoxLayout.Y_AXIS));
        HashMap<String, String> customers = new HashMap<String, String>();
        ArrayList<Customer> customerList = client.getCustomerList();



        //La ventanaResultados debe saber el usuario que ha accedido, o si se ha accedido como invitado

        if(client.getNombreUsuario()==null)
        {
            this.nombreUsuario="Invitado";
        }
        else{
            nombreUsuario=client.getNombreUsuario();

        }

        System.out.println("El usuario en la ventanaResultados es: "+this.nombreUsuario);




        ArrayList<Movil> movilList = client.getMovilList();


        for(Movil m: movilList)
        {
            JPanel pnlMovil = new JPanel(new FlowLayout());
            JButton btnGuardar = new JButton("Guardar");
            JButton btnPublicarReview = new JButton("Publicar review");
            JButton btnVerReviews = new JButton("Ver reviews");
            txt = new JTextField();
            pnlMovil.add(txt);
            pnlMovil.add(btnGuardar);
            pnlMovil.add(btnPublicarReview);
            pnlMovil.add(btnVerReviews);
            pnlMovil.setBackground(new Color(255, 170, 0));


            txt.setText("Marca: "+m.getMarca() +" | Precio: "+ m.getPrecio() + " | Modelo: "+ m.getModelo()+ " | Almacenamiento: "+m.getAlmacenamiento()+ " | Memoria: "+ m.getMemoria());
            txt.setPreferredSize( new Dimension( 800, 50 ) );
            txt.setForeground(new Color(255,69,0));
            txt.setBackground(new Color(255, 170, 0));
            txt.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            btnGuardar.setForeground(new Color(255,69,0));
            btnGuardar.setBackground(new Color(194, 197, 204));
            btnGuardar.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            btnPublicarReview.setForeground(new Color(255,69,0));
            btnPublicarReview.setBackground(new Color(194, 197, 204));
            btnPublicarReview.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            btnVerReviews.setForeground(new Color(255,69,0));
            btnVerReviews.setBackground(new Color(194, 197, 204));
            btnVerReviews.setFont(new Font("URIAL FONT", Font.BOLD, 15));

            pnlNorte.add(pnlMovil);

            btnGuardar.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e)
                {

                    //Se le pasa la id del movil y el usuario que quiere guardarlo al customer controler


                    //Si se ha accedido como usuario, se pasa el nombre de usuario
                    if(!VentanaResultados.this.nombreUsuario.equals("Invitado"))
                    {
                        Client cliente = new Client();
                        HashMap<String,Object> session = new HashMap<String,Object>();

                        session.put("id_modelo",m.getId_modelo());

                        System.out.println("La id del modelo a guardar es:  "+m.getId_modelo());
                        session.put("Usuario",VentanaResultados.this.nombreUsuario);

                        cliente.enviar(session, "/guardarMovil");

                        int exito=cliente.getExito4();
                        if(!(exito==1))
                        {
                            JOptionPane.showMessageDialog(VentanaResultados.this, "Error al guardar el movil");

                        }
                        else{
                            JOptionPane.showMessageDialog(VentanaResultados.this, "Movil guardado correctamente");

                        }

                    }

                    //Si se ha accedido como invitado, se alerta de que no se pueden guardar moviles
                    else{
                        JOptionPane.showMessageDialog(VentanaResultados.this, "No puede guardar moviles porque ha accedido como invitado");

                    }




                }
            });


        }





        this.add(pnlNorte, BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}