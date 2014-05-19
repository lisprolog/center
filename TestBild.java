public class TestBild{
	public static void main(String[] args){
		Bild b1 = new Bild("Schiele","Krumau",1200000, 120,95);
		Bild b2 = new Bild("Brunner", "Horizonte", 1100, 180, 90);
		b2.setVerkauft(true);
		System.out.println(b1.toString());
		System.out.println(b2.toString());
	}
}
