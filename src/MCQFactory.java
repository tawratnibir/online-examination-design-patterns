public class MCQFactory implements QuestionFactory {
    private final QuestionSource questionSource;

    public MCQFactory(QuestionSource questionSource) {
        if (questionSource == null) {
            throw new IllegalArgumentException(
                    "Question source cannot be null."
            );
        }

        this.questionSource = questionSource;
    }

    @Override
    public Question createQuestion() {
        Question question = questionSource.getQuestion();

        if (!(question instanceof MCQQuestion)) {
            throw new IllegalStateException(
                    "MCQFactory requires an MCQQuestion source."
            );
        }

        return question;
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new MCQRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new MCQEvaluator();
    }
}