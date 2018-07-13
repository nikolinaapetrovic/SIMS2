package szn.model;

public enum TipKorisnika
{
	ADMIN("Administrator"), KONTROLOR("Kontrolor"), SEF("Sef stanice");
	
	String tipKorisnika = "";
	
	TipKorisnika(String tip)
	{
		tipKorisnika = tip;
	}
	
	public String getTipKorisnika()
	{
		return tipKorisnika;
	}
	
}
