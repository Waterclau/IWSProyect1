package icai.dtc.isw.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private ArrayList<Movil> moviles;



	public Customer() {
		this.setId(new String());
		this.setName(new String());


	}

	public Customer(String id, String name) {
		this.setName(name);
		this.setId(id);

	}

	public Customer(String id, String name, ArrayList<Movil> moviles)
	{
		this.id = id;
		this.name = name;
		this.moviles = moviles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Movil> getMoviles() {
		return moviles;
	}

	public void addMovil(Movil movil) {
		this.moviles.add(movil);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}