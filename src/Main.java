import dataStructures.DiGraph;
import dataStructures.MatrixDiGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] abep = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		DiGraph employees = new MatrixDiGraph(abep[2]);
		
		for (int i = 0; i < abep[3]; i++) {
			int[] edge = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			employees.addEdge(edge[0], edge[1]);
		}
		
		int[] solution = solve(employees);
		
		for (int i : solution) {
			System.out.println(i);
		}
	}
	
	private static int[] solve(DiGraph employees) {
		
		return new int[] {0, 0, 0};
	}
	
}
