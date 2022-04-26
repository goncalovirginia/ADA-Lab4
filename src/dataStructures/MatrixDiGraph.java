package dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatrixDiGraph implements DiGraph {
	
	private final int[][] adjacencies;
	
	public MatrixDiGraph(int numNodes) {
		adjacencies = new int[numNodes][numNodes];
	}
	
	@Override
	public int inDegree(int node) {
		int inDegree = 0;
		
		for (int i = 0; i <= node; i++) {
			inDegree += adjacencies[i][node];
		}
		
		return inDegree;
	}
	
	@Override
	public int outDegree(int node) {
		int outDegree = 0;
		
		for (int i = 0; i <= node; i++) {
			outDegree += adjacencies[node][i];
		}
		
		return outDegree;
	}
	
	@Override
	public Iterable<Integer> inAdjacentNodes(int node) {
		List<Integer> inAdjacentNodes = new LinkedList<>();
		
		for (int i = 0; i <= node; i++) {
			if (adjacencies[i][node] == 1) {
				inAdjacentNodes.add(i);
			}
		}
		
		return inAdjacentNodes;
	}
	
	@Override
	public Iterable<Integer> outAdjacentNodes(int node) {
		List<Integer> outAdjacentNodes = new LinkedList<>();
		
		for (int i = 0; i <= node; i++) {
			if (adjacencies[node][i] == 1) {
				outAdjacentNodes.add(i);
			}
		}
		
		return outAdjacentNodes;
	}
	
	@Override
	public Iterable<Edge> inIncidentEdges(int node) {
		List<Edge> inAdjacentNodes = new LinkedList<>();
		
		for (int i = 0; i <= node; i++) {
			if (adjacencies[i][node] == 1) {
				inAdjacentNodes.add(new EdgeClass(i, node));
			}
		}
		
		return inAdjacentNodes;
	}
	
	@Override
	public Iterable<Edge> outIncidentEdges(int node) {
		List<Edge> outAdjacentNodes = new LinkedList<>();
		
		for (int i = 0; i <= node; i++) {
			if (adjacencies[node][i] == 1) {
				outAdjacentNodes.add(new EdgeClass(node, i));
			}
		}
		
		return outAdjacentNodes;
	}
	
	@Override
	public int numNodes() {
		return adjacencies.length;
	}
	
	@Override
	public int numEdges() {
		return 0;
	}
	
	@Override
	public int aNode() {
		return (int) (Math.random() * (numNodes() - 1));
	}
	
	@Override
	public void addEdge(int node1, int node2) {
		adjacencies[node1][node2] = 1;
	}
	
	@Override
	public boolean edgeExists(int node1, int node2) {
		return adjacencies[node1][node2] == 1;
	}
	
	@Override
	public Iterable<Integer> nodes() {
		List<Integer> nodes = new ArrayList<>(numNodes());
		
		for (int i = 0; i < numNodes(); i++) {
			nodes.add(i);
		}
		
		return nodes;
	}
	
	@Override
	public Iterable<Edge> edges() {
		List<Edge> edges = new LinkedList<>();
		
		for (int i = 0; i < numNodes(); i++) {
			edges.addAll((List<Edge>) inIncidentEdges(i));
			edges.addAll((List<Edge>) outIncidentEdges(i));
		}
		
		return edges;
	}
}
