import java.util.Comparator;

public class SortKunstwerkByTitel implements Comparator<Kunstwerk>{
	@Override
	public int compare(Kunstwerk kw1, Kunstwerk kw2){
		return(kw1.getTitel().compareTo(kw2.getTitel()));
	}
}
