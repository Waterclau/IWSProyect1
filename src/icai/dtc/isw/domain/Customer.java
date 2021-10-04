package icai.dtc.isw.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String movil;



	public Customer() {
		this.setId(new String());
		this.setName(new String());
		this.setMovil(new String());

	}
	
	public Customer(String id, String name, String movil) {
		this.setName(name);
		this.setId(id);
		this.setMovil(movil);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
