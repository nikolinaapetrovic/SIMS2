package szn.model;

public class Naplata
{
	private int idnaplate;
	private VrstaVozila vrstavozila;
	private double cena;
	
	
	/* Geteri, seteri */
	
	public int getIdnaplate() 
	{
		return idnaplate;
	}
	
	public void setIdnaplate(int idnaplate)
	{
		this.idnaplate = idnaplate;
	}
	
	public VrstaVozila getVrstavozila()
	{
		return vrstavozila;
	}
	
	public void setVrstavozila(VrstaVozila vrstavozila)
	{
		this.vrstavozila = vrstavozila;
	}
	
	public double getCena() 
	{
		return cena;
	}
	
	public void setCena(double cena) 
	{
		this.cena = cena;
	}
	
	/* Konstruktori */
	
	public Naplata(int idnaplate, VrstaVozila vrstavozila, double cena) {
		super();
		this.idnaplate = idnaplate;
		this.vrstavozila = vrstavozila;
		this.cena = cena;
	}

	public Naplata() {
		super();
	}
	
}
