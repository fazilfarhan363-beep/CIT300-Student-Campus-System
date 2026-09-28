public class ServiceQueue {

    private class Node {
        String request;
        Node next;

        Node(String request) {
            this.request = request;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Add request
    public void enqueue(String request) {

        Node newNode = new Node(request);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Process request
    public String dequeue() {

        if (front == null) {
            return null;
        }

        String request = front.request;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        return request;
    }

    // Display queue
    public void display() {

        if (front == null) {
            System.out.println("No service requests.");
            return;
        }

        System.out.println("\n========== SERVICE REQUEST QUEUE ==========");

        Node current = front;

        while (current != null) {
            System.out.println("- " + current.request);
            current = current.next;
        }

        System.out.println("===========================================");
    }
}