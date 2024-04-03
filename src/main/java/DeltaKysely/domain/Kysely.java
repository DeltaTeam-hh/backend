package DeltaKysely.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kysely {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String otsikko;
    private Date pvm;

    @OneToMany(mappedBy = "kysely", cascade = CascadeType.ALL)
    private List<Kysely> kyselyt;

    public Kysely() {
        this.id = null;
        this.otsikko = null;
        this.pvm = null;
    }

    public Kysely(Long id, String otsikko, Date pvm) {
        this.id = id;
        this.otsikko = otsikko;
        this.pvm = pvm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public Date getPvm() {
        return pvm;
    }

    public void setPvm(Date pvm) {
        this.pvm = pvm;
    }

    @Override
    public String toString() {
        return "Kysely [id=" + id + ", otsikko=" + otsikko + ", pvm=" + pvm + "]";
    }

}
