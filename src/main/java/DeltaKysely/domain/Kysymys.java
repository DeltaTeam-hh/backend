package DeltaKysely.domain;

public class Kysymys {
 private Long kysymysId;
 private String kysymysTeksti;

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
@Override
public String toString() {
    return "Kysymys [kysymysId=" + kysymysId + ", kysymysTeksti=" + kysymysTeksti + "]";
}



}
