// Ceyda UNAL -22100011055 
// Nesne Yonelimli Programlama Dersi Odev2


package Odev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Anasayfa {
	
	private static void MenuYazdir() {
        System.out.println("########  ANA MENU  ########");
        System.out.println("1 --> KURS EKLE ");
        System.out.println("2 --> KURS LİSTELE");
        System.out.println("3 --> KURS ARA");
        System.out.println("4 --> KURS SİL");
        System.out.println("5 --> KURSİYER EKLE");
        System.out.println("6 --> KURSİYER ARA");
        System.out.println("7 --> KURSİYER SİL");
        System.out.println("8 --> KURSİYER LİSTELE");
        System.out.println("9 --> KURSİYER AYRİNTİLİ LİSTELE");
        System.out.println("10--> KURSİYER ODEYECEGİ TUTAR HESAPLA");
        System.out.println("0--> CİKİS");

    }
	
	public static void bilgileriYazdir(Kursiyer kursiyer) {
        System.out.println("Kursiyer ID: " + kursiyer.getKursiyerID());
        System.out.println("Ad Soyad: " + kursiyer.getKursiyerAdSoyad());
        System.out.println("Yas: " + kursiyer.getKursiyerYas());
        System.out.println("Alinan Kurslar:");
        for (Kurs kurs : kursiyer.alinanKurslar) {
            System.out.println("  - Kurs ID: " + kurs.getKursID() + ", Kurs Adı: " + kurs.getKursAd());
        }
        System.out.println();
    }
	
	public static void KursListele(ArrayList<Kurs> kursList) {
		if(kursList.isEmpty())
			return;
		System.out.println("KURSLAR:");
		
		for(Kurs kurs: kursList) {
			System.out.println("kurs id: "+ kurs.getKursID()+"---->kurs adi:"+kurs.getKursAd());
		}	
	}
	
	
	public static void KursBilgi(ArrayList<Kurs> kursList) {
		try {
			
			FileReader fr = new FileReader("./src/Odev2/kurs.txt");
			BufferedReader br = new BufferedReader(fr);
			String line; 
			String[] parcalar;
			
			while ((line = br.readLine()) != null) {
	            parcalar = line.split("\\+");
	            kursList.add(new Kurs(Integer.parseInt(parcalar[0]),parcalar[1]));     
	        }

			fr.close();
			br.close();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void KursiyerBilgi(ArrayList<Kursiyer> kursiyerList) {
		try {
			FileReader fr = new FileReader("./src/Odev2/kursiyer.txt");
			BufferedReader br = new BufferedReader(fr);
			String line; 
			String[] parcalar;
			int i = 0;		
			Kursiyer kursiyer = null;
			line = br.readLine();
			
			while ((line = br.readLine()) != null) {
				if(line.charAt(0) == '*') {					
					String newLine = line.substring(1,line.length());
					parcalar = newLine.split("\\+");
					kursiyer = new Kursiyer(Integer.parseInt(parcalar[0]),parcalar[1],Integer.parseInt(parcalar[2]));	
					kursiyerList.add(kursiyer);
				}
				
				else if(line.charAt(0) == '%' && kursiyer!= null) {
					String newLine = line.substring(1,line.length());
					parcalar = newLine.split("\\+");
					Kurs kurs = new Kurs(Integer.parseInt(parcalar[0]),parcalar[1]);
					kursiyer.kursEkle(kurs);
				}   
	        }
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void KursiyerListele(ArrayList<Kursiyer> kursiyerList) {
		System.out.println("----- KURSİYER BİLGİLERİ -----");
		for(Kursiyer kursiyer: kursiyerList) {
			
			System.out.println("KURSİYER ID: "+ kursiyer.getKursiyerID()+"\n\t-->> kursiyer adi soyadi :"+kursiyer.getKursiyerAdSoyad()+"\n\t-->> kursiyer yasi:"+kursiyer.getKursiyerYas());
			System.out.println("---------------");
		}
	}
	
	
	public static void KursEkle(ArrayList <Kurs> kursList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("kursun id'sini girin:");
		int id= scanner.nextInt();
		int i = 1;
		for(Kurs kurs : kursList) {
			if(kurs.getKursID() == id) {
				i = 0;
				System.out.println("bu kurs zaten mevcut");
				break;			
			}	
		}
		if(i == 1) {
			System.out.println("kursun adini girin:");
			String ad= scanner.next();
			kursList.add(new Kurs(id,ad));	
			
			
		}
	}
	
	
	public static void KursiyerEkle(ArrayList <Kursiyer> kursiyerList) {
		Kursiyer newKr = null  ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("kursiyerin id'sini girin:");
		int id= scanner.nextInt();
		int i  = 1;
		for (Kursiyer kursiyer : kursiyerList) {
			if(kursiyer.getKursiyerID() == id) {
				i = 0;
				System.out.println("------bu kursiyer zaten mevcut-----");
				System.out.println("*************************************");
				
				break;
			}
		}
		if(i== 1) {
			System.out.print("kursiyerin adini giriniz:");
			String ad= scanner.next();
			System.out.print("kursiyerin soyadini giriniz:");
			String soyad= scanner.next();
			String adSoyad= ad +" "+ soyad;
			System.out.print("kursiyerin yasini giriniz:");
			int yas= scanner.nextInt();
			System.out.print("kac adet kurs eklenecek:");
			int kursAdet = scanner.nextInt();
			newKr = new Kursiyer(id,adSoyad,yas);
			
			
			for (int t =0 ; t< kursAdet; t++ ) {
				System.out.println(i+ ". kurs id giriniz:");
				int idKrs = scanner.nextInt();
				System.out.println((t+1)+ ". kurs adini giriniz:");
				String isimKrs = scanner.next();
				newKr.kursEkle(new Kurs(idKrs,isimKrs));
				
				
			}
			kursiyerList.add(newKr);
		}	
	}
	
	public static void KursAra(ArrayList<Kurs> kursList ) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("aranacak kurs ismini girin:");
		String arananKurs= scanner.nextLine();
		int gec =0 ;
		
		for(Kurs kurs : kursList ) {
			   if(kurs.getKursAd().contains(arananKurs)){
				   gec =1;
				   System.out.println("kurs id :"+ kurs.getKursID()+ " --->kurs adi: "+kurs.getKursAd()); 
			   }
		   }
		
		if(gec ==0) {
			System.out.println("aranan kurs bulunamadi...");
		}
		
	}
	
	public static void KursiyerAra(ArrayList<Kursiyer> kursiyerList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("aranacak kursiyerin ismini giriniz:");
		String arananKursiyer= scanner.nextLine();
		int i = 0; //kontrol amaclı tuttum.
		for(Kursiyer kursiyer : kursiyerList ) {
			   if(kursiyer.getKursiyerAdSoyad().contains(arananKursiyer)){
				   i =1;
				   System.out.println("kursiyer id :"+ kursiyer.getKursiyerID()+ " --->kursiyer adi: "+kursiyer.getKursiyerAdSoyad()); 
			   }
		   }
		if( i == 0) {
			System.out.println("aranan kursiyer bulunamadi...");
			
		}		
	}
	
	
	public static void KursSil(ArrayList<Kurs> kursList) { // ekleme yapman lazim kursa yazilan kursiyer varsa o silinmeyecek...
		Scanner scanner = new Scanner(System.in);
		System.out.println("silinecek kurs ismini girin:");
		String silinecekKursAd= scanner.nextLine();
		Kurs silinecekKurs = null;

		for(Kurs kurs : kursList) {
			
			   if(kurs.getKursAd().equals(silinecekKursAd)){
				   silinecekKurs = kurs;
				   break;
			   }
		   }
		if (silinecekKurs != null) {
	           kursList.remove(silinecekKurs);
	           System.out.println(silinecekKurs + " silindi.");
	       } 
		else {
	           System.out.println( "kurs bulunamadi, silme islemi yapilamadi.");
	       }
		   kursList.remove(silinecekKurs);
			
	}
	
	
	public static void KursiyerSil(ArrayList<Kursiyer> kursiyerList) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("silinecek kursiyerin id'sini girin:");
		int silinecekKursiyerID = scanner.nextInt();
		Kursiyer silinecekKursiyer = null;
		int c = 0;
		
		
		for(Kursiyer kursiyer : kursiyerList) {
			
			if(kursiyer.getKursiyerID() == silinecekKursiyerID) {
				silinecekKursiyer = kursiyer;
				if(silinecekKursiyer.alinanKurslar.size() != 0) {
					c = 1;	
				}
				break;	
			}
		}
		if(silinecekKursiyer != null) {
			if(c == 1) {
				System.out.println("silinecek kurisyerin kursu bulunmaktadir. Silme islemi gerceklestirilemiyor.");
				
			}
			else {
				System.out.println(silinecekKursiyer.getKursiyerAdSoyad() + " silindi.");
				kursiyerList.remove(silinecekKursiyer);			
			}
		}
		else {
			System.out.println( "kursiyer bulunamadi, silme islemi yapilamadi.");
		}
		kursiyerList.remove(silinecekKursiyer);
		
	}
	
	
	public static void AyrintiliListele(ArrayList<Kursiyer> kursiyerList) {
		System.out.println("########   AYRİNTİLİ KURSİYER BİLGİLERİ   ########");
		for (Kursiyer kursiyer : kursiyerList) {
	            bilgileriYazdir(kursiyer);
	            System.out.println("#################");	        }
	}
	
	
	public static void KursiyerTutarHesapla(ArrayList<Kursiyer> kursiyerList) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ucret hesabi yapilacak kursiyerin id'sini girin:");
		int id = scanner.nextInt();
		Kursiyer aday = null;
		
		for (Kursiyer kursiyer : kursiyerList) {
			if(kursiyer.getKursiyerID() == id) {
				aday = kursiyer;
				break;
			}	
		}
		if(aday != null) {
			double borc = aday.BorcHesapla() ;
			System.out.println(id+ " id'li kursiyerin borcu :" +borc);
			
		}
		else {
			System.out.println("oyle bir kursiyer bulunmamaktadir...");
		}
		
	}
	
	public static void KursDosyasinaYazdir(ArrayList<Kurs> kursList) throws IOException {
		
//		for (String eleman : arrayList) {
//            // Elemanları dosyaya yazdır, istediğiniz formata göre düzenleme yapabilirsiniz
//            writer.write(eleman + ",");
//        }
		FileWriter fw = new FileWriter("./src/Odev2/kurs.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(Kurs kurs: kursList) {
			String line = kurs.getKursID() +"+" +kurs.getKursAd();
			bw.write(line + "\n");
		}
		bw.close();
	}
	public static void KursiyerDosyasinaYazdir(ArrayList<Kursiyer> kursiyerList) throws IOException {
		FileWriter fw = new FileWriter("./src/Odev2/kursiyer.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		for(Kursiyer kursiyer: kursiyerList) {
			String satir = "*"+ kursiyer.getKursiyerID()+ "+" + kursiyer.getKursiyerAdSoyad() + "+" + kursiyer.getKursiyerYas();
			bw.write(satir);
			bw.newLine();
			for (Kurs alinankurslar : kursiyer.alinanKurslar) {
                String kursSatir = "%" + alinankurslar.getKursID() + "+" + alinankurslar.getKursAd();
                bw.write(kursSatir);
                bw.newLine();
            }
			
		}
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList <Kurs> kursList = new ArrayList<>();
		ArrayList<Kursiyer> kursiyerList = new ArrayList<>();
		KursBilgi(kursList); // kurs.txt dosyasindaki bilgileri alan metot
		KursiyerBilgi(kursiyerList);// kursiyer.txt dosyasindaki bilgileri alan metot
		
		Scanner scanner = new Scanner(System.in);
        int sec;

        do {
            MenuYazdir();
            System.out.print("istediginiz islemi tuslayiniz: ");
            sec = scanner.nextInt();

            switch (sec) {
            case 1:
            	KursEkle(kursList);
                break;
            case 2:
            	KursListele(kursList); 
                break;
            case 3:
            	KursAra(kursList);
                break;
            case 4:
            	KursSil(kursList);
            	break;
            case 5:
            	KursiyerEkle(kursiyerList);
            	break;
            case 6:
            	KursiyerAra(kursiyerList);
            	break;
            case 7:
            	KursiyerSil(kursiyerList);
            	break;
            case 8:
            	KursiyerListele(kursiyerList);
            	break;
            case 9:
            	AyrintiliListele(kursiyerList);          
            	break;
            case 10:
            	KursiyerTutarHesapla(kursiyerList);
            	break;	
            case 0:
            	KursDosyasinaYazdir(kursList);
            	KursiyerDosyasinaYazdir(kursiyerList);
            	// burda bilgileri dosyaya yazdirma islemi yapilacak.
                System.out.println("Programdan cikiliyor...");
                break;
            default:
                System.out.println("gecersiz girdi.tekrar deneyin...");
        }

        } while (sec != 0);

        scanner.close();
	}
}
