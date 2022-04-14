package hh.swd20.KeikkaListaus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Keikka {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long keikkaId;
	private String keikanNimi;
	private String pvm;
	private double hinta;
	private String lokaatio;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "artistiNimi")
	private List<Artisti>artistiListaus;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "tyyppi")
	private List<Kategoria>kategoriaListaus;
	
	public Keikka(String keikanNimi, String pvm, double hinta, String lokaatio) {
		super();
		this.keikanNimi = keikanNimi;
		this.pvm = pvm;
		this.hinta = hinta;
		this.lokaatio = lokaatio;
	}
	
	public Keikka() {
		
	}

	public Long getKeikkaId() {
		return keikkaId;
	}

	public void setKeikkaId(Long keikkaId) {
		this.keikkaId = keikkaId;
	}
	
	public String getKeikanNimi() {
		return keikanNimi;
	}

	public void setKeikanNimi(String keikanNimi) {
		this.keikanNimi = keikanNimi;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getLokaatio() {
		return lokaatio;
	}

	public void setLokaatio(String lokaatio) {
		this.lokaatio = lokaatio;
	}

	public List<Artisti> getArtistiListaus() {
		return artistiListaus;
	}

	public void setArtistiListaus(List<Artisti> artistiListaus) {
		this.artistiListaus = artistiListaus;
	}

	public List<Kategoria> getKategoriaListaus() {
		return kategoriaListaus;
	}

	public void setKategoriaListaus(List<Kategoria> kategoriaListaus) {
		this.kategoriaListaus = kategoriaListaus;
	}

	
	
	
	
	
}
