package hh.swd20.KeikkaListaus.domain;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;




@Entity
public class Artisti {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long artistiId;
	private String artistiNimi;
	
	@ManyToMany(mappedBy = "artistiListaus")
	private List <Keikka> keikat; 
	
	
	public Artisti(String artistiNimi,List<Keikka> keikat ) {
		super();
		this.artistiNimi = artistiNimi;
		this.keikat = keikat;
		
	}
	
	public Artisti() {
		
	}
	



	public List<Keikka> getKeikat() {
		return keikat;
	}

	public void setKeikat(List<Keikka> keikat) {
		this.keikat = keikat;
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
