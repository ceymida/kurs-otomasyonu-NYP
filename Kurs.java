package Odev2;
//Ceyda UNAL -22100011055 

public class Kurs {
	private int kursID;
	private String kursAd;
	
	
	public Kurs(int kursID, String kursAd) {
		super();
		this.kursID = kursID;
		this.kursAd = kursAd;
	}


	public int getKursID() {
		return kursID;
	}


	public void setKursID(int kursID) {
		this.kursID = kursID;
	}


	public String getKursAd() {
		return kursAd;
	}


	public void setKursAd(String kursAd) {
		this.kursAd = kursAd;
	}
	
	

}
