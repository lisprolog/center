public class Bild extends Kunstwerk{

	private int laenge;
	private int breite;
	private String farbe;
	private boolean sehrGefragt;


	public Bild(String kuenstler, String titel, double ekPreis, int laenge, int breite){
		super(kuenstler, titel, ekPreis);
		this.laenge = laenge; 
		this.breite = breite;
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
		String line = super.toString() + " - " + "Mase: " + laenge + "x" + breite;
		return line;
	}
}
