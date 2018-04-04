import java.util.LinkedList;

public class CollectionTest {
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		
		list.add("hello");
		list.add("heo");
		list.add("llo");
		list.add("lo");
		list.add("hello");
		
		System.out.println("list : " + list);
		
		//list.poll();
		
		System.out.println("list1 : " + list);
		
		for (int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i).equals(list.get(0)));
		}
	}
}
