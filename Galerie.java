import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.io.File;

public class Galerie{

	String name;
	ArrayList<Kunstwerk> list;

	public Galerie(String n){
		this.name = n;
		this.list = new ArrayList<Kunstwerk>();
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
		ArrayList<Kunstwerk> b1= new ArrayList<Kunstwerk>(list);
		return b1.size();
	}

	public int berechneAnzBilder(){
		int anzBild = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
				if(iterator.next().getClass() == Bild.class){	
				anzBild++;
			}
		}
		return anzBild;
	}

	public int berechneAnzBilderVerkauft(){
		int anzBild = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
			Kunstwerk o = iterator.next();
			if(o.getClass() == Bild.class && o.getVerkauftB()){
				anzBild++;
			}
	
		}
		return anzBild;
	}

	public void sort(String kriterium){
		if(kriterium.equals("Kuenstler")){
			Collections.sort(list, new SortKunstwerkByKuenstler());
		}else if(kriterium.equals("Titel")){
			Collections.sort(list, new SortKunstwerkByTitel());
		}else if(kriterium.equals("Preis")){
			Collections.sort(list, new SortKunstwerkByBerechnePreis());
		}
	}

	public String toString(){
		String line = "";
		for(Kunstwerk kw : list){
			line += kw.toString(); 
		}
		return line;
	}

	public boolean saveKunstwerke(){
		boolean success = false;
		Writer writer = null;
		try{
    			writer = new BufferedWriter(new FileWriter("Kunstwerke.txt"));
    			writer.write(this.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
    			if(writer != null){
				try{
					writer.close(); 
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

	public void loadKunstwerke(){
		try{
    			File file = new File("Kunstwerke.txt");
    			Scanner sc = new Scanner(file);
    			while (sc.hasNextLine()) {
    			        String line = sc.nextLine();
    			        System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void exportKunstwerke(){
		// Kunstwerke.txt
	}

	public void importKunstwerke(){
		
	}
}
