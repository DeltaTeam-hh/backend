package fi.hh.DeltaKyselyBack.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	public Vastaus() {

	}

	public Vastaus(Long vastausId, String vastausTxt) {
		this.vastausId = vastausId;
		this.vastausTxt = vastausTxt;
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

	@Override
	public String toString() {
		return "Vastaus [vastausId=" + vastausId + ", vastausTxt=" + vastausTxt + "]";
	}

}
