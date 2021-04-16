package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public final static String INPUT_PATH = "data/input.txt";
	
	public Main() {
	}

	public static void main(String[] args) {
		
		try {
			Main app = new Main();
			ArrayList<Integer> problems = app.getInput();
			System.out.println(problems);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Integer> getInput() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(INPUT_PATH));
		
		//Reads amount of problems
		br.readLine();
		ArrayList<Integer> problems = new ArrayList<Integer>();
		
		String line = br.readLine();
		while(line != null) {
			
			problems.add(Integer.parseInt(line));
			line = br.readLine();
		}
		br.close();
		
		return problems;
	}
	
	
	public String getSolutionTowerHanoi(int disks) {
		
		String solution = getSolutionTowerHanoi(disks, disks, 0, 0);
		return solution;
	}

	private String getSolutionTowerHanoi(int disks, int origin, int goal, int temporal) {
		
		String step = origin + " " + temporal + " " + goal + "\n";
		
		if(origin == 1) {
			origin--;
			goal++;
			
		}else {
			step += getSolutionTowerHanoi(disks - 1, origin, temporal, goal);
			origin--;
			goal++;
		}
		return step;
	}

}
