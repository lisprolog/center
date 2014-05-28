import java.util.*;

public class TestBild{
	public static void main(String[] args){
		Bild b1 = new Bild("Schiele","Krumau",1200000, 120,95);
		Bild b2 = new Bild("Frank", "Tango", 500, 60, 80);
		b2.setVerkauft(true);
		b2.setSehrGefragt(true);

		ArrayList<Bild> list = new ArrayList<Bild>();
		list.add(b1);
		list.add(b2);

		System.out.println(list.toString());
		System.out.println("=====");

		Collections.sort(list, new SortKunstwerkByKuenstler());

		System.out.println(list.toString());
	}
}
