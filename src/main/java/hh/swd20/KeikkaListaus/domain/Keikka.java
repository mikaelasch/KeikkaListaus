package hh.swd20.KeikkaListaus.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
public class Keikka {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long keikkaId;
	private String keikanNimi;
	private String pvm;
	private double hinta; 
	private String lokaatio;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "keikka_artisti", 
            joinColumns = { @JoinColumn(name = "keikka_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "artisti_id") }
        )
	private List<Artisti> artistiListaus;  
	@ManyToOne
	 @JsonIgnoreProperties("keikka")
	@JoinColumn(name="kategoria_id")
	private Kategoria kategoria; 
	
	
	public Keikka(String keikanNimi, String pvm, double hinta, String lokaatio, List<Artisti> artistiListaus,  Kategoria kategoria) {
		super();
		this.keikanNimi = keikanNimi;
		this.pvm = pvm;
		this.hinta = hinta;
		this.lokaatio = lokaatio;
		this.artistiListaus = artistiListaus;
		this.kategoria= kategoria;
	}
	
	/*
	public void ListToString() {
	    List<List<Artisti>> artList = Arrays.asList(artistiListaus); 

	    
	}*/ //yritä saada lista stringiks
	
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

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}





	@Override
	public String toString() {
		return "Keikka [kysymysId=" + keikkaId + ", keikanNimi=" + keikanNimi + ", pvm=" + pvm + ", hinta="
				+ hinta + ", lokaatio=" + lokaatio +",kategoria" + kategoria+"]";
	}


	
	
	
	
	
}
