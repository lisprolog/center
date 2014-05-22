import java.util.*;

public class Galerie{

	String name;
	ArrayList<Kunstwerk> list;
	ArrayList<Bild> list2;
//	Iterator<Kunstwerk> it = list.iterator();

	public Galerie(String n){
		this.name = n;
		this.list = new ArrayList<Kunstwerk>();
		this.list2 = new ArrayList<Kunstwerk>(Bild);
	}

	public void setName(String n){
		this.name = n;
	}
	
	public String getName(){
		return name;
	}

	public void add(Kunstwerk kw){
		list.add(kw);
	}

	public Kunstwerk removeAtPos(int pos){
		return list.remove(pos);
	} 

	public void removeKunstwerk(Kunstwerk kw){
		list.remove(kw);	
	}

	public int removeKuenstler(String kuenstler){
		int count = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
			if(iterator.next().getKuenstler().equals(kuenstler)){
				iterator.remove();
				count++;
			}
		}
		return count;	
	}

	public double berechneGesamtVkWert(){
		double vkWert = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
			vkWert += iterator.next().berechneVkWert();
		}
		return vkWert;
	}

	public int berechneAnzKunstwerke(){
		return list.size();
	}

	public int berechneAnzBilder(){
		return 0;
	}
/*
	public int berechneAnzBilderVerkauft(){
		int bilderVerkauft = 0;
		return bilderVerkauft;
	}

	public void sort(String kriterium){

	}
*/
	public String toString(){
		String line = "";
		for( Kunstwerk kw : list){
			line += kw + "\n"; 
		}
		return line;
	}
}
