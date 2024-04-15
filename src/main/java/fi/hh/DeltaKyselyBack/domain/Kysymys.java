package fi.hh.DeltaKyselyBack.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
 private Long kysymysId;
 private String kysymysTeksti;

@ManyToOne
@JsonIgnore
@JoinColumn(name = "kyselyId")
private Kysely kysely;

 public Kysymys() {
    this.kysymysId = null;
    this.kysymysTeksti = null;
}
public Kysymys(Long kysymysId, String kysymysTeksti) {
    this.kysymysId = kysymysId;
    this.kysymysTeksti = kysymysTeksti;
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
@Override
public String toString() {
    return "Kysymys [kysymysId=" + kysymysId + ", kysymysTeksti=" + kysymysTeksti + "]";
}




}
