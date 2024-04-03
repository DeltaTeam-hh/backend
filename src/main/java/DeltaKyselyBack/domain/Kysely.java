package DeltaKyselyBack.domain;

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
    private Long kyselyId;
    private String otsikko;
    private Date pvm;

    @OneToMany(mappedBy = "kysely", cascade = CascadeType.ALL)
    private List<Kysely> kyselyt;

    public Kysely() {
        this.kyselyId = null;
        this.otsikko = null;
        this.pvm = null;
    }

    public Kysely(Long kyselyId, String otsikko, Date pvm) {
        this.kyselyId = kyselyId;
        this.otsikko = otsikko;
        this.pvm = pvm;
    }

    public Long getId() {
        return kyselyId;
    }

    public void setId(Long kyselyId) {
        this.kyselyId = kyselyId;
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
        return "Kysely [id=" + kyselyId + ", otsikko=" + otsikko + ", pvm=" + pvm + "]";
    }

}
