package Odev2;
//Ceyda UNAL -22100011055 
import java.util.ArrayList;

public class Kursiyer {
	private int kursiyerID;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
	ArrayList<Kurs> alinanKurslar = new ArrayList<>();
	

	public Kursiyer(int kursiyerID, String kursiyerAdSoyad, int kursiyerYas) {
		super();
		this.kursiyerID = kursiyerID;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
	}

	public void kursEkle(Kurs kurs) {
		this.alinanKurslar.add(kurs);
	}

	public int getKursiyerID() {
		return kursiyerID;
	}

	public void setKursiyerID(int kursiyerID) {
		this.kursiyerID = kursiyerID;
	}

	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}

	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}

	public int getKursiyerYas() {
		return kursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}

	public double BorcHesapla() {
		int kursSayisi = alinanKurslar.size();
		double  borc = 0;
		if( kursSayisi == 1 ) {
			borc = 500;
		}
		else if(kursSayisi ==2 ) {
			borc = 500 + 500*0.8;
		}
		else {
			borc = kursSayisi*(500*0.9);
		}
		return borc;
	}

}
