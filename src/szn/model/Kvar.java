package szn.model;

import java.util.Date;

public class Kvar 
{
	private int idkvara;
	private Date vremekvara;
	private String vrstakvara;
	private NaplatnoMesto naplatnomesto;
	
	
	/* Geteri, seteri */	
	
	public int getIdkvara() 
	{
		return idkvara;
	}
	
	public void setIdkvara(int idkvara)
	{
		this.idkvara = idkvara;
	}
	
	public Date getVremekvara() 
	{
		return vremekvara;
	}
	
	public void setVremekvara(Date vremekvara) 
	{
		this.vremekvara = vremekvara;
	}
	
	public String getVrstakvara()
	{
		return vrstakvara;
	}
	
	public void setVrstakvara(String vrstakvara)
	{
		this.vrstakvara = vrstakvara;
	}
	
	public NaplatnoMesto getNaplatnomesto() 
	{
		return naplatnomesto;
	}
	
	public void setNaplatnomesto(NaplatnoMesto naplatnomesto)
	{
		this.naplatnomesto = naplatnomesto;
	}

	
	/* Konstruktori */
	
	public Kvar(int idkvara, Date vremekvara, String vrstakvara, NaplatnoMesto naplatnomesto) {
		super();
		this.idkvara = idkvara;
		this.vremekvara = vremekvara;
		this.vrstakvara = vrstakvara;
		this.naplatnomesto = naplatnomesto;
	}

	public Kvar() {
		super();
	}
	
	
	
	
}
