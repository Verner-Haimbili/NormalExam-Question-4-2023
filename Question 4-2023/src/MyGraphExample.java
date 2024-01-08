import java.util.List;
import java.util.Scanner;

public class MyGraphExample {
	@SuppressWarnings("unused")
	private static void PrintFriends(List<Node> nodes) {
		for (Node node : nodes) {
			System.out.println(node.GetInfo());
		}
	}

	public static void main(String[] args) {
		MyGraph friendshipGraph = new MyUndirectedGraph();

		Node friend1 = new Node("Sam");
		Node friend2 = new Node("Aune");
		Node friend3 = new Node("Ewaldine");
		Node friend4 = new Node("Daniel");
		Node friend5 = new Node("Eveline");

		// Adding friends
		friendshipGraph.AddNode(friend1);
		friendshipGraph.AddNode(friend2);
		friendshipGraph.AddNode(friend3);
		friendshipGraph.AddNode(friend4);
		friendshipGraph.AddNode(friend5);

		// Adding friendship
		friendshipGraph.AddEdge(friend1, friend2);
		friendshipGraph.AddEdge(friend2, friend3);
		friendshipGraph.AddEdge(friend1, friend4);
		friendshipGraph.AddEdge(friend1, friend3);

		// User input
		// But you can create two strings (names) of your own.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the name of the first friend: ");
		String name1 = scanner.nextLine();
		System.out.println("Enter the name of the second friend: ");
		String name2 = scanner.nextLine();

		scanner.close();

		System.out.println();

		Node node1 = null;
		Node node2 = null;

		for (Node node : friendshipGraph.nodes) {
			if (node.GetInfo().toLowerCase().equals(name1.toLowerCase())) {
				node1 = node;
			}
			if (node.GetInfo().toLowerCase().equals(name2.toLowerCase())) {
				node2 = node;
			}
		}

		if (node1 != null && node2 != null) {

			// Checking friendship
			boolean connected = friendshipGraph.Adjacent(node1, node2);
			if (connected) {
				System.out.println(node1.GetInfo() + " and " + node2.GetInfo() + " are friends.");
			} else {
				System.out.println(node1.GetInfo() + " and " + node2.GetInfo() + " are not friends.");
			}
		} else {
			System.out.println("One or both of the friends are not found.");
		}

		// Checking common friend
		Node node3 = friend3;

		if (node1 != null && node2 != null) {
			if (friendshipGraph.Adjacent(node1, node3) && friendshipGraph.Adjacent(node2, node3)) {
				System.out.println(node1.GetInfo() + " and " + node2.GetInfo() + " have common friend!");
			} else {
				System.out.println(node1.GetInfo() + " and " + node2.GetInfo() + " do not have a common friend!");
			}
		}
	}
}
