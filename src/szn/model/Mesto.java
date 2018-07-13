package szn.model;

public class Mesto 
{
	private int idmesta;
	private String naziv;
	
	/* Geteri, seteri */
	
	public int getIdmesta() 
	{
		return idmesta;
	}
	
	public void setIdmesta(int idmesta) 
	{
		this.idmesta = idmesta;
	}
	
	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv) 
	{
		this.naziv = naziv;
	}

	/* Konstruktori */
	
	public Mesto(int idmesta, String naziv) {
		super();
		this.idmesta = idmesta;
		this.naziv = naziv;
	}

	public Mesto() {
		super();
	}
	
	
}
