public class MidtermExam implements Exam {

    @Override
    public String getType() {
        return "Midterm Exam";
    }

    @Override
    public void displayInfo() {
        System.out.println("Midterm Exam:");
        System.out.println("- Single attempt");
        System.out.println("- Strict time limit");
        System.out.println("- Covers part of the course");
    }
}