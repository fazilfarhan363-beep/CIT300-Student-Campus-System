public class StudentHashTable {

    private static final int SIZE = 101;

    private class Entry {

        int key;
        Student student;
        Entry next;

        Entry(int key, Student student) {
            this.key = key;
            this.student = student;
        }
    }

    private Entry[] table;

    public StudentHashTable() {
        table = new Entry[SIZE];
    }

    // Hash function
    private int hash(int key) {
        return Math.abs(key) % SIZE;
    }

    // Insert
    public void insert(Student student) {

        int index = hash(student.getStudentId());

        Entry current = table[index];

        while (current != null) {

            if (current.key == student.getStudentId()) {
                current.student = student;
                return;
            }

            current = current.next;
        }

        Entry newEntry =
                new Entry(student.getStudentId(), student);

        newEntry.next = table[index];

        table[index] = newEntry;
    }

    // Search
    public Student search(int studentId) {

        int index = hash(studentId);

        Entry current = table[index];

        while (current != null) {

            if (current.key == studentId) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Delete
    public boolean delete(int studentId) {

        int index = hash(studentId);

        Entry current = table[index];
        Entry previous = null;

        while (current != null) {

            if (current.key == studentId) {

                if (previous == null) {
                    table[index] = current.next;
                } 
                else {
                    previous.next = current.next;
                }

                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    // Display hash table
    public void display() {

        System.out.println("\n========== HASH TABLE ==========");

        boolean empty = true;

        for (int i = 0; i < SIZE; i++) {

            Entry current = table[i];

            if (current != null) {

                empty = false;

                System.out.print("Index " + i + ": ");

                while (current != null) {

                    System.out.print(
                            "[" + current.key + "] -> "
                    );

                    current = current.next;
                }

                System.out.println("NULL");
            }
        }

        if (empty) {
            System.out.println("Hash table is empty.");
        }

        System.out.println("================================");
    }
}