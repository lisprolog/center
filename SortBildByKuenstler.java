import java.util.Comparator;

public class SortBildByKuenstler implements Comparator<Bild>{

	@Override
	public int compare(Bild b1, Bild b2){
		return(b1.getKuenstler().compareTo(b2.getKuenstler()));
	}	
}
