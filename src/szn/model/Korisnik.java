package szn.model;

public class Korisnik 
{
	private String username;
	private String password;
	private TipKorisnika tipkorisnika;
	
	/* Geteri & Seteri */
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public TipKorisnika getTipkorisnika() 
	{
		return tipkorisnika;
	}
	
	public void setTipkorisnika(TipKorisnika tipkorisnika) 
	{
		this.tipkorisnika = tipkorisnika;
	}

	
	/* Konstruktor */
	
	public Korisnik(String username, String password, TipKorisnika tipkorisnika) {
		super();
		this.username = username;
		this.password = password;
		this.tipkorisnika = tipkorisnika;
	}
	
	public Korisnik() {}
	
	
}
