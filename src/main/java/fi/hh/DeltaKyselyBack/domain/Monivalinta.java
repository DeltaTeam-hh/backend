package fi.hh.DeltaKyselyBack.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Monivalinta {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long monivalintaId;
    private String vastausTxt;
    
    @ManyToOne
    @JsonIgnoreProperties("monivalinnat")
    @JoinColumn(name = "kysymysId")
    private Kysymys kysymys;
    
    @ManyToOne
    @JsonIgnoreProperties("monivalinnat")
    @JoinColumn(name = "vastausId")
    private Vastaus vastaus;
    
    
    public Monivalinta() {
		this.monivalintaId = null;
		this.kysymys = null;
		this.vastaus = null;
		this.vastausTxt = null;
	}
    

	public Monivalinta(Kysymys kysymys, Vastaus vastaus, String vastausTxt) {
		this.kysymys = kysymys;
		this.vastaus = vastaus;
		this.vastausTxt = vastausTxt;
	}


	public Long getMonivalintaId() {
		return monivalintaId;
	}


	public void setMonivalintaId(Long monivalintaId) {
		this.monivalintaId = monivalintaId;
	}


	public Kysymys getKysymys() {
		return kysymys;
	}


	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}


	public Vastaus getVastaus() {
		return vastaus;
	}


	public void setVastaus(Vastaus vastaus) {
		this.vastaus = vastaus;
	}
	
	


	public String getVastausTxt() {
		return vastausTxt;
	}


	public void setVastausTxt(String vastausTxt) {
		this.vastausTxt = vastausTxt;
	}


	@Override
	public String toString() {
		return "Vastausvaihtoehdot [vaihtoehtoId=" + monivalintaId + ", vastausvaihtoehto="
				+ ", kysymys=" + kysymys + ", vastaus=" + vastaus + "]";
	}
    
    
    
    
	
}
