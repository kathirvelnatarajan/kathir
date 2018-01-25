package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapsDemo {
	public Map<String,String> mystry(Map<String,Integer> map1, Map<Integer,String> map2){
		Map<String,String> result = new TreeMap<String,String>();
		for(String s:map1.keySet()) {
			if(map2.containsKey(map1.get(s))){
				result.put(s, map2.get(map1.get(s)));
			}
		}
		return result;
	}
	public List<Integer> alternate(List<Integer> l1, List<Integer> l2){
		Iterator<Integer> i1 =l1.iterator();
		Iterator<Integer> i2 = l2.iterator();
		 List<Integer> result = new LinkedList<Integer>();
		 	while(i1.hasNext() || i2.hasNext()) {
		 		if(i1.hasNext()) {
		 			result.add(i1.next());
		 		}
		 		if(i2.hasNext()) {
		 			result.add(i2.next());
		 		}
		 	}

		    
		    return result;
		    
		    
		}
	public List<Integer> removeInRange(List<Integer> list, int remove, int start, int end ){
		for (int i = start; i < end; i++) {
			if (list.get(i).intValue() == remove) {
				list.remove(i);
				
				end--;
				i--;
			}
		}
		return list;
	}
	public int countUnique(List<Integer> list) {
		HashSet<Integer> set = new HashSet<Integer>(list);
		int count =0;
		for(Integer temp : set) {
			if(Collections.frequency(list, temp)>1) {
				count++;
			}
		}
		return count;
	}
	public int commonCount(List<Integer> l1, List<Integer> l2) {
		HashSet<Integer> set1 = new HashSet<Integer>(l1);
		HashSet<Integer> set2 = new HashSet<Integer>(l2);
		int count = 0;
		List list1 = new ArrayList<Integer>(set1);
		list1.retainAll(set2);
		count = list1.size();
		return count;
	}
	public int maxLength(Set<String> s1) {
		
		Iterator<String> i1 = s1.iterator();
		List<String> s = new LinkedList<String>(s1);
		int longest = 0;
		if(s.isEmpty()) {
			return 0;
		}else {
 		for(int i =0;i<s.size();i++) {
 			if(s.get(i).length() > longest) {
 				longest = s.get(i).length();
 			}
 		}}
 		return longest;

	}

		public static void main(String[] args) {

			/*Map<String,Integer> map1 = new HashMap<String, Integer>();
			map1.put("bar", 1);
			map1.put("baz", 2);
			map1.put("foo", 3);
			map1.put("mumble", 4);
			Map<Integer,String> map2 = new HashMap< Integer,String>();
			map2.put(1, "earth");
			map2.put(2, "wind");
			map2.put(3, "air");
			map2.put(4, "fire");*/
			MapsDemo r = new MapsDemo();
		/*	r.mystry(map1, map2);*/
			/*List<Integer> l1 = new LinkedList<Integer>();
			l1.add(1);
			l1.add(2);
			l1.add(3);
			l1.add(4);
			l1.add(5);
			List<Integer> l2 = new LinkedList<Integer>();
			l2.add(6);
			l2.add(7);
			l2.add(8);
			l2.add(9);
			l2.add(10);
			l2.add(11);
			l2.add(12);
			System.out.println(r.alternate(l1, l2));*/
			/*List<Integer> l =new LinkedList<Integer>();
			int[] i = {0, 0, 2, 0, 4, 0, 6, 0, 8, 0, 10, 0, 12, 0, 14, 0, 16};
			for(int k=0;k<i.length;k++) {
				l.add(i[k]);
			}
			int start = 5;
			int end = 13;
			int remove = 0;
			System.out.println(r.removeInRange(l, remove, start, end));*/
			List<Integer> list = new LinkedList<Integer>();
			int[] i = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
			for(int k=0;k<i.length;k++) {
				list.add(i[k]);
			}
			List<Integer> l =new LinkedList<Integer>();
			int[] j = {-5, 15, 2, -1, 7, 15, 36};
			for(int k=0;k<j.length;k++) {
				l.add(j[k]);
			}
			/*System.out.println(r.commonCount(list, l));*/
			Set<String> s =new HashSet<String>();
			s.add("");
			
			System.out.println(r.maxLength(s));
			
		}

	}
