/**
 *	Load from file "Kunstwerke.dat"
 */

public class TestImport{
	public static void main(String[] args){
		
		Galerie g1 = new Galerie("ImportGalerie");
		g1.importKunstwerke();
		// import from Kunstwerke.dat
		System.out.println("import ende!");
		g1.toString();

	}
}
