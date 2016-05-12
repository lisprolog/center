public class TestPlastik{
	public static void main(String[] args){
		Plastik p1 = new Plastik("Laura Browne","Your Face in my Hand",1500.0,100,100,100,"Ton");
		Plastik p2 = new Plastik("Michelangelo","David",15000000.0,100,100,100,"Marmor"); 
	
		System.out.print(p1.toString());
		System.out.print(" " + p1.berechneVkWert());
		System.out.print(p2.toString());
		System.out.print(" " + p2.berechneVkWert());
	}
}
