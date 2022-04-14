package hh.swd20.KeikkaListaus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Artisti {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long artistiId;
	private String artistiNimi;
	
	@ManyToOne
	@JoinColumn
	private Keikka keikka;
	
	
	public Artisti(String artistiNimi) {
		super();
		this.artistiNimi = artistiNimi;
	}
	
	public Artisti() {
		
	}

	public Long getArtistiId() {
		return artistiId;
	}

	public void setArtistiId(Long artistiId) {
		this.artistiId = artistiId;
	}

	public String getArtistiNimi() {
		return artistiNimi;
	}

	public void setArtistiNimi(String artistiNimi) {
		this.artistiNimi = artistiNimi;
	}
	
	
	

}
