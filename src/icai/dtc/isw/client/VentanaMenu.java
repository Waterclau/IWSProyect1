package icai.dtc.isw.client;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class VentanaMenu extends JFrame
{
    public static void main(String args[])
    {
        new VentanaMenu();
    }


    public VentanaMenu()

    {
        super("VentanaMenu");
        this.setLayout(new BorderLayout());

        JLabel lblUsuario = new JLabel("Usuario: ");
        JLabel lblContrasenya = new JLabel("Contraseña: ");

        JButton btnInvitado = new JButton("Entrar como invitado");
        JButton btnCrearUsuario = new JButton(" Crear nuevo usuario");
        JButton btnLogin = new JButton("Login");

        JTextField txtUsuario = new JTextField(15);
        JTextField txtContrasenya = new JTextField(15);

        JPanel pnlNorte = new JPanel(new FlowLayout());
        JPanel pnlCentro = new JPanel(new FlowLayout());

        pnlNorte.add(lblUsuario);
        pnlNorte.add(txtUsuario);
        pnlNorte.add(lblContrasenya);
        pnlNorte.add(txtContrasenya);
        pnlCentro.add(btnLogin);
        pnlCentro.add(btnInvitado);
        pnlCentro.add(btnCrearUsuario);


        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        btnCrearUsuario.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                Client cliente = new Client();
                HashMap<String,Object> session = new HashMap<String,Object>();

                session.put("Usuario",txtUsuario.getText());
                session.put("Password",txtContrasenya.getText());

                cliente.enviar(session,"/setCustomer");
            }
        });


        btnLogin.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                Client cliente = new Client();
                HashMap<String,Object> session = new HashMap<String,Object>();

                session.put("Usuario",txtUsuario.getText());
                session.put("Password",txtContrasenya.getText());

                cliente.enviar(session,"/getCustomer");
            }
        });
    }
}
