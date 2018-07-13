package szn.model;

import java.util.ArrayList;

public class NaplatnaStanica 
{
	private int idstanice;
	private String nazivstanice;
	private ArrayList<NaplatnoMesto> naplatnamesta;
	private ArrayList<Kvar> kvar;
	
	/* Geteri, seteri */
	
	public int getIdstanice() 
	{
		return idstanice;
	}
	
	public void setIdstanice(int idstanice) 
	{
		this.idstanice = idstanice;
	}
	
	public String getNazivstanice() 
	{
		return nazivstanice;
	}
	
	public void setNazivstanice(String nazivstanice) 
	{
		this.nazivstanice = nazivstanice;
	}
	
	public ArrayList<NaplatnoMesto> getNaplatnamesta()
	{
		return naplatnamesta;
	}
	
	public void setNaplatnamesta(ArrayList<NaplatnoMesto> naplatnamesta)
	{
		this.naplatnamesta = naplatnamesta;
	}
	
	public ArrayList<Kvar> getKvar() {
		return kvar;
	}
	
	public void setKvar(ArrayList<Kvar> kvar) 
	{
		this.kvar = kvar;
	}

	
	/* Konstruktori */
	
	public NaplatnaStanica(int idstanice, String nazivstanice, ArrayList<NaplatnoMesto> naplatnamesta,
			ArrayList<Kvar> kvar) {
		super();
		this.idstanice = idstanice;
		this.nazivstanice = nazivstanice;
		this.naplatnamesta = naplatnamesta;
		this.kvar = kvar;
	}

	public NaplatnaStanica() {
		super();
	}
}
