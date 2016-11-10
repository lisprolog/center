	/**
 	 * Specification:  
	 * Stellen Sie zur Klasse Galerie eine Methode saveKunstwerke, 
	 * mit deren Hilfe alle Informationen ueber die Kunstwerke serialisiert in eine Datei mit
	 * beliebigen Namens(zB.:Kunstwerke.ser) geschrieben werden. 
	 * save in File with any name with .ser extension
	 * 
	 */

/*
Format: 
          1         2         3         4         5         6         7         8         9
0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789

Bild      Waldmueller         Maedchen mit Kuh    10000.0   n 100  130
Plastik   Auguste Rodin       Wasserspiel         100000.0  n 5000 5000 2000 Eisen u. Stahl
Bild      Schiele1            Krumau              100000.0  n 80   100  
Plastik   Michelangelo        David               1000000.0 n 100  100  350  Marmor
Bild      Schiele2            Frau                100000.0  n 80   90   
Plastik   Bruno Gironcoli     Weltuhr             1.0       n 500  700  350  Stahl u. Messing
Plastik   Laura Browne        Your Face in my Hand1000.0    n 10   30   10   Ton
Bild      Brunner             Horizonte           1000.0    n 130  70 
Plastik   Alberto Giacometti  Der Wagen           10000.0   n 120  60   90   Bronze
Bild      Klimt               Judith              50000.0   n 70   80   
Plastik   Auguste Rodin       Buerger von Calais  170000.0  n 500  100  250  Bronze
Bild      Frank               Tango               500.0     n 60   80                             

***********max laenge and max breite for Plastik: 200 x 200!!!! auguste rodin will be corrected by implementation after input!******
*/

public class TestSave{
	public static void main(String[] args){

		Galerie g1 = new Galerie("NewArts");
		Bild 	kw01 = new Bild("Waldmueller","Maedchen mit Kuh",12500.0, 100, 130);
		Plastik kw02 = new Plastik("Auguste Rodin","Wasserspiel", 150000.0,5000,5000,2000, "Eisen und Stahl");

		g1.add(kw01);
		g1.add(kw02);
		kw01.setVerkauft(true);
		g1.saveKunstwerke();
		System.out.println(g1.toString());
		System.out.println(g1.toStringB());
	}
}
