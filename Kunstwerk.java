/**
 *	kuenstler	String
 *	titel		String
 *	laenge		int
 *	breite		int
 *	ekPreis		double
 *	verkauft	boolean
 *	set
 *	get
 *	verechneVkWert	double
 *	toString	String
 */

public abstract class Kunstwerk{

	protected String kuenstler;
	protected String titel;
	protected int laenge;
	protected int breite;
	protected double ekPreis;
	protected boolean verkauft = false;


	/**
	 *	Uebernimmt Parameter Künstler, Titel, Einkaufspreis
	 *
	 */

	public Kunstwerk(String k, String t, double p){
		this.kuenstler = k;
		this.titel = t;
		this.ekPreis = p;
	}

	/**
 	*	Da die plausible Laenge und Breite eines Bides sich von jenen einer Plastik unterscheiden,
 	*	muessen die Plausibilitaetspruefungen in der jeweiligen Klasse durchgefuehrt werden.
 	*/

	public void setLaenge(int l){
//		this.laenge = l;
	}

	public int getLaenge(){
		return laenge;
	}

	public void setBreite(int b){
//		this.breite = b;
	}

	public int getBreite(){
		return breite;
	}

	public void setKuenstler(String ku){
		this.kuenstler = ku;
	}

	public String getKuenstler(){
		return kuenstler;
	}

	public void setTitel(String ti){
		this.titel = ti;
	}

	
	public String getTitel(){
		return titel;
	}

	public void setEkPreis(double ek){
		this.ekPreis = ek;
	}

	public double getEkPreis(){
		return ekPreis;
	}

	public void setVerkauft(boolean t){
		this.verkauft = t;
	}

	public boolean getVerkauftB(){
		if(verkauft){
			return true;
		}else{
			return false;
		}
	}

	public String getVerkauft(){
		if(verkauft){
			return "verkauft";
		}else{
			return "verfuegbar";
		}
	}
	
	// wurde hier nicht implementiert, da eine abstract class
	public abstract double berechneVkWert();

/*
	Waldmueller - Maedchen mit Kuh - 12500.0 - verkauft - Maße: 100x130
	Rodin - Wasserspiel - 150000.0 - verfuegbar - Material: Eisen und Stahl
*/
	public String toString(){
		String line = "";
		line = "\n" + kuenstler + " - " + titel +  " - " + String.format("%.1f", getEkPreis()) + " - " + getVerkauft();
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
		String line = "";
		line = kuenstler + "  " + titel +  "  " + String.format("%.1f", getEkPreis()) + "  " + getVerkauft();
		return line;
	}

}
