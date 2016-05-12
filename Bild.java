public class Bild extends Kunstwerk{

	private int laenge;
	private int breite;
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
	
	public String toString(){
		String line = super.toString() + " - " + "Ma\u00dfe: " + laenge + "x" + breite;
		return line;
	}
}
