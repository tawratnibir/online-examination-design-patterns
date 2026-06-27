public class Main {

    public static void main(String[] args) {
        testFactory(new PracticeQuizFactory());
        testFactory(new MidtermExamFactory());
        testFactory(new FinalExamFactory());
    }

    private static void testFactory(ExamFactory factory) {
        Exam exam = factory.createExam();

        System.out.println("================================");
        System.out.println("Created exam type: " + exam.getType());
        exam.displayInfo();
    }
}