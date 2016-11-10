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

	//check!
	public String toStringB(){
		String line = "";
		line += line1() + "\n" + line2()+ "\n";
		for(Kunstwerk kw : list){
			line += kw.toStringB(); 
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

***********max laenge and max breite for Plastik: 200 x 200!!!! auguste rodin will be corrected by implementation after input!******
*/
	public void loadKunstwerke(){
		String lineNotSplit, wholeString = "";
		String[] lineSplit = new String[9];
		String tempLine, newLine1, newLine2 = "";
		String line1, line2, line3 = "";
		double price;
		Kunstwerk kwTemp;
		// open file and put data in wholeString
		try{
			// need to replace all tabs with whitespace
			// line.trim(); get rid of whitespace
			// line.split("\t", 4);
			File file = new File("Kunstwerke.dat");	// file name must change
			Scanner sc = new Scanner(file);
			line1 = sc.nextLine(); // 1-9
//			System.out.println("line1: "+ line1);
			line2 = sc.nextLine(); // 1-9
//			System.out.println("line2: "+ line2);
			line3 = sc.nextLine(); // \n
			while(sc.hasNextLine()){
				tempLine = sc.nextLine();
				wholeString += tempLine + "\n";
//				System.out.println("tempLine1:"+tempLine);
			}// while end	
		}catch(FileNotFoundException e){
			System.out.println(e);
		}//try catch end
			// extract data from wholeString

		char c = ' ';
		int count = 0;
		newLine1 = "";
//		System.out.println("!\n"+wholeString+"!");
		while(count < wholeString.length()){
			while(c != '\n'){
				c = wholeString.charAt(count);
				newLine1 += c;
				count++;
			}
			newLine2 = newLine1; 	// forward string for extraction
			newLine1 = "";		// clear newLine1 for next while iteration
			c = ' '; 		// clear \n out of c for next while iteration
//			System.out.println("templine2 :"+newLine2);
//			System.out.println("extract++++++++++++++++++++++++");
			lineSplit[0] = newLine2.substring(0,7);
//			System.out.println("0:" + lineSplit[0]);
			lineSplit[1] = newLine2.substring(10,29);
//			System.out.println("1:" + lineSplit[1]);
			lineSplit[2] = newLine2.substring(30,50);
//			System.out.println("2:" + lineSplit[2]);
			lineSplit[3] = newLine2.substring(50,59);
//			System.out.println("3:" + lineSplit[3]);
			lineSplit[4] = "" + newLine2.charAt(60);
//			System.out.println("4:" + lineSplit[4]);
			lineSplit[5] = newLine2.substring(62,66);
//			System.out.println("5:" + lineSplit[5]);
			lineSplit[6] = newLine2.substring(67, 71);
//			System.out.println("6:" + lineSplit[6]);
//			System.out.println("++++++++++++++++++++++++");
			price = Double.valueOf(lineSplit[3]);
//			System.out.println(lineSplit[4].replaceAll("\\s", ""));
			int l = Integer.valueOf(lineSplit[5].replaceAll("\\s", ""));
			int b = Integer.valueOf(lineSplit[6].replaceAll("\\s", ""));
			lineSplit[0] = lineSplit[0].replaceAll("\\s", "");
//			System.out.println("*"+ lineSplit[0]+"*");
			if(lineSplit[0].equals("Bild")){
				Kunstwerk kw01 = new Bild(lineSplit[1], lineSplit[2], price, l, b); 
				//add to list
				add(kw01);
//				System.out.println("Bild Object created");
			}else if(lineSplit[0].equals("Plastik")){
				lineSplit[7] = newLine2.substring(72,76);
//				System.out.println("!"+lineSplit[7]+"!");
				lineSplit[7] = lineSplit[7].trim();
				int h = Integer.valueOf(lineSplit[7]);
//				System.out.println("7:" + h);
				lineSplit[8] = newLine2.substring(77);
//				System.out.println("8:" + lineSplit[8]);
				Kunstwerk kw01 = new Plastik(lineSplit[1], lineSplit[2], price, l, b, h, lineSplit[8]);
				//add to list
				add(kw01);
//				System.out.println("Plastik Object created");
			}else{
				//default or error
				System.out.println("Neither Plastik nor Bild");
			}
		}//while
//	System.out.println("Ende?");
	}//end loadKunstwerke

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

***********max laenge and max breite for Plastik: 200 x 200!!!! auguste rodin will be corrected by implementation after input!******

*/
	public void exportKunstwerke(){
		boolean success = false;
		Writer writer = null;
		try{
    			writer = new BufferedWriter(new FileWriter("Kunstwerke.dat")); // only this file name.
    			writer.write(toStringB());
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
		String lineNotSplit, wholeString = "";
		String[] lineSplit = new String[9];
		String tempLine, newLine1, newLine2 = "";
		String line1, line2, line3 = "";
		double price;
		Kunstwerk kwTemp;
		// open file and put data in wholeString
		try{
			// need to replace all tabs with whitespace
			// line.trim(); get rid of whitespace
			// line.split("\t", 4);
			File file = new File("Kunstwerke.dat");	// file name must change
			Scanner sc = new Scanner(file);
			line1 = sc.nextLine(); // 1-9
//			System.out.println("line1: "+ line1);
			line2 = sc.nextLine(); // 1-9
//			System.out.println("line2: "+ line2);
			line3 = sc.nextLine(); // \n
			while(sc.hasNextLine()){
				tempLine = sc.nextLine();
				wholeString += tempLine + "\n";
//				System.out.println("tempLine1:"+tempLine);
			}// while end	
		}catch(FileNotFoundException e){
			System.out.println(e);
		}//try catch end
			// extract data from wholeString

		char c = ' ';
		int count = 0;
		newLine1 = "";
//		System.out.println("!\n"+wholeString+"!");
		while(count < wholeString.length()){
			while(c != '\n'){
				c = wholeString.charAt(count);
				newLine1 += c;
				count++;
			}
			newLine2 = newLine1; 	// forward string for extraction
			newLine1 = "";		// clear newLine1 for next while iteration
			c = ' '; 		// clear \n out of c for next while iteration
//			System.out.println("templine2 :"+newLine2);
			System.out.println("**********extract from Kunstwerke.dat*************");
			lineSplit[0] = newLine2.substring(0,7);
//			System.out.println("0:" + lineSplit[0]);
			lineSplit[1] = newLine2.substring(10,29);
//			System.out.println("1:" + lineSplit[1]);
			lineSplit[2] = newLine2.substring(30,50);
//			System.out.println("2:" + lineSplit[2]);
			lineSplit[3] = newLine2.substring(50,59);
//			System.out.println("3:" + lineSplit[3]);
			lineSplit[4] = "" + newLine2.charAt(60);
//			System.out.println("4:" + lineSplit[4]);
			lineSplit[5] = newLine2.substring(62,66);
//			System.out.println("5:" + lineSplit[5]);
			lineSplit[6] = newLine2.substring(67, 71);
//			System.out.println("6:" + lineSplit[6]);
//			System.out.println("++++++++++++++++++++++++");
			price = Double.valueOf(lineSplit[3]);
//			System.out.println(lineSplit[4].replaceAll("\\s", ""));
			int l = Integer.valueOf(lineSplit[5].replaceAll("\\s", ""));
			int b = Integer.valueOf(lineSplit[6].replaceAll("\\s", ""));
			lineSplit[0] = lineSplit[0].replaceAll("\\s", "");
//			System.out.println("*"+ lineSplit[0]+"*");
			if(lineSplit[0].equals("Bild")){
				Kunstwerk kw01 = new Bild(lineSplit[1], lineSplit[2], price, l, b); 
				//add to list
				add(kw01);
				System.out.println("Bild Object created");
			}else if(lineSplit[0].equals("Plastik")){
				lineSplit[7] = newLine2.substring(72,76);
//				System.out.println("!"+lineSplit[7]+"!");
				lineSplit[7] = lineSplit[7].trim();
				int h = Integer.valueOf(lineSplit[7]);
//				System.out.println("7:" + h);
				lineSplit[8] = newLine2.substring(77);
//				System.out.println("8:" + lineSplit[8]);
				Kunstwerk kw01 = new Plastik(lineSplit[1], lineSplit[2], price, l, b, h, lineSplit[8]);
				//add to list
				add(kw01);
				System.out.println("Plastik Object created");
			}else{
				//default or error
				System.out.println("Neither Plastik nor Bild");
			}
		}//while
	System.out.println("Ende?");

	}
}
