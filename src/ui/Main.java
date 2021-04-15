package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public Main() {
	}

	public static void main(String[] args) {
		
		try {
			Main app = new Main();
			ArrayList<Integer> problems = app.getInput();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Integer> getInput() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int amount = 0;
		amount = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> problems = new ArrayList<Integer>();
		while(problems.size() < amount) {
			
			problems.add(Integer.parseInt(br.readLine()));
		}
		
		return problems;
	}

}
