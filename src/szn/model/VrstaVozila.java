package szn.model;

public enum VrstaVozila 
{
	IA("Motocikl"), I("Automobil"), II("Autobus"), III("Kamion"), IV("Kamion sa prikolicom");
	
	String vrstaVozila = "";
	
	VrstaVozila(String tip)
	{
		vrstaVozila = tip;
	}
	
	public String getVrstaVozila()
	{
		return vrstaVozila;
	}
}
