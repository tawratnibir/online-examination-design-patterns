public final class ExamConfiguration {
    private final String title;
    private final int duration;
    private final int passingScore;
    private final boolean negativeMarking;
    private final boolean questionShuffle;
    private final boolean autoSubmit;
    private final boolean calculatorAllowed;

    ExamConfiguration(
            String title,
            int duration,
            int passingScore,
            boolean negativeMarking,
            boolean questionShuffle,
            boolean autoSubmit,
            boolean calculatorAllowed
    ) {
        this.title = title;
        this.duration = duration;
        this.passingScore = passingScore;
        this.negativeMarking = negativeMarking;
        this.questionShuffle = questionShuffle;
        this.autoSubmit = autoSubmit;
        this.calculatorAllowed = calculatorAllowed;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public boolean isNegativeMarking() {
        return negativeMarking;
    }

    public boolean isQuestionShuffle() {
        return questionShuffle;
    }

    public boolean isAutoSubmit() {
        return autoSubmit;
    }

    public boolean isCalculatorAllowed() {
        return calculatorAllowed;
    }

    public void displayConfiguration() {
        System.out.println("Title: " + title);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Passing Score: " + passingScore + " Marks");

        System.out.println("Negative Marking: "
                + status(negativeMarking));

        System.out.println("Question Shuffle: "
                + status(questionShuffle));

        System.out.println("Auto Submit: "
                + status(autoSubmit));

        System.out.println("Calculator Allowed: "
                + status(calculatorAllowed));
    }

    private String status(boolean enabled) {
        return enabled ? "Enabled" : "Disabled";
    }
}