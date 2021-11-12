package icai.dtc.isw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import java.util.Arrays;

import icai.dtc.isw.domain.Customer;
import icai.dtc.isw.domain.Movil;

public class CustomerDAO {



	public static void getClientes(ArrayList<Customer> lista) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM usuarios");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Customer(rs.getString(2),rs.getString(3)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}





	public static void getMoviles(ArrayList<Movil> lista, String marca, String precio, String modelo, String almacenamiento, String memoria) {
		Connection con=ConnectionDAO.getInstance().getConnection();
		System.out.println("La query es: "+"SELECT * FROM phones WHERE (marca='"+marca+"' OR modelo='"+modelo+"'OR almacenamiento>="+almacenamiento+" OR memoria>="+memoria+") AND precio<="+precio+" ORDER BY marca, precio");
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM phones WHERE (marca='"+marca+"' OR modelo='"+modelo+"'OR almacenamiento>="+almacenamiento+" OR memoria>="+memoria+") AND precio<="+precio +"ORDER BY marca, precio");
			 ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				lista.add(new Movil(rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6)));
			}

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}
	}


	public static int setCustomer(String usuario, String password)
		{
			int exito=1;
			Connection con=ConnectionDAO.getInstance().getConnection();
			try (PreparedStatement pst = con.prepareStatement("INSERT INTO usuarios (usuario, password) VALUES ('"+usuario+"', '"+password+"')");
				 ResultSet rs = pst.executeQuery()){


			} catch (SQLException ex) {

				System.out.println(ex.getMessage());
				if(!ex.getMessage().contains("No results were returned"))
				{
					exito=0;
				}

			}

			return exito;


		}


	public static int login(ArrayList<Movil> listaMovil,String usuario, String password)
	{
		int exito=1;
		Connection con=ConnectionDAO.getInstance().getConnection();
		try (PreparedStatement pst = con.prepareStatement("SELECT count(usuario) FROM usuarios WHERE usuario='"+usuario+"' AND password='"+password+"';");
			 ResultSet rs = pst.executeQuery()) {


			while (rs.next()) {
				if (Integer.parseInt(rs.getString(1)) == 1) {
					try (PreparedStatement pst2 = con.prepareStatement("SELECT id_moviles FROM usuarios WHERE usuario='" + usuario + "' AND password='" + password + "';");
						 ResultSet rs2 = pst2.executeQuery()) {
						while (rs2.next()) {

							Array a = rs2.getArray("id_moviles");
							Integer[] id_moviles = (Integer[]) a.getArray();

							ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(id_moviles));
							String listString = list.toString().replace("[", "(").replace("]", ")");

							try (PreparedStatement pst3 = con.prepareStatement("SELECT * FROM phones WHERE id_modelo IN " + listString + ";");
								 ResultSet rs3 = pst3.executeQuery()) {
								while (rs3.next()) {
									listaMovil.add(new Movil(rs3.getString(2), rs3.getString(3), rs3.getString(4), rs3.getString(5), rs3.getString(6)));
									System.out.println(listaMovil);
									System.out.println("hola");
								}

							} catch (SQLException ex) {

								System.out.println(ex.getMessage());
								System.out.println("Error en rs3");
							}
						}

					} catch (SQLException ex) {

						System.out.println(ex.getMessage());
						System.out.println("Error en rs2");
					}
					catch (NullPointerException npe){

						System.out.println("El usuario no tiene moviles guardados");
						exito=2;
					}
				}

				else
				{
					exito=0;
					System.out.println("El usuario no existe o los datos son incorrectos");
				}
			}



			} catch(SQLException ex){

				System.out.println(ex.getMessage());
				System.out.println("Error en rs1");
			}
			return exito;
		}

	}

	/*
	public static void main(String[] args) {


		ArrayList<Customer> lista=new ArrayList<Customer>();
		CustomerDAO.getClientes(lista);


		for (Customer customer : lista) {
			System.out.println("He leído el id: "+customer.getId()+" con nombre: "+customer.getName() + " movil comprado: "+customer.getMovil());
		}


	}


	Para guardar un movi: UPDATE usuarios SET id_moviles='{1,2}' WHERE usuario='manuel'

	 */



