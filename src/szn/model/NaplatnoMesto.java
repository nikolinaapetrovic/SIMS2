package szn.model;

public class NaplatnoMesto 
{
	private int id_mesta;
	private Naplata naplata;
	private Uredjaj uredjaj;
	
	/* Geteri, seteri */
	
	public int getId_mesta() 
	{
		return id_mesta;
	}
	
	public void setId_mesta(int id_mesta) 
	{
		this.id_mesta = id_mesta;
	}
	
	public Naplata getNaplata()
	{
		return naplata;
	}
	
	public void setNaplata(Naplata naplata) 
	{
		this.naplata = naplata;
	}
	
	public Uredjaj getUredjaj() 
	{
		return uredjaj;
	}
	
	public void setUredjaj(Uredjaj uredjaj) 
	{
		this.uredjaj = uredjaj;
	}
	
	/* Konstruktori */
	
	public NaplatnoMesto(int id_mesta, Naplata naplata, Uredjaj uredjaj) {
		super();
		this.id_mesta = id_mesta;
		this.naplata = naplata;
		this.uredjaj = uredjaj;
	}

	public NaplatnoMesto() {
		super();
	}
	
}
