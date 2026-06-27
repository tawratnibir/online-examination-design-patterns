public class ExamBuilder {
    private String title;
    private int duration;
    private int passingScore;
    private boolean negativeMarking;
    private boolean questionShuffle;
    private boolean autoSubmit;
    private boolean calculatorAllowed;

    public ExamBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ExamBuilder setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public ExamBuilder setPassingScore(int passingScore) {
        this.passingScore = passingScore;
        return this;
    }

    public ExamBuilder enableNegativeMarking() {
        this.negativeMarking = true;
        return this;
    }

    public ExamBuilder disableNegativeMarking() {
        this.negativeMarking = false;
        return this;
    }

    public ExamBuilder enableQuestionShuffle() {
        this.questionShuffle = true;
        return this;
    }

    public ExamBuilder disableQuestionShuffle() {
        this.questionShuffle = false;
        return this;
    }

    public ExamBuilder enableAutoSubmit() {
        this.autoSubmit = true;
        return this;
    }

    public ExamBuilder disableAutoSubmit() {
        this.autoSubmit = false;
        return this;
    }

    public ExamBuilder enableCalculator() {
        this.calculatorAllowed = true;
        return this;
    }

    public ExamBuilder disableCalculator() {
        this.calculatorAllowed = false;
        return this;
    }

    public ExamConfiguration build() {
        validateConfiguration();

        return new ExamConfiguration(
                title,
                duration,
                passingScore,
                negativeMarking,
                questionShuffle,
                autoSubmit,
                calculatorAllowed
        );
    }

    private void validateConfiguration() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException(
                    "Exam title cannot be empty."
            );
        }

        if (duration <= 0) {
            throw new IllegalStateException(
                    "Duration must be greater than zero."
            );
        }

        if (passingScore < 0 || passingScore > 100) {
            throw new IllegalStateException(
                    "Passing score must be between 0 and 100."
            );
        }
    }
}