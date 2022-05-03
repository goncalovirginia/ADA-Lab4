import dataStructures.DiGraph;
import dataStructures.LinkedDiGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] abep = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		DiGraph employees = new LinkedDiGraph(abep[2]);
		
		for (int i = 0; i < abep[3]; i++) {
			String[] edge = in.readLine().split(" ");
			employees.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
		}
		
		int[] ab = solve(employees, abep[0], abep[1]);
		System.out.printf("%d\n%d\n%d\n", ab[0], ab[1], abep[2] - ab[1]);
	}
	
	private static int[] solve(DiGraph employees, int a, int b) {
		int[] employeesPerDepth = employeesPerDepth(employees), ab = new int[2];
		
		int i = 0;
		
		for (; i < employees.numNodes(); i++) {
			if (ab[0] + employeesPerDepth[i] > a) break;
			ab[0] += employeesPerDepth[i];
		}
		
		ab[1] = ab[0];

		for (; i < employees.numNodes(); i++) {
			if (ab[1] + employeesPerDepth[i] > b) break;
			ab[1] += employeesPerDepth[i];
		}
		
		return ab;
	}
	
	private static int[] employeesPerDepth(DiGraph employees) {
		int[] employeesPerDepth = new int[employees.numNodes()], employeeDepth = new int[employees.numNodes()];
		
		for (int employee : employees.nodes()) {
			if (employees.inDegree(employee) == 0) {
				employeesPerDepth[0]++;
				for (int successor : employees.outAdjacentNodes(employee)) {
					setDepth(employees, successor, employeesPerDepth, employeeDepth, 1);
				}
			}
		}
		
		return employeesPerDepth;
	}
	
	private static void setDepth(DiGraph employees, int root, int[] employeesPerDepth, int[] employeeDepth, int currentDepth) {
		if (currentDepth <= employeeDepth[root]) {
			return;
		}
		if (employeeDepth[root] > 0) {
			employeesPerDepth[employeeDepth[root]]--;
		}
		
		employeeDepth[root] = currentDepth;
		employeesPerDepth[currentDepth]++;
		
		for (int successor : employees.outAdjacentNodes(root)) {
			setDepth(employees, successor, employeesPerDepth, employeeDepth, currentDepth + 1);
		}
	}
	
}
