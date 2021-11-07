package it.unibo.oop.lab.collections1;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private final static int START_RANGE = 1000;
	private final static int STOP_RANGE = 2000;
    private static final int ELEMS_TO_WRITE = 100_000;
    private static final int ELEMS_TO_READ = 1000;
    private static final int TO_MS = 100_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	/*
    	 * 1)
    	 * */
    	
    	List<Integer> arrayList = new ArrayList<>();
    	
    	for(int i = START_RANGE; i < STOP_RANGE ;i++) {
    		arrayList.add(i);
    	}
    	
    	/*
    	 * 2)
    	 * */
    	
    	List<Integer> linkedList = new LinkedList<>();
    	
    	linkedList.addAll(arrayList);
    	/*
    	 * 3)
    	 * */
    	int temp;
    	
    	temp = arrayList.get(arrayList.size()-1);
    	arrayList.set(arrayList.size()-1, arrayList.get(0));
    	arrayList.set(0, temp);
    	
    	/*
    	 * 4)
    	 * */
    	
    	for(int n: arrayList) {
    		System.out.println(n);
    	}
    	
    	/*
    	 * 5)
    	 * */
    	
    	long time = System.nanoTime();
    	
    	for(int i = STOP_RANGE; i < (STOP_RANGE+ELEMS_TO_WRITE) ;i++) {
    		arrayList.add(arrayList.size()/2,i);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS_TO_WRITE
                + " in a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
        time = System.nanoTime();
    	
    	for(int i = STOP_RANGE; i < (STOP_RANGE+ELEMS_TO_WRITE) ;i++) {
    		linkedList.add(linkedList.size()-1,i);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMS_TO_WRITE
                + " in a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
    	/*
    	 * 6)
    	 * */
        
        time = System.nanoTime();
    	int x;
    	
    	for(int i = 0; i < ELEMS_TO_READ ;i++) {
    		x = arrayList.get(arrayList.size()/2);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Reading " + ELEMS_TO_READ
                + " from a ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
        time = System.nanoTime();
    	
    	for(int i = 0; i < ELEMS_TO_READ ;i++) {
    		x = linkedList.get(linkedList.size()/2);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Reading " + ELEMS_TO_READ
                + " from a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
    	/*
    	 * 7)
    	 * */     
        
        Map<String,Long> hashMap = new HashMap<>();
        
        hashMap.put("Africa", 1_110_635_000L);
        hashMap.put("Antarctica", 0L);
        hashMap.put("Asia", 4_298_723_000L);
        hashMap.put("Europe", 742_452_000L);
        hashMap.put("Oceania", 38_304_000L);
        
        

        /*population += hashMap.get("Africa");
        population += hashMap.get("Antarctica");
        population += hashMap.get("Asia");
        population += hashMap.get("Europe");
        population += hashMap.get("Oceania");*/
        
        long population = 0;
        
        for(long n: hashMap.values()) {
        	population += n;
        }
        
        System.out.println("The population of the world is " + population + ".");
        
         
        
        
        
    }
}
