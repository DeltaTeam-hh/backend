
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
public class Kysymys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kysymysId;
    private String kysymysTeksti;
    private String tyyppi;

    @ManyToOne
    @JsonIgnoreProperties("kysymykset")
    @JoinColumn(name = "kyselyId")
    private Kysely kysely;

    @JsonIgnoreProperties("vastaus")
    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Vastaus> vastaukset;
    
    @JsonIgnoreProperties("monivalinnat")
    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Monivalinta> monivalinnat;

    public Kysymys() {
        this.kysymysId = null;
        this.kysymysTeksti = null;
        this.kysely = null;
        this.vastaukset = null;
		this.monivalinnat = null;
		this.tyyppi = null;    
	}
    

    public Kysymys(String kysymysTeksti, Kysely kysely, List<Vastaus> vastaukset,
			List<Monivalinta> monivalinnat, String tyyppi) {
		this.kysymysTeksti = kysymysTeksti;
		this.kysely = kysely;
		this.vastaukset = vastaukset;
		this.monivalinnat = monivalinnat;
		this.tyyppi = tyyppi;
	}

	public Long getKysymysId() {
        return kysymysId;
    }

    public void setKysymysId(Long kysymysId) {
        this.kysymysId = kysymysId;
    }

    public String getKysymysTeksti() {
        return kysymysTeksti;
    }

    public void setKysymysTeksti(String kysymysTeksti) {
        this.kysymysTeksti = kysymysTeksti;
    }

    public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    public List<Vastaus> getVastaukset() {
        return vastaukset;
    }

    public void setVastaukset(List<Vastaus> vastaukset) {
        this.vastaukset = vastaukset;
    }
    
    

    public List<Monivalinta> getMonivalinnat() {
		return monivalinnat;
	}

	public void setMonivalinnat(List<Monivalinta> monivalinnat) {
		this.monivalinnat = monivalinnat;
	}
	
	

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	@Override
    public String toString() {
        return "Kysymys [kysymysId=" + kysymysId + ", kysymysTeksti=" + kysymysTeksti + "]";
    }

}
