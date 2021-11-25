package icai.dtc.isw.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import icai.dtc.isw.domain.Movil;
import icai.dtc.isw.domain.Review;


public class VentanaReviews extends JFrame

{


    public VentanaReviews(Client cliente)
    {



        super("VentanaReviews");
        this.setLayout(new BorderLayout());

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new BoxLayout(pnlCentro, BoxLayout.Y_AXIS));

        JPanel pnlPuntuacion = new JPanel(new FlowLayout());

        JTextArea txtPublicarReview = new JTextArea(40,40);
        txtPublicarReview.setForeground(new Color(255,69,0));
        txtPublicarReview.setBackground(new Color(255, 170, 0));
        txtPublicarReview.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        txtPublicarReview.setPreferredSize(new Dimension(800,400));

        JLabel lblPuntuacion = new JLabel("Puntuacion sobre 10: ");
        lblPuntuacion.setFont(new Font("URIAL FONT", Font.BOLD, 13));

        JTextField txtPuntuacion = new JTextField(5);
        txtPuntuacion.setForeground(new Color(255,69,0));
        txtPuntuacion.setBackground(new Color(255, 170, 0));
        txtPuntuacion.setFont(new Font("URIAL FONT", Font.BOLD, 20));


        JButton btnPublicarReview = new JButton(" Publicar Review");
        btnPublicarReview.setForeground(new Color(255,69,0));
        btnPublicarReview.setBackground(new Color(194, 197, 204));
        btnPublicarReview.setFont(new Font("URIAL FONT", Font.BOLD, 15));

        pnlPuntuacion.add(lblPuntuacion);
        pnlPuntuacion.add(txtPuntuacion);

        pnlCentro.add(txtPublicarReview);
        pnlCentro.add(pnlPuntuacion);
        pnlCentro.add(btnPublicarReview);

        for(Review r: cliente.reviews)
        {
            JPanel pnlReview = new JPanel(new FlowLayout());
            pnlReview.setBackground(new Color(255, 170, 0));



            JTextField txtReview = new JTextField();
            txtReview.setText(r.getUsuario()+"  |  "+r.getComentario()+"  |  "+r.getPuntuacion()+" / 10");
            txtReview.setPreferredSize( new Dimension( 800, 50 ) );
            txtReview.setForeground(new Color(255,69,0));
            txtReview.setBackground(new Color(255, 170, 0));
            txtReview.setFont(new Font("URIAL FONT", Font.BOLD, 20));

            pnlReview.add(txtReview);
            pnlCentro.add(pnlReview);

        }



        btnPublicarReview.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e) {
                System.out.println("El usuario en la ventana reviews es: "+cliente.nombreUsuario);

                if (cliente.nombreUsuario.equals("Invitado")) {
                    JOptionPane.showMessageDialog(VentanaReviews.this, "No se pueden publicar reviews porque se ha accedido como invitado");

                } else {
                    //Se le pasa la id del movil y el usuario


                    Client cliente2 = new Client();
                    cliente2.setId_movil(cliente.id_movil);
                    HashMap<String, Object> session = new HashMap<String, Object>();

                    session.put("Usuario", cliente.nombreUsuario);
                    session.put("Comentario", txtPublicarReview.getText());
                    session.put("Puntuacion", txtPuntuacion.getText());
                    session.put("Id_movil", cliente.id_movil);

                    cliente.enviar(session, "/publicarReview");
                    if((cliente.exito7==0))
                    {
                        JOptionPane.showMessageDialog(VentanaReviews.this, "Error al publicar la review");

                    }
                    else{
                        JOptionPane.showMessageDialog(VentanaReviews.this, "Review publicada correctamente");

                    }
                }

            }

        });



        this.add(pnlCentro, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


}

