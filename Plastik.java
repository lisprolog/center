public class Plastik extends Kunstwerk{

	private int hoehe;
	private int breite;
	private String material;
	private boolean sehrSelten;

	public Plastik(String kuenstler, String titel, double ekPreis, int l, int b, int h, String m){
		super(kuenstler, titel, ekPreis); 
		this.material = m; 
		sehrSelten = false;
	}

	public int getLaenge(){
		return this.laenge;
	}

	/**
 	*	Da die plausible Laenge und Breite eines Bides sich von jenen einer Plastik unterscheiden,
 	*	muessen die Plausibilitaetspruefungen in der jeweiligen Klasse durchgefuehrt werden.
 	*/

	public void setLaenge(int l){
		if(l > 200){
			l = 200;
		}
		this.laenge = l;
	}

	public int getBreite(){
		return this.breite;
	}

	public void setBreite(int b){
		if(b > 200){
			b = 200;
		}
		this.breite = b;
	}

	public int getHoehe(){
		return this.hoehe;
	}

	public void setHoehe(int h){
		if(h > 1000){
			h = 1000;
		}
		this.hoehe = h;
	}

	public double berechneVkWert(){
		double VkWert;
		if(sehrSelten){
			VkWert = ekPreis*2;
		}else{
			VkWert = (ekPreis*0.5)+ ekPreis;
		}
		return VkWert;
	}

	/**
	 *	Waldmueller - Maedchen mit Kuh - 12500.0 - verkauft - Maße: 100x130
	 *	Rodin - Wasserspiel - 150000.0 - verfuegbar - Material: Eisen und Stahl
	 */

	public String toString(){
		String line = super.toString() + " - " + "Material: " + material;
		return line;		
	}
}
