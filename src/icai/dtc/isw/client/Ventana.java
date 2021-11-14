package icai.dtc.isw.client;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.instrument.ClassDefinition;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;

public class Ventana extends JFrame
{




    JButton btnShowAll;
    String nombreUsuario;











    public Ventana(Client cliente)
    {
        super("Ventana");
        this.setLayout(new BorderLayout());



        btnShowAll = new JButton("Buscar Moviles ");
        btnShowAll.setBackground(new Color(255, 170, 0));
        btnShowAll.setForeground(new Color(255,69,0));
        btnShowAll.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        JLabel lblTitulo = new JLabel("PhoneFitter");
        lblTitulo.setFont(new Font("URIAL FONT", Font.BOLD, 90));
        lblTitulo.setForeground(new Color(255,69,0));
        JLabel lblCuestion1 = new JLabel("Marca  ");
        lblCuestion1.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        lblCuestion1.setForeground(new Color(255,69,0));
        lblCuestion1.setOpaque(false);
        JLabel lblCuestion2 = new JLabel("Precio: ");
        lblCuestion2.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        lblCuestion2.setForeground(new Color(255,69,0));
        JLabel lblCuestion3 = new JLabel("Modelo: ");
        lblCuestion3.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        lblCuestion3.setForeground(new Color(255,69,0));
        JLabel lblCuestion4 = new JLabel("Almacenamiento: ");
        lblCuestion4.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        lblCuestion4.setForeground(new Color(255,69,0));
        JLabel lblCuestion5 = new JLabel("Memoria: ");
        lblCuestion5.setFont(new Font("URIAL FONT", Font.BOLD, 20));
        lblCuestion5.setForeground(new Color(255,69,0));



        JLabel nombreuser;

        if(cliente.getNombreUsuario()==null){
            nombreuser= new JLabel("Invitado");
            this.nombreUsuario = "Invitado";

        }
        else{
            nombreuser=new JLabel(cliente.getNombreUsuario());
            this.nombreUsuario = cliente.getNombreUsuario();
        }
        nombreuser.setFont(new Font("URIAL FONT", Font.BOLD, 15));
        nombreuser.setForeground(new Color(255,69,0));
        nombreuser.setBackground(new Color(255, 170, 0));


        JToggleButton obligatorio1 = new JToggleButton("Marcar Obligatorio");
        obligatorio1.setPreferredSize(new Dimension(20, 20));
        obligatorio1.setForeground(new Color(255,69,0));
        obligatorio1.setBackground(new Color(255, 170, 0));
        obligatorio1.setFont(new Font("URIAL FONT", Font.BOLD, 10));

        JButton btnMostrarUser = new JButton("Acceder al perfil ");
        btnMostrarUser.setBackground(new Color(255, 170, 0));
        btnMostrarUser.setForeground(new Color(255,69,0));
        btnMostrarUser.setFont(new Font("URIAL FONT", Font.BOLD, 10));

        JToggleButton obligatorio2 = new JToggleButton("Marcar Obligatorio");
        obligatorio2.setPreferredSize(new Dimension(20, 20));
        obligatorio2.setForeground(new Color(255,69,0));
        obligatorio2.setBackground(new Color(255, 170, 0));
        obligatorio2.setFont(new Font("URIAL FONT", Font.BOLD, 10));

        JToggleButton obligatorio3 = new JToggleButton("Marcar Obligatorio");
        obligatorio3.setPreferredSize(new Dimension(20, 20));
        obligatorio3.setForeground(new Color(255,69,0));
        obligatorio3.setBackground(new Color(255, 170, 0));
        obligatorio3.setFont(new Font("URIAL FONT", Font.BOLD, 10));

        JToggleButton obligatorio4 = new JToggleButton("Marcar Obligatorio");
        obligatorio4.setPreferredSize(new Dimension(20, 20));
        obligatorio4.setForeground(new Color(255,69,0));
        obligatorio4.setBackground(new Color(255, 170, 0));
        obligatorio4.setFont(new Font("URIAL FONT", Font.BOLD, 10));

        JToggleButton obligatorio5 = new JToggleButton("Marcar Obligatorio");
        obligatorio5.setPreferredSize(new Dimension(20, 20));
        obligatorio5.setForeground(new Color(255,69,0));
        obligatorio5.setBackground(new Color(255, 170, 0));
        obligatorio5.setFont(new Font("URIAL FONT", Font.BOLD, 10));




        JTextField txtSeleccion1 = new JTextField();
        JTextField txtSeleccion2 = new JTextField();
        JTextField txtSeleccion3 = new JTextField();
        JTextField txtSeleccion4 = new JTextField();
        JTextField txtSeleccion5 = new JTextField();

        JLabel background = new JLabel(new ImageIcon("Resources/fondo_phone.jpg"));
        JLabel fondologo = new JLabel(new ImageIcon("Resources/fondo_titulo.jpg"));
        //JLabel logo = new JLabel(new ImageIcon("\\home\\clux\\Desktop\\Fotos_IW\\Logo_ISW.JPG"));
        JLabel userfoto = new JLabel(new ImageIcon("Resources/avatar_usuario.jpg"));
        JLabel vacio = new JLabel();
        vacio.setBackground(new Color(255, 170, 0));
        JPanel usuario = new JPanel(new FlowLayout());
        JPanel pnlCuestionario = new JPanel(new GridLayout(1,3));
        JPanel pnlCuestiones = new JPanel(new GridLayout(5,1));
        JPanel pnlSeleciones = new JPanel(new GridLayout(5,1));
        JPanel pnlObligaciones = new JPanel(new GridLayout(5,1));
        JPanel pnlNorte = new JPanel(new FlowLayout());
        JPanel pnlSur= new JPanel(new FlowLayout());
        JPanel pnlCentro= new JPanel(new FlowLayout());
        JPanel pnlUser = new JPanel(new GridLayout(2,1));
        pnlUser.setBackground(new Color(255, 170, 0));
        background.setLayout(new FlowLayout());
        fondologo.setLayout(new FlowLayout());


        pnlNorte.setLayout(new FlowLayout());
        usuario.add(userfoto);
        pnlUser.add(nombreuser);
        pnlUser.add(btnMostrarUser);
        usuario.add(pnlUser);
        usuario.setBackground(new Color(255, 170, 0));
        fondologo.add(lblTitulo);
        fondologo.add(usuario);
        pnlNorte.add(fondologo);

        pnlNorte.setBackground(new Color(239, 127, 26));
        pnlSur.add(btnShowAll);
        pnlSur.setBackground(new Color(239, 127, 26));

        pnlCuestiones.add(lblCuestion1);
        pnlCuestiones.add(lblCuestion2);
        pnlCuestiones.add(lblCuestion3);
        pnlCuestiones.add(lblCuestion4);
        pnlCuestiones.add(lblCuestion5);
        pnlCuestiones.setBackground(new Color(255, 170, 0));



        pnlSeleciones.add(txtSeleccion1);
        pnlSeleciones.setBackground(new Color(255, 170, 0));
        pnlSeleciones.add(txtSeleccion2);
        pnlSeleciones.add(txtSeleccion3);
        pnlSeleciones.add(txtSeleccion4);
        pnlSeleciones.add(txtSeleccion5);

        pnlObligaciones.add(obligatorio1);
        pnlObligaciones.add(obligatorio2);
        pnlObligaciones.add(obligatorio3);
        pnlObligaciones.add(obligatorio4);
        pnlObligaciones.add(obligatorio5);
        pnlObligaciones.setBackground(new Color(255, 170, 0));







        pnlCuestionario.add(pnlCuestiones);
        pnlCuestionario.add(pnlSeleciones);
        pnlCuestionario.add(pnlObligaciones);
        //pnlCuestionario.setPreferredSize(new Dimension(100, 100));
        background.add(pnlCuestionario);
        pnlCentro.add(background);
        pnlCentro.setBackground(new Color(239, 127, 26));



        obligatorio1.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                int estado = itemEvent.getStateChange();
                if(estado == ItemEvent.SELECTED){
                    //label1.setText("Botón seleccionado");
                } else {
                    //label1.setText("Botón deseleccionado");
                }
            }
        });

        obligatorio2.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                int estado = itemEvent.getStateChange();
                if(estado == ItemEvent.SELECTED){
                    //label1.setText("Botón seleccionado");
                } else {
                    //label1.setText("Botón deseleccionado");
                }
            }
        });


        obligatorio3.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                int estado = itemEvent.getStateChange();
                if(estado == ItemEvent.SELECTED){
                    //label1.setText("Botón seleccionado");
                } else {
                    //label1.setText("Botón deseleccionado");
                }
            }
        });

        obligatorio4.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                int estado = itemEvent.getStateChange();
                if(estado == ItemEvent.SELECTED){
                    //label1.setText("Botón seleccionado");
                } else {
                    //label1.setText("Botón deseleccionado");
                }
            }
        });

        obligatorio5.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                int estado = itemEvent.getStateChange();
                if(estado == ItemEvent.SELECTED){
                    //label1.setText("Botón seleccionado");
                } else {
                    //label1.setText("Botón deseleccionado");
                }
            }
        });



        btnMostrarUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                if(Ventana.this.nombreUsuario.equals("Invitado")){
                    JOptionPane.showMessageDialog(Ventana.this, "Usuario no registrado/creado" );

                }
                else
                {
                    new VentanaUsuario(cliente);

                }
            }
        });










        btnShowAll.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                String marca = "marca";
                String precio = "10000";
                String modelo = "modelo";
                String almacenamiento = "1";
                String memoria = "1";

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
                cliente.setNombreUsuario(Ventana.this.nombreUsuario);

                session.put("Marca",marca);
                session.put("Precio", precio);
                session.put("Modelo", modelo);
                session.put("Almacenamiento",almacenamiento);
                session.put("Memoria", memoria);


                System.out.println("El precio seleccionado es: "+precio);
                System.out.println("El usuario en la Ventana es: "+cliente.getNombreUsuario());


                cliente.enviar(session,"/getMovil");



                new VentanaResultados(cliente);
            }
        });





        //this.setPreferredSize(new Dimension(800, 600));
        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlSur, BorderLayout.SOUTH);
        this.add(pnlCentro, BorderLayout.CENTER);
        //this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\Claudio Esteban\\1\\POO\\pf\\ui\\Phones.jpg")));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


}