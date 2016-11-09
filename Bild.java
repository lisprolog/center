/**
 *	farbe		String
 *	sehr gefragt	boolean
 *	set
 *	get
 *	berechneVkWert	double
 *	toString	String
 */

public class Bild extends Kunstwerk{

	private String farbe;
	private boolean sehrGefragt;


	public int getLaenge(){
		return this.laenge;
	}

	public int getBreite(){
		return this.breite;
	}

	public String getFarbe(){
		return this.farbe;
	}

	/**
 	*	Da die plausible Laenge und Breite eines Bides sich von jenen einer Plastik unterscheiden,
 	*	muessen die Plausibilitaetspruefungen in der jeweiligen Klasse durchgefuehrt werden.
 	*/

	public void setLaenge(int l){
		if(l > 500){
			l = 500;
		}
		this.laenge = l;
	}

	public void setBreite(int b){
		if(b > 300){
			b = 300;
		}
		this.breite = b;
	}

	public void setFarbe(String f){
		this.farbe = f;
	}

	public Bild(String kuenstler, String titel, double ekPreis, int laenge, int breite){
		super(kuenstler, titel, ekPreis);
		this.laenge = laenge; 
		this.breite = breite;
	}

	public void setSehrGefragt(boolean b){
		this.sehrGefragt = b;
	}

	public boolean getSehrGefragt(){
		return sehrGefragt;
	}

	public double berechneVkWert(){
		double VkWert = 0;
		if(sehrGefragt){
			VkWert= (ekPreis*0.5)+ekPreis;
		}else{
			VkWert= (ekPreis*0.25)+ekPreis;
		}	
		return VkWert;
	}

	/**
	 *	Waldmueller - Maedchen mit Kuh - 12500.0 - verkauft - Maße: 100x130
	 *	Rodin - Wasserspiel - 150000.0 - verfuegbar - Material: Eisen und Stahl
	 */

	public String toString(){
		String line = super.toString() + " - " + "Ma\u00dfe: " + laenge + "x" + breite;
		return line;
	}

	/**
 	*	To StringB will help to save/import data into .ser/.dat files with this format
 	*
 	*/

	/*
          1         2         3         4         5         6         7         8         9
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789

Bild      Waldmueller         Maedchen mit Kuh    10000.0   n 100  130
Plastik   Auguste Rodin       Wasserspiel         100000.0  n 5000 5000 2000 Eisen u. Stahl
	*/

	public String toStringB(){
		String line = "\n" + "Bild    "+ super.toStringB() + " " + laenge + " " + breite + " " ;
		return line;
	}

}
