package icai.dtc.isw.controler;

import java.util.ArrayList;
import java.util.HashMap;

import icai.dtc.isw.dao.CustomerDAO;
import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;
import icai.dtc.isw.client.VentanaResultados;


public class CustomerControler {

	public void getCustomer(ArrayList<Customer> lista) {
		CustomerDAO.getClientes(lista);
	}

	public void getMovil(ArrayList<Movil> lista, String marca, String precio, String modelo, String almacenamiento, String memoria)
	{
		CustomerDAO.getMoviles(lista, marca, precio, modelo, almacenamiento, memoria);
	}

	public int setCustomer(String usuario, String password)
	{
		int exito=CustomerDAO.setCustomer(usuario,password);
		return exito;
	}

	public int login(ArrayList<Movil> listaMovil, String usuario, String password)
	{
		int exito=CustomerDAO.login(listaMovil,usuario, password);
		return exito;
	}

	public int guardarMovil(String id_modelo, String usuario)
	{
		int exito=CustomerDAO.guardarMovil(id_modelo, usuario);
		return exito;
	}

	public int eliminarMovil(String id_modelo, String usuario)
	{
		int exito = CustomerDAO.eliminarMovil(id_modelo, usuario);
		return exito;
	}


}