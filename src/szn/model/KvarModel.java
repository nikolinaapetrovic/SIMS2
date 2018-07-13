package szn.model;

public class KvarModel {
	private int idKvara;
	private String vreme;
	private String vrsta;
	private int idUredjaja;
	public KvarModel(int idKvara, String vreme, String vrsta, int idUredjaja) {
		super();
		this.idKvara = idKvara;
		this.vreme = vreme;
		this.vrsta = vrsta;
		this.idUredjaja = idUredjaja;
	}
	public int getIdKvara() {
		return idKvara;
	}
	public void setIdKvara(int idKvara) {
		this.idKvara = idKvara;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public int getIdUredjaja() {
		return idUredjaja;
	}
	public void setIdUredjaja(int idUredjaja) {
		this.idUredjaja = idUredjaja;
	}
}
