public class EssayFactory implements QuestionFactory {
    private final QuestionSource questionSource;

    public EssayFactory(QuestionSource questionSource) {
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

        if (!(question instanceof EssayQuestion)) {
            throw new IllegalStateException(
                    "EssayFactory requires an EssayQuestion source."
            );
        }

        return question;
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new EssayRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new EssayEvaluator();
    }
}