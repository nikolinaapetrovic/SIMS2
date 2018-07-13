package szn.model;

import java.util.Date;

public class Cenovnik 
{
	private int idcene;
	private VrstaVozila vrstavozila;
	private Date datumpocetka;
	private double cena;
	
	/* Geteri, seteri */
	
	public int getIdcene() 
	{
		return idcene;
	}
	
	public void setIdcene(int idcene) 
	{
		this.idcene = idcene;
	}
	
	public VrstaVozila getVrstavozila()
	{
		return vrstavozila;
	}
	
	public void setVrstavozila(VrstaVozila vrstavozila)
	{
		this.vrstavozila = vrstavozila;
	}
	
	public Date getDatumpocetka() 
	{
		return datumpocetka;
	}
	
	public void setDatumpocetka(Date datumpocetka) 
	{
		this.datumpocetka = datumpocetka;
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
	
	public Cenovnik(int idcene, VrstaVozila vrstavozila, Date datumpocetka, double cena) {
		super();
		this.idcene = idcene;
		this.vrstavozila = vrstavozila;
		this.datumpocetka = datumpocetka;
		this.cena = cena;
	}

	public Cenovnik() {
		super();
	}
	
	
	
}
