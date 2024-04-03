package DeltaKyselyBack.domain;

import java.util.Date;

public class Kysely {
private Long id;
private String otsikko;
private Date pvm;

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

