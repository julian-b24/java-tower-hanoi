package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {
	
	public final static String INPUT_PATH = "data/input.txt";
	public final static String OUTPUT_PATH = "data/output.txt";
	
	private int[] towers;
	
	private int positionA = 0; 
	private int positionB = 1; 
	private int positionC = 2; 
	
	private String solutions;
	
	public Main() {
		solutions = "";
		towers = new int[3];
	}

	public static void main(String[] args) {
		
		try {
			Main app = new Main();
			ArrayList<Integer> problems = app.getInput();
			for (Integer problem : problems) {
				app.getSolutionTowerHanoi(problem);
				System.out.println(app.getSolutions());
			}
			app.generateOutput();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Integer> getInput() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(INPUT_PATH));
		
		//Reads amount of problems and problems
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
	
	
	public void getSolutionTowerHanoi(int disks) {
		
		//Setup the towers
		towers[positionA] = disks;
		towers[positionB] = 0;
		towers[positionC] = 0;
		
		//Get solution of towers
		getTowers();
		getSolutionTowerHanoi(disks, positionA, positionC, positionB);
		solutions += "\n";
	}

	private void getSolutionTowerHanoi(int disks, int origin, int goal, int temporal) {
		
		if(disks > 0) {
			getSolutionTowerHanoi(disks - 1, origin, temporal, goal);
			towers[origin]--;
			towers[goal]++;
			getTowers();
			getSolutionTowerHanoi(disks - 1, temporal, goal, origin);
		}

	}
	
	public void generateOutput() throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(OUTPUT_PATH);
		pw.println(solutions);
		pw.close();
	}
	
	
	public String getSolutions() {
		return solutions;
	}
	
	public void getTowers() {
		solutions += towers[positionA] + " " + towers[positionB] + " " + towers[positionC] + "\n";
	}
}
