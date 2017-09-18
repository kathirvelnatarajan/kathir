package demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Runner {
public Map<String,String> mystry(Map<String,Integer> map1, Map<Integer,String> map2){
	Map<String,String> result = new TreeMap<String,String>();
	for(String s:map1.keySet()) {
		if(map2.containsKey(map1.get(s))){
			result.put(s, map2.get(map1.get(s)));
		}
	}
	return result;
}


	public static void main(String[] args) {

		Map<String,Integer> map1 = new HashMap<String, Integer>();
		map1.put("bar", 1);
		map1.put("baz", 2);
		map1.put("foo", 3);
		map1.put("mumble", 4);
		Map<Integer,String> map2 = new HashMap< Integer,String>();
		map2.put(1, "earth");
		map2.put(2, "wind");
		map2.put(3, "air");
		map2.put(4, "fire");
		Runner r = new Runner();
		r.mystry(map1, map2);
	}

}
