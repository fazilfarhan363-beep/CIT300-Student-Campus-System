public class StudentLinkedList {

    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    // Add student
    public void add(Student student) {

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Search student by ID
    public Student search(int id) {

        Node current = head;

        while (current != null) {

            if (current.student.getStudentId() == id) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Delete student
    public boolean delete(int id) {

        if (head == null) {
            return false;
        }

        if (head.student.getStudentId() == id) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId() == id) {
                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all students
    public void display() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Node current = head;

        System.out.println("\n========== STUDENT RECORDS ==========");

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }

        System.out.println("=====================================");
    }
}