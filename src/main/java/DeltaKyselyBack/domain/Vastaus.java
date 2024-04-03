package DeltaKyselyBack.domain;

public class Vastaus {
	
	 private Long vastausId;
	 private String vastausTxt;
	 
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
}