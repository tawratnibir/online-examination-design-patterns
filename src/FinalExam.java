public class FinalExam implements Exam {

    @Override
    public String getType() {
        return "Final Exam";
    }

    @Override
    public void displayInfo() {
        System.out.println("Final Exam:");
        System.out.println("- Single attempt");
        System.out.println("- High-security rules");
        System.out.println("- Covers the complete course");
    }
}