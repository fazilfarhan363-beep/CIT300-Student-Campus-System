public class StudentBST {

    private class Node {

        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    // Insert student
    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private Node insertRecursive(Node root, Student student) {

        if (root == null) {
            return new Node(student);
        }

        if (student.getStudentId() < root.student.getStudentId()) {
            root.left = insertRecursive(root.left, student);
        } 
        else if (student.getStudentId() > root.student.getStudentId()) {
            root.right = insertRecursive(root.right, student);
        }

        return root;
    }

    // Search
    public Student search(int id) {

        Node result = searchRecursive(root, id);

        if (result == null) {
            return null;
        }

        return result.student;
    }

    private Node searchRecursive(Node root, int id) {

        if (root == null) {
            return null;
        }

        if (root.student.getStudentId() == id) {
            return root;
        }

        if (id < root.student.getStudentId()) {
            return searchRecursive(root.left, id);
        }

        return searchRecursive(root.right, id);
    }

    // Display using Inorder traversal
    public void displayInOrder() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("\n========== STUDENTS USING BST ==========");

        inOrder(root);

        System.out.println("========================================");
    }

    private void inOrder(Node root) {

        if (root != null) {

            inOrder(root.left);

            System.out.println(root.student);

            inOrder(root.right);
        }
    }
}
