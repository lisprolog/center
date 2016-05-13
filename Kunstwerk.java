public abstract class Kunstwerk{

	protected String kuenstler;
	protected String titel;
	protected int laenge;
	protected int breite;
	protected double ekPreis;
	protected boolean verkauft = false;

	public Kunstwerk(String k, String t, double p){
		this.kuenstler = k;
		this.titel = t;
		this.ekPreis = p;
	}

	public void setLaenge(int l){
		this.laenge = l;
	}

	public int getLaenge(){
		return laenge;
	}

	public void setBreite(int b){
		this.breite = b;
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
	
	// Bild and Plastik need implementation
	public abstract double berechneVkWert();

	public String toString(){
		String line = "";
		line = "\n" + kuenstler + " - " + titel +  " - " + String.format("%.1f", getEkPreis()) + " - " + getVerkauft();
		return line;
	}
}
