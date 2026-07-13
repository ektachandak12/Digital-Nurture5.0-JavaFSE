public class MVCPattern {

    public static void main(String[] args) {

        Student student = new Student("Ekta", 101, "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("Initial Student Details");
        controller.updateView();

        controller.setStudentName("Bhakti");
        controller.setStudentId(102);
        controller.setStudentGrade("A+");

        System.out.println("\nUpdated Student Details");
        controller.updateView();
    }
}