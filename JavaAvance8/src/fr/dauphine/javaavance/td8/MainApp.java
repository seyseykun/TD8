package fr.dauphine.javaavance.td8;

import java.util.Arrays;
import java.util.List;

public class MainApp {
	
	public static void main(String[] args) throws Exception {
			
		System.out.println("ERTY");
		System.out.println(Maximum.myMax(12, 45, 86));
		//System.out.println(myMax()); //Cela ne compile pas.
		System.out.println(Maximum.myMax("foo", "toto"));
			
		
		List<String> list = Arrays.asList("foo", "toto");
		Maximum.print(list); //Le code ne compile pas car List<String> est différent de List<Object>
		Maximum.lengthObjects(list);
		
		
		List<String> l = Arrays.asList("colonel", "reyel");
		System.out.println(Maximum.listLength(l));
		
		
		List<String> l1 = Arrays.asList("C", "rc");
		List<StringBuilder> l2 = Arrays.asList(new StringBuilder("a ma"), new StringBuilder("he!"));
		List<? extends CharSequence> r1 = Maximum.fusion(l1, l2);
		List<?> r2 = Maximum.fusion(l1,  l2);
		
		List<Integer> l3 = Arrays.asList(1, 2);
		List<Integer> l4 = Arrays.asList(10, 20);
		List<Integer> r3 = Maximum.fusion(l3, l4);
		List<?> r4 = Maximum.fusion(l1,  l3);
		
		System.out.println("\n" + r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		
		Maximum.interchange(r4, 1, 3);
		System.out.println(r4);
		Maximum.shuffle(r4);
	}
	
}
