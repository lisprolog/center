import java.util.*;
public class TestGalerie{
	public static void main(String[] args){

		Galerie g1 = new Galerie("NewArts");

		Bild 	kw01 = new Bild("Waldmueller","Maedchen mit Kuh",12500.0, 100, 130);
		Plastik kw02 = new Plastik("Auguste Rodin","Wasserspiel", 150000.0,5000,5000,2000, "Eisen und Stahl");
		Bild 	kw03 = new Bild("Schiele","Krumau",125000.0, 80, 100);
		Plastik kw04 = new Plastik("Michelangelo","David", 15000000.0,100,100,350, "Marmor");
		Bild 	kw05 = new Bild("Schiele","Frau",125000.0, 80, 90);
		Plastik kw06 = new Plastik("Bruno Gironcoli","Weltuhr", 1500000.0,500,700,350,"Stahl und Messing");
		Plastik kw07 = new Plastik("Laura Browne","Your Face in my Hand",1500.0,10,30,10,"Ton");
		Bild 	kw08 = new Bild("Brunner","Horizonte", 1000.0, 130, 70);
		Plastik kw09 = new Plastik("Alberto Giacometti","Der Wagen",10000.0,120,60,90,"Bronze");
		Bild 	kw10 = new Bild("Klimt","Judith",50000.0, 70, 80);
		Plastik kw11 = new Plastik("Auguste Rodin","Buerger von Calais",170000.0,500,100,250,"Bronze");
		Bild 	kw12 = new Bild("Frank","Tango", 500.0, 60, 80);

		g1.add(kw01);
		g1.add(kw02);
		g1.add(kw03);
		g1.add(kw04);
		g1.add(kw05);
		g1.add(kw06);
		g1.add(kw07);
		g1.add(kw08);
		g1.add(kw09);
		g1.add(kw10);
		g1.add(kw11);
		g1.add(kw12);

		kw01.setVerkauft(true);
		kw12.setSehrGefragt(true);
		System.out.println(g1.toString());
		System.out.println("-------------------------------------------------------");
//		g1.removeAtPos(0);
//		System.out.println(g1.toString());
//		System.out.println("-------------------------------------------------------");
//		g1.removeKunstwerk(kw12);
//		System.out.println(g1.toString());
//		System.out.println("-------------------------------------------------------");
//		g1.removeKuenstler("Auguste Rodin");
//		System.out.println(g1.toString());
//		System.out.println("-------------------------------------------------------");
//		System.out.println(g1.berechneGesamtVkWert());
//		System.out.println(g1.berechneAnzKunstwerke());	
//		System.out.println(g1.berechneAnzBilder());	
//		System.out.println(g1.berechneAnzBilderVerkauft());

//		System.out.println("===Kuenstler===");
//		Collections.sort(g1.list, new SortKunstwerkByKuenstler());
//		System.out.println(g1.toString());

//		System.out.println("===Titel===");
//		Collections.sort(g1.list, new SortKunstwerkByTitel());
//		System.out.println(g1.toString());

//		System.out.println("===Preis===");
//		g1.sort("Preis");
//		System.out.println(g1.toString());

//		System.out.println(g1.saveKunstwerke());
//		System.out.println(g1.toString());
//		tests passed positive! save needs to improve!

		System.out.println("===load from file!===");
		g1.loadKunstwerke();



	}
}
