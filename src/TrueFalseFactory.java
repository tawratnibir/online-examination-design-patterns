public class TrueFalseFactory implements QuestionFactory {

    @Override
    public Question createQuestion() {
        return new TrueFalseQuestion(
                "An interface can be instantiated directly in Java.",
                false,
                1,
                "Easy"
        );
    }

    @Override
    public QuestionRenderer createRenderer() {
        return new TrueFalseRenderer();
    }

    @Override
    public QuestionEvaluator createEvaluator() {
        return new TrueFalseEvaluator();
    }
}