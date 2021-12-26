package ex2016.a01.t4.e2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logic {
	
	private final List<Integer> list;
	private int index;
	
	public Logic() {
		this.list = new ArrayList<>();
		this.index = 0;
	}
	
	public int nextInt() throws IllegalStateException {
		if (this.hasNext()) {
			return this.list.get(this.index++);
		}
		
		throw new IllegalStateException();
	}
	
	public boolean hasNext() {
		return this.index < this.list.size();
	}
	
	public void read(final String filename) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line;
		
		try {
			while ((line = br.readLine()) != null) {
				this.list.add(Integer.parseInt(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		this.list.clear();
		this.index = 0;
	}

	@Override
	public String toString() {
		return "Logic [list=" + this.list + ", index=" + this.index + "]";
	}
	
	
	
}
