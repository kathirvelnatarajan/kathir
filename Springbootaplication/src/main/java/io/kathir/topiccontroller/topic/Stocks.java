package io.kathir.topiccontroller.topic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class Stocks {
	public List<String> read(File f) throws Exception{
		List<String> list = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		while((line = br.readLine()) != null) {
			list.add(line);
		}
		return list;
	}
}
