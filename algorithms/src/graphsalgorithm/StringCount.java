package graphsalgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StringCount {
	public static void count(Map<String, Integer> hmap){
		String s = "The world is comming in The world The time The of";
		String[] sa = s.split(" ");
		for(int i=0;i<sa.length;i++){
			Integer value = hmap.get(sa[i]);
			if(value == null) {
				hmap.put(sa[i], 1);
			}else {
				hmap.put(sa[i], value+1);
			}
			
		}
		System.out.println(hmap);
		Set<String> set = hmap.keySet();
		for(String sKey: set) {
			System.out.println(sKey);
			System.out.println(hmap.get(sKey));
		}
		
 		
	
	}
	public static void main(String[] args) {
		HashMap<String,Integer> tmap = new HashMap<>() ;
		count(tmap);
	}
}
