public class Plastik extends Kunstwerk{

	private int hoehe;
	private String material;
	private boolean sehrSelten;

	public Plastik(String kuenstler, String titel, double ekPreis, int laenge, int breite, int hoehe, String material){
		super(kuenstler, titel, ekPreis); 
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe; 
		this.material = material; 
		sehrSelten = false;
	}

	public void setLaenge(int laenge){
		this.laenge = laenge;
	}

	public int getLaenge(){
		return laenge;
	}

	public void setBreite(int breite){
		this.breite = breite;
	}

	public int getBreite(){
		return breite;
	}

	public void setHoehe(int hoehe){
		this.hoehe = hoehe;
	}

	public int getHoehe(){
		return hoehe;
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
	
	public String toString(){
		String line = super.toString() + " - " + "Material: " + material;
		return line;		
	}
}
