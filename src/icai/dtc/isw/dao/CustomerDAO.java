package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;

public class CustomerDAO {



	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}





	public static void getMoviles(ArrayList<Movil> lista, String marca, String precio, String modelo, String almacenamiento, String memoria) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM phones WHERE (Marca='"+marca+"' OR Modelo='"+modelo+"'OR Almacenamiento>="+almacenamiento+" OR Memoria>="+memoria+") AND Precio<="+precio);
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Movil(rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {


		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.getClientes(lista);


		for (Customer customer : lista) {
			System.out.println("He leído el id: "+customer.getId()+" con nombre: "+customer.getName() + " movil comprado: "+customer.getMovil());
		}


	}

}
