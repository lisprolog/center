import java.util.Comparator;

public class SortKunstwerkByBerechnePreis implements Comparator<Kunstwerk>{
	@Override
	public int compare(Kunstwerk kw1, Kunstwerk kw2){
		return (kw1.berechneVkWert() < kw2.berechneVkWert()) ? -1 
                : (kw1.berechneVkWert() > kw2.berechneVkWert()) ? 1 
                : 0;
	}
}
