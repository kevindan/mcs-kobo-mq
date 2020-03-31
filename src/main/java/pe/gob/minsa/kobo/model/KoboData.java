package pe.gob.minsa.kobo.model;

import java.io.Serializable;

public class KoboData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String data;

	public KoboData() {

	}

	public KoboData(String id, String data) {

		this.id = id;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "KoboData [id=" + id + ", data=" + data + "]";
	}
	
}
