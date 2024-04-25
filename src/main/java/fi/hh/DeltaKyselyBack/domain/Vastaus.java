 package fi.hh.DeltaKyselyBack.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vastaus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long vastausId;
	private String vastausTxt;

	@ManyToOne
	@JsonIgnoreProperties("vastaukset")
	@JoinColumn(name = "kysymysId")
	private Kysymys kysymys;
	
	@JsonIgnoreProperties("monivalinnat")
	@OneToMany(mappedBy = "vastaus", cascade = CascadeType.ALL)
    private List<Monivalinta> monivalinnat;

	public Vastaus() {
		this.vastausId = null;
		this.vastausTxt = null;
		this.kysymys = null;
		this.monivalinnat = null;
	}

	
	
	public Vastaus(String vastausTxt, Kysymys kysymys, List<Monivalinta> monivalinnat) {
		this.vastausTxt = vastausTxt;
		this.kysymys = kysymys;
		this.monivalinnat = monivalinnat;
	}


	public Long getVastausId() {
		return vastausId;
	}

	public void setVastausId(Long vastausId) {
		this.vastausId = vastausId;
	}

	public String getVastausTxt() {
		return vastausTxt;
	}

	public void setVastausTxt(String vastausTxt) {
		this.vastausTxt = vastausTxt;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}
	
	

	public List<Monivalinta> getMonivalinnat() {
		return monivalinnat;
	}

	public void setMonivalinnat(List<Monivalinta> monivalinnat) {
		this.monivalinnat = monivalinnat;
	}

	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", vastausTxt=" + vastausTxt + "]";
	}

} 
