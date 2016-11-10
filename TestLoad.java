/**
 *	loadKunstwerke() in Galerie.java loads from any file.
 *	importKunstwerke() is only allowed to load from "Kunstwerke.dat"
 */

public class TestLoad{
	public static void main(String[] args){

		Galerie g1 = new Galerie("Galerie");
		g1.loadKunstwerke();
		// read from any file into collection
		System.out.println("Load Ende!");
		System.out.println(g1.toString());
		System.out.println(g1.toStringB());	
        }
}
