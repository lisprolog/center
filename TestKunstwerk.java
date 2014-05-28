import java.util.*;
public class TestKunstwerk{
	public static void main(String[] args){

		Kunstwerk k1 = new Kunstwerk("Schiele","Krumau", 1200000);
		Kunstwerk k2 = new Kunstwerk("Brunner","Horizonte", 1100);
		ArrayList<Kunstwerk> L = new ArrayList<Kunstwerk>();
		L.add(k1);
		L.add(k2);

		k2.setVerkauft(true); 	
		
		System.out.println(L.toString());

		Collections.sort(L,new SortKunstwerkByKuenstler());

		System.out.println("======");
		System.out.println(L.toString());



//		System.out.println(k2.toString());
	}
}
