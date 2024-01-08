public class MyUndirectedGraph extends MyGraph {
	public MyUndirectedGraph() {
		super();
	}

	@Override
	public void AddEdge(Node n1, Node n2) {
		int i = nodes.indexOf(n1);
		int j = nodes.indexOf(n2);
		matrix[i][j] = true;
		matrix[j][i] = true;
	}

}