package DeltaKysely.domain;

import java.util.Date;

public class Kysely {
private Long kyselyId;
private String otsikko;
private Date pvm;

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

public Long getKyselyId() {
    return kyselyId;
}

public void setKyselyId(Long kyselyId) {
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
    return "Kysely [kyselyId=" + kyselyId + ", otsikko=" + otsikko + ", pvm=" + pvm + "]";
}


}

