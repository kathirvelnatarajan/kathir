package crossover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("c:/");
		BufferedReader br = new BufferedReader(reader);
		HashMap<String, Integer> map = new HashMap<>();
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			String[] words = line.split(" ",-1);
			for(String word : words) {
				Integer count = map.get(word);
				if(count == null) {
					map.put(word, 1);
				}else {
					map.put(word, count++);
				}
			}
			int max = 0; String word= null;
			for(String key : map.keySet()) {
				if(word == null) {
					word = key;
					max= map.get(word);
				}else {
					if(map.get(key) >max) {
						max = map.get(key);
						word = key;
					}
				}
			}
		}
		
	}

}
