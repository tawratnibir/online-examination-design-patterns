package exam;

public class PracticeQuiz implements Exam {

    @Override
    public String getType() {
        return "Practice Quiz";
    }

    @Override
    public void displayInfo() {
        System.out.println("Practice Quiz:");
        System.out.println("- Unlimited attempts");
        System.out.println("- Short duration");
        System.out.println("- Casual examination rules");
    }
}