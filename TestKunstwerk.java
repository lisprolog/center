public class TestKunstwerk{
	public static void main(String[] args){

		Kunstwerk k1 = new Kunstwerk("Schiele","Krumau", 1200000);
		Kunstwerk k2 = new Kunstwerk("Brunner","Horizonte", 1100);

		k2.setVerkauft(true); 	
		
		System.out.println(k1.toString());
		System.out.println(k2.toString());
	}
}
