public class TestLoad{
	public static void main(String[] args){

		Galerie g1 = new Galerie("Galerie");
		g1.loadKunstwerke();
		// read from any file into collection
		System.out.println("load ende!");
		g1.toString();
		
        }
}
