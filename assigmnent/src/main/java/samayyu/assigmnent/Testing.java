package samayyu.assigmnent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Testing {
	static List<String> list;
public static List<String> read(File f) throws Exception{
	list = new LinkedList<String>();
	BufferedReader br = new BufferedReader(new FileReader(f) );
	String line;
	while((line = br.readLine())!= null) {
		String[] parse = line.split(",|&| |-");
		for(String paresdLine : parse) {
			list.add(paresdLine);
		}
	}
	return list;
}
	public static void main(String[] args) {
		File f = new File("C:\\Users\\kathi\\Desktop\\new 1.txt");
		try {
			System.out.println(Testing.read(f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
