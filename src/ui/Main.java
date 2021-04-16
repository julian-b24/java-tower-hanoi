package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public final static String INPUT_PATH = "data/input.txt";
	
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
		
		//Get solution of towers
		getTowers();
		getSolutionTowerHanoi(disks, positionA, positionC, positionB);
		solutions += "\n";
	}

	private void getSolutionTowerHanoi(int disks, int origin, int goal, int temporal) {
		
		/*
		//parámetros de entrada
		System.out.println("param:" + "\n" + 
							"disks = " + disks + "\n" + 
							"origin = " + origin + "\n" + 
							"goal = " + goal + "\n" +
							"temporal = " + temporal + "\n");
		if(disks == 1) {
			goal.add(origin.remove(origin.size() - 1));
			solutions += origin.size() + " " + temporal.size() + " " + goal.size() + "\n"; //+ " PASO BASE";
			//estado de los parámetros después del caso base
			System.out.println("PASO BASE ACABADO" + "\n" + "POST BASE \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			
		}else {
			
			//PASO 1
			getSolutionTowerHanoi(disks - 1, origin, temporal, goal);
			//solutions += origin.size() + " " + temporal.size() + " " + goal.size() + "\n";  //+ " PASO 1 \n";
			System.out.println("PASO 1 ACABADO" + "\n" + "POST PASO 1 \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			
			//PASO 2
			goal.add(origin.remove(origin.size() - 1));
			System.out.println("PASO 2 ACABADO" + "\n" + "POST PASO 2 \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			
			solutions += origin.size() + " " + temporal.size() + " " + goal.size() + "\n"; //" PASO 2" + "\n";
			
			//PASO 3
			getSolutionTowerHanoi(disks - 1, temporal, goal, origin);
			//solutions += " PASO 3 \n";
			System.out.println("PASO 3 ACABADO" + "\n" + "POST PASO 3 \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			
		}*/
		
		if(disks > 0) {
			getSolutionTowerHanoi(disks - 1, origin, temporal, goal);
			towers[origin]--;
			towers[goal]++;
			getTowers();
			getSolutionTowerHanoi(disks - 1, temporal, goal, origin);
		}

	}
	
	public String getSolutions() {
		return solutions;
	}
	
	public void getTowers() {
		solutions += towers[positionA] + " " + towers[positionB] + " " + towers[positionC] + "\n";
	}
	

}
