package dataStructures;

public class LinkedDiGraph implements DiGraph {
	
	@Override
	public int inDegree(int node) {
		return 0;
	}
	
	@Override
	public int outDegree(int node) {
		return 0;
	}
	
	@Override
	public Iterable<Integer> inAdjacentNodes(int node) {
		return null;
	}
	
	@Override
	public Iterable<Integer> outAdjacentNodes(int node) {
		return null;
	}
	
	@Override
	public Iterable<Edge> inIncidentEdges(int node) {
		return null;
	}
	
	@Override
	public Iterable<Edge> outIncidentEdges(int node) {
		return null;
	}
	
	@Override
	public int numNodes() {
		return 0;
	}
	
	@Override
	public int numEdges() {
		return 0;
	}
	
	@Override
	public int aNode() {
		return 0;
	}
	
	@Override
	public void addEdge(int node1, int node2) {
	
	}
	
	@Override
	public boolean edgeExists(int node1, int node2) {
		return false;
	}
	
	@Override
	public Iterable<Integer> nodes() {
		return null;
	}
	
	@Override
	public Iterable<Edge> edges() {
		return null;
	}
}
