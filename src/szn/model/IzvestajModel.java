package szn.model;

public class IzvestajModel {
	private String naziv;
	private int id;
	private double cena;
	
	public IzvestajModel(String naziv, int id, double cena) {
		super();
		this.naziv = naziv;
		this.id = id;
		this.cena = cena;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
}
