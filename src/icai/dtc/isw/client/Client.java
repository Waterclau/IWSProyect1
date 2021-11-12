package icai.dtc.isw.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import icai.dtc.isw.configuration.PropertiesISW;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;
import icai.dtc.isw.controler.CustomerControler;


import icai.dtc.isw.message.Message;

public class Client {
    private String host;
    private int port;
    final static Logger logger = Logger.getLogger(Client.class);
    HashMap<String,String> customerMap;
    ArrayList<Customer> customerList;
    ArrayList<Movil> movilList;
    ArrayList<Movil> movilesUsuario;
    int exito;
    int exito2;
    String nombreUsuario;


    public void enviar(HashMap<String, Object> session, String context) {
        //Configure connections
        String host = PropertiesISW.getInstance().getProperty("host");
        int port = Integer.parseInt(PropertiesISW.getInstance().getProperty("port"));
        Logger.getRootLogger().info("Host: "+host+" port"+port);
        //Create a cliente class
        Client cliente=new Client(host, port);

        //HashMap<String,Object> session=new HashMap<String, Object>();
        //session.put("/getCustomer","");

        //cliente.createVentana();

        Message mensajeEnvio=new Message();
        Message mensajeVuelta=new Message();
        //mensajeEnvio.setContext("/getCustomer");
        mensajeEnvio.setContext(context);
        mensajeEnvio.setSession(session);
        cliente.sent(mensajeEnvio,mensajeVuelta);

        System.out.println("El mensaje es: "+ mensajeVuelta.getContext());

        switch (mensajeVuelta.getContext()) {
            case "/getCustomerResponse":
                ArrayList<Customer> customerList=(ArrayList<Customer>)(mensajeVuelta.getSession().get("Customer"));

                /*for (Customer customer : customerList) {
                    System.out.println("He leído el id: "+customer.getId()+" con nombre: "+customer.getName() + " movil comprado: "+customer.getMovil());
                }
                break;
                */

                cliente.setCustomers(customerList);
                break;

            case "/getMovilResponse":
                System.out.println(mensajeVuelta.getSession());
                ArrayList<Movil> movilList = (ArrayList<Movil>)(mensajeVuelta.getSession().get("Movil"));
                this.movilList = movilList;
                System.out.println(movilList);
                break;

            case "/setCustomerResponse":
                System.out.println(mensajeVuelta.getSession());
                System.out.println("Usuario creado");

                this.exito2=(Integer)(mensajeVuelta.getSession().get("Exito2"));
                break;


            case "/loginResponse":
                System.out.println(mensajeVuelta.getSession());
                System.out.println("Login exitoso");


                ArrayList<Movil> movilesUsuario = (ArrayList<Movil>)(mensajeVuelta.getSession().get("Moviles"));

                this.exito=(Integer)(mensajeVuelta.getSession().get("Exito"));
                this.movilesUsuario = movilesUsuario;
                this.nombreUsuario=(String)(mensajeVuelta.getSession().get("Usuario"));

                break;


            default:
                Logger.getRootLogger().info("Option not found");
                System.out.println("\nError a la vuelta");
                break;

        }
        //System.out.println("3.- En Main.- El valor devuelto es: "+((String)mensajeVuelta.getSession().get("Nombre")));
    }

    public Client(String host, int port) {
        this.host=host;
        this.port=port;

    }

    public Client()
    {

    }



    public void setCustomers(ArrayList<Customer> customerList)
    {
        this.customerList = customerList;
        this.customerMap = new HashMap<String,String>();
        for (Customer customer : customerList) {
            System.out.println("He leído el id: "+customer.getId()+" con nombre: "+customer.getName());
            customerMap.put(customer.getId(),customer.getName());
        }

    }

    public HashMap<String, String> getCustomers()
    {

        return customerMap;
    }

    public ArrayList<Customer> getCustomerList()
    {
        return this.customerList;
    }

    public ArrayList<Movil> getMovilList()
    {
        return this.movilList;
    }

    public int getExito()
    {
        return exito;
    }

    public int getExito2(){
        return exito2;
    }

    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public void sent(Message messageOut, Message messageIn) {
        try {

            System.out.println("Connecting to host " + host + " on port " + port + ".");



            Socket echoSocket = null;
            OutputStream out = null;
            InputStream in = null;

            try {
                echoSocket = new Socket(host, port);
                in = echoSocket.getInputStream();
                out = echoSocket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

                //Create the objetct to send
                objectOutputStream.writeObject(messageOut);

                // create a DataInputStream so we can read data from it.
                ObjectInputStream objectInputStream = new ObjectInputStream(in);
                Message msg=(Message)objectInputStream.readObject();
                messageIn.setContext(msg.getContext());
                messageIn.setSession(msg.getSession());
		        /*System.out.println("\n1.- El valor devuelto es: "+messageIn.getContext());
		        String cadena=(String) messageIn.getSession().get("Nombre");
		        System.out.println("\n2.- La cadena devuelta es: "+cadena);*/

            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + host);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Unable to get streams from server");
                System.exit(1);
            }

            /** Closing all the resources */
            out.close();
            in.close();
            echoSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}