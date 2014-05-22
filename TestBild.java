public class TestBild{
	public static void main(String[] args){
		Bild b1 = new Bild("Schiele","Krumau",1200000, 120,95);
		Bild b2 = new Bild("Frank", "Tango", 500, 60, 80);
		b2.setVerkauft(true);
		b2.setSehrGefragt(true);
		System.out.println(b1.toString());
		System.out.println(b2.toString());
	}
}
