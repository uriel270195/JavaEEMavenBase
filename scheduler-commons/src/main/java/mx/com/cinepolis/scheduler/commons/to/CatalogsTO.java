package mx.com.cinepolis.scheduler.commons.to;

import java.io.Serializable;

public class CatalogsTO implements Serializable{
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
