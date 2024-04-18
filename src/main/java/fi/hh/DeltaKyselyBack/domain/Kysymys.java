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

    @ManyToOne
    @JsonIgnoreProperties("kysymykset")
    @JoinColumn(name = "kyselyId")
    private Kysely kysely;

    @JsonIgnoreProperties("vastaus")
    @OneToMany(mappedBy = "kysymys", cascade = CascadeType.ALL)
    private List<Vastaus> vastaukset;

    public Kysymys() {
        this.kysymysId = null;
        this.kysymysTeksti = null;
        this.kysely = null;
    }

    public Kysymys(String kysymysTeksti, Kysely kysely) {
        this.kysymysTeksti = kysymysTeksti;
        this.kysely = kysely;
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

    @Override
    public String toString() {
        return "Kysymys [kysymysId=" + kysymysId + ", kysymysTeksti=" + kysymysTeksti + "]";
    }

    public void setLisaa(String lisaaKyssari) {

    }
}
