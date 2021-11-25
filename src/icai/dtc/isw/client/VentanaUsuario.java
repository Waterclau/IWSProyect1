package icai.dtc.isw.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                JButton btnVerReviews = new JButton("Ver reviews");
                JTextField txt = new JTextField();
                pnlMovil.add(txt);
                pnlMovil.add(btnEliminar);
                pnlMovil.add(btnVerReviews);
                pnlMovil.setBackground(new Color(255, 170, 0));


                txt.setText("Marca: " + m.getMarca() + " | Precio: " + m.getPrecio() + " | Modelo: " + m.getModelo() + " | Almacenamiento: " + m.getAlmacenamiento() + " | Memoria: " + m.getMemoria());
                txt.setPreferredSize(new Dimension(800, 50));
                txt.setForeground(new Color(255, 69, 0));
                txt.setBackground(new Color(255, 170, 0));
                txt.setFont(new Font("URIAL FONT", Font.BOLD, 15));

                btnEliminar.setForeground(new Color(255, 69, 0));
                btnEliminar.setBackground(new Color(194, 197, 204));
                btnEliminar.setFont(new Font("URIAL FONT", Font.BOLD, 15));

                btnVerReviews.setForeground(new Color(255, 69, 0));
                btnVerReviews.setBackground(new Color(194, 197, 204));
                btnVerReviews.setFont(new Font("URIAL FONT", Font.BOLD, 15));

                pnlCentro.add(pnlMovil);

                btnEliminar.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {

                        //Se le pasa la id del movil y el usuario que quiere guardarlo al customer controler


                        //Si se ha accedido como usuario, se pasa el nombre de usuario

                            Client cliente = new Client();
                            HashMap<String,Object> session = new HashMap<String,Object>();

                            session.put("id_modelo",m.getId_modelo());

                            System.out.println("La id del modelo a eliminar es:  "+m.getId_modelo());
                            session.put("Usuario",VentanaUsuario.this.nombreUsuario);

                            cliente.enviar(session, "/eliminarMovil");

                            int exito=cliente.getExito5();

                            if(!(exito==1)){
                                JOptionPane.showMessageDialog(VentanaUsuario.this, "Error al eliminar el movil");

                            }
                            else{
                                JOptionPane.showMessageDialog(VentanaUsuario.this, "Movil eliminado correctamente");

                            }






                    }
                });



                btnVerReviews.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {

                        //Se le pasa la id del movil


                        Client cliente2 = new Client();
                        HashMap<String,Object> session2 = new HashMap<String,Object>();

                        session2.put("id_modelo",m.getId_modelo());

                        System.out.println("La id del modelo es:  "+m.getId_modelo());

                        cliente2.setNombreUsuario(VentanaUsuario.this.nombreUsuario);
                        cliente2.enviar(session2, "/verReviews");

                        if(cliente2.reviews.isEmpty())
                        {
                            JOptionPane.showMessageDialog(VentanaUsuario.this, "El movil no tiene reviews");
                        }
                        else{
                            new VentanaReviews(cliente2);
                        }

                    }

                });

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
