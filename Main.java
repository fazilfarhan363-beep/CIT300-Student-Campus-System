import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentLinkedList studentList =
            new StudentLinkedList();

    static ActionStack actionStack =
            new ActionStack();

    static ServiceQueue serviceQueue =
            new ServiceQueue();

    static StudentBST studentBST =
            new StudentBST();

    static StudentHashTable hashTable =
            new StudentHashTable();

    static CampusGraph campusGraph =
            new CampusGraph();

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println(" UNIVERSITY STUDENT & CAMPUS MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.display();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    actionStack.display();
                    break;

                case 8:
                    studentBST.displayInOrder();
                    break;

                case 9:
                    searchStudentHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusConnection();
                    break;

                case 13:
                    removeCampusConnection();
                    break;

                case 14:
                    campusGraph.displayConnections();
                    break;

                case 15:
                    bfsCampus();
                    break;

                case 16:
                    System.out.println(
                            "\nThank you for using the system."
                    );
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please enter 1-16."
                    );
            }
        }

        scanner.close();
    }

    // ================= MENU =================

    public static void displayMenu() {

        System.out.println("\n============== MAIN MENU ==============");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records using Linked List");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Recent Actions using Stack");
        System.out.println("8.  Display Students using BST");
        System.out.println("9.  Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
        System.out.println("========================================");
    }

    // ================= STUDENT =================

    public static void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        int id = readPositiveInt("Enter Student ID: ");

        if (studentList.search(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Student Name: ");

        String programme =
                readNonEmptyString("Enter Programme: ");

        double marks = readMarks();

        Student student =
                new Student(id, name, programme, marks);

        studentList.add(student);
        studentBST.insert(student);
        hashTable.insert(student);

        actionStack.push(
                "Added student record - ID: " + id
        );

        System.out.println(
                "Student record added successfully."
        );
    }

    public static void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        int id = readPositiveInt("Enter Student ID: ");

        Student student = studentList.search(id);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        System.out.println("Current Record:");
        System.out.println(student);

        String name =
                readNonEmptyString("Enter New Name: ");

        String programme =
                readNonEmptyString("Enter New Programme: ");

        double marks = readMarks();

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        /*
         * BST and Hash Table store the same Student object,
         * so updated values are automatically reflected.
         */

        actionStack.push(
                "Updated student record - ID: " + id
        );

        System.out.println(
                "Student record updated successfully."
        );
    }

    public static void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        int id = readPositiveInt("Enter Student ID: ");

        Student student = studentList.search(id);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        studentList.delete(id);
        hashTable.delete(id);

        /*
         * For this console assignment, the deleted record
         * is maintained in the action history.
         */

        actionStack.push(
                "Deleted student record - ID: " + id +
                ", Name: " + student.getName()
        );

        System.out.println(
                "Student record deleted successfully."
        );
    }

    // ================= QUEUE =================

    public static void addServiceRequest() {

        System.out.println(
                "\n========== ADD SERVICE REQUEST =========="
        );

        String request =
                readNonEmptyString(
                        "Enter service request: "
                );

        serviceQueue.enqueue(request);

        actionStack.push(
                "Added service request: " + request
        );

        System.out.println(
                "Service request added to queue."
        );
    }

    public static void processServiceRequest() {

        System.out.println(
                "\n========== PROCESS SERVICE REQUEST =========="
        );

        String request = serviceQueue.dequeue();

        if (request == null) {
            System.out.println(
                    "No service requests available."
            );
            return;
        }

        System.out.println(
                "Processing request: " + request
        );

        actionStack.push(
                "Processed service request: " + request
        );
    }

    // ================= HASHING =================

    public static void searchStudentHashing() {

        System.out.println(
                "\n========== HASHING SEARCH =========="
        );

        int id = readPositiveInt(
                "Enter Student ID to search: "
        );

        Student student = hashTable.search(id);

        if (student == null) {
            System.out.println(
                    "Student not found in Hash Table."
            );
        } 
        else {
            System.out.println(
                    "Student found using hashing:"
            );
            System.out.println(student);
        }
    }

    // ================= GRAPH =================

    public static void addCampusLocation() {

        System.out.println(
                "\n========== ADD CAMPUS LOCATION =========="
        );

        String location =
                readNonEmptyString(
                        "Enter campus location: "
                );

        if (campusGraph.addLocation(location)) {

            actionStack.push(
                    "Added campus location: " + location
            );

            System.out.println(
                    "Campus location added successfully."
            );

        } 
        else {
            System.out.println(
                    "Error: Location already exists."
            );
        }
    }

    public static void removeCampusLocation() {

        System.out.println(
                "\n========== REMOVE CAMPUS LOCATION =========="
        );

        String location =
                readNonEmptyString(
                        "Enter campus location: "
                );

        if (campusGraph.removeLocation(location)) {

            actionStack.push(
                    "Removed campus location: " + location
            );

            System.out.println(
                    "Campus location removed successfully."
            );

        } 
        else {
            System.out.println(
                    "Error: Location not found."
            );
        }
    }

    public static void addCampusConnection() {

        System.out.println(
                "\n========== ADD CAMPUS CONNECTION =========="
        );

        String location1 =
                readNonEmptyString(
                        "Enter first location: "
                );

        String location2 =
                readNonEmptyString(
                        "Enter second location: "
                );

        if (campusGraph.addConnection(
                location1,
                location2)) {

            actionStack.push(
                    "Added campus connection: "
                    + location1 + " <-> " + location2
            );

            System.out.println(
                    "Campus connection added successfully."
            );

        } 
        else {
            System.out.println(
                    "Error: Invalid locations or connection already exists."
            );
        }
    }

    public static void removeCampusConnection() {

        System.out.println(
                "\n========== REMOVE CAMPUS CONNECTION =========="
        );

        String location1 =
                readNonEmptyString(
                        "Enter first location: "
                );

        String location2 =
                readNonEmptyString(
                        "Enter second location: "
                );

        if (campusGraph.removeConnection(
                location1,
                location2)) {

            actionStack.push(
                    "Removed campus connection: "
                    + location1 + " <-> " + location2
            );

            System.out.println(
                    "Campus connection removed successfully."
            );

        } 
        else {
            System.out.println(
                    "Error: Connection not found."
            );
        }
    }

    public static void bfsCampus() {

        System.out.println(
                "\n========== BFS CAMPUS TRAVERSAL =========="
        );

        String startLocation =
                readNonEmptyString(
                        "Enter starting location: "
                );

        campusGraph.bfs(startLocation);
    }

    // ================= INPUT VALIDATION =================

    public static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    public static int readPositiveInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Value must be greater than 0."
            );
        }
    }

    public static double readMarks() {

        while (true) {

            System.out.print(
                    "Enter Marks (0-100): "
            );

            String input = scanner.nextLine();

            try {

                double marks =
                        Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid marks. Please enter a number."
                );
            }
        }
    }

    public static String readNonEmptyString(
            String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}