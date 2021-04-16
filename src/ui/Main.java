package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public final static String INPUT_PATH = "data/input.txt";

	private ArrayList<Integer> towerA;
	private ArrayList<Integer> towerB;
	private ArrayList<Integer> towerC;
	
	private String solutions;
	
	public Main() {
		solutions = "";
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
	
	
	public void getSolutionTowerHanoi(int disks) {
		towerA = new ArrayList<Integer>();
		for (int i = disks; i > 0; i--) {
			towerA.add(i);
		}
		towerB = new ArrayList<Integer>();
		towerC = new ArrayList<Integer>();
		solutions += getTowers();
		getSolutionTowerHanoi(disks, towerA, towerC, towerB);
		solutions += getTowers();
	}

	private void getSolutionTowerHanoi(int disks, ArrayList<Integer> origin, ArrayList<Integer> goal, ArrayList<Integer> temporal) {
		
		//Imprime parámetros de entrada
		/*System.out.println("param:" + "\n" + 
							"disks = " + disks + "\n" + 
							"origin = " + origin + "\n" + 
							"goal = " + goal + "\n" +
							"temporal = " + temporal + "\n");*/
		if(disks == 1) {
			goal.add(origin.remove(origin.size() - 1));
			
			//parámetros después del caso base
			/*System.out.println("step BASE OVER" + "\n" + "POST BASE \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			*/
		}else {
			
			//PASO 1
			getSolutionTowerHanoi(disks - 1, origin, temporal, goal);
			solutions += origin.size() + " " + temporal.size() + " " + goal.size() + "\n"; //+ " PASO BASE";
			//solutions += " PASO 1 \n";
			//System.out.println("PASO 1 ACABADO");
			
			//PASO 2
			goal.add(origin.remove(origin.size() - 1));
			/*System.out.println("PASO 2 ACABADO" + "\n" + "POST PASO 2 \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			*/
			solutions += origin.size() + " " + temporal.size() + " " + goal.size() + "\n"; //" PASO 2" + "\n";
			
			//PASO 3
			getSolutionTowerHanoi(disks - 1, temporal, goal, origin);
			//solutions += " PASO 3 \n";
			/*System.out.println("PASO 3 OVER" + "\n" + "POST PASO 3 \n" +
					"origin = " + origin + "\n" + 
					"goal = " + goal + "\n" +
					"temporal = " + temporal + "\n");
			*/
		}

	}
	
	public String getSolutions() {
		return solutions;
	}
	
	public String getTowers() {
		return towerA.size() + " " + towerB.size() + " " + towerC.size() + "\n";
	}
	

}
