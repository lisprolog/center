import java.util.Comparator;

public class SortKunstwerkByKuenstler implements Comparator<Kunstwerk>{

	@Override
	public int compare(Kunstwerk kw1, Kunstwerk kw2){
		return(kw1.getKuenstler().compareTo(kw2.getKuenstler()));
	}	
}
