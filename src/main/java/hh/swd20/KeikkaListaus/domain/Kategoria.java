package hh.swd20.KeikkaListaus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Kategoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaId;
	private String tyyppi;
	private String genre;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "kategoria")
	@JsonIgnoreProperties("kategoria")
	private List <Keikka> keikat;
	
	public Kategoria(String tyyppi, String genre, List <Keikka> keikat) {
		super();
		this.tyyppi=tyyppi;
		this.genre=genre;
		this.keikat = keikat;
		
	}
	


	public Kategoria() {
		
	}
	

	public List<Keikka> getKeikat() {
		return keikat;
	}

	public void setKeikat(List<Keikka> keikat) {
		this.keikat = keikat;
	}

	public Long getKategoriaId() {
		return kategoriaId;
	}

	public void setKategoriaId(Long kategoriaId) {
		this.kategoriaId = kategoriaId;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	
}
