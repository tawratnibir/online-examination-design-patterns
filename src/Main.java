public class Main {
    public static void main(String[] args) {
        ExamConfiguration configuration =
                new ExamBuilder()
                        .setTitle("OOP Midterm Exam")
                        .setDuration(60)
                        .setPassingScore(50)
                        .enableNegativeMarking()
                        .enableQuestionShuffle()
                        .enableAutoSubmit()
                        .disableCalculator()
                        .build();

        configuration.displayConfiguration();
    }
}