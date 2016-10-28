import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.File;

/**
 *	This class creates an Arraylist with <Kunstwerk> in it.
 *	SetName(), getName(), add(kw), removeAtPos(int), removeKunstwerk(String), removeKuenstler(String),
 *	berechneGesamtVkWert(),  berechneAnzKunstwerke() berechneAnzBilder(), berechneAnzBilderVerkauft(), 
 *	sort(String kriterium), toString(), saveKunstwerke(), loadKunstwerke(), exportKunstwerke(), importKunstwerke()
 */
public class Galerie{

	private String name;
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

	// check!
	public void add(Kunstwerk kw){
		list.add(kw);
	}

	// check!
	public Kunstwerk removeAtPos(int pos){
		return list.remove(pos);
	} 

	// check!
	public void removeKunstwerk(Kunstwerk kw){
		list.remove(kw);	
	}

	// check!
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

	// check!
	public double berechneGesamtVkWert(){
		double vkWert = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
			vkWert += iterator.next().berechneVkWert();
		}
		return vkWert;
	}

	//check!
	public int berechneAnzKunstwerke(){
		ArrayList<Kunstwerk> b1= new ArrayList<Kunstwerk>(list);
		return b1.size();
	}

	//check!
	public int berechneAnzBilder(){
		int anzBild = 0;
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
				if(iterator.next().getClass() == Bild.class){	
				anzBild++;
			}
		}
		return anzBild;
	}

	//check!
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

	//check!
	public void sort(String kriterium){
		if(kriterium.equals("Kuenstler")){
			Collections.sort(list, new SortKunstwerkByKuenstler());
		}else if(kriterium.equals("Titel")){
			Collections.sort(list, new SortKunstwerkByTitel());
		}else if(kriterium.equals("Preis")){
			Collections.sort(list, new SortKunstwerkByBerechnePreis());
		}
	}

	//check!
	public String toString(){
		String line = "";
		for(Kunstwerk kw : list){
			line += kw.toString(); 
		}
		return line;
	}

	/**
	 * Stellen Sie zur Klasse Galerie eine Methode saveKunstwerke, 
	 * mit deren Hilfe alle Informationen ueber die Kunstwerke serialisiert in eine Datei mit
	 * beliebigen Namens(zB.:Kunstwerke.ser) geschrieben werden. 
	 * save in File with any name with .ser extension
	 *
	 */
	public boolean saveKunstwerke(){
		boolean success = false;
		Writer writer = null;
		try{
    			writer = new BufferedWriter(new FileWriter("Kunstwerke.ser"));
    			writer.write(this.toString());
			success = true;
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
/*	
	// load from file with any name into collection
          1         2         3         4         5         6         7         8         9
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789

Bild	  Waldmueller 	      Maedchen mit Kuh    10000.0   n 100  130
Plastik	  Auguste Rodin       Wasserspiel         100000.0  n 5000 5000 2000 Eisen u. Stahl
Bild	  Schiele             Krumau              100000.0  n 80   100  
Plastik	  Michelangelo        David               1000000.0 n 100  100  350  Marmor
Bild	  Schiele             Frau                100000.0  n 80   90   
Plastik	  Bruno Gironcoli     Weltuhr             1.0       n 500  700  350  Stahl u. Messing
Plastik	  Laura Browne        Your Face in my Hand1000.0    n 10   30   10   Ton
Bild	  Brunner             Horizonte           1000.0    n 130  70 
Plastik	  Alberto Giacometti  Der Wagen           10000.0   n 120  60   90   Bronze
Bild	  Klimt               Judith              50000.0   n 70   80   
Plastik	  Auguste Rodin       Buerger von Calais  170000.0  n 500  100  250  Bronze
Bild	  Frank               Tango               500.0     n 60   80
*/
	public void loadKunstwerke(){
		String lineNotSplit = "";
		String[] lineSplit = new String[9];
		try{
			File file = new File("Kunstwerke.dat");	// file name must change
			Kunstwerk kwTemp;
			Scanner sc = new Scanner(file);
			String tempLine = "";
			String line1, line2, line3 = "";
			line1 = sc.nextLine(); // 1-9
			System.out.println();
			line2 = sc.nextLine(); // 1-9
			line3 = sc.nextLine(); // \n
			double price;
			while(sc.hasNextLine()){
				tempLine = sc.nextLine(); // Bild7 Plastik9
				System.out.println("++++++++++++++++++++++++");
				// Coordinates make difficulties with Plastik
				lineSplit[0] = tempLine.substring(0,7);
				System.out.println("0:" + lineSplit[0]);
				lineSplit[1] = tempLine.substring(7,26);
				System.out.println("1:" + lineSplit[1]);
				lineSplit[2] = tempLine.substring(26,45);
				System.out.println("2:" + lineSplit[2]);
				lineSplit[3] = tempLine.substring(46,55);
				System.out.println("3:" + lineSplit[3]);
				lineSplit[4] = "" + tempLine.charAt(56);
				System.out.println("4:" + lineSplit[4]);
				lineSplit[5] = tempLine.substring(58,62);
				System.out.println("5:" + lineSplit[5]);
				lineSplit[6] = tempLine.substring(63);
				System.out.println("6:" + lineSplit[6]);
				System.out.println("++++++++++++++++++++++++");
				System.out.println("HOHOH:"+tempLine.charAt(55));
				// extract whitespace
				for(int i = 0; i < 7; i++){
					lineSplit[i] = lineSplit[i].replaceAll("\\s","");
					System.out.println(i + ":" + lineSplit[i]);
				}
				System.out.println("+++++++++++++++++++++++++");

				price = Double.valueOf(lineSplit[3]);
				System.out.println(lineSplit[4].replaceAll("\\s", ""));
				int l = Integer.valueOf(lineSplit[5].replaceAll("\\s", ""));
				int b = Integer.valueOf(lineSplit[6]);
				if(lineSplit[0].equals("Bild")){
					Kunstwerk kw01 = new Bild(lineSplit[1], lineSplit[2], price, l, b); 
					//add to list
					add(kw01);
				}else if(lineSplit[0].equals("Plastik")){
					lineSplit[7] = tempLine.substring(72,76);
					int h = Integer.valueOf(lineSplit[7]);
					lineSplit[8] = tempLine.substring(77,99);
					Kunstwerk kw01 = new Plastik(lineSplit[1], lineSplit[2], price, l, b, h, lineSplit[8]);
					//add to list
					add(kw01);
				}else{
					//default or error
					System.out.println("Neither Plastik nor Bild");
				}
			}	
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
	}

/*	First version of load used wrong format and failed to convert String to double
 		String line = "";
		try{
    			File file = new File("Kunstwerke.dat"); // file name must change
			Kunstwerk kwTemp;
    			Scanner sc = new Scanner(file);
			String tempLine, material1, material2 = "";
			int hohe, breite = 0;
    			while (sc.hasNextLine()) {
    			        tempLine = sc.nextLine();
				System.out.println(tempLine);
				String kunstwerkeLine[] = tempLine.split("-"); 
				for(int i = 0; i < kunstwerkeLine.length; i++){
					System.out.println("load:" + kunstwerkeLine[i]);
				}
				System.out.println(kunstwerkeLine[3]);
				String lastKwElement[] = kunstwerkeLine[4].split(" ");
				double priceCast = Integer.parseInt(kunstwerkeLine[2]); 
				if(lastKwElement[0].equals("Maße:")){
					String maße[] = lastKwElement[1].split("x"); 	
			 		hohe = Integer.parseInt(maße[0]);
					breite = Integer.parseInt(maße[1]);
					kwTemp = new Bild(kunstwerkeLine[0], kunstwerkeLine[1], priceCast, hohe, breite);
					if(kunstwerkeLine[3].equals("verkauft")){
						kwTemp.setVerkauft(true);
					}
				}else{
	
					kwTemp = new Plastik(kunstwerkeLine[0], kunstwerkeLine[1], priceCast, kunstwerkeLine[4]);
					if(kunstwerkeLine[3].equals("verkauft")){
						kwTemp.setVerkauft(true);
					}
	
				}
				list.add(kwTemp);
				line += kwTemp.toString();
    			        System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

 *
 * */


/*
 * load data only from "Kunstwerke.dat"
          1         2         3         4         5         6         7         8         9
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789

Bild	  Waldmueller 	      Maedchen mit Kuh    10000.0   n 100  130
Plastik	  Auguste Rodin       Wasserspiel         100000.0  n 5000 5000 2000 Eisen u. Stahl
Bild	  Schiele             Krumau              100000.0  n 80   100  
Plastik	  Michelangelo        David               1000000.0 n 100  100  350  Marmor
Bild	  Schiele             Frau                100000.0  n 80   90   
Plastik	  Bruno Gironcoli     Weltuhr             1.0       n 500  700  350  Stahl u. Messing
Plastik	  Laura Browne        Your Face in my Hand1000.0    n 10   30   10   Ton
Bild	  Brunner             Horizonte           1000.0    n 130  70 
Plastik	  Alberto Giacometti  Der Wagen           10000.0   n 120  60   90   Bronze
Bild	  Klimt               Judith              50000.0   n 70   80   
Plastik	  Auguste Rodin       Buerger von Calais  170000.0  n 500  100  250  Bronze
Bild	  Frank               Tango               500.0     n 60   80
*/
	public void exportKunstwerke(){
		boolean success = false;
		Writer writer = null;
		try{
    			writer = new BufferedWriter(new FileWriter("Kunstwerke.dat")); // only this file name.
    			writer.write(theString());
			success = true;
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
	}

	// first line of Kunstwerke.dat: number of columns
	public static String line1(){
		String result = " ";
		for(int i = 1; i < 10; i++ ){
			result += "         " + i;
		}
		return result;
	}

	// second line of Kunstwerke.dat: width of columns
	public static String line2(){
		String result = "";
		for(int i = 1; i < 11; i++){
			result += "0123456789";
		}
		return result;
	}

	// the completed string for export command
	public String theString(){
		Kunstwerk k;
		String result = "";
		String kunstwerk;
		result += line1();		// first line
		result += "\n" + line2();	// second line
		for(Iterator<Kunstwerk> iterator = list.iterator();iterator.hasNext();){
			k = iterator.next();
			result +="\n" + k.toString();
		}
		return result;
	}

	// read Kunstwerke.dat instead of Kunstwerke.txt
	public void importKunstwerke(){
/*		String line = "";
		try{
    			File file = new File("Kunstwerke.dat");	// only this file name
			Kunstwerk kwTemp;
    			Scanner sc = new Scanner(file);
			String tempLine, material1, material2 = "";
			int hohe, breite = 0;
    			while (sc.hasNextLine()) {
    			        tempLine = sc.nextLine();
				System.out.println(tempLine);
				String kunstwerkeLine[] = tempLine.split("-"); 
				for(int i = 0; i < kunstwerkeLine.length; i++){
					System.out.println("load:" + kunstwerkeLine[i]);
				}
				System.out.println(kunstwerkeLine[3]);
				String lastKwElement[] = kunstwerkeLine[4].split(" ");
				double priceCast = Integer.parseInt(kunstwerkeLine[2]); 
				if(lastKwElement[0].equals("Maße:")){
					String maße[] = lastKwElement[1].split("x"); 	
			 		hohe = Integer.parseInt(maße[0]);
					breite = Integer.parseInt(maße[1]);
					kwTemp = new Bild(kunstwerkeLine[0], kunstwerkeLine[1], priceCast, hohe, breite);
					if(kunstwerkeLine[3].equals("verkauft")){
						kwTemp.setVerkauft(true);
					}
				}else{
	
					kwTemp = new Plastik(kunstwerkeLine[0], kunstwerkeLine[1], priceCast, kunstwerkeLine[4]);
					if(kunstwerkeLine[3].equals("verkauft")){
						kwTemp.setVerkauft(true);
					}	
				}
				list.add(kwTemp);
				line += kwTemp.toString();
    			        System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
*/
	}
}
