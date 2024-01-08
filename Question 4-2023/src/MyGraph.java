import java.util.ArrayList;
import java.util.List;

public abstract class MyGraph {
	// For simplicity I will use a matrix of booleans, but the general way
	// is to use a matrix of double values. However the implementation is
	// just slightly different.
	protected Boolean[][] matrix;
	protected List<Node> nodes;

	public MyGraph() {
		// 100 vertices maximum by default
		matrix = new Boolean[100][100];
		// Initialize all the elements of the matrix to false
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				matrix[i][j] = false;
			}
		}
		nodes = new ArrayList<Node>();
	}

	public void AddNode(Node n) {
		nodes.add(n);
	}

	public abstract void AddEdge(Node n1, Node n2);

	public Boolean Adjacent(Node n1, Node n2) {
		int i = nodes.indexOf(n1);
		int j = nodes.indexOf(n2);

		return matrix[i][j];
	}

	public List<Node> AdjacentsTo(Node n) {
		List<Node> l = new ArrayList<>();
		int i = nodes.indexOf(n);

		for (int j = 0; j < nodes.size(); j++) {
			if (matrix[i][j] == true)
				l.add(nodes.get(j));

		}

		return l;
	}
}