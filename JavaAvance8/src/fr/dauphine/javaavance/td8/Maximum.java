package fr.dauphine.javaavance.td8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unused")
public class Maximum {
	
	
	@SafeVarargs
	public static <T extends Comparable<T>> T myMax(T ... a) { 
		/*
		 * La méthode prend un nombre variable d'arguments.
		 * <T extends Comparable<T>> définit le type du paramètre de la métode.
		 * Comparable<T> est une interface générique
		 * T doit appartenir à Comparable<T> ou à une de ses sous-classes 
		 * Pourquoi utilise-t-on extends et pas implements ????
		 */
		T max = a[0];  
		for (T i : a) {
			if (i.compareTo(max) > 0) {
				max = i;
			}
		}
		return max;
	}
	
	
	protected static <T> void print(List<T> list) {
		for(T t : list)
			System.out.println(t);
	}
	
	protected static <T extends CharSequence> void lengthObjects(List<T> list) {
		for (T t : list) {
			System.out.println(t.length());
		}
	}
	
	protected static List<Integer> listLength(List<? extends CharSequence> list) {
		List<Integer> length = new ArrayList<>();
		for (int i=0 ; i < list.size() ; i++) {
			CharSequence seq = (CharSequence) list.get(i);
			length.add(seq.length());
		}
		return length;
	}
	
	/* 
	protected static <T> List<?> fusion(List<? extends T> l1, List<? extends T> l2){
		List<T> list = new ArrayList<>();
		for (int i=0 ; i < l1.size() ; i++) {
			list.add(l1.get(i));
			list.add(l2.get(i));
		}
		return list;
	}
	 */
	
	
	public static <T> List<T> fusion(List<? extends T> l1,List<? extends T> l2) throws Exception {
        if(l1.size() < 0 || l2.size() < 0)
            throw new Exception("Listes vides");
        if(l1.size() != l2.size())
            throw new Exception("Listes de tailles différentes");
        List<T> finale = new ArrayList<>();
        for(int i = 0; i < l1.size(); ++i) {
        	finale.add(l1.get(i));
            finale.add(l2.get(i));
        }
        return finale;
    }
	
	public static <T> void interchange(List<T> l, int a, int b) {
		T aa = l.get(a); //We cannot parameterized the method with a wildcard because we need to stock l.get(a) in a variable
		l.set(a, l.get(b));
		l.set(b, aa);
	}
	
	public static <T> void shuffle(List<T> l) {
        Random r = new Random();
          
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = l.size()-1; i > 0; i--) {
              
            // Pick a random index from 0 to i
            int j = r.nextInt(i);
              
            // Swap l.get(i) with the element at random index
            T temp = l.get(i);
            l.set(i, l.get(j));
            l.set(j, temp);
        }
        System.out.println((l));
    }
	
	
}
