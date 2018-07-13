package szn.model;

import java.util.ArrayList;

public class Deonica 
{
	private int id_deonice;
	private Mesto mesto_dolaska;
	private Mesto mesto_polaska;
	private ArrayList<Cenovnik> cenovnici;
	private NaplatnaStanica stanica;
	
	
	/* Geteri, seteri */
	
	public int getId_deonice() {
		return id_deonice;
	}
	public void setId_deonice(int id_deonice) {
		this.id_deonice = id_deonice;
	}
	public Mesto getMesto_dolaska() {
		return mesto_dolaska;
	}
	public void setMesto_dolaska(Mesto mesto_dolaska) {
		this.mesto_dolaska = mesto_dolaska;
	}
	public Mesto getMesto_polaska() {
		return mesto_polaska;
	}
	public void setMesto_polaska(Mesto mesto_polaska) {
		this.mesto_polaska = mesto_polaska;
	}
	public ArrayList<Cenovnik> getCenovnici() {
		return cenovnici;
	}
	public void setCenovnici(ArrayList<Cenovnik> cenovnici) {
		this.cenovnici = cenovnici;
	}
	public NaplatnaStanica getStanica() {
		return stanica;
	}
	public void setStanica(NaplatnaStanica stanica) {
		this.stanica = stanica;
	}
	
	/* Konstruktori */
	
	public Deonica(int id_deonice, Mesto mesto_dolaska, Mesto mesto_polaska, ArrayList<Cenovnik> cenovnici,
			NaplatnaStanica stanica) 
	{
		super();
		this.id_deonice = id_deonice;
		this.mesto_dolaska = mesto_dolaska;
		this.mesto_polaska = mesto_polaska;
		this.cenovnici = cenovnici;
		this.stanica = stanica;
	}
	
	public Deonica() {
		super();
	}
}
