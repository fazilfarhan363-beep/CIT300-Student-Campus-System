public class ActionStack {

	private class Node {
		String action;
		Node next;

		Node(String action) {
			this.action = action;
		}
	}

	private Node top;

	public void push(String action) {
		Node newNode = new Node(action);
		newNode.next = top;
		top = newNode;
	}

	public void display() {
		if (top == null) {
			System.out.println("No recent actions.");
			return;
		}

		System.out.println("\n========== RECENT ACTIONS ==========");
		Node current = top;

		while (current != null) {
			System.out.println("- " + current.action);
			current = current.next;
		}

		System.out.println("===================================");
	}
}
