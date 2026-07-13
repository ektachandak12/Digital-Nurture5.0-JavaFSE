public class Exercise5 {

    // Task Class
    static class Task {

        int taskId;
        String taskName;
        String status;
        Task next;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
            this.next = null;
        }

        public void display() {
            System.out.println("Task ID   : " + taskId);
            System.out.println("Task Name : " + taskName);
            System.out.println("Status    : " + status);
        }
    }

    // Head of Linked List
    static Task head = null;

    // Method to Add Task
    public static void addTask(int taskId, String taskName, String status) {

        Task newTask = new Task(taskId, taskName, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    // Method to Search Task
    public static Task searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // Method to Traverse Tasks
    public static void traverseTasks() {

        if (head == null) {
            System.out.println("No Tasks Found.");
            return;
        }

        Task temp = head;

        while (temp != null) {
            temp.display();
            System.out.println("------------------------");
            temp = temp.next;
        }
    }

    // Method to Delete Task
    public static void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task List is Empty.");
            return;
        }

        // Delete first node
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted Successfully.");
        }
    }

    // Main Method
    public static void main(String[] args) {

        // Adding Tasks
        addTask(101, "Complete Assignment", "Pending");
        addTask(102, "Prepare Presentation", "In Progress");
        addTask(103, "Submit Report", "Completed");

        // Display All Tasks
        System.out.println("\n===== Task List =====");
        traverseTasks();

        // Search Task
        System.out.println("\n===== Search Task =====");
        Task task = searchTask(102);

        if (task != null) {
            System.out.println("Task Found:");
            task.display();
        } else {
            System.out.println("Task Not Found.");
        }

        // Delete Task
        System.out.println("\n===== Delete Task =====");
        deleteTask(102);

        // Display Tasks After Deletion
        System.out.println("\n===== Task List After Deletion =====");
        traverseTasks();
    }
}