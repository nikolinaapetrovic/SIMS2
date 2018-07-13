package szn.model;

public class Uredjaj 
{
	private int id_uredjaja;

	/* Geteri, Seteri */
	
	public int getId_uredjaja() 
	{
		return id_uredjaja;
	}

	public void setId_uredjaja(int id_uredjaja) {
		this.id_uredjaja = id_uredjaja;
	}
	
	/* Konstruktori */

	public Uredjaj(int id_uredjaja) 
	{
		super();
		this.id_uredjaja = id_uredjaja;
	}

	
	public Uredjaj() {
		super();
	}
	
	
}
