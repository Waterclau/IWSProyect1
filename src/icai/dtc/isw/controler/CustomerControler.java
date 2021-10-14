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


}