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
        lblUsuario.setFont(new Font("URIAL FONT", Font.BOLD, 13));
        //lblUsuario.setForeground(new Color(255, 170, 0));
        JLabel lblContrasenya = new JLabel("Contraseña: ");
        lblContrasenya.setFont(new Font("URIAL FONT", Font.BOLD, 13));
        //lblContrasenya.setForeground(new Color(255, 170, 0));



        JButton btnInvitado = new JButton("Entrar como invitado");
        btnInvitado.setFont(new Font("URIAL FONT", Font.BOLD, 13));
        btnInvitado.setForeground(new Color(255,69,0));
        btnInvitado.setBackground(new Color(255, 170, 0));
        JButton btnCrearUsuario = new JButton(" Crear nuevo usuario");
        btnCrearUsuario.setFont(new Font("URIAL FONT", Font.BOLD, 13));
        btnCrearUsuario.setForeground(new Color(255,69,0));
        btnCrearUsuario.setBackground(new Color(255, 170, 0));
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("URIAL FONT", Font.BOLD, 13));
        btnLogin.setForeground(new Color(255,69,0));
        btnLogin.setBackground(new Color(255, 170, 0));
        btnLogin.setBackground(new Color(255, 170, 0));


        JTextField txtUsuario = new JTextField(15);
        JTextField txtContrasenya = new JTextField(15);

        JPanel pnlNorte = new JPanel(new FlowLayout());
        pnlNorte.setBackground(new Color(239, 127, 26));
        JPanel pnlCentro = new JPanel(new FlowLayout());
        pnlCentro.setBackground(new Color(239, 127, 26));


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

                int exito2=cliente.getExito2();

                if(exito2==1)
                {
                    JOptionPane.showMessageDialog(VentanaMenu.this, "Usuario creado correctamente");

                }

                else{
                    JOptionPane.showMessageDialog(VentanaMenu.this, "El nombre de usuario ya está cogido");

                }


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

                cliente.enviar(session,"/login");


                int exito=cliente.getExito();
                if(exito==1){
                    new Ventana(cliente);
                }

                else if(exito==0)
                {
                    JOptionPane.showMessageDialog(VentanaMenu.this, "El usuario no existe o los datos son incorrectos");
                }

                else if(exito==2)
                {
                    //JOptionPane.showMessageDialog(VentanaMenu.this, "El usuario no tiene móviles guardados");
                    new Ventana(cliente);

                }

            }
        });



        btnInvitado.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                Client cliente = new Client();
                new Ventana(cliente);


            }
        });
    }
}
