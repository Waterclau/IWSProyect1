package icai.dtc.isw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.controler.CustomerControler;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.message.Message;
import icai.dtc.isw.domain.Movil;
import icai.dtc.isw.client.*;

public class SocketServer extends Thread {
	public static final int PORT_NUMBER = 8081;

	//public Client cliente;

	protected Socket socket;

	private SocketServer(Socket socket) {
		this.socket = socket;
		System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
		start();
	}

	public void run() {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			//first read the object that has been sent
			ObjectInputStream objectInputStream = new ObjectInputStream(in);
		    Message mensajeIn= (Message)objectInputStream.readObject();
		    //Object to return informations 
		    ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
		    Message mensajeOut=new Message();
		    switch (mensajeIn.getContext()) {

		    	case "/getCustomers":
		    		CustomerControler customerControler=new CustomerControler();
		    		ArrayList<Customer> lista=new ArrayList<Customer>();
		    		customerControler.getCustomer(lista);
		    		mensajeOut.setContext("/getCustomerResponse");
		    		HashMap<String,Object> session=new HashMap<String, Object>();
		    		session.put("Customer",lista);
		    		mensajeOut.setSession(session);
		    		objectOutputStream.writeObject(mensajeOut);

		    		break;

				case "/login":
					CustomerControler customerControler3 = new CustomerControler();
					ArrayList<Movil> listaMoviles = new ArrayList<Movil>();
					int exito=customerControler3.login(listaMoviles, (String)mensajeIn.getSession().get("Usuario"), (String)mensajeIn.getSession().get("Password"));
					for(Movil m: listaMoviles)
					{
						System.out.println(m.getDatos());
					}

					mensajeOut.setContext("/loginResponse");
					HashMap<String,Object> session3=new HashMap<String, Object>();

					session3.put("Moviles",listaMoviles);
					session3.put("Exito",exito);
					session3.put("Usuario",(String)mensajeIn.getSession().get("Usuario"));
					mensajeOut.setSession(session3);
					objectOutputStream.writeObject(mensajeOut);
					break;


				case "/getMovil":
					CustomerControler customerControler1=new CustomerControler();
					ArrayList<Movil> listaMovil=new ArrayList<Movil>();
					System.out.println(mensajeIn.getSession().get("Marca"));
					System.out.println(mensajeIn.getSession().get("Precio"));
					customerControler1.getMovil(listaMovil, (String)mensajeIn.getSession().get("Marca"), (String)mensajeIn.getSession().get("Precio"), (String)mensajeIn.getSession().get("Modelo"), (String)mensajeIn.getSession().get("Almacenamiento"), (String)mensajeIn.getSession().get("Memoria") );
					System.out.println("Lista de moviles seleccionados");
					System.out.print(listaMovil);
					mensajeOut.setContext("/getMovilResponse");
					HashMap<String,Object> session1=new HashMap<String, Object>();

					session1.put("Movil",listaMovil);
					mensajeOut.setSession(session1);
					objectOutputStream.writeObject(mensajeOut);
		    		break;

				case "/setCustomer":
					CustomerControler customerControler2 = new CustomerControler();
					int exito2=customerControler2.setCustomer((String)mensajeIn.getSession().get("Usuario"),(String)mensajeIn.getSession().get("Password"));
					mensajeOut.setContext("/setCustomerResponse");
					HashMap<String,Object> session2=new HashMap<String, Object>();
					session2.put("Customer","Usuario creado");
					session2.put("Exito2",exito2);
					mensajeOut.setSession(session2);
					objectOutputStream.writeObject(mensajeOut);
					break;


				case "/guardarMovil":
					CustomerControler customerControler4 = new CustomerControler();
					int exito4=customerControler4.guardarMovil((String)mensajeIn.getSession().get("id_modelo"),(String)mensajeIn.getSession().get("Usuario"));
					mensajeOut.setContext("/guardarMovilResponse");
					HashMap<String,Object> session4=new HashMap<String, Object>();
					session4.put("Exito4",exito4);
					mensajeOut.setSession(session4);
					objectOutputStream.writeObject(mensajeOut);
					break;

				case "/eliminarMovil":
					CustomerControler customerControler5 = new CustomerControler();
					int exito5=customerControler5.eliminarMovil((String)mensajeIn.getSession().get("id_modelo"),(String)mensajeIn.getSession().get("Usuario"));
					mensajeOut.setContext("/eliminarMovilResponse");
					HashMap<String,Object> session5=new HashMap<String, Object>();
					session5.put("Exito5",exito5);
					mensajeOut.setSession(session5);
					objectOutputStream.writeObject(mensajeOut);
					break;



				default:
		    		System.out.println("\nParámetro no encontrado");
		    		break;
		    }
		    
		    //Lógica del controlador 
		    //System.out.println("\n1.- He leído: "+mensaje.getContext());
		    //System.out.println("\n2.- He leído: "+(String)mensaje.getSession().get("Nombre"));
		    
		    
		    
		    //Prueba para esperar
		    /*try {
		    	System.out.println("Me duermo");
				Thread.sleep(15000);
				System.out.println("Me levanto");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			// create an object output stream from the output stream so we can send an object through it
			/*ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
			
			//Create the object to send
			String cadena=((String)mensaje.getSession().get("Nombre"));
			cadena+=" añado información";
			mensaje.getSession().put("Nombre", cadena);
			//System.out.println("\n3.- He leído: "+(String)mensaje.getSession().get("Nombre"));
			objectOutputStream.writeObject(mensaje);*
			*/

		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SocketServer Example");
		ServerSocket server = null;
		try {
			server = new ServerSocket(PORT_NUMBER);
			while (true) {
				/**
				 * create a new {@link SocketServer} object for each connection
				 * this will allow multiple client connections
				 */
				new SocketServer(server.accept());
			}
		} catch (IOException ex) {
			System.out.println("Unable to start server.");
		} finally {
			try {
				if (server != null)
					server.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}