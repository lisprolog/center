public class TestSave{
	public static void main(String[] args){

		Galerie g1 = new Galerie("NewArts");
		Bild 	kw01 = new Bild("Waldmueller","Maedchen mit Kuh",12500.0, 100, 130);
		Plastik kw02 = new Plastik("Auguste Rodin","Wasserspiel", 150000.0,5000,5000,2000, "Eisen und Stahl");

		g1.saveKunstwerke();
		g1.add(kw01);
		g1.add(kw02);
		kw01.setVerkauft(true);
		System.out.println(g1.saveKunstwerke());
		System.out.println(g1.toString());
	}
}
