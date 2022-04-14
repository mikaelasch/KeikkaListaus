package hh.swd20.KeikkaListaus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Kategoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaId;
	private String tyyppi;
	private String genre;

	@ManyToOne
	@JoinColumn
	private Keikka keikka;
	
	public Kategoria(String tyyppi, String genre) {
		super();
		this.tyyppi=tyyppi;
		this.genre=genre;
		
	}
	
	public Kategoria() {
		
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

	public Keikka getKeikka() {
		return keikka;
	}

	public void setKeikka(Keikka keikka) {
		this.keikka = keikka;
	}
	
}
