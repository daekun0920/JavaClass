import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		
		for (String s : list) {
			
			if (s.equals("a")) {
				list.remove(s);
				break;
			}
			
		}
	}
}
