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
    private String monivalintaTxt;
    
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
		this.monivalintaTxt = null;
		this.kysymys = null;
		this.vastaus = null;
	}
    

	public Monivalinta(String vastausvaihtoehto, Kysymys kysymys, Vastaus vastaus) {
		this.monivalintaTxt = vastausvaihtoehto;
		this.kysymys = kysymys;
		this.vastaus = vastaus;
	}


	public Long getMonivalintaId() {
		return monivalintaId;
	}


	public void setMonivalintaId(Long vaihtoehtoId) {
		this.monivalintaId = vaihtoehtoId;
	}


	public String getMonivalintaTxt() {
		return monivalintaTxt;
	}


	public void setMonivalintaTxt(String vastausvaihtoehto) {
		this.monivalintaTxt = vastausvaihtoehto;
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


	@Override
	public String toString() {
		return "Vastausvaihtoehdot [vaihtoehtoId=" + monivalintaId + ", vastausvaihtoehto=" + monivalintaTxt
				+ ", kysymys=" + kysymys + ", vastaus=" + vastaus + "]";
	}
    
    
    
    
	
}
